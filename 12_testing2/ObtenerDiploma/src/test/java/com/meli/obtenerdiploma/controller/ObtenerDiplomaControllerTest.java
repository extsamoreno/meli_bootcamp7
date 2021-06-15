package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {

    @Mock
    IObtenerDiplomaService obtenerDiplomaService;

    @InjectMocks
    ObtenerDiplomaController controller;

    @Test
    public void analyzeScoresTest() {
        List<SubjectDTO> subjectDTOS = new ArrayList<>();
        SubjectDTO subject = new SubjectDTO("Matematica", 10.0);
        subjectDTOS.add(subject);
        StudentDTO studentDTO = new StudentDTO(1L, "Pepe", "Pepito", 10.0, subjectDTOS);
        when(obtenerDiplomaService.analyzeScores(1L)).thenReturn(studentDTO);
        assertEquals(controller.analyzeScores(1L), studentDTO);
    }


}
