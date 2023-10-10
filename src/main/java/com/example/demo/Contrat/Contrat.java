package com.example.demo.Contrat;

import com.example.demo.Facture.Facture;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table
public class Contrat {
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
     private String contratPdf;
     private Date start_date;
    private Date end_date;
    @OneToOne
    private Facture facture;
    public Contrat(){

    }

    public Contrat(long id, String contratPdf,Facture facture, Date start_date, Date end_date) {
        this.id = id;
        this.contratPdf = contratPdf;
        this.start_date = start_date;
        this.end_date = end_date;
        this.facture=facture;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }

    public Facture getFacture() {
        return facture;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContratPdf() {
        return contratPdf;
    }

    public void setContratPdf(String contratPdf) {
        this.contratPdf = contratPdf;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }
}
