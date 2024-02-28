package org.example.hibernate;

import org.example.model.Client;
import org.example.model.Planet;
import org.example.model.Ticket;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSingleton {
    private static SessionFactory INSTANCE;

    private HibernateSingleton(){

    }

    public static synchronized SessionFactory getInstance(){
        if(INSTANCE == null){
            INSTANCE = new Configuration()
                    .addAnnotatedClass(Client.class)
                    .addAnnotatedClass(Planet.class)
                    .addAnnotatedClass(Ticket.class)
                    .buildSessionFactory();
        }

        return INSTANCE;
    }

    public void close(){
        INSTANCE.close();
    }
}
