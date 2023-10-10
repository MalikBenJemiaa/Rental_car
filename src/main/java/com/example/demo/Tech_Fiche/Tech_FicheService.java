package com.example.demo.Tech_Fiche;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Tech_FicheService {
private final Tech_FicheRepo tech_FicheRepo;
@Autowired
    public Tech_FicheService(Tech_FicheRepo teach_FicheRepo){
    this.tech_FicheRepo=teach_FicheRepo;
}
    public Tech_FicheService(){

      //  tech_FicheRepo = null;
    }
}
