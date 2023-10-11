package com.example.demo.Location;

import com.example.demo.Client.Client;
import com.example.demo.cars.Cars;
import jakarta.persistence.*;

import java.util.Date;

@Table
@Entity
public class Location {
    @Id
    @SequenceGenerator(
            name="Facture_sequence",
            sequenceName = "Facture_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Facture_sequence"
    )
    private long id;
    private Date date_prevu;

    @ManyToOne
    private Client client;

    @ManyToOne

    private Cars car;
    public Location() {
    }
    public Location(long id, Client client, Cars car,Date date_prevu) {
        this.id = id;
        this.client = client;
        this.car = car;
        this.date_prevu=date_prevu;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate_prevu() {
        return date_prevu;
    }

    public void setDate_prevu(Date date_prevu) {
        this.date_prevu = date_prevu;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Cars getCar() {
        return car;
    }

    public void setCar(Cars car) {
        this.car = car;
    }
}
