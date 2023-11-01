package com.example.demo.QueryCar;

import com.example.demo.Execptons.myExecption;
import com.example.demo.cars.Cars;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/")
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
    @DeleteMapping("/secure/admin/deleteCarAndRelatedInfo/{idCar}")

    public ResponseEntity<String> deleteCarAndAllRelatedInfo(@PathVariable Long idCar){
                try {
                    this.queryCarService.deleteTheCarAndTheRelatedInfo(idCar);

                }catch (myExecption e){
                     return ResponseEntity.status(HttpStatus.NOT_FOUND).body("we got an error the operation not affected");

                }

                return ResponseEntity.status(HttpStatus.OK).body("Operation affected with success");

    }
}
