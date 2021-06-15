package com.meli.obtenerdiploma.unit.controller;

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

import java.util.ArrayList;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {

    @Mock
    IObtenerDiplomaService service;

    @InjectMocks
    ObtenerDiplomaController controller;

    @Test
    public void analyzeScoresHappyPath(){
        //arrange
        Long studentId = 1L;

        StudentDTO expected = new StudentDTO(studentId,"Juan","message",7.33,new ArrayList<>());
        Mockito.when(service.analyzeScores(studentId)).thenReturn(expected);

        //act
        StudentDTO recive = controller.analyzeScores(studentId);

        //Assert
        Mockito.verify(service,Mockito.atLeastOnce()).analyzeScores(studentId);
        Assertions.assertEquals(expected,recive);
    }
}
