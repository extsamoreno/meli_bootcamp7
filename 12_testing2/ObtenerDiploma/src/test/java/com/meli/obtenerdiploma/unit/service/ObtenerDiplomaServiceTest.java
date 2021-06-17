package com.meli.obtenerdiploma.unit.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
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
public class ObtenerDiplomaServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;


    static StudentDTO studentDTOWithHonor;
    static StudentDTO studentDTOWithoutHonor;
    static Long id;

    @BeforeAll
    public static void beforeAll() {
        id = 1L;
        studentDTOWithHonor = new StudentDTO(id, "Juan", "", null,
                new ArrayList<>() {
                    {
                        add(new SubjectDTO("Matemática", 9.0));
                        add(new SubjectDTO("Física", 9.5));
                        add(new SubjectDTO("Química", 10.0));
                    }
                });

        studentDTOWithoutHonor = new StudentDTO(id, "Juan", null, null,
                new ArrayList<>() {
                    {
                        add(new SubjectDTO("Matemática", 9.0));
                        add(new SubjectDTO("Física", 7.0));
                        add(new SubjectDTO("Química", 6.0));
                    }
                });
    }


    @Test
    public void analyzeScoresHappyPathNoHonor() {
        //arrange
        StudentDTO expected = new StudentDTO(id,
                "Juan",
                "El alumno Juan ha obtenido un promedio de 7,33. Puedes mejorar.",
                (9.0 + 7 + 6) / 3,
                new ArrayList<>() {
                    {
                        add(new SubjectDTO("Matemática", 9.0));
                        add(new SubjectDTO("Física", 7.0));
                        add(new SubjectDTO("Química", 6.0));
                    }
                });

        Mockito.when(studentDAO.findById(id)).thenReturn(studentDTOWithoutHonor);

        //act
        StudentDTO received = obtenerDiplomaService.analyzeScores(id);

        //assert
        Mockito.verify(studentDAO, Mockito.atLeast(1)).findById(id);
        Assertions.assertEquals(expected, received);
    }

    @Test
    public void analyzeScoresHappyPathWithHonor() {
        //arrange
        StudentDTO expected = new StudentDTO(1L,
                "Juan",
                "El alumno Juan ha obtenido un promedio de 9,5. Felicitaciones!",
                (9.0 + 9.5 + 10.0) / 3,
                new ArrayList<>() {
                    {
                        add(new SubjectDTO("Matemática", 9.0));
                        add(new SubjectDTO("Física", 9.5));
                        add(new SubjectDTO("Química", 10.0));
                    }
                });

        Mockito.when(studentDAO.findById(id)).thenReturn(studentDTOWithHonor);

        //act
        StudentDTO received = obtenerDiplomaService.analyzeScores(id);

        //assert
        Mockito.verify(studentDAO, Mockito.atLeast(1)).findById(id);
        Assertions.assertEquals(expected, received);
    }


}
