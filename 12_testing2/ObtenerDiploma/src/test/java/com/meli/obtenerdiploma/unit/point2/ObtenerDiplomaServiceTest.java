package com.meli.obtenerdiploma.unit.point2;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import com.meli.obtenerdiploma.unit.Utils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.DecimalFormat;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    public void calculateAverageHappyPath() {
        //arr
        double expected = 8.0;
        StudentDTO studentDTO = Utils.getStudentDTOWithAverage(expected);
        Long id = 101L;
        studentDTO.setId(id);
        Mockito.when(studentDAO.findById(id)).thenReturn(studentDTO);
        // act
        StudentDTO received = obtenerDiplomaService.analyzeScores(id);
        //assert
        Mockito.verify(studentDAO, Mockito.atLeastOnce()).findById(id);
        assertEquals(expected, received.getAverageScore());
    }

    @Test
    public void messageHighAverageHappyPath() {
        //arr
        double average = 9.5;
        StudentDTO studentDTO = Utils.getStudentDTOWithAverage(average);
        Long id = 101L;
        String expectedMessage = "El alumno " + studentDTO.getStudentName() + " ha obtenido un promedio de " + new DecimalFormat("#.##").format(average)
                + ". Felicitaciones!";

        studentDTO.setId(id);
        Mockito.when(studentDAO.findById(id)).thenReturn(studentDTO);
        // act
        StudentDTO received = obtenerDiplomaService.analyzeScores(id);
        //assert
        Mockito.verify(studentDAO, Mockito.atLeastOnce()).findById(id);
        assertEquals(expectedMessage, received.getMessage());
    }
    @Test
    public void messageLowAverageHappyPath() {
        //arr
        double average = 7.5;
        StudentDTO studentDTO = Utils.getStudentDTOWithAverage(average);
        Long id = 101L;
        String expectedMessage = "El alumno " + studentDTO.getStudentName() + " ha obtenido un promedio de " + new DecimalFormat("#.##").format(average)
                + ". Puedes mejorar.";
        studentDTO.setId(id);
        Mockito.when(studentDAO.findById(id)).thenReturn(studentDTO);
        // act
        StudentDTO received = obtenerDiplomaService.analyzeScores(id);
        //assert
        Mockito.verify(studentDAO, Mockito.atLeastOnce()).findById(id);
        assertEquals(expectedMessage, received.getMessage());
    }
    @Test
    public void emptyStudentPath() {
        //arr

        Long id = 101L;
        Mockito.when(studentDAO.findById(id)).thenReturn(new StudentDTO());
        // act
        //assert
        assertThrows(NullPointerException.class, ()->obtenerDiplomaService.analyzeScores(id));
        Mockito.verify(studentDAO, Mockito.atLeastOnce()).findById(id);
    }

    @Test
    public void calculateNegativeAveragePath() {
        //arr
        double expected = -8.0;
        StudentDTO studentDTO = Utils.getStudentDTOWithAverage(expected);
        Long id = 101L;
        studentDTO.setId(id);
        Mockito.when(studentDAO.findById(id)).thenReturn(studentDTO);
        // act
        StudentDTO received = obtenerDiplomaService.analyzeScores(id);
        //assert
        Mockito.verify(studentDAO, Mockito.atLeastOnce()).findById(id);
        assertEquals(expected, received.getAverageScore());

        // CONSULTAR SI AL PONER VALID NO EN LA CLASE NO DEBO VERIFICAR QUE SEA MAYOR A CERO
    }

    @Test
    public void sameEntryDataAndOutputData() {
        //arr
        StudentDTO studentDTO = Utils.getStudentDTO();
        Long id = 101L;
        studentDTO.setId(id);
        Mockito.when(studentDAO.findById(id)).thenReturn(studentDTO);
        // act
        StudentDTO received = obtenerDiplomaService.analyzeScores(id);
        //assert
        Mockito.verify(studentDAO, Mockito.atLeastOnce()).findById(id);
//        assertEquals(studentDTO.getStudentName(), received.getStudentName());
//        assertEquals(studentDTO.getSubjects(), received.getSubjects());
        assertEquals(studentDTO, received);

        // CONSULTAR A QUE SE REFIERE CON MISMOS DATOS DE ENTRADA Y SALIDA
        // LA ENTRADA NO TIENE AVERAGE NI MESSAGE
        // LA SALIDA SI, PERO MODIFICA EL OBEJTO DE ENTRADA
    }

}
