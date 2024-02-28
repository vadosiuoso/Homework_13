package org.example.app;

import org.example.dao.ClientDao;
import org.example.dao.PlanetDao;
import org.example.dao.TicketDao;
import org.example.flyway.FlyWayMigration;
import org.example.hibernate.HibernateSingleton;
import org.example.model.Client;
import org.example.model.Planet;
import org.example.model.Ticket;

public class TestApp {
    public static void main(String[] args) {
        FlyWayMigration.migrate();

        ClientDao clientDao = new ClientDao();
        PlanetDao planetDao = new PlanetDao();
        TicketDao ticketDao = new TicketDao();

        Client client = new Client();
        client.setName("Taras");
        clientDao.saveOrUpdateClient(client);


        Planet earth = new Planet();
        earth.setId("EAR");
        earth.setName("Earth");
        planetDao.saveOrUpdatePlanet(earth);

        Planet neptune = new Planet();
        neptune.setId("NEP");
        neptune.setName("Neptune");
        planetDao.saveOrUpdatePlanet(neptune);

        Ticket onewayTicket = new Ticket();
        onewayTicket.setClient(client);
        client.addTicketToClient(onewayTicket);
        onewayTicket.setFromPlanet(earth);
        onewayTicket.setToPlanet(neptune);
        ticketDao.saveOrUpdateTicket(onewayTicket);


        Ticket returnTicket = new Ticket();
        returnTicket.setClient(client);
        client.addTicketToClient(returnTicket);
        returnTicket.setFromPlanet(neptune);
        returnTicket.setToPlanet(earth);
        ticketDao.saveOrUpdateTicket(returnTicket);


        client.getTickets().forEach(System.out::println);
        System.out.println("---------------------------------------");
        clientDao.getAllClients().forEach(System.out::println);
        System.out.println("---------------------------------------");
        planetDao.getAllPlanets().forEach(System.out::println);
        System.out.println("---------------------------------------");
        ticketDao.getAllTickets().forEach(System.out::println);


        ticketDao.deleteTicket(onewayTicket.getId());
        ticketDao.deleteTicket(returnTicket.getId());
        clientDao.deleteClient(client.getId());
        planetDao.deletePlanet(earth.getId());
        planetDao.deletePlanet(neptune.getId());
        HibernateSingleton.getInstance().close();
    }
}
