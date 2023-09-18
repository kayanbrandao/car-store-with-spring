package com.carstorewithspring.repository;

import com.carstorewithspring.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
