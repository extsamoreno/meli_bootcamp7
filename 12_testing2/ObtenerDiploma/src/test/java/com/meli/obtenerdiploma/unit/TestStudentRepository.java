package com.meli.obtenerdiploma.unit;


import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestStudentRepository {
    @Test
    public void findAllTest(){
        Set<StudentDTO> expected = new HashSet<>();
        Set<StudentDTO> received = new HashSet<>();

        StudentDTO a = new StudentDTO(1L, "Juan", null, null, null);

        SubjectDTO m1 = new SubjectDTO("Matemática", 9.0);
        SubjectDTO m2 = new SubjectDTO("Física", 7.0);
        SubjectDTO m3 = new SubjectDTO("Química", 6.0);
        List<SubjectDTO> materias = new ArrayList<>();
        materias.add(m1);
        materias.add(m2);
        materias.add(m3);
        a.setSubjects(materias);
        expected.add(a);


        StudentDTO b = new StudentDTO(2L, "Pedro", null, null, null);
        SubjectDTO ma1 = new SubjectDTO("Matemática", 10.0);
        SubjectDTO ma2 = new SubjectDTO("Física", 8.0);
        SubjectDTO ma3 = new SubjectDTO("Química", 4.0);
        List<SubjectDTO> materias2 = new ArrayList<>();
        materias2.add(ma1);
        materias2.add(ma2);
        materias2.add(ma3);
        b.setSubjects(materias2);
        received.add(b);


        IStudentRepository iStudentRepository = new StudentRepository();

        received = iStudentRepository.findAll();

        Assertions.assertEquals(expected, received);


    }

}
