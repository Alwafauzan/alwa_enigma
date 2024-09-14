package com.example.cobajwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cobajwt.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
