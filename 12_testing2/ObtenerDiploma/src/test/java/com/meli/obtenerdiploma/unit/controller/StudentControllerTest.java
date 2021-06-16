package com.meli.obtenerdiploma.unit.controller;

import com.meli.obtenerdiploma.controller.StudentController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import com.meli.obtenerdiploma.unit.MockHelper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

    @Mock
    private IStudentService studentService;

    @InjectMocks
    private StudentController studentController;

    @Test
    public void testRegisterStudent(){
        //Arrange
        StudentDTO student = MockHelper.getUserMockWithCongrats();
        HttpStatus statusExpected = HttpStatus.OK;

        //Act
        ResponseEntity<?> received = studentController.registerStudent(student);

        //Assert
        assertEquals(statusExpected, received.getStatusCode());
    }

    @Test
    public void testGetStudent(){
        //Arrange
        Long studentId = 1L;
        StudentDTO studentExpected = MockHelper.getUserMockWithCongrats();
        when(studentService.read(studentId)).thenReturn(studentExpected);

        //Act
        StudentDTO studentReceived = studentController.getStudent(studentId);

        //Assert
        verify(studentService, atLeastOnce()).read(studentId);
        assertEquals(studentExpected, studentReceived);
    }

    @Test
    public void testModifyStudent(){
        //Arrange
        StudentDTO student = new StudentDTO(1L,"Santiago Garcia", "", 0.0,
                Arrays.asList(new SubjectDTO("Fisica", 5.0), new SubjectDTO("Matematica", 8.0), new SubjectDTO("Lengua", 10.0)));
        HttpStatus statusExpected = HttpStatus.OK;
        doNothing().when(studentService).update(student);

        //Act
        ResponseEntity<?> received = studentController.modifyStudent(student);

        //Assert
        verify(studentService, atLeastOnce()).update(student);
        assertEquals(statusExpected, received.getStatusCode());
    }

    @Test
    public void testRemoveStudent(){
        //Arrange
        Long studentId = 1L;
        HttpStatus statusExpected = HttpStatus.OK;
        doNothing().when(studentService).delete(studentId);

        //Act
        ResponseEntity<?> received = studentController.removeStudent(studentId);

        //Assert
        verify(studentService, atLeastOnce()).delete(studentId);
        assertEquals(statusExpected, received.getStatusCode());
    }

    @Test
    public void testListStudentsStudent(){
        //Arrange
        StudentDTO student = MockHelper.getUserMockWithCongrats();
        Set<StudentDTO> expected = new HashSet<>();
        expected.add(student);
        when(studentService.getAll()).thenReturn(expected);

        //Act
        Set<StudentDTO> received = studentController.listStudents();

        //Assert
        verify(studentService, atLeastOnce()).getAll();
        assertEquals(expected, received);
    }
    
}
