package com.example.demo.services;

import com.example.demo.model.Student;
import com.example.demo.repositories.IStudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentService  implements  IStudentService{

    IStudentRepository iStudentRepository;


    @Override
    public void createStudent(Student student) {
        iStudentRepository.save(student);

    }

    @Override
    public void deleteStudent(Student student) {
        iStudentRepository.delete(student);

    }

    @Override
    public List<Student> findAll() {
        return iStudentRepository.findAll(PageRequest.of(1,50)).getContent();
    }

    @Override
    public Optional<Student> findById(Long id) {
        return iStudentRepository.findById(id);
    }

    @Override
    public void updateStudent(Student student) {
        iStudentRepository.save(student);
    }
}
