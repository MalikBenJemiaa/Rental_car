package com.example.demo.Facture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RestController
@RequestMapping("/Facutre")
public class FacutreController {
    private final FactureService fService;
    @Autowired
    public FacutreController(FactureService fser){
        this.fService=fser;
    }

    @GetMapping("/GetAllFacutres")
    public List<Facture> getAllFacture(){
        return this.fService.getAllFacture();
    }
    @GetMapping("/getFactureBuId/{itemId}")
    public Optional<Facture> getFactureById(@PathVariable Long itemId){
        return this.fService.getFactureById(itemId);
    }
    @PostMapping("/registerNewFacute")
    public Facture registerNewFacture(@RequestBody Facture f){
        System.out.println("lsmsml");
        return this.fService.createFacture(f);

    }
    @PutMapping("/updateFacuture/{itemId}")
    public Facture updateFacutre(@PathVariable Long itemId,@RequestBody Facture f){
        return this.fService.updateFacture(itemId,f);
    }
    @DeleteMapping("/deleteFacture/{itemId}")
    public void deleteFacture(@PathVariable Long itemId){
        this.fService.deleteFacutre(itemId);
    }
}
