package com.meli.obtenerdiploma.unit;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    public void testDiploma(){

        //arrange
        StudentDTO expected = new StudentDTO(2L, "Pedro", "", null, null);
        SubjectDTO ma1 = new SubjectDTO("", 10.0);
       // SubjectDTO ma2 = new SubjectDTO("Física", 8.0);
       // SubjectDTO ma3 = new SubjectDTO("Química", 4.0);
        List<SubjectDTO> materias2 = new ArrayList<>();
        materias2.add(ma1);
       // materias2.add(ma2);
       // materias2.add(ma3);
        expected.setSubjects(materias2);
        expected.setAverageScore(7.33);

        when(studentDAO.findById(2L).getAverageScore()).thenReturn(expected.getAverageScore());
        System.out.println(expected.getAverageScore());

        //act
        StudentDTO received = obtenerDiplomaService.analyzeScores(2L);
       // System.out.println(expected.getAverageScore());

        //assert
        verify(studentDAO, Mockito.atLeast(1)).findById(2L);
        Assertions.assertEquals(expected.getAverageScore(), received.getAverageScore());

    }

}
