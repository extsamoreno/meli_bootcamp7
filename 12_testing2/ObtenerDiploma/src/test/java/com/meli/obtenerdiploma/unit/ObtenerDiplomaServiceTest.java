package com.meli.obtenerdiploma.unit;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    public void analyzeScoresTestHappyPath() {

        //Arrange
        //Arrange
        SubjectDTO subjectOne = new SubjectDTO("Programación", 10d);
        SubjectDTO subjectTwo = new SubjectDTO("Algoritmos", 10d);
        SubjectDTO subjectThree = new SubjectDTO("Base de datos", 10d);

        List<SubjectDTO> listSubjects = new ArrayList<>();
        listSubjects.add(subjectOne);
        listSubjects.add(subjectTwo);
        listSubjects.add(subjectThree);

        StudentDTO student = new StudentDTO(3L, "Genardo", "No se", 10d, listSubjects);

        Mockito.when(studentDAO.findById(3L)).thenReturn(student);

        //act

        StudentDTO result = obtenerDiplomaService.analyzeScores(3L);

        //asert

        Assertions.assertEquals(result, student);
        Assertions.assertEquals(result.getAverageScore(), student.getAverageScore());
        Assertions.assertEquals("El alumno " + student.getStudentName() + " ha obtenido un promedio de " + new DecimalFormat("#.##").format(student.getAverageScore())
                + ((student.getAverageScore() > 9) ? ". Felicitaciones!" : ". Puedes mejorar."), result.getMessage());
    }

    @Test
    public void analyzeScoresTestNull() {
        //Arrange
        Mockito.when(studentDAO.findById(3L)).thenReturn(null);

        //Asert
        Assertions.assertThrows(NullPointerException.class, () -> obtenerDiplomaService.analyzeScores(3L));
    }


}
