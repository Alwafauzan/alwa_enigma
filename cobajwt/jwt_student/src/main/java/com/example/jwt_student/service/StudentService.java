package com.example.jwt_student.service;

import org.springframework.data.domain.Page;

import com.example.jwt_student.dto.request.DTOReqStudent;
import com.example.jwt_student.dto.request.DTOReqUpdateStudent;
import com.example.jwt_student.dto.request.PagingStudentRequest;
import com.example.jwt_student.dto.response.DTORespStudent;
import com.example.jwt_student.model.Student;

public interface StudentService {
    DTORespStudent createNew(DTOReqStudent dtoReqStudent);

    DTORespStudent createNew(Student student);

    Student getById(String id);

    DTORespStudent getOne(String id);

    Page<DTORespStudent> getAll(PagingStudentRequest request);

    DTORespStudent update(DTOReqUpdateStudent request);

    void delete(String id);
}
