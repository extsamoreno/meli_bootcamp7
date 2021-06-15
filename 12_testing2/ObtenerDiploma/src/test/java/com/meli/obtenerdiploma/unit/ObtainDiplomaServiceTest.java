package com.meli.obtenerdiploma.unit;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
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

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtainDiplomaServiceTest {

    @Mock
    IStudentDAO iStudentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    public void analyzeScoresTest() {
        //Arrange
        long id = 2;

        List<SubjectDTO> subj2 = new ArrayList<>();
        subj2.add(new SubjectDTO("Matemática", 10.00));
        subj2.add(new SubjectDTO("Física", 8.00));
        subj2.add(new SubjectDTO("Química", 4.00));
        StudentDTO student = new StudentDTO(2L, "Pedro", null, null, subj2);
        double average = (subj2.get(0).getScore() + subj2.get(1).getScore() +
                subj2.get(2).getScore()) / subj2.size();
        String messageExpected = "El alumno " + student.getStudentName() + " ha obtenido un promedio de " + new DecimalFormat("#.##").format(average)
                + ". Puedes mejorar.";
        StudentDTO expected = new StudentDTO(2L, "Pedro", messageExpected, average, subj2);

        when(iStudentDAO.findById(id)).thenReturn(student);

        //Act
        StudentDTO received = obtenerDiplomaService.analyzeScores(id);
        //Assert
        Mockito.verify(iStudentDAO, Mockito.atLeastOnce()).findById(id);
        Assertions.assertEquals(expected, received);
    }

    @Test
    public void calculateAverageOKTest() {
        //Arrange
        long id = 2;

        List<SubjectDTO> subj2 = new ArrayList<>();
        subj2.add(new SubjectDTO("Matemática", 10.00));
        subj2.add(new SubjectDTO("Física", 8.00));
        subj2.add(new SubjectDTO("Química", 4.00));
        StudentDTO student = new StudentDTO(2L, "Pedro", null, null, subj2);
        double average = (subj2.get(0).getScore() + subj2.get(1).getScore() +
                subj2.get(2).getScore()) / subj2.size();
        StudentDTO expected = new StudentDTO(2L, "Pedro", null, average, subj2);

        when(iStudentDAO.findById(id)).thenReturn(student);

        //Act
        StudentDTO received = obtenerDiplomaService.analyzeScores(id);
        //Assert
        Mockito.verify(iStudentDAO, Mockito.atLeastOnce()).findById(id);
        Assertions.assertEquals(expected.getAverageScore(), received.getAverageScore());
    }

    @Test
    public void calculateAverageLowerBorderTest() {
        //Arrange
        long id = 2;

        List<SubjectDTO> subj2 = new ArrayList<>();
        subj2.add(new SubjectDTO("Matemática", 10.00));
        subj2.add(new SubjectDTO("Física", 8.00));
        subj2.add(new SubjectDTO("Química", 4.00));
        StudentDTO student = new StudentDTO(2L, "Pedro", null, null, subj2);
        double average = (subj2.get(0).getScore() + subj2.get(1).getScore() +
                (subj2.get(2).getScore() - 0.01)) / subj2.size();
        StudentDTO expected = new StudentDTO(2L, "Pedro", null, average, subj2);

        when(iStudentDAO.findById(id)).thenReturn(student);

        //Act
        StudentDTO received = obtenerDiplomaService.analyzeScores(id);

        //Assert
        Mockito.verify(iStudentDAO, Mockito.atLeastOnce()).findById(id);
        double average1 = expected.getAverageScore();
        double average2 = received.getAverageScore();
        Assertions.assertTrue(average1 < average2);
    }

    @Test
    public void calculateAverageUpperBorderTest() {
        //Arrange
        long id = 2;

        List<SubjectDTO> subj2 = new ArrayList<>();
        subj2.add(new SubjectDTO("Matemática", 10.00));
        subj2.add(new SubjectDTO("Física", 8.00));
        subj2.add(new SubjectDTO("Química", 4.00));
        StudentDTO student = new StudentDTO(2L, "Pedro", null, null, subj2);
        double average = (subj2.get(0).getScore() + subj2.get(1).getScore() +
                (subj2.get(2).getScore() + 0.01)) / subj2.size();
        StudentDTO expected = new StudentDTO(2L, "Pedro", null, average, subj2);

        when(iStudentDAO.findById(id)).thenReturn(student);

        //Act
        StudentDTO received = obtenerDiplomaService.analyzeScores(id);

        //Assert
        Mockito.verify(iStudentDAO, Mockito.atLeastOnce()).findById(id);
        double average1 = expected.getAverageScore();
        double average2 = received.getAverageScore();
        Assertions.assertTrue(average1 > average2);
    }

    @Test
    public void diplomaNormalMessageTest() {
        //Arrange
        long id = 2;

        List<SubjectDTO> subj2 = new ArrayList<>();
        subj2.add(new SubjectDTO("Matemática", 9.00));
        subj2.add(new SubjectDTO("Física", 9.00));
        subj2.add(new SubjectDTO("Química", 9.00));
        StudentDTO student = new StudentDTO(2L, "Pedro", null, null, subj2);
        double average = (subj2.get(0).getScore() + subj2.get(1).getScore() +
                subj2.get(2).getScore()) / subj2.size();
        String messageExpected = "El alumno " + student.getStudentName() + " ha obtenido un promedio de " + new DecimalFormat("#.##").format(average)
                + ". Puedes mejorar.";
        StudentDTO expected = new StudentDTO(2L, "Pedro", messageExpected, average, subj2);

        when(iStudentDAO.findById(id)).thenReturn(student);

        //Act
        StudentDTO received = obtenerDiplomaService.analyzeScores(id);

        //Assert
        Mockito.verify(iStudentDAO, Mockito.atLeastOnce()).findById(id);
        Assertions.assertEquals(expected.getMessage(), received.getMessage());
    }

    @Test
    public void diplomaCongratsMessageTest() {
        //Arrange
        long id = 2;

        List<SubjectDTO> subj2 = new ArrayList<>();
        subj2.add(new SubjectDTO("Matemática", 9.01));
        subj2.add(new SubjectDTO("Física", 9.00));
        subj2.add(new SubjectDTO("Química", 9.00));
        StudentDTO student = new StudentDTO(2L, "Pedro", null, null, subj2);
        double average = (subj2.get(0).getScore() + subj2.get(1).getScore() +
                subj2.get(2).getScore()) / subj2.size();
        String messageExpected = "El alumno " + student.getStudentName() + " ha obtenido un promedio de " + new DecimalFormat("#.##").format(average)
                + ". Felicitaciones!";
        StudentDTO expected = new StudentDTO(2L, "Pedro", messageExpected, average, subj2);

        when(iStudentDAO.findById(id)).thenReturn(student);

        //Act
        StudentDTO received = obtenerDiplomaService.analyzeScores(id);

        //Assert
        Mockito.verify(iStudentDAO, Mockito.atLeastOnce()).findById(id);
        Assertions.assertEquals(expected.getMessage(), received.getMessage());
    }
}
