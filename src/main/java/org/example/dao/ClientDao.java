package org.example.dao;

import org.example.hibernate.HibernateSingleton;
import org.example.model.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class ClientDao {
    private final SessionFactory sessionFactory;

    public ClientDao(){
        this.sessionFactory = HibernateSingleton.getInstance();
    }

    public void saveOrUpdateClient(Client client){
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(client);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
    }

    public void deleteClient(Long id){
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Client client = session.get(Client.class, id);
            session.delete(client);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
    }

    public List<Client> getAllClients() {
        Session session = sessionFactory.openSession();
        List<Client> clients = session.createQuery("FROM Client", Client.class).list();
        session.close();
        return clients;
    }

    public Client getClientById(Long id) {
        Session session = sessionFactory.openSession();
        Client client = session.get(Client.class, id);
        session.close();
        return client;
    }
}
