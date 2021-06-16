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
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {

    @Mock
    IObtenerDiplomaService obtenerDiplomaService;

    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;

    @Test
    public void analyzeScoresOk(){

        //Arrange
        long id = 2;
        StudentDTO studentDTO = Utils.getStudentDTO();
        studentDTO.setId(id);

        when(obtenerDiplomaService.analyzeScores(id)).thenReturn(studentDTO);

        //Act
        StudentDTO studentReceived = obtenerDiplomaService.analyzeScores(id);

        //Assert
        Mockito.verify(obtenerDiplomaService, Mockito.atLeastOnce()).analyzeScores(id);
        Assertions.assertEquals(studentDTO, studentReceived);
    }
}
