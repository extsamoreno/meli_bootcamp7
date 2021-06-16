package com.meli.obtenerdiploma.unit.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import com.sun.source.tree.ModuleTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    public void analyzeScoresHappyPathScoreBelow9() {
        //arrange
        StudentDTO expected = new StudentDTO(1L, "Juan", "El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar.", (9.0 + 7 + 6) / 3, new ArrayList<>() {
            {
                add(new SubjectDTO("Matemática", 9.0));
                add(new SubjectDTO("Física", 7.0));
                add(new SubjectDTO("Química", 6.0));
            }
        });

        Long id = 1L;

        StudentDTO studentDTO = new StudentDTO(1L, "Juan", null, null, new ArrayList<>() {
            {
                add(new SubjectDTO("Matemática", 9.0));
                add(new SubjectDTO("Física", 7.0));
                add(new SubjectDTO("Química", 6.0));
            }
        });
        Mockito.when(studentDAO.findById(id)).thenReturn(studentDTO);

        //act
        StudentDTO received = obtenerDiplomaService.analyzeScores(id);

        //assert
        Mockito.verify(studentDAO, Mockito.atLeast(1)).findById(id);
        Assertions.assertEquals(expected, received);
    }


    @Test
    public void analyzeScoresHappyPathScoreAbove9() {
        //arrange
        StudentDTO expected = new StudentDTO(2L, "Pedro", "El alumno Pedro ha obtenido un promedio de 9.33. Felicitaciones!", (10.0 + 9 + 9) / 3, new ArrayList<>() {
            {
                add(new SubjectDTO("Matemática", 10.0));
                add(new SubjectDTO("Física", 9.0));
                add(new SubjectDTO("Química", 9.0));
            }
        });

        Long id = 1L;

        StudentDTO studentDTO = new StudentDTO(2L, "Pedro", null, null, new ArrayList<>() {
            {
                add(new SubjectDTO("Matemática", 10.0));
                add(new SubjectDTO("Física", 9.0));
                add(new SubjectDTO("Química", 9.0));
            }
        });
        Mockito.when(studentDAO.findById(id)).thenReturn(studentDTO);

        //act
        StudentDTO received = obtenerDiplomaService.analyzeScores(id);

        //assert
        Mockito.verify(studentDAO, Mockito.atLeast(1)).findById(id);
        Assertions.assertEquals(expected, received);
    }
}
