package com.randomstudent.demo.Service;

import com.randomstudent.demo.Model.Student;
import com.randomstudent.demo.Model.StudentDTO;
import com.randomstudent.demo.Repository.IStudentRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.*;

@AllArgsConstructor
@Service
public class StudentService implements IStudentService{

    IStudentRepository iStudentRepository;
    ModelMapper modelMapper;

    public Long getRandomNumber(){
        Random random = new Random();
        Long id = (long) random.nextInt(60);
        return id > 0 ? id : getRandomNumber();
    }

    @Override
    public Set<StudentDTO> getExhibitors(int count) {
        Set<StudentDTO> students = new HashSet<>();

        while (students.size() < count){
            Long id = getRandomNumber();
            Student student = iStudentRepository.getStudentById(id);
            students.add(modelMapper.map(student, StudentDTO.class));
        }

        return students;
    }
}
