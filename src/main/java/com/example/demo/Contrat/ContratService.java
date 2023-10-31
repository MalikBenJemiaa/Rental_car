package com.example.demo.Contrat;

import com.example.demo.Client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContratService {
    private final ContractRepo contractRepo;

@Autowired
    public ContratService(ContractRepo contractRepo) {
        this.contractRepo = contractRepo;
    }
    ///////////////////////////////
    public List<Contrat> getAllContrat() {
        return contractRepo.findAll();
    }
    public Optional<Contrat> getContratById(Long id) {
        return contractRepo.findById(id);
    }
    public Contrat createContrat(Contrat contrat) {
        return contractRepo.save(contrat);
    }


    public Contrat updateContrat(Long id, Contrat updatedContrat) {
        Optional<Contrat> existingContrat = contractRepo.findById(id);
        if (existingContrat.isPresent()) {
            Contrat contratToUpdate = existingContrat.get();
            contratToUpdate.setContratPdf(updatedContrat.getContratPdf());
            contratToUpdate.setStart_date(updatedContrat.getStart_date());
            contratToUpdate.setEnd_date(updatedContrat.getEnd_date());
            contratToUpdate.setFacture(updatedContrat.getFacture());


            // You can update other properties as needed
            return contractRepo.save(contratToUpdate);
        } else {
            throw new RuntimeException("Contract not found with id: " + id);
        }
    }
    public void deleteContrat(Long id) {
        contractRepo.deleteById(id);
    }
    /*public List<Long> getFactureIds(List<Long> idsTab){
        return this.contractRepo.findFactureIdsByLocationIds(idsTab);
    }*/

}
