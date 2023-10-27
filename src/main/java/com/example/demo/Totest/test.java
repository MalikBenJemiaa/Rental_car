package com.example.demo.Totest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apiDemo")

public class test {
    @GetMapping
    public ResponseEntity<String> sayHallo(){
        return ResponseEntity.ok("Hello you have a token");
    }
}
