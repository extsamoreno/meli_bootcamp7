package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaControllerTest {

    @Mock
    ObtenerDiplomaService diplomaServiceservice;

    @InjectMocks
    ObtenerDiplomaController diplomaController;

    @Test
    public void analyzeScoresHappyPath(){
        //Arrange
        Long id = 1L;
        StudentDTO studentDTO = new StudentDTO();
        when(diplomaServiceservice.analyzeScores(id)).thenReturn(studentDTO);

        //act
        StudentDTO response = diplomaController.analyzeScores(id);

        //assert
        assertEquals(studentDTO, response);
    }

    @Test
    public void analyzeScoresNullResponse(){
        //Arrange
        Long id = null;

        //act
        StudentDTO response = diplomaController.analyzeScores(id);

        //assert
        assertNull(response);
    }

}