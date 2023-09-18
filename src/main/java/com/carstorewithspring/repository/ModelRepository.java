package com.carstorewithspring.repository;

import com.carstorewithspring.data.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Long> {
}
