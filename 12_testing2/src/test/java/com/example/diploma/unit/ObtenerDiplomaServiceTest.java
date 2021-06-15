package com.example.diploma.unit;

import com.example.diploma.exception.StudentNotFoundException;
import com.example.diploma.model.StudentDTO;
import com.example.diploma.model.SubjectDTO;
import com.example.diploma.repository.IStudentDAO;
import com.example.diploma.service.ObtenerDiplomaService;
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
    IStudentDAO iStudentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    //ANALYZE SCORES

    @Test
    public void testAnalyzeScoresNoHonor() {
        //ARRANGE
        StudentDTO expected = new StudentDTO(1L, "Juan", "El alumno Juan ha obtenido un promedio de 7,33. Puedes mejorar.", (9.0 + 7 + 6) / 3, new ArrayList<>() {
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
        Mockito.when(iStudentDAO.findById(id)).thenReturn(studentDTO);

        //ACT
        StudentDTO received = obtenerDiplomaService.analyzeScores(id);

        //ASSERT
        Mockito.verify(iStudentDAO, Mockito.atLeast(1)).findById(id);
        Assertions.assertEquals(expected, received);
    }

    @Test
    public void testAnalyzeScoresWithHonor() {
        //ARRANGE
        StudentDTO expected = new StudentDTO(2L, "Pedro", "El alumno Pedro ha obtenido un promedio de 10. Felicitaciones!", (10.0 + 10 + 10.0) / 3, new ArrayList<>() {
            {
                add(new SubjectDTO("Matemática", 10.0));
                add(new SubjectDTO("Física", 10.0));
                add(new SubjectDTO("Química", 10.0));
            }
        });

        Long id = 2L;

        StudentDTO studentDTO = new StudentDTO(2L, "Pedro", null, null, new ArrayList<>() {
            {
                add(new SubjectDTO("Matemática", 10.0));
                add(new SubjectDTO("Física", 10.0));
                add(new SubjectDTO("Química", 10.0));
            }
        });
        Mockito.when(iStudentDAO.findById(id)).thenReturn(studentDTO);

        //ACT
        StudentDTO received = obtenerDiplomaService.analyzeScores(id);

        //ASSERT
        Mockito.verify(iStudentDAO, Mockito.atLeast(1)).findById(id);
        Assertions.assertEquals(expected, received);
    }

    @Test
    public void testAnalizeScoresInexistentStudent() {
        //ARRANGE
        Long id = 5L;

        Mockito.when(iStudentDAO.findById(id)).thenReturn(new StudentDTO());

        //ACT

        //ASSERT
        Assertions.assertThrows(NullPointerException.class, () -> obtenerDiplomaService.analyzeScores(id));
        Mockito.verify(iStudentDAO, Mockito.atLeastOnce()).findById(id);
    }

    @Test
    public void testAnalizeScoresNullStudent() {
        //ARRANGE
        Long id = null;

        Mockito.when(iStudentDAO.findById(id)).thenReturn(new StudentDTO());

        //ACT

        //ASSERT
        Assertions.assertThrows(NullPointerException.class, () -> obtenerDiplomaService.analyzeScores(id));
        Mockito.verify(iStudentDAO, Mockito.atLeastOnce()).findById(id);
    }
}
