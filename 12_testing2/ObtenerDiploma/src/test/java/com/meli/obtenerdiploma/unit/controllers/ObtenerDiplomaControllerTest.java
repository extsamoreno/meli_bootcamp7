package com.meli.obtenerdiploma.unit.controllers;

import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.unit.Utils;
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
    public void analyzeScoresHappyPath() {
        //arr
        StudentDTO expectedStud = Utils.getStudentDTO();
        Long id = 1L;
        Mockito.when(iObtenerDiplomaService.analyzeScores(id)).thenReturn(expectedStud);

        // act
        StudentDTO receivedStud = obtenerDiplomaController.analyzeScores(id);

        //assert
        Mockito.verify(iObtenerDiplomaService, Mockito.atLeast(1)).analyzeScores(id);
        Assertions.assertEquals(expectedStud, receivedStud);
    }
}
