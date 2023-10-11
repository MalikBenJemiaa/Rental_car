package com.example.demo.Assurance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Assurance")
public class AssuranceController {
private final AssuranceService assuranceService;

@Autowired
public AssuranceController(AssuranceService assuranceService) {
        this.assuranceService = assuranceService;
    }
    @GetMapping("/GetAllAssurances")
    public List<Assurance> getAllAssurance() {
        return assuranceService.getAllAssurance();
    }
    @GetMapping("/GetOneAssurance/{id}")
    public Optional<Assurance> getAssuranceById(@PathVariable Long id) {
        return assuranceService.getAssuranceById(id);
    }
    @PostMapping("/CreateAssurance")
    public Assurance createAssurance(@RequestBody Assurance assurance) {
        return assuranceService.createAssurance(assurance);
    }

    @PutMapping("/UpdateAssurance/{id}")
    public Assurance updateAssurance(@PathVariable Long id, @RequestBody Assurance updatedAssurance) {
        return assuranceService.updateAssurance(id, updatedAssurance);
    }

    @DeleteMapping("/DeleteAssurance/{id}")
    public void deleteAssurance(@PathVariable Long id) {
        assuranceService.deleteAssurance(id);
    }
}
