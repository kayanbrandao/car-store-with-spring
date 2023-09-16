package com.carstorewithspring.repository;

import com.carstorewithspring.data.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BrandRepository extends JpaRepository<Brand, Long> {
}
