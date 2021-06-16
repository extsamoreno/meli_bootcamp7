package com.meli.obtenerdiploma.unit.controller;

import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {

    @Mock
    private IObtenerDiplomaService service;

    @InjectMocks
    private ObtenerDiplomaController controller;

    @Test
    public void testAnalyzeScores(){
        //Arrange
        Long studentId = 1L;
        StudentDTO studentExpected = new StudentDTO(1L,"Santiago Garcia", "", 8.33,
                Arrays.asList(new SubjectDTO("Fisica", 5.0), new SubjectDTO("Matematica", 8.0), new SubjectDTO("Lengua", 10.0)));

        when(service.analyzeScores(studentId)).thenReturn(studentExpected);

        //Act
        StudentDTO studentReceived = controller.analyzeScores(studentId);

        //Assert
        verify(service, atLeastOnce()).analyzeScores(studentId);
        assertEquals(studentExpected, studentReceived);
    }

}
