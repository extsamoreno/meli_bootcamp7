package com.meli.obtenerdiploma.unit;

import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
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
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {
    @Mock
    IObtenerDiplomaService iObtenerDiplomaService;
    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;
    @Test
    public void getAnalyzeScoresTest () {

        //arrange

        StudentDTO expected = new StudentDTO();
        expected.setStudentName("Camilo");
        expected.setMessage("El alumno Camilo ha obtenido un promedio de 10. Felicitaciones!");
        ArrayList<SubjectDTO> arrayList1 = new ArrayList<>();
        arrayList1.add(new SubjectDTO("Matematica",10.0));
        arrayList1.add(new SubjectDTO("Fisica",10.0));
        arrayList1.add(new SubjectDTO("Quimica",10.0));
        expected.setSubjects(arrayList1);
        expected.setAverageScore(10.0);
        when(iObtenerDiplomaService.analyzeScores(1L)).thenReturn(expected);

        //act
        StudentDTO received = obtenerDiplomaController.analyzeScores(1L);

        //assert
        Mockito.verify(iObtenerDiplomaService,Mockito.atLeastOnce()).analyzeScores(1L);
        assertEquals(expected, received);


    }

}
