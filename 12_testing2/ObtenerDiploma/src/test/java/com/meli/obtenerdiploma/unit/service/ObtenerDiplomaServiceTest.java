package com.meli.obtenerdiploma.unit.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.unit.MockHelper;
import com.meli.obtenerdiploma.unit.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService service;

    @Test
    public void testAnalyzeScoresWithValidScore(){
        //Arrange
        Long studentId = 1L;
        StudentDTO student = MockHelper.getUserMockWithCongrats();
        double averageExpected = 9.333333333333334;
        when(studentDAO.findById(studentId)).thenReturn(student);

        //Act
        StudentDTO studentReceived = service.analyzeScores(studentId);
        double averageReceived = studentReceived.getAverageScore();

        //Assert
        verify(studentDAO, atLeastOnce()).findById(studentId);
        assertEquals(averageExpected, averageReceived);
    }

    @Test
    public void testAnalyzeScoresWithCongrats(){
        //Arrange
        Long studentId = 1L;
        StudentDTO student = MockHelper.getUserMockWithCongrats();
        String messageExpected = "El alumno Santiago Garcia ha obtenido un promedio de 9.33. Felicitaciones!";
        when(studentDAO.findById(studentId)).thenReturn(student);

        //Act
        StudentDTO studentReceived = service.analyzeScores(studentId);
        String messageReceived = studentReceived.getMessage();

        //Assert
        verify(studentDAO, atLeastOnce()).findById(studentId);
        assertEquals(messageExpected, messageReceived);
    }

    @Test
    public void testAnalyzeScoresWithoutCongrats(){
        //Arrange
        Long studentId = 1L;
        StudentDTO student = MockHelper.getUserMockWithoutCongrats();
        String messageExpected = "El alumno Santiago Garcia ha obtenido un promedio de 8.33. Puedes mejorar.";
        when(studentDAO.findById(studentId)).thenReturn(student);

        //Act
        StudentDTO studentReceived = service.analyzeScores(studentId);
        String messageReceived = studentReceived.getMessage();

        //Assert
        verify(studentDAO, atLeastOnce()).findById(studentId);
        assertEquals(messageExpected, messageReceived);
    }

    @Test
    public void testAnalyzeScoresWithNullStudent(){
        //Arrange
        Long studentId = 1L;
        when(studentDAO.findById(studentId)).thenReturn(null);

        //Act
        //Assert
        assertThrows(NullPointerException.class, () -> service.analyzeScores(studentId));
    }

    @Test
    public void testAnalyzeScoresWithNullStudentId(){
        //Arrange
        Long studentId = null;
        when(studentDAO.findById(studentId)).thenReturn(null);

        //Act
        //Assert
        assertThrows(NullPointerException.class, () -> service.analyzeScores(studentId));
    }

}
