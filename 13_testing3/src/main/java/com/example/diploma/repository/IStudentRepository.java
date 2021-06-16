package com.example.diploma.repository;

import com.example.diploma.model.StudentDTO;

import java.util.Set;

public interface IStudentRepository {

    Set<StudentDTO> findAll();

}
