package com.meli.obtenerdiploma.unit;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    IStudentDAO iStudentDAO;

    @Mock
    IStudentRepository iStudentRepository;

    @InjectMocks
    StudentService studentService;

    @Test
    public void createStudentHappyPath(){

        // Arrange
        Long studentId = 1L;
        SubjectDTO subject = new SubjectDTO( "Matematica", 9.0);
        SubjectDTO subject2 = new SubjectDTO( "Lengua", 10.0);
        List<SubjectDTO> subjects = new ArrayList<SubjectDTO>();
        subjects.add(subject);
        subjects.add(subject2);
        StudentDTO student =  new StudentDTO(studentId,"Juan", "hola", 0.0, subjects);
        doNothing().when(iStudentDAO).save(student);

        // Act
        studentService.create(student);

        // Assert
        verify(iStudentDAO, times(1)).save(student);

    }

    @Test
    public void readStudentHappyPath(){
        // Arrange
        Long studentId = 1L;
        SubjectDTO subject = new SubjectDTO( "Matematica", 9.0);
        SubjectDTO subject2 = new SubjectDTO( "Lengua", 10.0);
        List<SubjectDTO> subjects = new ArrayList<SubjectDTO>();
        subjects.add(subject);
        subjects.add(subject2);
        StudentDTO student =  new StudentDTO(studentId,"Juan", "hola", 0.0, subjects);
        when(iStudentDAO.findById(studentId)).thenReturn(student);

        // Act
        StudentDTO received = studentService.read(studentId);

        // Assert
        verify(iStudentDAO, times(1)).findById(studentId);
        Assertions.assertEquals(student, received);

    }
}
