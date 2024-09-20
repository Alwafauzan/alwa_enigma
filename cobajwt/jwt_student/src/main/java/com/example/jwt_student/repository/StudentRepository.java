package com.example.jwt_student.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jwt_student.model.Student;

public interface StudentRepository extends JpaRepository<Student, String> {

    Optional<Student> findByName(String name);
}