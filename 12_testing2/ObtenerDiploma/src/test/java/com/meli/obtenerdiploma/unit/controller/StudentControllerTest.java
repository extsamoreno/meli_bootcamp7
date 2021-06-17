package com.meli.obtenerdiploma.unit.controller;

import com.meli.obtenerdiploma.controller.StudentController;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
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
    IStudentService studentService;

    @InjectMocks
    StudentController studentController;

    @Test
    public void registerStudent() {
        //arrange
        StudentDTO studentDTO = new StudentDTO(1L, "Juan", null, null, new ArrayList<>());
        Mockito.doNothing().when(studentService).create(studentDTO);

        //act
        ResponseEntity<?> received = studentController.registerStudent(studentDTO);

        //assert
        Mockito.verify(studentService, Mockito.atLeast(1)).create(studentDTO);
        Assertions.assertEquals(HttpStatus.OK, received.getStatusCode());
    }

    @Test
    public void getStudent() {
        //arrange
        Long id = 1L;
        StudentDTO studentDTO = new StudentDTO(id, "Juan", null, null, null);
        Mockito.when(studentService.read(id)).thenReturn(studentDTO);

        //act
        StudentDTO received = studentController.getStudent(id);

        //assert
        Mockito.verify(studentService, Mockito.atLeast(1)).read(id);
        Assertions.assertEquals(studentDTO, received);
    }

    @Test
    public void getStudentThrowStudentNotFoundException() {
        //arrange
        Long id = 4L;
        Mockito.when(studentService.read(id)).thenThrow(StudentNotFoundException.class);

        //act

        //assert
        Assertions.assertThrows(StudentNotFoundException.class, () -> studentController.getStudent(id));
        Mockito.verify(studentService, Mockito.atLeast(1)).read(id);
    }

    @Test
    public void modifyStudent() {
        //arrange
        StudentDTO studentDTO = new StudentDTO(1L, "Juan", null, null, new ArrayList<>());
        Mockito.doNothing().when(studentService).update(studentDTO);

        //act
        ResponseEntity<?> received = studentController.modifyStudent(studentDTO);

        //assert
        Mockito.verify(studentService, Mockito.atLeast(1)).update(studentDTO);
        Assertions.assertEquals(HttpStatus.OK, received.getStatusCode());
    }

    @Test
    public void removeStudent() {
        //arrange
        Long id = 1L;
        Mockito.doNothing().when(studentService).delete(id);

        //act
        ResponseEntity<?> received = studentController.removeStudent(id);

        //assert
        Mockito.verify(studentService, Mockito.atLeast(1)).delete(id);
        Assertions.assertEquals(HttpStatus.OK, received.getStatusCode());
    }

    @Test
    public void listStudents() {
        //arrange
        Set<StudentDTO> students = new HashSet<>(){{
            add(new StudentDTO(1L, "Juan", null, null, null));
            add(new StudentDTO(2L, "Mariano", null, null, null));
            add(new StudentDTO(3L, "Gerónimo", null, null, null));
        }};
        Mockito.when(studentService.getAll()).thenReturn(students);

        //act
        Set<StudentDTO> received = studentController.listStudents();

        //assert
        Assertions.assertEquals(students, received);
        Mockito.verify(studentService, Mockito.atLeast(1)).getAll();
    }
}
