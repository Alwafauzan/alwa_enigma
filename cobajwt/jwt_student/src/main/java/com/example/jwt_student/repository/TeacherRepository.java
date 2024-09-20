package com.example.jwt_student.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jwt_student.model.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, String> {
    Optional<Teacher> findByName(String name);
}
