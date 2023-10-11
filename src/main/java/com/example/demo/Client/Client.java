package com.example.demo.Client;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Table
public class Client {
    @Id
    private String numPermis;
    private String cin;
    private String username;

    private String address;
    private String contact;
    private Integer fidalityPoint;
    public Client() {}

    public Client(String numPermis, String cin, String username, String address, String contact, Integer fidalityPoint) {
        this.numPermis = numPermis;
        this.cin = cin;
        this.username = username;
        this.address = address;
        this.contact = contact;
        this.fidalityPoint = fidalityPoint;
    }

    public String getNumPermis() {
        return numPermis;
    }

    public void setNumPermis(String numPermis) {
        this.numPermis = numPermis;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Integer getFidalityPoint() {
        return fidalityPoint;
    }

    public void setFidalityPoint(Integer fidalityPoint) {
        fidalityPoint = fidalityPoint;
    }
}
