package com.example.demo.Facture;

import com.example.demo.Assurance.Assurance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FactureService {
    private final FactureRepo Frepo;


    @Autowired
    public FactureService(FactureRepo frepo){

    this.Frepo=frepo;
}
    public List<Facture> getAllFacture() {
        return Frepo.findAll();
    }
    public Optional<Facture> getFactureById(Long id) {
        return Frepo.findById(id);
    }
    public Facture createFacture(Facture f) {
        return Frepo.save(f);
    }
    public Facture updateFacture(Long id, Facture updatedFacture) {
        Optional<Facture> existingFacture = Frepo.findById(id);
        if (existingFacture.isPresent()) {
            Facture factureToUpdate = existingFacture.get();
            factureToUpdate.setCreationDate(updatedFacture.getCreationDate());
            factureToUpdate.setPrice(updatedFacture.getPrice());

            // You can update other properties as needed
            return Frepo.save(factureToUpdate);
        } else {
            throw new RuntimeException("Facutre not found with id: " + id);
        }
    }
    public void deleteFacutre(Long id) {
        Frepo.deleteById(id);
    }
    public void deleteMoreThenOneFacture(List<Long> tabOfIds){
        System.out.println(tabOfIds);
        this.Frepo.deleteByFactureIds(tabOfIds);
    }
}





