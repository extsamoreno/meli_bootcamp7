package com.meli.obtenerdiploma.Utils;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;

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

    public static StudentDTO getExcelentStudentDTO() {
        SubjectDTO subject1= new SubjectDTO("Mate1",10D);
        SubjectDTO subject2= new SubjectDTO("Mate2",10D);
        SubjectDTO subject3= new SubjectDTO("Mate3",10D);
        List<SubjectDTO> list= (Arrays.asList(subject1,subject2,subject3));
        StudentDTO studentDTO= new StudentDTO();
        studentDTO.setStudentName("Test");
        studentDTO.setSubjects(list);
        return studentDTO;
    }


    public static StudentDTO getStudentDTO() {
        SubjectDTO subject1= new SubjectDTO("Mate1",6.D);
        SubjectDTO subject2= new SubjectDTO("Mate2",7.D);
        SubjectDTO subject3= new SubjectDTO("Mate3",6.5);
        List<SubjectDTO> list= (Arrays.asList(subject1,subject2,subject3));
        StudentDTO studentDTO= new StudentDTO();
        studentDTO.setStudentName("Test2");
        studentDTO.setSubjects(list);
        return studentDTO;
    }

    public static List<SubjectDTO> getArraySubjects(){
        SubjectDTO subject1= new SubjectDTO("Mate",5.5);
        SubjectDTO subject2= new SubjectDTO("Geometria",6.5);
        SubjectDTO subject3= new SubjectDTO("Fisica",6.);
        List<SubjectDTO> result = Arrays.asList(subject1,subject2,subject3);
        return result;
    }
}
