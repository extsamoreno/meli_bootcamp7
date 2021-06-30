package com.example.demo.services;

import com.example.demo.model.Student;

import java.util.List;
import java.util.Optional;

public interface IStudentService {
    void createStudent(Student student);
    void deleteStudent(Student student);
    List<Student> findAll();
    Optional<Student> findById(Long id);
    void updateStudent(Student student);
}
