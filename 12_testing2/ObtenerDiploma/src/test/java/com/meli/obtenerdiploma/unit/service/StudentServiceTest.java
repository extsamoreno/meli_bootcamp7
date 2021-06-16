package com.meli.obtenerdiploma.unit.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.unit.MockHelper;
import com.meli.obtenerdiploma.unit.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    StudentService studentService;

    @Test
    public void testCreateStudent(){
        //Arrange
        StudentDTO student = MockHelper.getUserMockWithCongrats();
        doNothing().when(studentDAO).save(student);

        //Act
        studentService.create(student);

        //Assert
        verify(studentDAO, atLeastOnce()).save(student);
    }

    @Test
    public void testReadWithUserExist(){
        //Arrange
        Long studentId = 1L;
        StudentDTO studentExpected = MockHelper.getUserMockWithCongrats();
        when(studentDAO.findById(studentId)).thenReturn(studentExpected);

        //Act
        StudentDTO studentReceived = studentService.read(studentId);

        //Assert
        verify(studentDAO, atLeastOnce()).findById(studentId);
        assertEquals(studentExpected, studentReceived);
    }

    @Test
    public void testReadWithUserNotExist(){
        //Arrange
        Long studentId = 1L;
        when(studentDAO.findById(studentId)).thenReturn(null);

        //Act
        StudentDTO studentReceived = studentService.read(studentId);

        //Assert
        verify(studentDAO, atLeastOnce()).findById(studentId);
        assertNull(studentReceived);
    }

    @Test
    public void testReadWithInvalidStudentId(){
        //Arrange
        Long studentId = null;
        when(studentDAO.findById(studentId)).thenReturn(null);

        //Act
        StudentDTO studentReceived = studentService.read(studentId);

        //Assert
        verify(studentDAO, atLeastOnce()).findById(studentId);
        assertNull(studentReceived);
    }

    @Test
    public void testUpdateStudent(){
        //Arrange
        StudentDTO student = MockHelper.getUserMockWithCongrats();
        doNothing().when(studentDAO).save(student);

        //Act
        studentService.update(student);

        //Assert
        verify(studentDAO, atLeastOnce()).save(student);
    }

    @Test
    public void testDeleteStudent(){
        //Arrange
        Long studentId = 1L;
        when(studentDAO.delete(studentId)).thenReturn(true);

        //Act
        studentService.delete(studentId);

        //Assert
        verify(studentDAO, atLeastOnce()).delete(studentId);
    }

}
