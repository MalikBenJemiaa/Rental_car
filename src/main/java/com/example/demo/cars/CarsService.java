package com.example.demo.cars;

import com.example.demo.Assurance.Assurance;
import com.example.demo.Assurance.AssuranceService;
import com.example.demo.Tech_Fiche.Tech_Fiche;
import com.example.demo.Tech_Fiche.Tech_FicheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarsService {
    private CarsRepo carsRepo;

    private final Tech_FicheService techFicheService;
    private final AssuranceService assuranceService;
    @Autowired
    public CarsService(CarsRepo carsRepo, Tech_FicheService techFicheService, AssuranceService assuranceService) {
        this.carsRepo = carsRepo;
        this.techFicheService = techFicheService;

        this.assuranceService = assuranceService;
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
            carsToUpdate.setPhoto1(updatedCars.getPhoto1());
            carsToUpdate.setPhoto2(updatedCars.getPhoto2());
            carsToUpdate.setPhoto3(updatedCars.getPhoto3());
            carsToUpdate.setPhoto4(updatedCars.getPhoto4());
            carsToUpdate.setPrice_per_day(updatedCars.getPrice_per_day());

            //checking if is there a techfiche or not
            Optional<Tech_Fiche> FrontTechFiche =techFicheService.getTechFicheById(updatedCars.getTech_fiche().getId());
            Tech_Fiche UT=new Tech_Fiche(updatedCars.getTech_fiche());
            if(FrontTechFiche.isPresent()){

                techFicheService.updateTechFiche(updatedCars.getTech_fiche().getId(),UT);
            }
            else{

                carsToUpdate.setTech_fiche(techFicheService.createTechFiche(UT));
            }


            Optional<Assurance> FrontAssurance =assuranceService.getAssuranceById(updatedCars.getNum_assurance().getNum_assurace());
            Assurance UA=new Assurance(updatedCars.getNum_assurance());
            if(FrontAssurance.isPresent()){
                assuranceService.updateAssurance(updatedCars.getNum_assurance().getNum_assurace(),UA);
            }
            else{

                carsToUpdate.setNum_assurance(assuranceService.createAssurance(UA));
            }

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
