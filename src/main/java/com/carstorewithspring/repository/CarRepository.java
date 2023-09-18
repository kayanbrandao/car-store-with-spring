package com.carstorewithspring.repository;

import com.carstorewithspring.data.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
