package com.meli.obtenerdiploma.units;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTests {
    @Mock
    IStudentDAO iStudentDAO;

    @InjectMocks
    StudentService studentService;


    @Test
    public void ReadHappyPath(){
        //arrange
        Long id = 1L;
        StudentDTO student = new StudentDTO(id,"Juan",null,null,null);

        Mockito.when(iStudentDAO.findById(id)).thenReturn(student);
        //act
        StudentDTO expected = studentService.read(id);

        //assert
        Assertions.assertEquals(expected, student);
    }

    @Test
    public void ReadShouldThrowStudentNotFoundException(){
        //arrange
        Long id = 1L;
        Mockito.when(iStudentDAO.findById(id)).thenThrow(new StudentNotFoundException(id));
        //act

        //assert
        assertThrows(StudentNotFoundException.class, () -> studentService.read(id));
    }

}