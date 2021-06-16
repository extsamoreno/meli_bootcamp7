package com.meli.obtenerdiploma.unit;


import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    IStudentRepository iStudentRepository;

    @Mock
    IStudentDAO iStudentDAO;

    @InjectMocks
    StudentService studentService;

    @Test
    public void createTest() {
        //arrange
        StudentDTO studentDTO = new StudentDTO();
        Mockito.doNothing().when(iStudentDAO).save(studentDTO);

        //act
        studentService.update(studentDTO);

        //assert
        Mockito.verify(iStudentDAO, Mockito.atLeast(1)).save(studentDTO);
    }
    @Test
    public void deleteTest() {
        //arrange
        Long id = 1L;
        Boolean expected = true;
        when(iStudentDAO.delete(id)).thenReturn(expected);

        //act
        studentService.delete(id);

        //assert
        Mockito.verify(iStudentDAO, Mockito.atLeast(1)).delete(id);
    }
    @Test
    public void updateTest() {
        //arrange
        StudentDTO studentDTO = new StudentDTO();
        Mockito.doNothing().when(iStudentDAO).save(studentDTO);

        //act
        studentService.create(studentDTO);

        //assert
        Mockito.verify(iStudentDAO, Mockito.atLeast(1)).save(studentDTO);
    }

    @Test
    public void readTest() {
        //arrange
        Long id = 1L;
        StudentDTO expectedStudent = new StudentDTO();
        when(iStudentDAO.findById(id)).thenReturn(expectedStudent);

        //act
        StudentDTO student = studentService.read(id);

        //assert
        verify(iStudentDAO,Mockito.atLeast(1)).findById(id);
        assertEquals(student, expectedStudent);
    }

    @Test
    public void getAllTest() {
        //arrange
        Long id = 1L;
        StudentDTO student1 = new StudentDTO();
        StudentDTO student2 = new StudentDTO();
        StudentDTO student3 = new StudentDTO();
        StudentDTO student4 = new StudentDTO();

        Set<StudentDTO> expectedSudents = new HashSet<>(Arrays.asList(student1,student2, student3, student4));

        when(iStudentRepository.findAll()).thenReturn(expectedSudents);

        //act
        Set<StudentDTO> students = studentService.getAll();

        //assert
        verify(iStudentRepository,Mockito.atLeast(1)).findAll();
        assertEquals(students, expectedSudents);
    }



}
