package com.meli.obtenerdiploma.unit.service;

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
    public void analyzeScoresHappyPath(){
        // arrange
        Long studentId = 1L;

        SubjectDTO subjectOne = new SubjectDTO("Matemática", 9.0);
        SubjectDTO subjectTwo = new SubjectDTO("Física", 7.0);
        SubjectDTO subjectThree = new SubjectDTO("Química", 6.0);

        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(subjectOne);
        subjectDTOList.add(subjectTwo);
        subjectDTOList.add(subjectThree);

        StudentDTO expectedStudent = new StudentDTO(studentId,"Juan","message",7.33,subjectDTOList);

        Mockito.when(studentDAO.findById(studentId)).thenReturn(expectedStudent);

        // act
        StudentDTO recived = obtenerDiplomaService.analyzeScores(studentId);

        // assert
        Mockito.verify(studentDAO,Mockito.atLeastOnce()).findById(studentId);
        Assertions.assertEquals(expectedStudent,recived);

        Assertions.assertEquals("El alumno " + expectedStudent.getStudentName() + " ha obtenido un promedio de " + new DecimalFormat("#.##").format(expectedStudent.getAverageScore())
                + ((expectedStudent.getAverageScore() > 9) ? ". Felicitaciones!" : ". Puedes mejorar."), recived.getMessage());

        Assertions.assertEquals(expectedStudent.getAverageScore() ,recived.getAverageScore());
        Assertions.assertEquals(expectedStudent.getMessage(), recived.getMessage());
    }

    @Test
    public void analyzeScoresNullStudent(){
        //arrange
        Mockito.when(studentDAO.findById(1L)).thenReturn(null);

        // assert
        Assertions.assertThrows(NullPointerException.class, () -> obtenerDiplomaService.analyzeScores(1L));
    }

}
