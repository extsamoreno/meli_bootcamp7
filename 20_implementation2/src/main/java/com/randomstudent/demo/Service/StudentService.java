package com.randomstudent.demo.Service;

import com.randomstudent.demo.Model.StudentDTO;
import com.randomstudent.demo.Repository.IStudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class StudentService implements IStudentService{

    IStudentRepository iStudentRepository;

    @Override
    public List<StudentDTO> getTenExhibitors() {
        return null;
    }
}
