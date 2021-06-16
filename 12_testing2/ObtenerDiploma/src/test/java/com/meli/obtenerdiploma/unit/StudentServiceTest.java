package com.meli.obtenerdiploma.unit;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.StudentService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

  @Mock
  private IStudentDAO studentDAO;

  @Mock
  private IStudentRepository studentRepository;

  @InjectMocks
  private StudentService studentService;

  @Test
  void createStudentHappyPath() {
    // Arrange
    Long id = 18L;
    String name = "Test";
    String message = "";
    Double average = 0.00;
    SubjectDTO subjectA = new SubjectDTO("Matemática", 8.00);
    SubjectDTO subjectB = new SubjectDTO("Lengua", 7.50);
    SubjectDTO subjectC = new SubjectDTO("Ed. Física", 7.00);
    List<SubjectDTO> subjects = Arrays.asList(subjectA, subjectB, subjectC);

    StudentDTO student = new StudentDTO(id,name,message,average,subjects);
    doNothing().when(studentDAO).save(student);

    // Act
    studentService.create(student);

    // Assert
    verify(studentDAO, times(1)).save(student);
  }

  @Test
  void readStudentHappyPath() {
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
    when(studentDAO.findById(id)).thenReturn(expectedStudent);

    // Act
    StudentDTO currentStudent = studentService.read(id);

    // Assert
    verify(studentDAO, times(1)).findById(id);
    Assertions.assertThat(expectedStudent).isEqualTo(currentStudent);
  }

}
