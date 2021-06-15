package com.meli.obtenerdiploma.unit;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.mockito.internal.junit.StrictStubsRunnerTestListener;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestStudentDAO {

    @Test
    public void saveTest(){
        StudentDTO expected = new StudentDTO(3L, "Jorge", null, null, null);
        SubjectDTO m1 = new SubjectDTO("Matemática", 10.0);
        SubjectDTO m2 = new SubjectDTO("Física", 6.0);
        SubjectDTO m3 = new SubjectDTO("Química", 6.0);
        List<SubjectDTO> materias = new ArrayList<>();
        materias.add(m1);
        materias.add(m2);
        materias.add(m3);
        expected.setSubjects(materias);

        IStudentDAO studentDAO = new StudentDAO();

        studentDAO.save(expected);

        Assertions.assertTrue(studentDAO.exists(expected));

    }

    @Test
    public void findByIdTest(){
        IStudentDAO studentDAO = new StudentDAO();
        StudentDTO received  = studentDAO.findById(2L);

        StudentDTO expected = new StudentDTO(2L, "Pedro", null, null, null);
        SubjectDTO ma1 = new SubjectDTO("Matemática", 10.0);
        SubjectDTO ma2 = new SubjectDTO("Física", 8.0);
        SubjectDTO ma3 = new SubjectDTO("Química", 4.0);
        List<SubjectDTO> materias2 = new ArrayList<>();
        materias2.add(ma1);
        materias2.add(ma2);
        materias2.add(ma3);
        expected.setSubjects(materias2);

        Assertions.assertEquals(expected, received);

    }




}
