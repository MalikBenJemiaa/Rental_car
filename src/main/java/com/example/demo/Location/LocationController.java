package com.example.demo.Location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Controller
@RequestMapping("/secure/location")
public class LocationController {
    private final LocationService locationService;
    @Autowired
    public LocationController(LocationService locationService){
        this.locationService=locationService;
    }
    @GetMapping("/getAllLocations")
    public List<Location> GetAllLocations(){
        return this.locationService.getAllLocation();
    }
    @PostMapping("/registerNawLocation")
    public Location registerNewLocation(@RequestBody Location l){
        return this.locationService.createLocation(l);
    }
    @PutMapping("/updateLocation/{itemId}")
    public Location UpdateLocation(@PathVariable Long itemId,@RequestBody Location l){
        return this.locationService.updateLocation(itemId,l);
    }
    @DeleteMapping("deleteLocation/{itemId}")
    public void deleteLocation(@PathVariable Long itemId){
        this.locationService.deleteLocation(itemId);
    }
    @GetMapping("getLoactionById/{itemId}")
    public Optional<Location> getLocationById(@PathVariable Long itemId){
        return this.locationService.getLocationById(itemId);
    }

}
