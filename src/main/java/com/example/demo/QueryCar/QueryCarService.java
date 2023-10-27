package com.example.demo.QueryCar;

import com.example.demo.Execptons.myExecption;
import com.example.demo.Assurance.Assurance;
import com.example.demo.Assurance.AssuranceRepo;
import com.example.demo.Contrat.ContractRepo;
import com.example.demo.Facture.FactureRepo;
import com.example.demo.Location.LocationRepo;
import com.example.demo.Tech_Fiche.Tech_Fiche;
import com.example.demo.Tech_Fiche.Tech_FicheRepo;
import com.example.demo.cars.Cars;
import com.example.demo.cars.CarsRepo;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QueryCarService {
   // @Autowired
    private final AssuranceRepo assuranceRepository;
    //@Autowired
    private final Tech_FicheRepo techFicheRepository;
    private final CarsRepo carsRepo;
    private final ContractRepo contractRepo;

    private final FactureRepo factureRepo;
    private final LocationRepo locationRepo;

    @Autowired
    public QueryCarService(LocationRepo locationRepo,FactureRepo factureRepo,ContractRepo contractRepo, AssuranceRepo ass,Tech_FicheRepo techFicheRepository,CarsRepo carsRepo){
        this.assuranceRepository=ass;
        this.techFicheRepository=techFicheRepository;
        this.carsRepo=carsRepo;
        this.contractRepo=contractRepo;
        this.factureRepo=factureRepo;
        this.locationRepo=locationRepo;


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
    @Transactional
    public void deleteFactureFormTheLocationIds  (List<Long> locationId) throws myExecption{
        List<Long> FactureIds = this.contractRepo.findFactureIdsByLocationIds(locationId);
        /*System.out.println(FactureIds);*/

        System.out.println(FactureIds);
        this.contractRepo.deleteAllByLocationIds(locationId);
        this.factureRepo.deleteByFactureIds(FactureIds);

    }
    @Transactional
    public void deleteTheCarAndTheRelatedInfo  (Long idCar) throws myExecption{
        System.out.println("lmssml");

        List<Long> locationIds=this.locationRepo.findTheIdLocationByTheCarMat(idCar);
        System.out.println(locationIds);
        if (locationIds.size()==0){
            /*this when the car has hot a related data*/
            throw new myExecption("","this car not deserve this method to delete it");
        }

        this.deleteFactureFormTheLocationIds(locationIds)  ;
        this.locationRepo.deleteAllTheLocationWithIdCar(idCar);
        Long idAssurance =this.carsRepo.getAssuranceNum(idCar);
        this.carsRepo.deleteById(idCar);
        this.assuranceRepository.deleteById(idAssurance);
    }


}
