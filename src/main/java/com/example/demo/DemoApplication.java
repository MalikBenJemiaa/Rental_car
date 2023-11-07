package com.example.demo;

import com.example.demo.Accounts.AccountsRepo;
import com.example.demo.DbInitializr.InitializrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/*
@SpringBootApplication(scanBasePackages = "SpringSecurity")*/
@SpringBootApplication
@RestController
@CrossOrigin
public class DemoApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		InitializrService initializrService = null;
		initializrService.createTheFirstAdmin();
	}
@GetMapping("/")
	public String hello(){
		return "helloo";
}
}
