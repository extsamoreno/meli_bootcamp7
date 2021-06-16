package com.meli.obtenerdiploma.unit;

import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {

  @Mock
  private IObtenerDiplomaService obtenerDiplomaService;

  @InjectMocks
  private ObtenerDiplomaController obtenerDiplomaController;

  @Test
  // Arrange
  Long id = 18L;
  String name = "Test";
  String message = "";
  Double average = 0.00;
  SubjectDTO subjectA = new SubjectDTO("Matemática", 8.00);
  SubjectDTO subjectB = new SubjectDTO("Lengua", 7.50);
  SubjectDTO subjectC = new SubjectDTO("Ed. Física", 7.00);
  List<SubjectDTO> subjects = Arrays.asList(subjectA, subjectB, subjectC);

  StudentDTO expectedStudent = new StudentDTO(id,name,message,average,subjects);
  //when()

  // Act
  StudentDTO currentStudent = obtenerDiplomaController.analyzeScores(id);

  // Assert


}

