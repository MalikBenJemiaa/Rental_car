package com.example.demo.cars;

import com.example.demo.Assurance.Assurance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Cars")
public class CarsController {
    private final CarsService carsService;

    @Autowired
    public CarsController(CarsService carsService) {
        this.carsService = carsService;
    }

    //////////////////////////////////////////////////
    @GetMapping
    public List<Cars> getAllCars() {
        return carsService.getAllCars();
    }
    @GetMapping("/{id}")
    public Optional<Cars> getCarsById(@PathVariable Long id) {
        return carsService.getCarsById(id);
    }
    @PostMapping
    public Cars createCars(@RequestBody Cars cars) {

        System.out.println("update car is made succefully");
        return carsService.createCars(cars);
    }

    @PutMapping("/{id}")
    public Cars updateCars(@PathVariable Long id, @RequestBody Cars updatedCars) {
        return carsService.updateCars(id, updatedCars);
    }

    @DeleteMapping("/{id}")
    public void deleteCars(@PathVariable Long id) {
        carsService.deleteCars(id);
    }

}
