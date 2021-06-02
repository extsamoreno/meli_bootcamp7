package com.example.ApiSpring2.services;

import com.example.ApiSpring2.dto.CourseDTO;
import com.example.ApiSpring2.dto.DiplomaDTO;
import com.example.ApiSpring2.dto.StudentDTO;
import com.example.ApiSpring2.entities.Student;
import com.example.ApiSpring2.repository.StudentRepository;

import java.util.ArrayList;

public class DiplomaService {
    ArrayList<Student> students = StudentRepository.addData();

    public ArrayList<Student> getStudents(){
        return StudentRepository.addData();
    }

    public DiplomaDTO getDiploma(Integer id){
        Student student = null;
        for(Student st : students){
            if(st.getId() == id) {
                student = st;
                break;
            }
        }
        if(student!=null) {
            float avg = 0;
            int count = 1;
            for (CourseDTO asignatura : student.getCourse()) {
                if (asignatura.getNote() > 6) {
                    avg += asignatura.getNote();
                    count++;
                }
            }
            avg = (float) (avg / (count - 1));
            String msg = avg > 8 ? "felicidades" : "";
            return new DiplomaDTO(msg,avg, new StudentDTO(student.getName(),student.getCourse()));
        }
        else{
            return null;
        }
    }

}
