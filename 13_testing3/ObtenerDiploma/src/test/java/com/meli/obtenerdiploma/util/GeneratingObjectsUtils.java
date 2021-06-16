package com.meli.obtenerdiploma.util;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;

import java.util.ArrayList;
import java.util.List;

public class GeneratingObjectsUtils {

    public static StudentDTO getGoodStudent(){
        SubjectDTO subjectDTO1 = new SubjectDTO("Matemática", 10.0);
        SubjectDTO subjectDTO2 = new SubjectDTO("Física", 8.0);
        SubjectDTO subjectDTO3 = new SubjectDTO("Química", 10.0);
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(subjectDTO1);
        subjects.add(subjectDTO2);
        subjects.add(subjectDTO3);

        return new StudentDTO(2L,"Pedro", null, null, subjects);
    }


    public static StudentDTO getBadStudent(){
        SubjectDTO subjectDTO1 = new SubjectDTO("Matemática", 9.0);
        SubjectDTO subjectDTO2 = new SubjectDTO("Física", 7.0);
        SubjectDTO subjectDTO3 = new SubjectDTO("Química", 6.0);
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(subjectDTO1);
        subjects.add(subjectDTO2);
        subjects.add(subjectDTO3);

        return new StudentDTO(1L,"Juan", null, null, subjects);
    }


    public static StudentDTO getNewtudent(){
        SubjectDTO subjectDTO1 = new SubjectDTO("Matemática", 10.0);
        SubjectDTO subjectDTO2 = new SubjectDTO("Física", 9.0);
        SubjectDTO subjectDTO3 = new SubjectDTO("Química", 10.0);
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(subjectDTO1);
        subjects.add(subjectDTO2);
        subjects.add(subjectDTO3);

        return new StudentDTO(null,"Yisel", null, null, subjects);
    }
}
