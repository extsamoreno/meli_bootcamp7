package com.meli.obtenerdiploma.unit;

import com.meli.obtenerdiploma.controller.StudentController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

    @Mock
    IStudentService iStudentService;

    @InjectMocks
    StudentController studentController;


    Long studentId;
    SubjectDTO subject1;
    SubjectDTO subject2 = new SubjectDTO( "Lengua", 10.0);
    List<SubjectDTO> subjects;
    StudentDTO student1;

    @BeforeEach
    public void init() {
        this.studentId = 1L;
        this.subject1 = new SubjectDTO( "Matematica", 9.0);
        this.subject2 = new SubjectDTO( "Lengua", 10.0);
        this.subjects = new ArrayList<SubjectDTO>();
        this.subjects.add(subject1);
        this.subjects.add(subject2);
        this.student1 =  new StudentDTO(studentId,null, "hola", 0.0, subjects);
    }

    @Test
    public void registerStudentSuccessfully(){
        // Arrange
        doNothing().when(iStudentService).create(student1);

        // Act
        ResponseEntity<?> response = studentController.registerStudent(student1);

        // Assert
        verify(iStudentService, times(1)).create(student1);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void getStudentSuccessfully(){
        // Arrange
        when(iStudentService.read(studentId)).thenReturn(student1);

        // Act
        StudentDTO response = studentController.getStudent(studentId);

        // Assert
        verify(iStudentService, times(1)).read(studentId);
        Assert.assertEquals(student1, response);

    }
}
