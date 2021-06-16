package com.meli.obtenerdiploma.unit.controller;

import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {

    @Mock
    IObtenerDiplomaService obtenerDiplomaService;

    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;

    @Test
    public void getAnalizeScoresVerifyService(){
        // arrange
        // Estudiente
        SubjectDTO subjectDTO1 = new SubjectDTO("Matemática", 10.0);
        SubjectDTO subjectDTO2 = new SubjectDTO("Física", 8.0);
        SubjectDTO subjectDTO3 = new SubjectDTO("Química", 10.0);
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(subjectDTO1);
        subjects.add(subjectDTO2);
        subjects.add(subjectDTO3);

        Double expectedAverageScore = 9.33;
        String expectedMessage = "El alumno Pedro ha obtenido un promedio de 9.33. Felicitaciones!";

        StudentDTO expectedStudent = new StudentDTO(2L,"Pedro", expectedMessage, expectedAverageScore, subjects);

        Mockito.when(obtenerDiplomaService.analyzeScores(2L)).thenReturn(expectedStudent);

        // act
        StudentDTO actualStudent = obtenerDiplomaController.analyzeScores(2L);

        // assert
        Mockito.verify(obtenerDiplomaService,Mockito.atLeastOnce()).analyzeScores(2L);
    }


    @Test
    public void getAnalizeScoresCompleteData(){
        // arrange
        // Estudiente
        SubjectDTO subjectDTO1 = new SubjectDTO("Matemática", 10.0);
        SubjectDTO subjectDTO2 = new SubjectDTO("Física", 8.0);
        SubjectDTO subjectDTO3 = new SubjectDTO("Química", 10.0);
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(subjectDTO1);
        subjects.add(subjectDTO2);
        subjects.add(subjectDTO3);

        Double expectedAverageScore = 9.33;
        String expectedMessage = "El alumno Pedro ha obtenido un promedio de 9.33. Felicitaciones!";

        StudentDTO expectedStudent = new StudentDTO(2L,"Pedro", expectedMessage, expectedAverageScore, subjects);

        Mockito.when(obtenerDiplomaService.analyzeScores(2L)).thenReturn(expectedStudent);

        // act
        StudentDTO actualStudent = obtenerDiplomaController.analyzeScores(2L);

        // assert
        assertEquals(expectedStudent, actualStudent);
    }

}
