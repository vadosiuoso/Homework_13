package org.example.model;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "created_at",
            nullable = false,
            updatable = false)
    private Timestamp createdAt;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "from_planet_id", nullable = false)
    private Planet fromPlanet;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "to_planet_id", nullable = false)
    private Planet toPlanet;


    public Ticket(){
        createdAt = new Timestamp(System.currentTimeMillis());
    }

    public long getId() {
        return id;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Planet getFromPlanet() {
        return fromPlanet;
    }

    public void setFromPlanet(Planet fromPlanet) {
        this.fromPlanet = fromPlanet;
    }

    public Planet getToPlanet() {
        return toPlanet;
    }

    public void setToPlanet(Planet toPlanet) {
        this.toPlanet = toPlanet;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", client=" + client +
                ", fromPlanet=" + fromPlanet +
                ", toPlanet=" + toPlanet +
                '}';
    }
}

