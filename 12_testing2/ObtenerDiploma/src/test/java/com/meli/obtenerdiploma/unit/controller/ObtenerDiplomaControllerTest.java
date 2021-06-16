package com.meli.obtenerdiploma.unit.controller;

import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {

    @Mock
    IObtenerDiplomaService iObtenerDiplomaService;

    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;

    @Test
    public void analyzeScoresHappyPath(){
        //arrange
        Long id = 1L;
        StudentDTO expected = new StudentDTO(1L, "Juan", "Message", 9.0, null);
        Mockito.when(iObtenerDiplomaService.analyzeScores(id)).thenReturn(new StudentDTO(1L, "Juan", "Message", 9.0, null));
        //act
        StudentDTO received = obtenerDiplomaController.analyzeScores(id);
        //assert
        Mockito.verify(iObtenerDiplomaService, Mockito.atLeast(1)).analyzeScores(id);
        Assertions.assertEquals(expected,received);
    }

    @Test
    public void analyzeScoresUnhappyThrowStudentNotFoundException(){
        //arrange
        Long id = 4L;
        Mockito.when(iObtenerDiplomaService.analyzeScores(id)).thenThrow(new StudentNotFoundException(id));
        //act

        //assert
        Assertions.assertThrows(StudentNotFoundException.class,  () -> iObtenerDiplomaService.analyzeScores(id));
        Mockito.verify(iObtenerDiplomaService, Mockito.atLeast(1)).analyzeScores(id);
    }
}
