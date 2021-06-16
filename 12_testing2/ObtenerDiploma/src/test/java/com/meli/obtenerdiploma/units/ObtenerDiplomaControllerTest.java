package com.meli.obtenerdiploma.units;

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

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {

    @Mock
    IObtenerDiplomaService iObtenerDiplomaService;

    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;

    @Test
    public void obtenerDiplomaHappyPath(){
        //arrange
        long id = 1L;
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Matematicas" , 10D));
        subjectDTOList.add(new SubjectDTO("Fisica" , 10D));

        StudentDTO studentDTOReturn = new StudentDTO(id, "Pedro","",10D, subjectDTOList);
        when(iObtenerDiplomaService.analyzeScores(id)).thenReturn(studentDTOReturn);

        //act
        StudentDTO receive = obtenerDiplomaController.analyzeScores(id);

        //assert
        Mockito.verify(iObtenerDiplomaService, Mockito.atLeastOnce()).analyzeScores(id);
        assertEquals(receive, studentDTOReturn);
    }
}
