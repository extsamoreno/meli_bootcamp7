package com.meli.obtenerdiploma.unit;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    IStudentDAO iStudentDAO;

    @Mock
    IStudentRepository iStudentRepository;

    @InjectMocks
    StudentService studentService;

    @Test
    public void createStudentOk() {

        // arrange
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentName("Marcelo");
        studentDTO.setId(3L);

        //act
        studentService.create(studentDTO);

        // assert
        verify(iStudentDAO, atLeast(1)).save(studentDTO);
    }

    @Test
    public void readStudentOk() {

        // arrange
        long id = 3;
        StudentDTO expected = new StudentDTO();
        expected.setStudentName("Marcelo");
        expected.setId(id);

        when(iStudentDAO.findById(id)).thenReturn(expected);

        // act
        StudentDTO received = studentService.read(id);

        // assert
        verify(iStudentDAO, atLeast(1)).findById(id);
        Assertions.assertEquals(expected, received);
    }

    @Test
    public void updateStudentOk() {

        // arrange
        long id = 3;
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentName("Marcelo");
        studentDTO.setId(id);

        // act
        studentService.update(studentDTO);

        // assert
        verify(iStudentDAO, atLeast(1)).save(studentDTO);
    }



}
