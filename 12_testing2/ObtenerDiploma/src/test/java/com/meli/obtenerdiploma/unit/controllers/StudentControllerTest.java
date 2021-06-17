package com.meli.obtenerdiploma.unit.controllers;

import com.meli.obtenerdiploma.controller.StudentController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import com.meli.obtenerdiploma.unit.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashSet;
import java.util.Set;

@ExtendWith(MockitoExtension.class)

public class StudentControllerTest {

    @Mock
    IStudentService iStudentService;

    @InjectMocks
    StudentController studentController;

    @Test
    public void registerStudentHappyPath() {

        //Arrange
        StudentDTO studDTO = Utils.getStudentDTO();
        HttpStatus statusExpected = HttpStatus.OK;

        //Act
        ResponseEntity<?> received = studentController.registerStudent(studDTO);

        //Assert
        Mockito.verify(iStudentService, Mockito.atLeastOnce()).create(studDTO);
        Assertions.assertNull(received.getBody());

        HttpStatus statusReceived = received.getStatusCode();
        Assertions.assertEquals(statusExpected, statusReceived);
    }

    @Test
    public void getStudentHappyPath() {

        //Arrange
        StudentDTO studentDTO = Utils.getStudentDTO();
        long id = 1L;

        Mockito.when(iStudentService.read(id)).thenReturn(studentDTO);

        //Act
        StudentDTO received = studentController.getStudent(id);

        //Assert
        Mockito.verify(iStudentService, Mockito.atLeastOnce()).read(id);
        Assertions.assertEquals(studentDTO, received);
    }

    @Test
    public void modifyStudentHappyPath() {

        //Arrange
        StudentDTO studentDTO = Utils.getStudentDTO();
        HttpStatus statusExpected = HttpStatus.OK;

        //Act
        ResponseEntity<?> received = studentController.modifyStudent(studentDTO);

        //Assert
        Mockito.verify(iStudentService, Mockito.atLeastOnce()).update(studentDTO);
        HttpStatus statusReceived = received.getStatusCode();
        Assertions.assertNull(received.getBody());
        Assertions.assertEquals(statusExpected, statusReceived);
    }

    @Test
    public void removeStudentHappyPath() {

        //Arrange
        Long id = 1L;
        HttpStatus statusExpected = HttpStatus.OK;

        //Act
        ResponseEntity<?> received = studentController.removeStudent(id);

        //Assert
        Mockito.verify(iStudentService, Mockito.atLeastOnce()).delete(id);
        HttpStatus statusReceived = received.getStatusCode();

        Assertions.assertNull(received.getBody());
        Assertions.assertEquals(statusExpected, statusReceived);
    }


    @Test
    public void listStudentsHappyPath() {

        //Arrange
        StudentDTO studentDTO1 = Utils.getStudentDTO();
        StudentDTO studentDTO2 = Utils.getStudentDTO();
        Set<StudentDTO> list = new HashSet<>();
        list.add(studentDTO1);
        list.add(studentDTO2);

        Mockito.when(iStudentService.getAll()).thenReturn(list);

        //Act
        Set<StudentDTO> received = studentController.listStudents();

        //Assert
        Mockito.verify(iStudentService, Mockito.atLeastOnce()).getAll();
        Assertions.assertEquals(list, received);
    }
}
