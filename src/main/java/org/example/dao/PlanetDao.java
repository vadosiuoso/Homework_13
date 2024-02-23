package org.example.dao;

import org.example.hibernate.HibernateSingleton;
import org.example.model.Planet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class PlanetDao {
    private final SessionFactory sessionFactory;

    public PlanetDao() {
        this.sessionFactory = HibernateSingleton.getInstance();
    }

    public void saveOrUpdatePlanet(Planet planet) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(planet);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
    }

    public void deletePlanet(String id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Planet planet = session.get(Planet.class, id);
            session.delete(planet);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
    }

    public List<Planet> getAllPlanets() {
        Session session = sessionFactory.openSession();
        List<Planet> planets = session.createQuery("FROM Planet", Planet.class).list();
        session.close();
        return planets;
    }

    public Planet getPlanetById(String id) {
        Session session = sessionFactory.openSession();
        Planet planet = session.get(Planet.class, id);
        session.close();
        return planet;
    }
}
