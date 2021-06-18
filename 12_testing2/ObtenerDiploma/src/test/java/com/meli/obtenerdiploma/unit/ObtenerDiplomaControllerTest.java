package com.meli.obtenerdiploma.unit;

import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
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
    public void analyzeScoresHappyPath() {
        //Arrange
        Long studentId = 1L;
        Mockito.when(iObtenerDiplomaService.analyzeScores(1L)).thenReturn(Utils.getStudentDTO());

        //Act
        StudentDTO received = obtenerDiplomaController.analyzeScores(studentId);

        //Assert
        Mockito.verify(iObtenerDiplomaService,Mockito.atLeastOnce()).analyzeScores(studentId);
        //TODO: Que assertion uso aca?
    }
}
