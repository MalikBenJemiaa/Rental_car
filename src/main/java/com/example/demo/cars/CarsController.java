package com.example.demo.cars;

import com.example.demo.Assurance.Assurance;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class CarsController {
    private final CarsService carsService;

    @Autowired
    public CarsController(CarsService carsService) {
        this.carsService = carsService;
    }

    //////////////////////////////////////////////////
    @GetMapping("/getAllCars")
    public List<Cars> getAllCars() {
        return carsService.getAllCars();
    }
    @GetMapping("/getCarsById/{id}")
    public Optional<Cars> getCarsById(@PathVariable Long id) {
        return carsService.getCarsById(id);
    }
    @PostMapping("/secure/admin/registerCar")
    public Cars createCars(@RequestBody Cars cars) {
        return carsService.createCars(cars);
    }

    @PutMapping("/secure/admin/updateCars/{id}")
    public Cars updateCars(@PathVariable Long id, @RequestBody Cars updatedCars) {
        return carsService.updateCars(id, updatedCars);
    }


    @DeleteMapping("/secure/admin/deleteCars/{id}")
    public void deleteCars(@PathVariable Long id) {
        carsService.deleteCars(id);
    }

}
