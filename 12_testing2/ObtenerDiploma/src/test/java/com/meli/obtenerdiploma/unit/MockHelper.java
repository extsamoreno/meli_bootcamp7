package com.meli.obtenerdiploma.unit;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;

import java.util.Arrays;

public class MockHelper {
    public static StudentDTO getUserMockWithCongrats(){
        return new StudentDTO(1L,"Santiago Garcia", "", 0.0,
                Arrays.asList(new SubjectDTO("Fisica", 8.0), new SubjectDTO("Matematica", 10.0), new SubjectDTO("Lengua", 10.0)));
    }

    public static StudentDTO getUserMockWithoutCongrats(){
        return new StudentDTO(1L,"Santiago Garcia", "", 0.0,
                Arrays.asList(new SubjectDTO("Fisica", 5.0), new SubjectDTO("Matematica", 10.0), new SubjectDTO("Lengua", 10.0)));
    }
}
