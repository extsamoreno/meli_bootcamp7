package com.meli.obtenerdiploma.unit.service;

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

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    // Cálculo del Promedio.
    @Test
    public void averageScores(){
        // arrange
        Long studentId = Long.valueOf(1);
        Double expectedAverageScore = 7.33;

        // Crear el Student esperado
        SubjectDTO subjectDTO1 = new SubjectDTO("Matemática", 9.0);
        SubjectDTO subjectDTO2 = new SubjectDTO("Física", 7.0);
        SubjectDTO subjectDTO3 = new SubjectDTO("Química", 6.0);
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(subjectDTO1);
        subjects.add(subjectDTO2);
        subjects.add(subjectDTO3);
        StudentDTO expectedStudent = new StudentDTO(1L,"Juan", "", expectedAverageScore, subjects);

        Mockito.when(studentDAO.findById(studentId)).thenReturn(expectedStudent);

        // act
        StudentDTO currentStudent = obtenerDiplomaService.analyzeScores(studentId);
        Double receivedAverageScore = Math.round(currentStudent.getAverageScore()*100.0)/100.0;

        // assert
        assertEquals(expectedAverageScore, receivedAverageScore);
    }


    // Leyenda del Diploma sin Honores
    @Test
    public void messageWithOutHonor(){
        // arrange
        Long studentId = Long.valueOf(1);
        String expectedMessage = "El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar.";

        // Crear el Student esperado
        SubjectDTO subjectDTO1 = new SubjectDTO("Matemática", 9.0);
        SubjectDTO subjectDTO2 = new SubjectDTO("Física", 7.0);
        SubjectDTO subjectDTO3 = new SubjectDTO("Química", 6.0);
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(subjectDTO1);
        subjects.add(subjectDTO2);
        subjects.add(subjectDTO3);
        StudentDTO expectedStudent = new StudentDTO(1L,"Juan", expectedMessage, 0.0, subjects);

        Mockito.when(studentDAO.findById(studentId)).thenReturn(expectedStudent);

        // act
        StudentDTO currentStudent = obtenerDiplomaService.analyzeScores(studentId);
        String receivedMessage = currentStudent.getMessage();

        // assert
        assertEquals(expectedMessage, receivedMessage);
    }


    // Mensaje de Diploma con Honores.
    @Test
    public void messageWithHonor(){
        // arrange
        Long studentId = Long.valueOf(2);
        String expectedMessage = "El alumno Pedro ha obtenido un promedio de 9.33. Felicitaciones!";

        // Crear el Student esperado
        SubjectDTO subjectDTO1 = new SubjectDTO("Matemática", 10.0);
        SubjectDTO subjectDTO2 = new SubjectDTO("Física", 8.0);
        SubjectDTO subjectDTO3 = new SubjectDTO("Química", 10.0);
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(subjectDTO1);
        subjects.add(subjectDTO2);
        subjects.add(subjectDTO3);
        StudentDTO expectedStudent = new StudentDTO(2L,"Pedro", expectedMessage, 0.0, subjects);

        Mockito.when(studentDAO.findById(studentId)).thenReturn(expectedStudent);

        // act
        StudentDTO currentStudent = obtenerDiplomaService.analyzeScores(studentId);
        String receivedMessage = currentStudent.getMessage();

        // assert
        assertEquals(expectedMessage, receivedMessage);
    }


    // Comparacion de Student completo
    @Test
    public void studentDTOComplete(){
        // arrange
        Long studentId = Long.valueOf(2);
        Double expectedAverageScore = 9.33;
        String expectedMessage = "El alumno Pedro ha obtenido un promedio de 9.33. Felicitaciones!";

        // Crear el Student esperado
        SubjectDTO subjectDTO1 = new SubjectDTO("Matemática", 10.0);
        SubjectDTO subjectDTO2 = new SubjectDTO("Física", 8.0);
        SubjectDTO subjectDTO3 = new SubjectDTO("Química", 10.0);
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(subjectDTO1);
        subjects.add(subjectDTO2);
        subjects.add(subjectDTO3);
        StudentDTO expectedStudent = new StudentDTO(2L,"Pedro", expectedMessage, expectedAverageScore, subjects);

        Mockito.when(studentDAO.findById(studentId)).thenReturn(expectedStudent);

        // act
        StudentDTO currentStudent = obtenerDiplomaService.analyzeScores(studentId);

        // assert
        assertEquals(expectedStudent, currentStudent);
    }

}
