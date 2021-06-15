package com.example.diploma.service;

import com.example.diploma.model.StudentDTO;
import com.example.diploma.repository.IStudentDAO;
import com.example.diploma.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class StudentService implements IStudentService {

    @Autowired
    IStudentDAO studentDAO;

    @Autowired
    IStudentRepository studentRepository;

    @Override
    public void create(StudentDTO stu) {
        studentDAO.save(stu);
    }

    @Override
    public StudentDTO read(Long id) {
        return studentDAO.findById(id);
    }

    @Override
    public void update(StudentDTO stu) {
        studentDAO.save(stu);
    }

    @Override
    public void delete(Long id) {
        studentDAO.delete(id);
    }

    @Override
    public Set<StudentDTO> getAll() {
        return this.studentRepository.findAll();
    }
}
