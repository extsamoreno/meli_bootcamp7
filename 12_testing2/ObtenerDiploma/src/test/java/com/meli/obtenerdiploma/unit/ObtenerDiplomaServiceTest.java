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
    public void getanAlyzeScores () {
        //arrange
        long id = 1L;
        StudentDTO expected = new StudentDTO();
        expected.setStudentName("Camilo");
        expected.setMessage("El alumno Camilo ha obtenido un promedio de 6. Puedes mejorar.");
        ArrayList<SubjectDTO> arrayList1 = new ArrayList<>();
        arrayList1.add(new SubjectDTO("Matematica",5.0));
        arrayList1.add(new SubjectDTO("Fisica",7.0));
        arrayList1.add(new SubjectDTO("Quimica",6.0));
        expected.setSubjects(arrayList1);
        when(iStudentDAO.findById(id)).thenReturn(expected);
        expected.setAverageScore(6.0);
        //act
        StudentDTO received = obtenerDiplomaService.analyzeScores(id);
        //assert
        verify(iStudentDAO, Mockito.atLeast(1)).findById(id);
        // verify(productMapper, Mockito.atLeastOnce()).toDTO(product);
        assertEquals(expected, received);
        /*Acá se puede testear la funciones de calcular el promedio y el mensaje, en este caso mensaje normal. ¿Es valido así o tengo
        que igual hacer un test unitario por cada método?*/
    }
    @Test
    public void getAnalyzeScoreNullCase () {
        //arrange
        StudentDTO studentDTO = null;
        when(iStudentDAO.findById(null)).thenReturn(studentDTO);
        //assert
        assertThrows(NullPointerException.class,()->obtenerDiplomaService.analyzeScores(null));
    }
    @Test
    public void getAnalyzeScoreEmptyCase () {
        //arrange
        StudentDTO studentDTO = new StudentDTO();
        when(iStudentDAO.findById(studentDTO.getId())).thenReturn(studentDTO);
        //assert
        assertThrows(NullPointerException.class,()->obtenerDiplomaService.analyzeScores(studentDTO.getId()));
    }
    @Test
    public void getAnalyzeScoreWithHonors () {
        //arrange
        long id = 1L;
        StudentDTO expected = new StudentDTO();
        expected.setStudentName("Camilo");
        expected.setMessage("El alumno Camilo ha obtenido un promedio de 10. Felicitaciones!");
        ArrayList<SubjectDTO> arrayList1 = new ArrayList<>();
        arrayList1.add(new SubjectDTO("Matematica",10.0));
        arrayList1.add(new SubjectDTO("Fisica",10.0));
        arrayList1.add(new SubjectDTO("Quimica",10.0));
        expected.setSubjects(arrayList1);
        when(iStudentDAO.findById(id)).thenReturn(expected);
        expected.setAverageScore(10.0);
        //act
        StudentDTO received = obtenerDiplomaService.analyzeScores(id);
        //assert
        verify(iStudentDAO, Mockito.atLeast(1)).findById(id);
        // verify(productMapper, Mockito.atLeastOnce()).toDTO(product);
        assertEquals(expected, received);

    }

}
