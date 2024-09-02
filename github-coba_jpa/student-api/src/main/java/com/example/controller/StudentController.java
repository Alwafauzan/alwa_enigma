package com.example.controller;

import java.util.List;

import com.example.model.Student;
import com.example.service.StudentService;

public class StudentController {

    private StudentService studentService;

    public StudentController() {
        studentService = new StudentService();
    }

    // public void createStudent(String nama, String jurusan) {
    // Student student = new Student();
    // student.setNama(nama);
    // student.setJurusan(jurusan);
    // studentService.saveStudent(student);
    // }

    public void createStudent(String nama, String jurusan) {
        Student student = new Student(nama, jurusan);
        studentService.saveStudent(student);
    }

    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    public Student getStudentById(int id) {
        return studentService.getStudentById(id);
    }

    public void updateStudent(int id, String nama, String jurusan) {
        Student student = studentService.getStudentById(id);
        if (student != null) {
            student.setNama(nama);
            student.setJurusan(jurusan);
            studentService.updateStudent(student);
        }
    }

    public void deleteStudent(int id) {
        studentService.deleteStudent(id);
    }
}
