package com.meli.obtenerdiploma.unit.utils;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utils {
    public static StudentDTO getStudentDTOWithAverage(double average) {
        StudentDTO studentDTO = getStudentDTO();
        setScore(studentDTO.getSubjects(),average);
        return studentDTO;
    }

    private static void setScore(List<SubjectDTO> subjects, double v) {
        subjects.forEach((x)->x.setScore(v));
    }

    public static StudentDTO getStudentDTO() {
        SubjectDTO subject1= new SubjectDTO("mate1",10D);
        SubjectDTO subject2= new SubjectDTO("mate2",10D);
        SubjectDTO subject3= new SubjectDTO("mate3",10D);

        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(subject1);
        subjects.add(subject2);
        subjects.add(subject3);

        StudentDTO studentDTO= new StudentDTO();
        studentDTO.setStudentName("Test");
        studentDTO.setSubjects(subjects);
        return studentDTO;
    }
}
