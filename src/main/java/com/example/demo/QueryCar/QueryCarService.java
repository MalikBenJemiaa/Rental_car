package com.example.demo.QueryCar;

import com.example.demo.Assurance.Assurance;
import com.example.demo.Assurance.AssuranceRepo;
import com.example.demo.Tech_Fiche.Tech_Fiche;
import com.example.demo.Tech_Fiche.Tech_FicheRepo;
import com.example.demo.cars.Cars;
import com.example.demo.cars.CarsRepo;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QueryCarService {
   // @Autowired
    private final AssuranceRepo assuranceRepository;
    //@Autowired
    private final Tech_FicheRepo techFicheRepository;
    private final CarsRepo carsRepo;


    @Autowired
    public QueryCarService(AssuranceRepo ass,Tech_FicheRepo techFicheRepository,CarsRepo carsRepo){
        this.assuranceRepository=ass;
        this.techFicheRepository=techFicheRepository;
        this.carsRepo=carsRepo;


    }
    //@Transactional
    public Cars insertAllCridests(Cars carr){
        Assurance assurance = new Assurance(carr.getNum_assurance());
        assuranceRepository.save(assurance);

        Tech_Fiche techFiche = new Tech_Fiche(carr.getTech_fiche());
        Tech_Fiche techFicheee =techFicheRepository.save(techFiche);
        Assurance assurancee = assuranceRepository.findById(assurance.getNum_assurace()).orElseThrow(() -> new EntityNotFoundException("Assurance not found"));
        Tech_Fiche techFichee = techFicheRepository.findById(techFicheee.getId()).orElseThrow(() -> new EntityNotFoundException("Tech_Fiche not found"));

        Cars car = new Cars();
        car.setMat(carr.getMat());
        car.setModel(carr.getModel());
        car.setStock(carr.getStock());
        car.setPrice_per_day(carr.getPrice_per_day());
        car.setColor(carr.getColor());
        car.setNum_assurance(assurance);
        car.setTech_fiche(techFicheee);
        car.setPhoto1(carr.getPhoto1());
        car.setPhoto2(carr.getPhoto2());
        car.setPhoto3(carr.getPhoto3());
        car.setPhoto4(carr.getPhoto4());
// Set other properties of the car

        carsRepo.save(car);

        return carr;
    }
}
