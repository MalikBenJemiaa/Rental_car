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
    @ElementCollection
    @Lob
    private List<byte[]> Photos;
    @OneToOne
    @JoinColumn(name = "num_assurance")
    private Assurance num_assurance;
    @ManyToOne
    private Tech_Fiche tech_fiche;

    public List<byte[]> getPhotos() {
        return this.Photos;
    }

    public void setPhotos(List<byte[]> photos) {
        this.Photos = photos;
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

    public Cars(Long mat, String model, Integer stock, Integer price_per_day, String color, List<byte[]> photos, Assurance num_assurance, Tech_Fiche tech_fiche) {
        this.mat = mat;
        this.model = model;
        this.stock = stock;
        this.price_per_day = price_per_day;
        this.color = color;
        Photos = photos;
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
