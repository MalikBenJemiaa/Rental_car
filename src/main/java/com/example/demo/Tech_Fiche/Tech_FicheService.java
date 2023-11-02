package com.example.demo.Tech_Fiche;

import com.example.demo.Assurance.Assurance;
import com.example.demo.Assurance.AssuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Tech_FicheService {
private final Tech_FicheRepo tech_FicheRepo;

@Autowired
    public Tech_FicheService(Tech_FicheRepo teach_FicheRepo){
    this.tech_FicheRepo=teach_FicheRepo;
}
    public List<Tech_Fiche> getAllTechFiche() {
        System.out.println("slslsmmmmm1111");

        return tech_FicheRepo.findAll();
    }
    public Optional<Tech_Fiche> getTechFicheById(Long id) {
        return tech_FicheRepo.findById(id);
    }
    public Tech_Fiche createTechFiche(Tech_Fiche t) {
        return tech_FicheRepo.save(t);
    }

    public Tech_Fiche updateTechFiche(Long id, Tech_Fiche tech_Fiche) {
        Optional<Tech_Fiche> existingTechFiche = tech_FicheRepo.findById(id);
        if (existingTechFiche.isPresent()) {
            Tech_Fiche TechFicheToUpdate = existingTechFiche.get();
            TechFicheToUpdate.setDescription(tech_Fiche.getDescription());
            TechFicheToUpdate.setId(tech_Fiche.getId());
            TechFicheToUpdate.setMarque(tech_Fiche.getMarque());
            TechFicheToUpdate.setOption(tech_Fiche.getOption());
            TechFicheToUpdate.setPuissence(tech_Fiche.getPuissence());
            TechFicheToUpdate.setReleased_date(tech_Fiche.getReleased_date());
            TechFicheToUpdate.setEnergie(tech_Fiche.getEnergie());
            TechFicheToUpdate.setBoite(tech_Fiche.getBoite());



            // You can update other properties as needed
            return tech_FicheRepo.save(TechFicheToUpdate);
        } else {
            throw new RuntimeException("Tech_Fiche not found with id: " + id);
        }
    }

    public void deleteTechFiche(Long id) {
        tech_FicheRepo.deleteById(id);
    }

}
