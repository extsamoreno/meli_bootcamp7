package com.meli.obtenerdiploma.unit.point4;

import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.unit.Utils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {

    @Mock
    IObtenerDiplomaService service;

    @InjectMocks
    ObtenerDiplomaController controller;

    @Test
    public void analyzeScoresHappyPath() {
        //arr
        StudentDTO studentDTO = Utils.getStudentDTO();
        Long id = 99L;
        Mockito.when(service.analyzeScores(id)).thenReturn(studentDTO);
        // act
        controller.analyzeScores(id);
        StudentDTO received = controller.analyzeScores(id);
        //assert
        Mockito.verify(service, Mockito.atLeast(2)).analyzeScores(id);
        assertEquals(studentDTO, received);
    }



}
