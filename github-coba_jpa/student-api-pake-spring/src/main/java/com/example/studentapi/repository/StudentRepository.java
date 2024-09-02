package com.example.studentapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// import com.example.model.Student;
import com.example.studentapi.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    // Kamu bisa menambahkan metode query khusus di sini jika diperlukan
}
