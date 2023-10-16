package com.example.demo.QueryCar;

import com.example.demo.cars.Cars;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/QueryCars")
@RestController
@Controller
public class QueryCarController {
    private final QueryCarService queryCarService;
    @Autowired
    public QueryCarController(QueryCarService a){
        this.queryCarService=a;
    }
    @PostMapping("/saveNewCar")
    public Cars saveNewCar(@RequestBody Cars car){
        return this.queryCarService.insertAllCridests(car);

    }
}
