package com.meli.obtenerdiploma.unit;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    @Mock
    IStudentDAO iStudentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    public void analyzeScoresCorrectOperation() {
        // Arrange
        Long id = 1L;

        ArrayList<SubjectDTO> subjectDTOS = new ArrayList<>();
        SubjectDTO subjectDTO = new SubjectDTO("Ciencias", 10.0);
        subjectDTOS.add(subjectDTO);

        StudentDTO expected = new StudentDTO();
        expected.setId(id);
        expected.setAverageScore(10.0);
        expected.setStudentName("Juan");
        expected.setSubjects(subjectDTOS);

        Mockito.when(iStudentDAO.findById(id)).thenReturn(expected);

        // Act
        StudentDTO received = obtenerDiplomaService.analyzeScores(id);

        // Assert

        Mockito.verify(iStudentDAO, Mockito.atLeast(1)).findById(id);
        assertEquals(expected, received);
    }

    @Test
    public void analyzeScoresCongratulationsMessage() {
        // Arrange
        Long id = 1L;

        ArrayList<SubjectDTO> subjectDTOS = new ArrayList<>();
        SubjectDTO subjectDTO = new SubjectDTO("Ciencias", 10.0);
        subjectDTOS.add(subjectDTO);

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(id);
        studentDTO.setStudentName("Juan");
        studentDTO.setSubjects(subjectDTOS);

        String expected = "El alumno Juan ha obtenido un promedio de 10. Felicitaciones!";

        Mockito.when(iStudentDAO.findById(id)).thenReturn(studentDTO);

        // Act
        StudentDTO received = obtenerDiplomaService.analyzeScores(id);

        // Assert

        Mockito.verify(iStudentDAO, Mockito.atLeast(1)).findById(id);
        assertEquals(expected, received.getMessage());
    }

    @Test
    public void analyzeScoresDefaultMessage() {
        // Arrange
        Long id = 1L;

        ArrayList<SubjectDTO> subjectDTOS = new ArrayList<>();
        SubjectDTO subjectDTO = new SubjectDTO("Ciencias", 7.0);
        subjectDTOS.add(subjectDTO);

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(id);
        studentDTO.setStudentName("Juan");
        studentDTO.setSubjects(subjectDTOS);

        String expected = "El alumno Juan ha obtenido un promedio de 7. Puedes mejorar.";

        Mockito.when(iStudentDAO.findById(id)).thenReturn(studentDTO);

        // Act
        StudentDTO received = obtenerDiplomaService.analyzeScores(id);

        // Assert

        Mockito.verify(iStudentDAO, Mockito.atLeast(1)).findById(id);
        assertEquals(expected, received.getMessage());
    }

    @Test
    public void analyseScoresCalculateAverage() {

        // Arrange
        Long id = 1L;

        ArrayList<SubjectDTO> subjectDTOS = new ArrayList<>();
        SubjectDTO subjectDTO1 = new SubjectDTO("Ciencias", 10.0);
        SubjectDTO subjectDTO2 = new SubjectDTO("Física", 10.0);
        SubjectDTO subjectDTO3 = new SubjectDTO("Matemáticas", 6.0);
        SubjectDTO subjectDTO4 = new SubjectDTO("Filosofia", 7.0);
        SubjectDTO subjectDTO5 = new SubjectDTO("Sociales", 8.0);

        subjectDTOS.add(subjectDTO1);
        subjectDTOS.add(subjectDTO2);
        subjectDTOS.add(subjectDTO3);
        subjectDTOS.add(subjectDTO4);
        subjectDTOS.add(subjectDTO5);

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(id);
        studentDTO.setStudentName("Juan");
        studentDTO.setSubjects(subjectDTOS);

        double expected = 8.2;

        Mockito.when(iStudentDAO.findById(id)).thenReturn(studentDTO);

        // Act
        StudentDTO received = obtenerDiplomaService.analyzeScores(id);

        // Assert

        Mockito.verify(iStudentDAO, Mockito.atLeast(1)).findById(id);

        assertEquals(expected, received.getAverageScore());
        
    }
}
