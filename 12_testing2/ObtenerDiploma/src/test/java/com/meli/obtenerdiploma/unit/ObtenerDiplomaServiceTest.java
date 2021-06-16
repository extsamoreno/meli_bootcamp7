package com.meli.obtenerdiploma.unit;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    public void calculateAverageHappyPath() {
        //ar
        Long id = 1L;
        double expected = 10L;
        StudentDTO studentDTO = Utils.getStudentDTOWithAverage(expected);
        studentDTO.setId(id);
        Mockito.when(studentDAO.findById(id)).thenReturn(studentDTO);
        //act
        StudentDTO received = obtenerDiplomaService.analyzeScores(id);
        //assert
        Mockito.verify(studentDAO, Mockito.atLeastOnce()).findById(id);
        assertEquals(expected, received.getAverageScore());
        assertNotEquals(8L,received.getAverageScore());
    }

    @Test
    public void emptyStudentPath() {
        //arr
        Long id = 1L;
        Mockito.when(studentDAO.findById(id)).thenReturn(new StudentDTO());
        //act
        //assert
        assertThrows(NullPointerException.class, ()->obtenerDiplomaService.analyzeScores(id));
        Mockito.verify(studentDAO, Mockito.atLeastOnce()).findById(id);
    }

    @Test
    public void sameEntryDataAndOutputData() {
        //arr
        StudentDTO studentDTO = Utils.getStudentDTO();
        Long id = 101L;
        studentDTO.setId(id);
        Mockito.when(studentDAO.findById(id)).thenReturn(studentDTO);
        // act
        StudentDTO received = obtenerDiplomaService.analyzeScores(id);
        //assert
        Mockito.verify(studentDAO, Mockito.atLeastOnce()).findById(id);
//        assertEquals(studentDTO.getStudentName(), received.getStudentName());
//        assertEquals(studentDTO.getSubjects(), received.getSubjects());
        assertEquals(studentDTO, received);

        // LA ENTRADA NO TIENE AVERAGE NI MESSAGE
        // LA SALIDA SI, PERO MODIFICA EL OBEJTO DE ENTRADA
    }
}
