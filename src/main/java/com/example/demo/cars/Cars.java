package com.example.demo.cars;

import com.example.demo.Assurance.Assurance;
import com.example.demo.Tech_Fiche.Tech_Fiche;
import jakarta.persistence.*;

import java.util.List;
import javax.persistence.Lob;
@Entity
@Table
public class Cars {
    @Id

    /*@SequenceGenerator(
            name = "cars_sequence",
            sequenceName = "cars_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "cars_sequence"
    )*/
    private Long mat;
    private String model;
    private Integer stock;
    private Integer price_per_day;
    private String color;

    private String Photo1;
    private String Photo2;
    private String Photo3;
    private String Photo4;
    @OneToOne
    @JoinColumn(name = "num_assurance")
    private Assurance num_assurance;
    @ManyToOne
    private Tech_Fiche tech_fiche;

    public String getPhoto1() {

        return Photo1;
    }

    public void setPhoto1(String photo1) {
        Photo1 = photo1;
    }
    public String getPhoto2() {

        return Photo2;
    }

    public void setPhoto2(String photo2) {
        Photo2 = photo2;
    }
    public String getPhoto3() {

        return Photo3;
    }

    public void setPhoto3(String photo3) {
        Photo3 = photo3;
    }

    public String getPhoto4() {

        return Photo4;
    }

    public void setPhoto4(String photo4) {
        Photo4 = photo4;
    }
    /* @OneToMany
            private List<CarsPhoto> CarsPhoto;
        */

    public Cars() {

    }

    public Cars(Long mat,String color,Tech_Fiche tech_fiche, Integer price_per_day, String model, Integer stock, Assurance num_assurace) {
        this.mat = mat;
        this.stock = stock;
        this.num_assurance = num_assurace;
        this.model = model;
        this.price_per_day = price_per_day;
        this.color=color;
        this.tech_fiche=tech_fiche;

    }

    public Cars(Long mat,String photo1,String photo2,String photo3,String photo4, String model, Integer stock, Integer price_per_day, String color, String photos, Assurance num_assurance, Tech_Fiche tech_fiche) {
        this.mat = mat;
        this.model = model;
        this.stock = stock;
        this.price_per_day = price_per_day;
        this.color = color;
        this.Photo1 = photo1;
        this.Photo2 = photo2;
        this.Photo3 = photo3;
        this.Photo4 = photo4;
        this.num_assurance = num_assurance;
        this.tech_fiche = tech_fiche;
    }

    public void setTech_fiche(Tech_Fiche tech_fiche) {
        this.tech_fiche = tech_fiche;
    }

    public Tech_Fiche getTech_fiche() {
        return tech_fiche;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Long getMat() {
        return mat;
    }

    public void setMat(Long mat) {
        this.mat = mat;
    }

    public String getModel() {
        return model;
    }

    /*public List<com.example.demo.CarsPhoto.CarsPhoto> getCarsPhoto() {
        return CarsPhoto;
    }*/

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getPrice_per_day() {
        return price_per_day;
    }

    public void setPrice_per_day(Integer price_per_day) {
        this.price_per_day = price_per_day;
    }

    public Assurance getNum_assurance() {
        return num_assurance;
    }

    public void setNum_assurance(Assurance num_assurance) {
        this.num_assurance = num_assurance;
    }
}
