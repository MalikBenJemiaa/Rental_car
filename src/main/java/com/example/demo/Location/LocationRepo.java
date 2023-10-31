package com.example.demo.Location;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LocationRepo extends JpaRepository<Location,Long> {
    /*@Modifying*/
    @Transactional
    @Query("SELECT l.id FROM Location l WHERE l.car.mat = :CarMat")
    List<Long> findTheIdLocationByTheCarMat(@Param("CarMat")Long CarMat);
    @Modifying
    @Transactional
    @Query("DELETE FROM Location l WHERE l.car.mat= :CarMat")
    void deleteAllTheLocationWithIdCar(@Param("CarMat")Long CarMat);

}
