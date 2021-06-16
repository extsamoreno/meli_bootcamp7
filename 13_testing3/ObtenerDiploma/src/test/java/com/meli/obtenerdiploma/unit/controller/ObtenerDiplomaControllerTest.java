package com.meli.obtenerdiploma.unit.controller;

import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {

    @Mock
    IObtenerDiplomaService iObtenerDiplomaService;

    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;

    @Test
    public void analyzeScoresHappyPath() {
        //Arrange
        Long studentId = 1L;
        SubjectDTO subjectOne = new SubjectDTO("Matemática", 10d);
        SubjectDTO subjectTwo = new SubjectDTO("Física", 10d);
        SubjectDTO subjectThree = new SubjectDTO("Química", 10d);

        ArrayList<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(subjectOne);
        subjectDTOList.add(subjectTwo);
        subjectDTOList.add(subjectThree);

        StudentDTO studentDTO = new StudentDTO(studentId,"Juan","Asd",10d,subjectDTOList);

        Mockito.when(iObtenerDiplomaService.analyzeScores(1L)).thenReturn(studentDTO);

        //Act
        StudentDTO received = obtenerDiplomaController.analyzeScores(studentId);

        //Assert
        Mockito.verify(iObtenerDiplomaService,Mockito.atLeastOnce()).analyzeScores(studentId);

    }

}
