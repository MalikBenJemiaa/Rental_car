package com.example.demo.Facture;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table
public class Facture {
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
    private Date CreationDate;
    private Integer price;
    public Facture() {
    }

    public Facture(long id, Date CreationDate, Integer price) {
        this.id = id;
       this.CreationDate=CreationDate;
        this.price = price;
    }

    public Date getCreationDate() {
        return CreationDate;
    }

    public void setCreationDate(Date creationDate) {
        CreationDate = creationDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }



    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
