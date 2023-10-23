package com.example.demo.Tech_Fiche;

import com.example.demo.cars.Cars;
import jakarta.persistence.*;

import java.util.Date;
@Embeddable

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

    private String energie;

    private String boite;

    public Tech_Fiche(){

    }
    public Tech_Fiche(Tech_Fiche t){
        this.id=t.getId();
        this.option=t.getOption();
        this.description=t.getDescription();
        this.marque=t.getMarque();
        this.released_date=t.getReleased_date();
        this.puissence=t.puissence;
        this.energie=t.getEnergie();

    }

    public String getBoite() {
        return boite;
    }

    public void setBoite(String boite) {
        this.boite = boite;
    }

    public String getEnergie() {
        return energie;
    }

    public void setEnergie(String energie) {
        this.energie = energie;
    }

    public Tech_Fiche(long id, String marque, Integer puissence, String option, Date released_date, String description, String energie,String Boite) {
        this.id = id;
        this.marque = marque;
        this.puissence = puissence;
        this.option = option;

        this.released_date = released_date;
        this.description = description;
        this.energie=energie;
        this.boite=Boite;
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
