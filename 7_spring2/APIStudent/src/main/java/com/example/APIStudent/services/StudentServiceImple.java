package com.example.APIStudent.services;

import com.example.APIStudent.repository.Course;
import com.example.APIStudent.repository.Student;
import com.example.APIStudent.services.dto.StudentDTO;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImple implements IStudentService{

    @Override
    public StudentDTO getCertificate(Student student) {
        return new StudentDTO(student.getName(),getMessage(student),calculateProm(student));
    }
    public double calculateProm(Student student){
        double aux=0;
        for (Course course: student.getCourses()) {
            aux+=course.getGrade();

        }
        return aux/student.getCourses().size();
    }
    public String getMessage(Student student){

        String message;
        if(calculateProm(student)>9){
            message=" ¡¡¡Congratulations!!!";
        }else message="Approved";
        return message;
    }
}
