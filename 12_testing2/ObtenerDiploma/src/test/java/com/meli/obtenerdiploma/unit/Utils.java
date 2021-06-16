package com.meli.obtenerdiploma.unit;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;

import java.util.Arrays;
import java.util.List;

public class Utils {

    public static StudentDTO getStudentDTO() {

        SubjectDTO subject1 = new SubjectDTO("Matematica", 10.0);
        SubjectDTO subject2 = new SubjectDTO("Lengua", 8.0);
        SubjectDTO subject3 = new SubjectDTO("Fisica", 9.0);

        List<SubjectDTO> list = (Arrays.asList(subject1, subject2, subject3));
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentName("Carlos");
        studentDTO.setSubjects(list);

        return studentDTO;
    }

    public static StudentDTO getStudentDTOWithAverage(double average) {

        StudentDTO studentDTO = getStudentDTO();
        setScore(studentDTO.getSubjects(),average);
        return studentDTO;
    }

    private static void setScore(List<SubjectDTO> subjects, double v) {
        subjects.forEach((x)->x.setScore(v));
    }

}
