package com.meli.obtenerdiploma.unit;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTests {


    @Mock
    IStudentDAO iStudentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    public void ObtenerDiplomaHappyPathCongratulation(){
        // Arrange
        Long studentId = 1L;
        SubjectDTO subject = new SubjectDTO( "Matematica", 9.0);
        SubjectDTO subject2 = new SubjectDTO( "Lengua", 10.0);

        List<SubjectDTO> subjects = new ArrayList<SubjectDTO>();
        subjects.add(subject);
        subjects.add(subject2);
        StudentDTO student =  new StudentDTO(studentId,"Juan", "hola", 0.0, subjects);
        StudentDTO expected = new StudentDTO(studentId,"Juan", "hola", 0.0, subjects);
        expected.setMessage("El alumno Juan ha obtenido un promedio de 9.5. Felicitaciones!" );
        expected.setAverageScore(9.5 );
        when(iStudentDAO.findById(studentId)).thenReturn(student);

        // Act
        StudentDTO received = obtenerDiplomaService.analyzeScores(studentId);

        // Assert
        verify(iStudentDAO, times(1)).findById(studentId);
        Assertions.assertEquals(expected, received);

    }

    @Test
    public void ObtenerDiplomaHappyPathPuedeMejorar(){
        // Arrange
        Long studentId = 1L;
        SubjectDTO subject = new SubjectDTO( "Matematica", 8.0);
        SubjectDTO subject2 = new SubjectDTO( "Lengua", 9.0);
        List<SubjectDTO> subjects = new ArrayList<SubjectDTO>();
        subjects.add(subject);
        subjects.add(subject2);
        StudentDTO student =  new StudentDTO(studentId,"Juan", "hola", 0.0, subjects);
        StudentDTO expected = new StudentDTO(studentId,"Juan", "hola", 0.0, subjects);
        expected.setMessage("El alumno Juan ha obtenido un promedio de 8.5. Puedes mejorar." );
        expected.setAverageScore(8.5 );
        when(iStudentDAO.findById(studentId)).thenReturn(student);

        // Act
        StudentDTO received = obtenerDiplomaService.analyzeScores(studentId);

        // Assert
        verify(iStudentDAO, times(1)).findById(studentId);
        Assertions.assertEquals(expected, received);

    }

    @Test
    public void ObtenerDiplomaEmptyList(){
        // Arrange
        Long studentId = 100L;
        when(iStudentDAO.findById(studentId)).thenThrow(new StudentNotFoundException(studentId));

        // Act // Assert
        assertThrows(StudentNotFoundException.class, () -> obtenerDiplomaService.analyzeScores(studentId));

    }
}

