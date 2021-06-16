package com.meli.obtenerdiploma.unit;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @Mock
    StudentRepository studentRepository;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    public void analizeScoresNull() {

        //arrange
        long id = -1;
        Mockito.when(studentDAO.findById(id)).thenThrow(new StudentNotFoundException(id));

        //assert
        Assertions.assertThrows(StudentNotFoundException.class, () -> obtenerDiplomaService.analyzeScores(id));
    }

    @Test
    public void analizeScoresOk() {

        //arrange
        long id = 1;
        List<SubjectDTO> subjects = new ArrayList<>();
        SubjectDTO subjectDTO = new SubjectDTO("Matemáticas", 8d);
        subjects.add(subjectDTO);
        StudentDTO expected = new StudentDTO();
        expected.setSubjects(subjects);

        Mockito.when(studentDAO.findById(id)).thenReturn(expected);

        //act
        StudentDTO received = obtenerDiplomaService.analyzeScores(id);

        //assert
        Assertions.assertEquals(expected, received);
    }

    @Test
    public void getGreetingsOk() {

        //arrange
        long id = 1;
        List<SubjectDTO> subjects = new ArrayList<>();
        SubjectDTO subjectDTO = new SubjectDTO("Matemáticas", 8d);
        subjects.add(subjectDTO);
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setSubjects(subjects);
        studentDTO.setStudentName("Juan");

        Mockito.when(studentDAO.findById(id)).thenReturn(studentDTO);
        String expectedMessage = "El alumno Juan ha obtenido un promedio de 8. Puedes mejorar.";

        //act
        String received = obtenerDiplomaService.analyzeScores(id).getMessage();

        //assert
        Assertions.assertEquals(expectedMessage, received);
    }

    @Test
    public void getGreetingsOkWithHonors() {

        //arrange
        long id = 1;
        //List<SubjectDTO> subjects = new ArrayList<>(Arrays.asList(new SubjectDTO("Matemática",9.0), new SubjectDTO("Física",7.0), new SubjectDTO("Química", 6.0)));
        List<SubjectDTO> subjects = new ArrayList<>();
        SubjectDTO subjectDTO = new SubjectDTO("Matemáticas", 10d);
        subjects.add(subjectDTO);
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setSubjects(subjects);
        studentDTO.setStudentName("Juan");

        Mockito.when(studentDAO.findById(id)).thenReturn(studentDTO);
        String expected = "El alumno Juan ha obtenido un promedio de 10. Felicitaciones!";

        //act
        String received = obtenerDiplomaService.analyzeScores(id).getMessage();

        //assert
        Assertions.assertEquals(expected, received);
    }

    @Test
    public void getAverageOk() {

        //arrange
        long id = 1;
        List<SubjectDTO> subjects = new ArrayList<>();
        SubjectDTO subjectDTO = new SubjectDTO("Matemáticas", 10d);
        subjects.add(subjectDTO);
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setSubjects(subjects);
        studentDTO.setStudentName("Juan");

        Mockito.when(studentDAO.findById(id)).thenReturn(studentDTO);
        Double expected = 10d;

        //act
        Double received = obtenerDiplomaService.analyzeScores(id).getAverageScore();

        //assert
        Assertions.assertEquals(expected, received);
    }
}
