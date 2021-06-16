package com.meli.obtenerdiploma.unit.controller;

import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
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
    IObtenerDiplomaService obtenerDiplomaService;

    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;

    @Test
    public void analyzeScoreWithHonor() {
        //arrange
        Long id = 1L;
        StudentDTO studentDTOWithHonor = new StudentDTO(id, "Juan",
                "El alumno Juan ha obtenido un promedio de 9,5. Felicitaciones!",
                9.5,
                new ArrayList<>() {
                    {
                        add(new SubjectDTO("Matemática", 9.0));
                        add(new SubjectDTO("Física", 9.5));
                        add(new SubjectDTO("Química", 10.0));
                    }
                });
        Mockito.when(obtenerDiplomaService.analyzeScores(id)).thenReturn(studentDTOWithHonor);

        //act
        StudentDTO received = obtenerDiplomaController.analyzeScores(id);

        //assert
        Mockito.verify(obtenerDiplomaService, Mockito.atLeast(1)).analyzeScores(id);
        Assertions.assertEquals(studentDTOWithHonor, received);
    }

    @Test
    public void analyzeScoreWithoutHonor() {
        //arrange
        Long id = 1L;
        StudentDTO studentDTOWithoutHonor = new StudentDTO(id, "Juan",
                "El alumno Juan ha obtenido un promedio de 7,33. Puedes mejorar.", 7.33,
                new ArrayList<>() {
                    {
                        add(new SubjectDTO("Matemática", 9.0));
                        add(new SubjectDTO("Física", 7.0));
                        add(new SubjectDTO("Química", 6.0));
                    }
                });
        Mockito.when(obtenerDiplomaService.analyzeScores(id)).thenReturn(studentDTOWithoutHonor);

        //act
        StudentDTO received = obtenerDiplomaController.analyzeScores(id);

        //assert
        Mockito.verify(obtenerDiplomaService, Mockito.atLeast(1)).analyzeScores(id);
        Assertions.assertEquals(studentDTOWithoutHonor, received);
    }

}
