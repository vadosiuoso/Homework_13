package org.example.app;

import org.example.dao.ClientDao;
import org.example.dao.PlanetDao;
import org.example.flyway.FlyWayMigration;
import org.example.hibernate.HibernateSingleton;
import org.example.model.Client;
import org.example.model.Planet;

public class TestApp {
    public static void main(String[] args) {
        FlyWayMigration.migrate();

        ClientDao clientDao = new ClientDao();
        PlanetDao planetDao = new PlanetDao();

        Client client = new Client();
        client.setName("Taras");
        clientDao.saveOrUpdateClient(client);

        Planet planet = new Planet();
        planet.setId("EAR");
        planet.setName("Earth");
        planetDao.saveOrUpdatePlanet(planet);

        clientDao.getAllClients().forEach(System.out::println);
        planetDao.getAllPlanets().forEach(System.out::println);

        clientDao.deleteClient(client.getId());
        planetDao.deletePlanet(planet.getId());

        HibernateSingleton.getInstance().close();
    }
}
