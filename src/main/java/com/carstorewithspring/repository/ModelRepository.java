package com.carstorewithspring.repository;

import com.carstorewithspring.data.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ModelRepository extends JpaRepository<Model, Long> {
}
