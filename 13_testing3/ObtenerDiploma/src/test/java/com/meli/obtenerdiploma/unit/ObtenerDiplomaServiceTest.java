package com.meli.obtenerdiploma.unit;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.DecimalFormat;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {
    @Mock
    IStudentDAO iStudentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    public void calculateAverageHappyPath() {
        //Arrange
        double expected = 8.0;
        StudentDTO studentDTO = Utils.getStudentDTOWithAverage(expected);
        Long id = 101L;
        studentDTO.setId(id);
        Mockito.when(iStudentDAO.findById(id)).thenReturn(studentDTO);

        //Act
        StudentDTO received = obtenerDiplomaService.analyzeScores(id);

        //Assert
        Mockito.verify(iStudentDAO, Mockito.atLeastOnce()).findById(id);
        Assertions.assertEquals(expected, received.getAverageScore());
    }

    @Test
    public void messageHighAverageHappyPath() {
        //Arrange
        double average = 9.5;
        StudentDTO studentDTO = Utils.getStudentDTOWithAverage(average);
        Long id = 101L;
        String expectedMessage = "El alumno " + studentDTO.getStudentName() + " ha obtenido un promedio de " + new DecimalFormat("#.##").format(average)
                + ". Felicitaciones!";

        studentDTO.setId(id);
        Mockito.when(iStudentDAO.findById(id)).thenReturn(studentDTO);

        //Act
        StudentDTO received = obtenerDiplomaService.analyzeScores(id);

        //Assert
        Mockito.verify(iStudentDAO, Mockito.atLeastOnce()).findById(id);
        Assertions.assertEquals(expectedMessage, received.getMessage());
    }

    @Test
    public void messageLowAverageHappyPath() {
        //Arrange
        double average = 7.5;
        StudentDTO studentDTO = Utils.getStudentDTOWithAverage(average);
        Long id = 101L;
        String expectedMessage = "El alumno " + studentDTO.getStudentName() + " ha obtenido un promedio de " + new DecimalFormat("#.##").format(average)
                + ". Puedes mejorar.";
        studentDTO.setId(id);
        Mockito.when(iStudentDAO.findById(id)).thenReturn(studentDTO);

        //Act
        StudentDTO received = obtenerDiplomaService.analyzeScores(id);

        //Assert
        Mockito.verify(iStudentDAO, Mockito.atLeastOnce()).findById(id);
        Assertions.assertEquals(expectedMessage, received.getMessage());
    }

    @Test
    public void emptyStudentPath() {
        //Arrange
        Long id = 101L;
        Mockito.when(iStudentDAO.findById(id)).thenReturn(new StudentDTO());

        //Act

        //Assert
        Assertions.assertThrows(NullPointerException.class, () -> obtenerDiplomaService.analyzeScores(id));
        Mockito.verify(iStudentDAO, Mockito.atLeastOnce()).findById(id);
    }

    @Test
    public void sameEntryDataAndOutputData() {
        //Arrange
        StudentDTO studentDTO = Utils.getStudentDTO();
        Long id = 101L;
        studentDTO.setId(id);
        Mockito.when(iStudentDAO.findById(id)).thenReturn(studentDTO);

        //Act
        StudentDTO received = obtenerDiplomaService.analyzeScores(id);

        //Assert
        Mockito.verify(iStudentDAO, Mockito.atLeastOnce()).findById(id);
//        assertEquals(studentDTO.getStudentName(), received.getStudentName());
//        assertEquals(studentDTO.getSubjects(), received.getSubjects());
        Assertions.assertEquals(studentDTO, received);

        // CONSULTAR A QUE SE REFIERE CON MISMOS DATOS DE ENTRADA Y SALIDA
        // LA ENTRADA NO TIENE AVERAGE NI MESSAGE
        // LA SALIDA SI, PERO MODIFICA EL OBJETO DE ENTRADA
    }
}
