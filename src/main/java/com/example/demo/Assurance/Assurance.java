package com.example.demo.Assurance;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table
public class Assurance {
@Id
/*@SequenceGenerator(
        name="Assurance_sequence",
        sequenceName = "Assurance_sequence",
        allocationSize = 1
)
@GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "Assurance_sequence"
)*/
    private long num_assurace;
    private Date end_assurance;
    public Assurance(){

    }
    public Assurance(long num_assurace,Date end_assurance){
        this.end_assurance=end_assurance;
        this.num_assurace=num_assurace;

    }

    public Date getEnd_assurance() {
        return end_assurance;
    }

    public void setNum_assurace(long num_assurace) {
        this.num_assurace = num_assurace;
    }

    public long getNum_assurace() {
        return num_assurace;
    }

    public void setEnd_assurance(Date end_assurance) {
        this.end_assurance = end_assurance;
    }
}
