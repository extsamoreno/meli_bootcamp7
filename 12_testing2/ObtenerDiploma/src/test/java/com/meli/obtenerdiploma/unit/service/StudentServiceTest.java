package com.meli.obtenerdiploma.unit.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {
    @Mock
    IStudentDAO studentDAO;
    @Mock
    IStudentRepository iStudentRepository;

    @InjectMocks
    StudentService studentService;

    @Test
    public void createTest() {
        //arrange
        StudentDTO studentDTO = new StudentDTO();
        Mockito.doNothing().when(studentDAO).save(studentDTO);

        //act
        studentService.create(studentDTO);

        //assert
        Mockito.verify(studentDAO, Mockito.atLeast(1)).save(studentDTO);
    }

    @Test
    public void readTest() {
        //arrange
        Long id = 1L;
        StudentDTO expected = new StudentDTO(1L, "Juan", null, null, new ArrayList<>() {
            {
                add(new SubjectDTO("Matemática", 9.0));
                add(new SubjectDTO("Física", 7.0));
                add(new SubjectDTO("Química", 6.0));
            }
        });
        Mockito.when(studentDAO.findById(id)).thenReturn(expected);

        //act
        StudentDTO received = studentService.read(id);

        //assert
        Assertions.assertEquals(expected, received);
        Mockito.verify(studentDAO,Mockito.atLeast(1)).findById(id);
    }

    @Test
    public void updateTest() {
        //arrange
        StudentDTO studentDTO = new StudentDTO();
        Mockito.doNothing().when(studentDAO).save(studentDTO);

        //act
        studentService.update(studentDTO);

        //assert
        Mockito.verify(studentDAO, Mockito.atLeast(1)).save(studentDTO);
    }

    @Test
    public void deleteTest() {
        //arrange
        Long id = 1L;
        Mockito.when(studentDAO.delete(id)).thenReturn(true);

        //act
        studentService.delete(id);

        //assert
        Mockito.verify(studentDAO, Mockito.atLeast(1)).delete(id);
    }
}