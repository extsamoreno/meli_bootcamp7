package com.meli.obtenerdiploma.unit.controller;

import com.meli.obtenerdiploma.controller.StudentController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import com.meli.obtenerdiploma.unit.utils.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.apache.commons.collections4.CollectionUtils;
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
        StudentDTO studentDTO = Utils.getStudentDTO();
        Mockito.doNothing().when(iStudentService).create(studentDTO);

        //Act
        ResponseEntity<?> received = studentController.registerStudent(studentDTO);

        //Assert
        Mockito.verify(iStudentService,Mockito.atLeastOnce()).create(studentDTO);
        Assertions.assertEquals(HttpStatus.OK,received.getStatusCode());
    }

    @Test
    public void getStudentHappyPath() {
        //Arrange
        StudentDTO studentDTO = Utils.getStudentDTO();
        Mockito.when(iStudentService.read(studentDTO.getId())).thenReturn(studentDTO);

        //Act
        StudentDTO received = studentController.getStudent(studentDTO.getId());

        //Assert
        Mockito.verify(iStudentService,Mockito.atLeastOnce()).read(studentDTO.getId());
        Assertions.assertEquals(studentDTO,received);
    }

    @Test
    public void modifyStudentHappyPath() {
        //Arrange
        StudentDTO studentDTO = Utils.getStudentDTO();
        Mockito.doNothing().when(iStudentService).update(studentDTO);

        //Act
        ResponseEntity<?> received = studentController.modifyStudent(studentDTO);

        //Assert
        Mockito.verify(iStudentService,Mockito.atLeastOnce()).update(studentDTO);
        Assertions.assertEquals(HttpStatus.OK,received.getStatusCode());
    }

    @Test
    public void removeStudentHappyPath() {
        //Arrange
        Long studentId = 1L;
        Mockito.doNothing().when(iStudentService).delete(studentId);

        //Act
        ResponseEntity<?> received = studentController.removeStudent(studentId);

        //Assert
        Mockito.verify(iStudentService,Mockito.atLeastOnce()).delete(studentId);
        Assertions.assertEquals(HttpStatus.OK,received.getStatusCode());
    }

    @Test
    public void listStudentsHappyPath() {
        //Arrange
        Set<StudentDTO> students = new HashSet<>();
        students.add(new StudentDTO());
        students.add(new StudentDTO());
        Mockito.when(iStudentService.getAll()).thenReturn(students);

        //Act
        Set<StudentDTO> received = studentController.listStudents();

        //Assert
        Mockito.verify(iStudentService,Mockito.atLeastOnce()).getAll();
        Assertions.assertTrue(CollectionUtils.isEqualCollection(students,received));
    }
}
