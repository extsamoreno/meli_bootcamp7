package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTests {
    @Mock
    IStudentDAO studentDAO;

    @Mock
    IStudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;



    @Test
    public void create() {

        StudentDTO studentDTO = new StudentDTO(1L, "Edu", "Congrats", 10.0, new ArrayList<>());

        Mockito.doNothing().when(studentDAO).save(studentDTO);

        studentService.create(studentDTO);
        Mockito.verify(studentDAO, Mockito.atLeastOnce()).save(studentDTO);
    }

    @Test
    public void readOkTest() {
        long expectedId = 1;
        StudentDTO expected = new StudentDTO(1L,
                "Edu","", 10.0,
                Arrays.asList(new SubjectDTO("Matematica", 10.0),
                        new SubjectDTO("Historia", 10.0),
                        new SubjectDTO("Fisica", 10.0)));

        Mockito.when(studentDAO.findById(expected.getId())).thenReturn(expected);

        StudentDTO received = studentService.read(expectedId);

        Mockito.verify(studentDAO, Mockito.atLeastOnce()).findById(expected.getId());

        Assertions.assertEquals(expected.getAverageScore(), received.getAverageScore());
        Assertions.assertEquals(expected, received);
    }

    @Test
    public void updateOkTest() {
        StudentDTO expected = new StudentDTO();
        expected.setId(1L);
        expected.setStudentName("Test");
        expected.setSubjects(Arrays.asList(new SubjectDTO("Matematica", 10.0),
                                        new SubjectDTO("Historia", 10.0),
                                        new SubjectDTO("Fisica", 10.0)));

        Mockito.doNothing().when(studentDAO).save(expected);

        studentService.update(expected);

        Mockito.verify(studentDAO, Mockito.atLeastOnce()).save(expected);
    }

    //@Test
    public void deleteOkTest() {
        long expectedId = 1L;

        Mockito.doNothing().when(studentDAO).delete(expectedId);

        studentService.delete(expectedId);

        Mockito.verify(studentDAO, Mockito.atLeastOnce()).delete(expectedId);
    }

    @Test
    public void getAllOkWithDataTest() {
        Set<StudentDTO> expected = new HashSet<>();
        expected.add(new StudentDTO());
        expected.add(new StudentDTO());

        Mockito.when(studentRepository.findAll()).thenReturn(expected);

        Set<StudentDTO> received = studentService.getAll();

        Assertions.assertEquals(expected, received);
    }
}
