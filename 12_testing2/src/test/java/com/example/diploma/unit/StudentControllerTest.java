package com.example.diploma.unit;

import com.example.diploma.controller.StudentController;
import com.example.diploma.model.StudentDTO;
import com.example.diploma.model.SubjectDTO;
import com.example.diploma.service.IStudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

    @Mock
    IStudentService iStudentService;

    @InjectMocks
    StudentController studentController;

    //REGISTER STUDENT ENDPOINT

    @Test
    public void testRegisterStudent() {
        //ARRANGE
        StudentDTO studentDTO = new StudentDTO();

        Mockito.doNothing().when(iStudentService).create(studentDTO);

        //ACT
        ResponseEntity<?> received = studentController.registerStudent(studentDTO);

        //ASSERT
        Mockito.verify(iStudentService,Mockito.atLeast(1)).create(studentDTO);
        Assertions.assertEquals(HttpStatus.OK,received.getStatusCode());
    }

    //GET STUDENT ENDPOINT

    @Test
    public void testGetStudent() {
        //ARRANGE
        Long id = 1L;
        StudentDTO expected = new StudentDTO(1L, "Juan", null, null, new ArrayList<>() { {
            add(new SubjectDTO("Matemática", 9.0));
            add(new SubjectDTO("Física", 7.0));
            add(new SubjectDTO("Química", 6.0));
        }});

        Mockito.when(iStudentService.read(id)).thenReturn(expected);

        //ACT
        StudentDTO received = studentController.getStudent(id);

        //ASSERT
        Mockito.verify(iStudentService, Mockito.atLeast(1)).read(id);
        Assertions.assertEquals(expected, received);
    }

    //MODIFY STUDENT ENDPOINT

    @Test
    public void testModifyStudent() {
        //ARRANGE
        StudentDTO studentDTO = new StudentDTO();

        Mockito.doNothing().when(iStudentService).update(studentDTO);

        //ACT
        ResponseEntity<?> received = studentController.modifyStudent(studentDTO);

        //ASSERT
        Mockito.verify(iStudentService,Mockito.atLeast(1)).update(studentDTO);
        Assertions.assertEquals(HttpStatus.OK,received.getStatusCode());
    }

    //REMOVE STUDENT ENDPOINT

    @Test
    public void testRemoveStudent() {
        //ARRANGE
        Long id = 1L;

        Mockito.doNothing().when(iStudentService).delete(id);

        //ACT
        ResponseEntity<?> received = studentController.removeStudent(id);

        //ASSERT
        Mockito.verify(iStudentService,Mockito.atLeast(1)).delete(id);
        Assertions.assertEquals(HttpStatus.OK,received.getStatusCode());
    }

    //LIST STUDENTS ENDPOINT
    @Test
    public void testListStudents() {
        //ARRANGE
        HashSet<StudentDTO> expected = new HashSet<>() {{
            add(new StudentDTO(1L, "Juan", null, null, null));
            add(new StudentDTO(2L, "Pedro", null, null, null));
        }};

        Mockito.when(iStudentService.getAll()).thenReturn(expected);

        //ACT
        Set<StudentDTO> received = studentController.listStudents();

        //ASSERT
        Mockito.verify(iStudentService,Mockito.atLeast(1)).getAll();
        Assertions.assertEquals(expected, received);
    }

}
