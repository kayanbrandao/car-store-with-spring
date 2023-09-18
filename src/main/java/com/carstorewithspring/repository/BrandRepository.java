package com.carstorewithspring.repository;

import com.carstorewithspring.data.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {
}
