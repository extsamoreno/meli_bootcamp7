package com.meli.obtenerdiploma.unit.services;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import com.meli.obtenerdiploma.unit.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {
    @Mock
    IStudentDAO iStudentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    public void AlyzeScoresHappyPath(){
        //Arrange

        StudentDTO expected = Utils.getStudentDTO();

        long id = 1;
        Mockito.when(iStudentDAO.findById(id)).thenReturn(expected);

        //Act
        StudentDTO received = obtenerDiplomaService.analyzeScores(id);

        //Assert
        Mockito.verify(iStudentDAO,Mockito.atLeast(1)).findById(id);
        Assertions.assertEquals(expected,received);
    }




}
