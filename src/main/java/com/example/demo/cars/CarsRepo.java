package com.example.demo.cars;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CarsRepo extends JpaRepository<Cars,Long> {
    /*@Modifying*/
    @Query("select c.num_assurance.num_assurace from Cars c where c.mat= :idCar")
    Long getAssuranceNum(@Param("idCar") Long idCar);
}