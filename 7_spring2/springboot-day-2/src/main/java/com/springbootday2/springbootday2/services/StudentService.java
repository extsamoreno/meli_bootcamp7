package com.springbootday2.springbootday2.services;

import com.springbootday2.springbootday2.dtos.CertificateDTO;
import com.springbootday2.springbootday2.dtos.StudentDTO;
import com.springbootday2.springbootday2.entities.Course;
import com.springbootday2.springbootday2.entities.Student;

import java.util.HashMap;
import java.util.Objects;

public class StudentService {
    private HashMap<Integer, Student> studentHashMap;

    public StudentService() {
        this.studentHashMap = new HashMap<Integer, Student>();
    }

    public String addStudent(StudentDTO studentDTO) {

        Student student = new Student(studentHashMap.size()+1,
                                        studentDTO.getName(),
                                        studentDTO.getCourses());

        this.studentHashMap.put(student.getId(), student);

        return "Alumno agregado - id: " + student.getId();
    }

    public CertificateDTO generateCertificateByStudent(int idStudent) {
        Student student = studentHashMap.get(idStudent);

        if (Objects.isNull(student)) return null;

        float result = calculateAverage(student);

        String message = result >= 9 ? "Felicitaciones!" : "";

        CertificateDTO certificateDTO = new CertificateDTO(message, student.getName(), result);

        return certificateDTO;
    }

    private float calculateAverage(Student student) {
        float average = 0;

        for (Course course:
                student.getCourses()) {
            average += course.getNumber();
        }
        return average / student.getCourses().length;
    }
}
