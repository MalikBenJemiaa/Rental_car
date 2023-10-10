package com.example.demo.Assurance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Assurance")
public class AssuranceController {
private final AssuranceService assuranceService;
@Autowired
public AssuranceController(AssuranceService assuranceService) {
        this.assuranceService = assuranceService;
    }
}
