package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
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
    public void create(StudentDTO stu)  {
        if(stu.getId()==null) throw new StudentNotFoundException(stu.getId());
        studentDAO.save(stu);
    }

    @Override
    public StudentDTO read(Long id) {
        if(id==null) throw new StudentNotFoundException(id);
        return studentDAO.findById(id);
    }

    @Override
    public void update(StudentDTO stu) {
        if(stu.getId()==null) throw new StudentNotFoundException(stu.getId());
        studentDAO.save(stu);
    }

    @Override
    public void delete(Long id) {
        if(id==null) throw new StudentNotFoundException(id);
        studentDAO.delete(id);
    }

    @Override
    public Set<StudentDTO> getAll() {
        return this.studentRepository.findAll();
    }
}
