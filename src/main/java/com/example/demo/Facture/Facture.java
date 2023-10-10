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
    private Date start_day;
    private Date end_day;

}
