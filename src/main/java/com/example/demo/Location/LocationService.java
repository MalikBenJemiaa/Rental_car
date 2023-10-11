package com.example.demo.Location;

import com.example.demo.Facture.Facture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {
    private final LocationRepo locationRepo;
    @Autowired
    public LocationService(LocationRepo locationRepo){
        this.locationRepo=locationRepo;
    }
    public List<Location> getAllLocation() {
        return locationRepo.findAll();
    }
    public Optional<Location> getLocationById(Long id) {
        return locationRepo.findById(id);
    }
    public Location createLocation(Location l) {
        return locationRepo.save(l);
    }
    public Location updateLocation(Long id, Location updatedLocation) {
        Optional<Location> existingLocation = locationRepo.findById(id);
        if (existingLocation.isPresent()) {
            Location locationToUpdate = existingLocation.get();
            locationToUpdate.setCar(updatedLocation.getCar());
            locationToUpdate.setId(updatedLocation.getId());
            locationToUpdate.setClient(updatedLocation.getClient());
            locationToUpdate.setDate_prevu(updatedLocation.getDate_prevu());


            // You can update other properties as needed
            return locationRepo.save(locationToUpdate);
        } else {
            throw new RuntimeException("Location not found with id: " + id);
        }
    }
    public void deleteLocation(Long id) {
        locationRepo.deleteById(id);
    }


}
