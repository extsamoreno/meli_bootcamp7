package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
import com.meli.obtenerdiploma.exception.ObtenerDiplomaException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.Arrays;


@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTests {
    @Mock
    private IObtenerDiplomaService diplomaService;

    @InjectMocks
    ObtenerDiplomaController diplomaController;

    @Test
    public void analyzeScoresOkTest() {
        long expectedId = 1L;
        var expectedSubjects = Arrays.asList(new SubjectDTO("A", 10D));
        var expected = new StudentDTO(1L, "Edu", "Congrats", 10D, expectedSubjects);

        Mockito.when(diplomaService.analyzeScores(expectedId)).thenReturn(expected);

        var received = diplomaController.analyzeScores(expectedId);

        Assertions.assertEquals(expected, received);
    }

    @Test
    public void analyzeScoresNullTest() {
        long expectedId = 1L;

        Mockito.when(diplomaService.analyzeScores(expectedId)).thenReturn(null);

        var received = diplomaController.analyzeScores(expectedId);

        Assertions.assertNull(received);
    }

    @Test
    public void analyzeScoresErrorTest() {
        long expectedId = 1L;

        Mockito.when(diplomaService.analyzeScores(expectedId)).thenThrow(new ObtenerDiplomaException("", HttpStatus.BAD_REQUEST));

        Assertions.assertThrows(ObtenerDiplomaException.class, () ->
                diplomaController.analyzeScores(expectedId));
    }
}
