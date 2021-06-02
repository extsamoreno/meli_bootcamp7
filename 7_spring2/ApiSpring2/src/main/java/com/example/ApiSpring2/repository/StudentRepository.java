package com.example.ApiSpring2.repository;

import com.example.ApiSpring2.dto.CourseDTO;
import com.example.ApiSpring2.entities.Student;

import java.util.ArrayList;

public class StudentRepository {
    public static ArrayList<Student> addData(){
        ArrayList<Student> students = new ArrayList<Student>();
        int count = 0;
        /*ArrayList<CourseDTO> notasFederico = new ArrayList<CourseDTO>();
        notasFederico.add(new CourseDTO("Matematica",(short)4));
        notasFederico.add(new CourseDTO("Historia",(short)6));
        notasFederico.add(new CourseDTO("Biologia", (short)7));
        students.add(new Student(count,"Federico", notasFederico));*/

        ArrayList<CourseDTO> notasLautaro = new ArrayList<CourseDTO>();
        notasLautaro.add(new CourseDTO("Matematica",(short)9));
        notasLautaro.add(new CourseDTO("Historia",(short)8));
        notasLautaro.add(new CourseDTO("Biologia", (short)3));
        students.add(new Student(count,"Lautaro", notasLautaro));

        return students;
    }
}
