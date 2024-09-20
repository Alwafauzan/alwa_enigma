package com.example.jwt_student.service.imp;

import java.util.Optional;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.example.jwt_student.dto.request.DTOReqStudent;
import com.example.jwt_student.dto.request.DTOReqUpdateStudent;
import com.example.jwt_student.dto.request.PagingStudentRequest;
import com.example.jwt_student.dto.response.DTORespStudent;
import com.example.jwt_student.model.Student;
import com.example.jwt_student.repository.StudentRepository;
import com.example.jwt_student.service.StudentService;
import com.example.jwt_student.util.ValidationUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class StudentServiceImp implements StudentService {

    private final StudentRepository studentRepository;
    private final ValidationUtil validationUtil;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public DTORespStudent createNew(DTOReqStudent request) {
        try {
            validationUtil.validate(request);
            Student student = Student.builder()
                    .nim(request.getNim())
                    .name(request.getName())
                    .email(request.getEmail())
                    .password(request.getPassword())
                    .build();
            studentRepository.saveAndFlush(student);
            return mapToResponse(student);
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "data sudah exist");
        }
    }

    @Override
    public DTORespStudent createNew(Student request) {
        Student student = studentRepository.saveAndFlush(request);
        return mapToResponse(student);
    }

    @Transactional(readOnly = true)
    @Override
    public Student getById(String id) {
        return findByIdOrThrowNotFound(id);
    }

    @Override
    public DTORespStudent getOne(String id) {
        Student student = findByIdOrThrowNotFound(id);
        return mapToResponse(student);
    }

    @Transactional(readOnly = true)
    @Override
    public Page<DTORespStudent> getAll(PagingStudentRequest request) {
        Pageable pageable = PageRequest.of(request.getPage() - 1, request.getSize());
        Page<Student> students = studentRepository.findAll(pageable);
        return students.map(student -> mapToResponse(student));
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    // INI APA BJIR UDAH KU BKIN
    public DTORespStudent update(DTOReqUpdateStudent request) {
        try {
            Student currentStudent = findByIdOrThrowNotFound(request.getId());
            currentStudent.setNim(request.getNim());
            currentStudent.setName(request.getName());
            currentStudent.setEmail(request.getEmail());
            currentStudent.setPassword(request.getPassword());
            studentRepository.saveAndFlush(currentStudent);
            return mapToResponse(currentStudent);
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "data already exist");
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(String id) {
        Student student = findByIdOrThrowNotFound(id);
        studentRepository.delete(student);
    }

    // helper-----------------------------------------------------------
    private Student findByIdOrThrowNotFound(String id) {
        Optional<Student> student = studentRepository.findById(id);
        return student.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "student not found"));
    }

    private DTORespStudent mapToResponse(Student student) {
        return DTORespStudent.builder()
                .studentId(student.getId())
                .nim(student.getNim())
                .name(student.getName())
                .email(student.getEmail())
                .password(student.getPassword())
                .build();
    }

}
