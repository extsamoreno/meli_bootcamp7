package com.example.diploma.unit;

import com.example.diploma.controller.ObtenerDiplomaController;
import com.example.diploma.model.StudentDTO;
import com.example.diploma.model.SubjectDTO;
import com.example.diploma.repository.IStudentDAO;
import com.example.diploma.service.IObtenerDiplomaService;
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

    @Mock
    IStudentDAO iStudentDAO;

    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;

    @Test
    public void analyzeScores() {
        //ARRANGE
        StudentDTO expected = new StudentDTO(1L, "Juan", "El alumno Juan ha obtenido un promedio de 7,33. Puedes mejorar.", (9.0 + 7 + 6) / 3, new ArrayList<>() {
            {
                add(new SubjectDTO("Matemática", 9.0));
                add(new SubjectDTO("Física", 7.0));
                add(new SubjectDTO("Química", 6.0));
            }
        });

        Long id = 1L;
        
        Mockito.when(iObtenerDiplomaService.analyzeScores(1L)).thenReturn(expected);

        //ACT
        StudentDTO received = obtenerDiplomaController.analyzeScores(id);

        //ASSERT
        Mockito.verify(iObtenerDiplomaService,Mockito.atLeastOnce()).analyzeScores(id);
        Assertions.assertEquals(expected, received);
    }
}
