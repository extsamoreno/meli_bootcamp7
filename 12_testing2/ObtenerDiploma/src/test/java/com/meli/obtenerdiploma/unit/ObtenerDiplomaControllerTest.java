package com.meli.obtenerdiploma.unit;

import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {

  @Mock
  private IObtenerDiplomaService obtenerDiplomaService;

  @InjectMocks
  private ObtenerDiplomaController obtenerDiplomaController;

  @Test
  public void obtenerDiplomaHappyPath(){
    // Arrange
    Long studentId = 1L;
    SubjectDTO subject = new SubjectDTO( "Matematica", 9.0);
    SubjectDTO subject2 = new SubjectDTO( "Lengua", 10.0);
    List<SubjectDTO> subjects = new ArrayList<SubjectDTO>();
    subjects.add(subject);
    subjects.add(subject2);
    StudentDTO student =  new StudentDTO(studentId,"Juan", "hola", 0.0, subjects);
    when(obtenerDiplomaService.analyzeScores(studentId)).thenReturn(student);
    // Act
    StudentDTO received = obtenerDiplomaController.analyzeScores(studentId);

    //Assert
    Assertions.assertEquals(received, student);

  }
}
