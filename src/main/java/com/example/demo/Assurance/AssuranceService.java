package com.example.demo.Assurance;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class AssuranceService {
    private AssuranceRepo assuranceRepo;
    public AssuranceService(){

    }
    @Autowired
    public AssuranceService(AssuranceRepo assuranceRepo) {
        this.assuranceRepo = assuranceRepo;
    }

    public List<Assurance> getAllAssurance() {
        return assuranceRepo.findAll();
    }
    public Optional<Assurance> getAssuranceById(Long id) {
        return assuranceRepo.findById(id);
    }
    public Assurance createAssurance(Assurance assurance) {
        return assuranceRepo.save(assurance);
    }

    public Assurance updateAssurance(Long id, Assurance updatedAssurance) {
        Optional<Assurance> existingAssurance = assuranceRepo.findById(id);
        if (existingAssurance.isPresent()) {
            Assurance assuranceToUpdate = existingAssurance.get();
            assuranceToUpdate.setNum_assurace(updatedAssurance.getNum_assurace());
            assuranceToUpdate.setEnd_assurance(updatedAssurance.getEnd_assurance());
            // You can update other properties as needed
            return assuranceRepo.save(assuranceToUpdate);
        } else {
            throw new RuntimeException("Assurance not found with id: " + id);
        }
    }

    public void deleteAssurance(Long id) {
        assuranceRepo.deleteById(id);
    }
}
