package com.example.demo.cars;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CarsRepo extends JpaRepository<Cars,Long> {
}