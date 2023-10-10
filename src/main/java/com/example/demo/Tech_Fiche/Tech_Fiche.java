package com.example.demo.Tech_Fiche;

import com.example.demo.cars.Cars;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table
public class Tech_Fiche {
    @Id
    @SequenceGenerator(
            name="Model_sequence",
            sequenceName = "Model_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Model_sequence"
    )
    private long id;
    private String marque;
    private Integer puissence;
    private String option;
    private Date released_date;
    private String description;

    public Tech_Fiche(){

    }

    public Tech_Fiche(long id,String marque, Integer puissence, String option, Date released_date, String description) {
        this.id = id;
        this.marque = marque;
        this.puissence = puissence;
        this.option = option;

        this.released_date = released_date;
        this.description = description;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public Integer getPuissence() {
        return puissence;
    }

    public void setPuissence(Integer puissence) {
        this.puissence = puissence;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }



    public Date getReleased_date() {
        return released_date;
    }

    public void setReleased_date(Date released_date) {
        this.released_date = released_date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
