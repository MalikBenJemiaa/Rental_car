package com.example.demo.cars;

import com.example.demo.Assurance.Assurance;
import com.example.demo.Assurance.AssuranceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarsService {
    private CarsRepo carsRepo;
    public CarsService(){

    }
    @Autowired
    public CarsService(CarsRepo carsRepo) {
        this.carsRepo = carsRepo;
    }
    public List<Cars> getAllCars() {
        return carsRepo.findAll();
    }
    public Optional<Cars> getCarsById(Long id) {
        return carsRepo.findById(id);
    }
    public Cars createCars(Cars cars) {
        return carsRepo.save(cars);
    }

    public Cars updateCars(Long id, Cars updatedCars) {
        Optional<Cars> existingCars = carsRepo.findById(id);
        if (existingCars.isPresent()) {
            Cars carsToUpdate = existingCars.get();
            carsToUpdate.setColor(updatedCars.getColor());
            carsToUpdate.setModel(updatedCars.getModel());
            carsToUpdate.setStock(updatedCars.getStock());
            carsToUpdate.setPrice_per_day(updatedCars.getPrice_per_day());
            // You can update other properties as needed
            return carsRepo.save(carsToUpdate);
        } else {
            throw new RuntimeException("Car not found with id: " + id);
        }
    }
    public void deleteCars(Long id) {
        carsRepo.deleteById(id);
    }
}
