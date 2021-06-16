package com.meli.obtenerdiploma.unit;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
public class StudentDaoTest {


    @InjectMocks
    StudentDAO StudentDAO;


    @Test
    public void findByIdFailureTest(){

        Long id = null;

        assertThrows(StudentNotFoundException.class, () -> StudentDAO.findById(id));

    }
    @Test
    public void findByIdTest(){

        SubjectDTO subject1 = new SubjectDTO("Mate", 10.0);
        SubjectDTO subject2 = new SubjectDTO("Musica", 0.0);
        SubjectDTO subject3 = new SubjectDTO("Biologia", 5.0);
        List<SubjectDTO> subjects = new ArrayList<>(Arrays.asList(subject1, subject3, subject2));

        StudentDTO expectedStudent = new StudentDTO();
        expectedStudent.setStudentName("Alex");
        expectedStudent.setSubjects(subjects);
        expectedStudent.setId(100L);
        StudentDAO.save(expectedStudent);


        StudentDTO student = StudentDAO.findById(expectedStudent.getId());


        assertEquals(student, expectedStudent);

    }
    @Test
    public void deleteFailureTest(){

        SubjectDTO subject1 = new SubjectDTO("Mate", 10.0);
        SubjectDTO subject2 = new SubjectDTO("Musica", 0.0);
        SubjectDTO subject3 = new SubjectDTO("Biologia", 5.0);
        List<SubjectDTO> subjects = new ArrayList<>(Arrays.asList(subject1, subject3, subject2));

        StudentDTO expectedStudent = new StudentDTO();
        expectedStudent.setStudentName("Alex");
        expectedStudent.setSubjects(subjects);
        expectedStudent.setId(100L);



        StudentDAO.save(expectedStudent);
        StudentDAO.delete(expectedStudent.getId()+1L);


        assertTrue(StudentDAO.exists(expectedStudent));

    }
    @Test
    public void deleteTest(){

        SubjectDTO subject1 = new SubjectDTO("Mate", 10.0);
        SubjectDTO subject2 = new SubjectDTO("Musica", 0.0);
        SubjectDTO subject3 = new SubjectDTO("Biologia", 5.0);
        List<SubjectDTO> subjects = new ArrayList<>(Arrays.asList(subject1, subject3, subject2));

        StudentDTO expectedStudent = new StudentDTO();
        expectedStudent.setStudentName("Alex");
        expectedStudent.setSubjects(subjects);
        expectedStudent.setId(100L);



        StudentDAO.save(expectedStudent);
        StudentDAO.delete(expectedStudent.getId());


        assertFalse(StudentDAO.exists(expectedStudent));

    }

    @Test
    public void saveTest(){

        SubjectDTO subject1 = new SubjectDTO("Mate", 10.0);
        SubjectDTO subject2 = new SubjectDTO("Musica", 0.0);
        SubjectDTO subject3 = new SubjectDTO("Biologia", 5.0);
        List<SubjectDTO> subjects = new ArrayList<>(Arrays.asList(subject1, subject3, subject2));

        StudentDTO expectedStudent = new StudentDTO();
        expectedStudent.setStudentName("Alex");
        expectedStudent.setSubjects(subjects);
        expectedStudent.setId(100L);



        StudentDAO.save(expectedStudent);



        assertTrue(StudentDAO.exists(expectedStudent));

    }

    @Test
    public void existTest(){

        Long id = new Long(1);

        StudentDTO student =StudentDAO.findById(id);

        Boolean response = StudentDAO.exists(student);

        assertTrue(response);

    }

}
