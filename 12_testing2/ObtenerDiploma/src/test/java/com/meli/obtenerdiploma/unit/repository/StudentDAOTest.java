package com.meli.obtenerdiploma.unit.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.unit.MockHelper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentDAOTest {

    @Mock
    private IStudentDAO studentDAO;

    @Test
    public void testSaveWithValidStudent(){

        StudentDTO student = MockHelper.getUserMockWithCongrats();

        doNothing().when(studentDAO).save(student);

        studentDAO.save(student);

        verify(studentDAO, atLeastOnce()).save(student);

    }

    @Test
    public void testSaveThrowStudentNotFound(){
        StudentDTO student = new StudentDTO();
        student.setId(1L);
        doThrow(StudentNotFoundException.class).when(studentDAO).save(student);

        assertThrows(StudentNotFoundException.class, () -> studentDAO.save(student));
    }

    @Test
    public void testDeleteWithExistStudent(){
        //Arrange
        Long studentId = 1L;
        when(studentDAO.delete(studentId)).thenReturn(true);

        //Act
        boolean received = studentDAO.delete(studentId);

        //Assert
        verify(studentDAO, atLeastOnce()).delete(studentId);
        assertTrue(received);
    }

    @Test
    public void testDeleteWithoutExistStudent(){
        //Arrange
        Long studentId = 0L;
        when(studentDAO.delete(studentId)).thenReturn(false);

        //Act
        boolean received = studentDAO.delete(studentId);

        //Assert
        verify(studentDAO, atLeastOnce()).delete(studentId);
        assertFalse(received);
    }

    @Test
    public void testDeleteThrowStudentNotFound(){
        //Arrange
        Long studentId = 1L;
        when(studentDAO.delete(studentId)).thenThrow(new StudentNotFoundException(studentId));

        //Act
        //Assert
        assertThrows(StudentNotFoundException.class, () -> studentDAO.delete(studentId));
    }

    @Test
    public void testFindByIdWithExistStudent(){
        //Arrange
        Long studentId = 1L;
        StudentDTO expected = MockHelper.getUserMockWithCongrats();
        when(studentDAO.findById(studentId)).thenReturn(expected);

        //Act
        StudentDTO received = studentDAO.findById(studentId);

        //Assert
        verify(studentDAO, atLeastOnce()).findById(studentId);
        assertEquals(expected, received);
    }

    @Test
    public void testFindByIdWithoutExistStudent(){
        //Arrange
        Long studentId = 1L;
        when(studentDAO.findById(studentId)).thenThrow(new StudentNotFoundException(studentId));

        //Act
        //Assert
        assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(studentId));
    }


    @Test
    public void testExistWithStudentExist(){
        //Arrange
        StudentDTO student = MockHelper.getUserMockWithCongrats();
        when(studentDAO.exists(student)).thenReturn(true);

        //Act
        boolean received = studentDAO.exists(student);

        //Assert
        assertTrue(received);
    }

    @Test
    public void testExistWithoutStudentExist(){
        //Arrange
        StudentDTO student = MockHelper.getUserMockWithCongrats();
        when(studentDAO.exists(student)).thenReturn(false);

        //Act
        boolean received = studentDAO.exists(student);

        //Assert
        assertFalse(received);
    }

    @Test
    public void testExistThrowStudentNotFound(){
        //Arrange
        StudentDTO student = MockHelper.getUserMockWithCongrats();
        when(studentDAO.exists(student)).thenThrow(new StudentNotFoundException(student.getId()));

        //Act
        //Assert
        assertThrows(StudentNotFoundException.class, () -> studentDAO.exists(student));
    }



}
