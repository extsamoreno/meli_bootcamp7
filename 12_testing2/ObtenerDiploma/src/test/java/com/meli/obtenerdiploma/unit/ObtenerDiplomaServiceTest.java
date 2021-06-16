package com.meli.obtenerdiploma.unit;


import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    @Mock
    IStudentDAO iStudentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    public void testForAnalyzeScoresWithCorrectId(){
        //arrange
        Long id=10L;
        SubjectDTO s1 = new SubjectDTO("Matemática",10.0);
        SubjectDTO s2 = new SubjectDTO("Física",8.0);
        SubjectDTO s3 = new SubjectDTO("Química",4.0);

        List<SubjectDTO> sujects = new ArrayList<>();
        sujects.add(s1);sujects.add(s2);sujects.add(s3);

        StudentDTO expected = new StudentDTO(id,"Pedro", null, null, sujects);
        when(iStudentDAO.findById(id)).thenReturn(expected);
        //act

        StudentDTO received = obtenerDiplomaService.analyzeScores(id);
        // assert
        verify(iStudentDAO, Mockito.atLeastOnce()).findById(id);

        assertEquals((10+8+4)/3.0 ,received.getAverageScore());
        assertEquals("El alumno Pedro ha obtenido un promedio de 7.33. Puedes mejorar.", received.getMessage());
    }

    @Test
    public void testForAnalyzeScoresWithNullStudent(){
        // arrange
        StudentDTO student= null;
        Mockito.when(iStudentDAO.findById(null)).thenReturn(student);
        // act
        // assert
        assertThrows(NullPointerException.class, () -> obtenerDiplomaService.analyzeScores(null));
    }
    @Test
    public void testForAnalyzeScoresWithVoidStudent(){
        // arrange
        StudentDTO student= new StudentDTO();
        Mockito.when(iStudentDAO.findById(student.getId())).thenReturn(student);
        // act
        // assert
        assertThrows(NullPointerException.class, () -> obtenerDiplomaService.analyzeScores(student.getId()));
    }
    @Test
    public void testForAnalyzeScoresWithHigherAverage(){
        //arrange
        Long id=5L;
        SubjectDTO s1 = new SubjectDTO("Matemática",10.0);
        SubjectDTO s2 = new SubjectDTO("Física",9.6);
        SubjectDTO s3 = new SubjectDTO("Química",9.3);

        List<SubjectDTO> sujects = new ArrayList<>();
        sujects.add(s1);sujects.add(s2);sujects.add(s3);

        StudentDTO expected = new StudentDTO(id,"Pedro", null, null, sujects);
        when(iStudentDAO.findById(id)).thenReturn(expected);
        //act

        StudentDTO received = obtenerDiplomaService.analyzeScores(id);
        // assert
        verify(iStudentDAO, Mockito.atLeastOnce()).findById(id);

        assertEquals((10+9.6+9.3)/3.0 ,received.getAverageScore());
        assertEquals("El alumno Pedro ha obtenido un promedio de 9.63. Felicitaciones!", received.getMessage());
    }







}
