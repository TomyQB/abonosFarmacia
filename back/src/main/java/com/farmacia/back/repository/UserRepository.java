package com.farmacia.back.repository;

import com.farmacia.back.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    
    User findByNameAndPassword(String email, String password);
}
