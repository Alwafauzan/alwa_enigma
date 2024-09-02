package com.example.studentapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.studentapi.model.Student;
import com.example.studentapi.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // Menyimpan Student
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    // Mengambil semua Student
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Mengambil Student berdasarkan ID
    public Optional<Student> getStudentById(Integer id) {
        return studentRepository.findById(id);
    }

    // Mengupdate Student
    public Student updateStudent(Integer id, Student studentDetails) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found for this id :: " + id));

        student.setNama(studentDetails.getNama());
        student.setJurusan(studentDetails.getJurusan());
        return studentRepository.save(student);
    }

    // Menghapus Student
    public void deleteStudent(Integer id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found for this id :: " + id));

        studentRepository.delete(student);
    }
}
