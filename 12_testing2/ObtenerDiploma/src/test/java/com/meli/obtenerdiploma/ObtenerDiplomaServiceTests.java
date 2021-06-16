package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTests {

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    public void analyzeScoresOkWitAverageTest() {
        //Arrange
        StudentDTO expected = new StudentDTO(1L,
                "Edu","", 10.0,
                Arrays.asList(new SubjectDTO("Matematica", 10.0),
                        new SubjectDTO("Historia", 10.0),
                        new SubjectDTO("Fisica", 10.0)));

        String expectedMessage = "El alumno Edu ha obtenido un promedio de 10. Felicitaciones!";

        Mockito.when(studentDAO.findById(expected.getId())).thenReturn(expected);

        //Act
        StudentDTO received = obtenerDiplomaService.analyzeScores(expected.getId());

        //Assert
        Mockito.verify(studentDAO, Mockito.atLeastOnce()).findById(expected.getId());

        Assertions.assertEquals(expected.getAverageScore(), received.getAverageScore());
        Assertions.assertEquals(expectedMessage, received.getMessage());
    }

    @Test
    public void analyzeScoresOkWithoutAverageTest() {
        //Arrange
        StudentDTO expected = new StudentDTO(1L,
                "Edu","", 8.0,
                Arrays.asList(new SubjectDTO("Matematica", 8.0),
                        new SubjectDTO("Historia", 8.0),
                        new SubjectDTO("Fisica", 8.0)));

        String expectedMessage = "El alumno Edu ha obtenido un promedio de 8. Puedes mejorar.";

        Mockito.when(studentDAO.findById(expected.getId())).thenReturn(expected);

        //Act
        StudentDTO received = obtenerDiplomaService.analyzeScores(expected.getId());

        //Assert
        Mockito.verify(studentDAO, Mockito.atLeastOnce()).findById(expected.getId());

        Assertions.assertEquals(expected.getAverageScore(), received.getAverageScore());
        Assertions.assertEquals(expectedMessage, received.getMessage());
    }


}
