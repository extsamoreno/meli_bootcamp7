package com.meli.obtenerdiploma.unit;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*; // Para el when, verify y times.
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.security.auth.Subject;
import java.util.*;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

  @Mock
  private IStudentDAO studentDAO; // Se mockea para obtener el método de la dependencia que necesitamos testear

  @InjectMocks
  private ObtenerDiplomaService obtenerDiplomaService; // Para inyectar en la implementación

  @Test
  void obtenerDiplomaHappyPath(){
    // Arrange
    Long id = 18L;
    String name = "";
    String message = "";
    Double average = 3.50;
    SubjectDTO subjectA = new SubjectDTO("Matemática", 10.00);
    SubjectDTO subjectB = new SubjectDTO("Lengua", 9.00);
    SubjectDTO subjectC = new SubjectDTO("Ed. Física", 9.50);
    List<SubjectDTO> subjects = Arrays.asList(subjectA, subjectB, subjectC);

    StudentDTO expectedStudent = new StudentDTO(id,name,message,average,subjects);
    when(studentDAO.findById(id)).thenReturn(expectedStudent);

    // Act
    StudentDTO receivedStudent = obtenerDiplomaService.analyzeScores(id);

    // Assert
    verify(studentDAO, times(1)).findById(id);
    assertThat(expectedStudent).isEqualTo(receivedStudent);
  }

  @Test
  void obtenerDiplomaCongratulationHappyPath(){
    // Arrange
    Long id = 18L;
    String name = "Test";
    String message = "";
    Double average = 0.00;
    SubjectDTO subjectA = new SubjectDTO("Matemática", 10.00);
    SubjectDTO subjectB = new SubjectDTO("Lengua", 9.00);
    SubjectDTO subjectC = new SubjectDTO("Ed. Física", 9.50);
    List<SubjectDTO> subjects = Arrays.asList(subjectA, subjectB, subjectC);

    StudentDTO expectedStudent = new StudentDTO(id,name,message,average,subjects);
    expectedStudent.setAverageScore(9.5);
    expectedStudent.setMessage("El alumno " + expectedStudent.getStudentName() + " ha obtenido un promedio de " +
            expectedStudent.getAverageScore() + ". Felicitaciones!");

    StudentDTO otherStudent = new StudentDTO(id, name, message, average, subjects);

    when(studentDAO.findById(id)).thenReturn(otherStudent);

    // Act
    StudentDTO receivedStudent = obtenerDiplomaService.analyzeScores(id);

    // Assert
    verify(studentDAO, times(1)).findById(id);
    assertThat(expectedStudent).isEqualTo(receivedStudent);
  }

  @Test
  void obtenerDiplomaCanImproveHappyPath(){
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
    expectedStudent.setAverageScore(7.50);
    expectedStudent.setMessage("El alumno " + expectedStudent.getStudentName() + " ha obtenido un promedio de " +
            expectedStudent.getAverageScore() + ". Puedes mejorar.");

    StudentDTO otherStudent = new StudentDTO(id, name, message, average, subjects);

    when(studentDAO.findById(id)).thenReturn(otherStudent);

    // Act
    StudentDTO receivedStudent = obtenerDiplomaService.analyzeScores(id);

    // Assert
    verify(studentDAO, times(1)).findById(id);
    assertThat(expectedStudent).isEqualTo(receivedStudent);
  }

  // Supuestamente los test de Exceptions se hacen en los Integration
  @Test
  void obtenerDiplomaEmptyList(){
    // Arrange
    Long studentId = 100L;
    when(studentDAO.findById(studentId)).thenThrow(new StudentNotFoundException(studentId));

    // Act // Assert
    assertThrows(StudentNotFoundException.class, () -> obtenerDiplomaService.analyzeScores(studentId));

  }


}
