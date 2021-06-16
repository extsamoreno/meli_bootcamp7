package com.meli.obtenerdiploma.unit.controller;

import com.meli.obtenerdiploma.controller.StudentController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

    @Mock
    IStudentService iStudentService;

    @InjectMocks
    StudentController studentController;

    @Test
    public void registerStudentHappyPath(){
        //arrange
        ResponseEntity<?> expected = ResponseEntity.ok(null);
        Mockito.doNothing().when(iStudentService).create(new StudentDTO());

        //act
        ResponseEntity<?> received = studentController.registerStudent(new StudentDTO());

        //assert
        Mockito.verify(iStudentService,Mockito.atLeast(1)).create(new StudentDTO());
        Assertions.assertEquals(expected, received);
    }
}
