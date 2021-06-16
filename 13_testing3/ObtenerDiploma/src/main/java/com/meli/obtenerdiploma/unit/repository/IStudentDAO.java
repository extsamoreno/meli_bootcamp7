package com.meli.obtenerdiploma.unit.repository;

import com.meli.obtenerdiploma.model.StudentDTO;

public interface IStudentDAO {
    void save(StudentDTO stu);
    boolean delete(Long id);
    boolean exists(StudentDTO stu);
    StudentDTO findById(Long id);
}