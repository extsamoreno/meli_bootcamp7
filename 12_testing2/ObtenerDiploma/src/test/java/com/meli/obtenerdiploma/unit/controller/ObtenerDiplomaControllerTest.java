package com.meli.obtenerdiploma.unit.controller;


import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
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
    IObtenerDiplomaService iObtenerDiplomaService;

    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;


   @Test
    public void  analyzeScores(){
        //arrange

        Long id = 1L;
        StudentDTO expected = new StudentDTO(1L, "Juan", null, null, new ArrayList<>() {
            {
                add(new SubjectDTO("Matemática", 9.0));
                add(new SubjectDTO("Física", 7.0));
                add(new SubjectDTO("Química", 6.0));
            }
        });

        Mockito.when(iObtenerDiplomaService.analyzeScores(1L)).thenReturn(expected);



        //act
        StudentDTO received= obtenerDiplomaController.analyzeScores(1L);

        //assert
        Mockito.verify(iObtenerDiplomaService, Mockito.atLeast(1)).analyzeScores(id);
        Assertions.assertEquals(expected, received);

    }

    @Test
    public void analyzeScoresStudentNotFoundException() {
        //arrange
        Long id = 4L;
        StudentDTO expected = new StudentDTO();

        Mockito.when(iObtenerDiplomaService.analyzeScores(4L)).thenReturn(expected);

        //act
        StudentDTO received= obtenerDiplomaController.analyzeScores(4L);

        //assert
        Mockito.verify(iObtenerDiplomaService, Mockito.atLeast(1)).analyzeScores(id);
        Assertions.assertEquals(expected, received);

    }


}
