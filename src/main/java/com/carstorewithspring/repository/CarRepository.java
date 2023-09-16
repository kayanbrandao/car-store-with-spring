package com.carstorewithspring.repository;

import com.carstorewithspring.data.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CarRepository extends JpaRepository<Car, Long> {
}
