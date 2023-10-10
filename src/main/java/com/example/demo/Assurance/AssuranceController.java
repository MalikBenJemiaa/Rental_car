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
    @GetMapping
    public List<Assurance> getAllAuthors() {
        return assuranceService.getAllAssurance();
    }
    @GetMapping("/{id}")
    public Optional<Assurance> getAuthorById(@PathVariable Long id) {
        return assuranceService.getAssuranceById(id);
    }
    @PostMapping
    public Assurance createAuthor(@RequestBody Assurance assurance) {
        return assuranceService.createAssurance(assurance);
    }

    @PutMapping("/{id}")
    public Assurance updateAuthor(@PathVariable Long id, @RequestBody Assurance updatedAssurance) {
        return assuranceService.updateAssurance(id, updatedAssurance);
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable Long id) {
        assuranceService.deleteAssurance(id);
    }
}
