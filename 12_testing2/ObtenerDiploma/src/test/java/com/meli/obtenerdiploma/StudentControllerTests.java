package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.controller.StudentController;
import com.meli.obtenerdiploma.exception.ObtenerDiplomaException;
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

@ExtendWith(MockitoExtension.class)
public class StudentControllerTests {
    @Mock
    private IStudentService studentService;

    @InjectMocks
    private StudentController studentController;

    @Test
    public void registerStudentOkTest() {
        var expected = new StudentDTO();

        Mockito.doNothing().when(studentService).create(expected);

        var received = studentController.registerStudent(expected);

        Mockito.verify(studentService, Mockito.atLeastOnce()).create(expected);
        Assertions.assertEquals(HttpStatus.OK, received.getStatusCode());
    }
}
