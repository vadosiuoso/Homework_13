package org.example.dao;

import org.example.hibernate.HibernateSingleton;
import org.example.model.Planet;
import org.example.model.Ticket;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class TicketDao {
    private final SessionFactory sessionFactory;

    public TicketDao(){
        this.sessionFactory = HibernateSingleton.getInstance();
    }

    public void saveOrUpdateTicket(Ticket ticket) {
        if (ticket.getClient() == null || ticket.getFromPlanet() == null || ticket.getToPlanet() == null) {
            throw new IllegalArgumentException("Ticket must have a valid client and planets");
        }

        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(ticket);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Failed to save or update ticket");
        } finally {
            session.close();
        }
    }

    public void deleteTicket(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Ticket ticket = session.get(Ticket.class, id);
            ticket.setToPlanet(null);
            ticket.setFromPlanet(null);
            ticket.setClient(null);
            session.delete(ticket);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Failed to delete ticket");
        } finally {
            session.close();
        }
    }

    public List<Ticket> getAllTickets() {
        Session session = sessionFactory.openSession();
        List<Ticket> tickets = session.createQuery("FROM Ticket", Ticket.class).list();
        session.close();
        return tickets;
    }

    public Ticket getTicketById(Long id) {
        Session session = sessionFactory.openSession();
        Ticket ticket = session.get(Ticket.class, id);
        session.close();
        return ticket;
    }

}
