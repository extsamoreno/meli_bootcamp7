package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService diplomaService;

    @Test
    public void analyzeScoresTest() {
        List<SubjectDTO> subjectDTOS = new ArrayList<>();
        SubjectDTO subject = new SubjectDTO("Matematica", 10.0);
        subjectDTOS.add(subject);
        StudentDTO studentDTO = new StudentDTO(1L, "Pepe", "Pepito", 10.0, subjectDTOS);
        when(studentDAO.findById(1L)).thenReturn(studentDTO);
        assertEquals(studentDTO, diplomaService.analyzeScores(1L));
    }

    @Test
    public void analyzeScoredTestNullPointerException() {
        when(studentDAO.findById(1L)).thenReturn(null);
        assertThrows(NullPointerException.class, () -> diplomaService.analyzeScores(1L));
    }

    @Test
    public void analyzeScoresTestAverage() {
        List<SubjectDTO> subjectDTOS = new ArrayList<>();
        SubjectDTO subject = new SubjectDTO("Maths", 10.0);
        subjectDTOS.add(subject);
        SubjectDTO subject2 = new SubjectDTO("Physics", 6.0);
        subjectDTOS.add(subject2);
        StudentDTO studentDTO = new StudentDTO(1L, "Pepe", "Pepito", 10.0, subjectDTOS);
        when(studentDAO.findById(1L)).thenReturn(studentDTO);
        assertEquals(8.0, diplomaService.analyzeScores(1L).getAverageScore());
    }

    @Test
    public void analyzeScoresTestMessageWithHonors() {
        List<SubjectDTO> subjectDTOS = new ArrayList<>();
        SubjectDTO subject = new SubjectDTO("Maths", 10.0);
        subjectDTOS.add(subject);
        SubjectDTO subject2 = new SubjectDTO("Physics", 9.0);
        subjectDTOS.add(subject2);
        StudentDTO studentDTO = new StudentDTO(1L, "Pepe", "Pepito", 10.0, subjectDTOS);
        when(studentDAO.findById(1L)).thenReturn(studentDTO);
        String message = "El alumno " + studentDTO.getStudentName() + " ha obtenido un promedio de 9.5. Felicitaciones!";
        assertEquals(message, diplomaService.analyzeScores(1L).getMessage());
    }

    @Test
    public void analyzeScoredTestMessage() {
        List<SubjectDTO> subjectDTOS = new ArrayList<>();
        SubjectDTO subject = new SubjectDTO("Maths", 10.0);
        subjectDTOS.add(subject);
        SubjectDTO subject2 = new SubjectDTO("Physics", 7.0);
        subjectDTOS.add(subject2);
        StudentDTO studentDTO = new StudentDTO(1L, "Pepe", "Pepito", 10.0, subjectDTOS);
        when(studentDAO.findById(1L)).thenReturn(studentDTO);
        String message = "El alumno " + studentDTO.getStudentName() + " ha obtenido un promedio de 8.5. Puedes mejorar.";
        assertEquals(message, diplomaService.analyzeScores(1L).getMessage());
    }

}
