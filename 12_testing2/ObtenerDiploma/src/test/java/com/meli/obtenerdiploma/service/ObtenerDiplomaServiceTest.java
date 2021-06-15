package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    public void analyzeScoresHappyPath(){
        //Arrange
        long id = 1;
        ArrayList<SubjectDTO> subjectDTOS = new ArrayList<>();
        SubjectDTO subj1 = new SubjectDTO("Mate", 10.0);
        SubjectDTO subj2 = new SubjectDTO("Mate", 8.2);
        subjectDTOS.add(subj1);
        subjectDTOS.add(subj2);
        StudentDTO studentDTO = new StudentDTO(1L, "Juan", null, null, subjectDTOS);
        StudentDTO studentExcepted = new StudentDTO(1L, "Juan", "El alumno Juan ha obtenido un promedio de 9.1. Felicitaciones!",
                        9.1, subjectDTOS);
        when(studentDAO.findById(id)).thenReturn(studentDTO);
        //Act
        StudentDTO expected = obtenerDiplomaService.analyzeScores(id);
        //Assert
        verify(studentDAO, atLeast(1)).findById(id);
        assertEquals(studentExcepted, expected);
    }

    @Test
    public void analyzeScoresTestAverage(){
        //Arrange
        long id = 1;
        ArrayList<SubjectDTO> subjectDTOS = new ArrayList<>();
        SubjectDTO subj1 = new SubjectDTO("Mate", 10.0);
        SubjectDTO subj2 = new SubjectDTO("Mate", 8.4);
        subjectDTOS.add(subj1);
        subjectDTOS.add(subj2);
        StudentDTO studentDTO = new StudentDTO(1L, "Juan", null, null, subjectDTOS);
        when(studentDAO.findById(id)).thenReturn(studentDTO);
        //Act
        StudentDTO expected = obtenerDiplomaService.analyzeScores(id);
        //Assert
        verify(studentDAO, atLeast(1)).findById(id);
        assertEquals(studentDTO.getAverageScore(), expected.getAverageScore());
    }

    @Test
    public void analyzeScoresTestMessageHonor(){
        //Arrange
        long id = 1;
        ArrayList<SubjectDTO> subjectDTOS = new ArrayList<>();
        SubjectDTO subj1 = new SubjectDTO("Mate", 10.0);
        SubjectDTO subj2 = new SubjectDTO("Mate", 8.4);
        subjectDTOS.add(subj1);
        subjectDTOS.add(subj2);
        StudentDTO studentDTO = new StudentDTO(1L, "Juan", null, null, subjectDTOS);
        StudentDTO studentExcepted = new StudentDTO(1L, "Juan", "El alumno " +studentDTO.getStudentName()+
                                            " ha obtenido un promedio de 9.2. Felicitaciones!",
                9.2, subjectDTOS);
        when(studentDAO.findById(id)).thenReturn(studentDTO);
        //Act
        StudentDTO response = obtenerDiplomaService.analyzeScores(id);
        //Assert
        verify(studentDAO, atLeast(1)).findById(id);
        assertEquals(studentExcepted.getMessage(), response.getMessage());
    }

    @Test
    public void analyzeScoresTestMessage(){
        //Arrange
        long id = 1;
        ArrayList<SubjectDTO> subjectDTOS = new ArrayList<>();
        SubjectDTO subj1 = new SubjectDTO("Mate", 10.0);
        SubjectDTO subj2 = new SubjectDTO("Mate", 6.0);
        subjectDTOS.add(subj1);
        subjectDTOS.add(subj2);
        StudentDTO studentDTO = new StudentDTO(1L, "Juan", null, null, subjectDTOS);
        StudentDTO studentExcepted = new StudentDTO(1L, "Juan", "El alumno Juan ha obtenido un promedio de 8. Puedes mejorar.",
                8.0, subjectDTOS);
        when(studentDAO.findById(id)).thenReturn(studentDTO);
        //Act
        StudentDTO response = obtenerDiplomaService.analyzeScores(id);
        //Assert
        verify(studentDAO, atLeast(1)).findById(id);
        assertEquals(studentExcepted.getMessage(), response.getMessage());
    }
}