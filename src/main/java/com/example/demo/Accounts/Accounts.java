package com.example.demo.Accounts;

import jakarta.persistence.*;

@Entity
@Table
public class Accounts {
    @Id
    @SequenceGenerator(
            name="Accounts_sequence",
            sequenceName = "Accounts_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Accounts_sequence"
    )
    private long id;
    private String username;
    private String email;
    private String password;
    public Accounts() {
    }
    public Accounts(long id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
