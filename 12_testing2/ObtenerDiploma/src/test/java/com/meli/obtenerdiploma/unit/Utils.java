package com.meli.obtenerdiploma.unit;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;

import java.util.ArrayList;
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
        SubjectDTO subjectDTOOne = new SubjectDTO("Matemática",9d);
        SubjectDTO subjectDTOTwo = new SubjectDTO("Física",7d);
        SubjectDTO subjectDTOThree = new SubjectDTO("Química",6d);

        List<SubjectDTO> listSubjects = new ArrayList<>();
        listSubjects.add(subjectDTOOne);
        listSubjects.add(subjectDTOTwo);
        listSubjects.add(subjectDTOThree);

        StudentDTO studentDTO = new StudentDTO(1L,"Leandro"
                ,null
                ,null
                ,listSubjects);

        return studentDTO;

    }
}
