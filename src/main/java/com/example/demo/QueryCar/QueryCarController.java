package com.example.demo.QueryCar;

import com.example.demo.cars.Cars;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPOutputStream;

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
    //    return this.queryCarService.insertAllCridests(car);
     /*   List<byte[]> tab=new ArrayList<>();
        try {
            for(int i=0;i<car.getPhotos().size();i++){
                byte[] toConvert=car.getPhotos().get(i);

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            try (GZIPOutputStream gzipOutputStream = new GZIPOutputStream(baos)) {
                gzipOutputStream.write(toConvert);
            }
            tab.add(baos.toByteArray());
            }
            car.setPhotos(tab);*/
        System.out.println("car object coming from frontend"+car);
            return this.queryCarService.insertAllCridests(car);
   /*     } catch (Exception e) {
            // Handle exceptions
            return new Cars();
        }*/
    }
}
