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
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    public void calculateAverageOkTest(){

        //Arrange
        long id = 2;
        double expected = 9.0;
        StudentDTO studentDTO = Utils.getStudentDTO();

        /*List<SubjectDTO> subj2 = new ArrayList<>();
        subj2.add(new SubjectDTO("Matemática", 10.00));
        subj2.add(new SubjectDTO("Física", 8.00));
        subj2.add(new SubjectDTO("Química", 4.00));
        StudentDTO expected = new StudentDTO(2L, "Pedro", null, null, subj2);*/

        /*double average = (subj2.get(0).getScore() + subj2.get(1).getScore() +
        subj2.get(2).getScore()) / subj2.size();*/
        //StudentDTO ex1 = new StudentDTO(2L, "Pedro", null, average, subj2);

        when(studentDAO.findById(id)).thenReturn(studentDTO);

        //Act
        StudentDTO received = obtenerDiplomaService.analyzeScores(id);

        //Assert
        Mockito.verify(studentDAO, Mockito.atLeastOnce()).findById(id);
        Assertions.assertEquals(expected, received.getAverageScore());
    }

    @Test
    public void calculateAverageBorderUpperTest(){

        //Arrange
        long id = 2;
        double expected = 9.1;
        StudentDTO studentDTO = Utils.getStudentDTO();

        when(studentDAO.findById(id)).thenReturn(studentDTO);

        //Act
        StudentDTO received = obtenerDiplomaService.analyzeScores(id);

        //Assert
        Mockito.verify(studentDAO, Mockito.atLeastOnce()).findById(id);
        Assertions.assertTrue(expected > received.getAverageScore());
    }

    @Test
    public void calculateAverageBorderLowerTest(){

        //Arrange
        long id = 2;
        double expected = 8.9;
        StudentDTO studentDTO = Utils.getStudentDTO();

        when(studentDAO.findById(id)).thenReturn(studentDTO);

        //Act
        StudentDTO received = obtenerDiplomaService.analyzeScores(id);

        //Assert
        Mockito.verify(studentDAO, Mockito.atLeastOnce()).findById(id);
        Assertions.assertTrue(expected < received.getAverageScore());
    }

    @Test
    public void messageAverageHigherThanNine(){

        //Arrange
        double avg = 9.2;
        long id = 2;
        StudentDTO studentDTO = Utils.getStudentDTOWithAverage(avg);
        String expectedMessage = "El alumno " + studentDTO.getStudentName() + " ha obtenido un promedio de " + avg + ". Felicitaciones!";

        studentDTO.setId(id);
        when(studentDAO.findById(id)).thenReturn(studentDTO);

        //Act
        StudentDTO studentReceived = obtenerDiplomaService.analyzeScores(id);

        //Assert
        Mockito.verify(studentDAO, Mockito.atLeastOnce()).findById(id);
        Assertions.assertEquals(expectedMessage, studentReceived.getMessage());

    }

    @Test
    public void messageAverageLowerThanNine(){

        //Arrange
        double avg = 7.2;
        long id = 2;
        StudentDTO studentDTO = Utils.getStudentDTOWithAverage(avg);
        String expectedMessage = "El alumno " + studentDTO.getStudentName() + " ha obtenido un promedio de " + avg + ". Puedes mejorar.";

        studentDTO.setId(id);
        when(studentDAO.findById(id)).thenReturn(studentDTO);

        //Act
        StudentDTO studentReceived = obtenerDiplomaService.analyzeScores(id);

        //Assert
        Mockito.verify(studentDAO, Mockito.atLeastOnce()).findById(id);
        Assertions.assertEquals(expectedMessage, studentReceived.getMessage());

    }

    @Test
    public void emptyStudentIdPath() { // throws StudentNotFoundException

        //Arrange
        long id = 2;
        //StudentDTO studentDTO = Utils.getStudentDTO();
        when(studentDAO.findById(id)).thenReturn(null);

        //Act
        //StudentDTO studentReceived = obtenerDiplomaService.analyzeScores(id);

        //Assert
        //Mockito.verify(studentDAO, Mockito.atLeastOnce()).findById(id);
        Assertions.assertThrows(NullPointerException.class, () -> obtenerDiplomaService.analyzeScores(id));
    }
}
