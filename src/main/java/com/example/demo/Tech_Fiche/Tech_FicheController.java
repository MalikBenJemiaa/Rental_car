package com.example.demo.Tech_Fiche;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@RequestMapping("/tech_fiche")
@RestController
@Controller
public class Tech_FicheController {
    private final Tech_FicheService techFicheService;
    @Autowired
    public Tech_FicheController(Tech_FicheService techFicheService){
        this.techFicheService=techFicheService;
    }
    @GetMapping("/ ")
    public List<Tech_Fiche> getallficheTech(){
        System.out.println("slslsmmmmm");
        return this.techFicheService.getAllTechFiche();
    }

        @DeleteMapping("/deleteTechFiche/{itemId}")
        public void deleteTechFiche(@PathVariable Long itemId){
            this.techFicheService.deleteTechFiche(itemId);
        }
    @PutMapping("/updateTechFiche/{itemId}")
    public Tech_Fiche updateTechFiche( @PathVariable Long itemId,@RequestBody Tech_Fiche t){
            return  this.techFicheService.updateTechFiche(itemId,t);

    }
    @PostMapping("/insertTechFiche")
    public Tech_Fiche insertTchFiche(@RequestBody Tech_Fiche t){
        /*Tech_Fiche t=new Tech_Fiche(1l,"bmw",12,"full option",new Date(1234567890000L),"a great car");
        */
        return techFicheService.createTechFiche(t);
    }
    }
