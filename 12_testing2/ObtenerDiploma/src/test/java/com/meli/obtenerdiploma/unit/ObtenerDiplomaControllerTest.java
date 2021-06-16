package com.meli.obtenerdiploma.unit;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
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
public class ObtenerDiplomaControllerTest {
    @Mock
    IObtenerDiplomaService iObtenerDiplomaService;
    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    public void analyzeScoresHappyPath(){
        //arrange
        Long id = 1L;
        SubjectDTO s1 = new SubjectDTO("Matemática",10.0);
        SubjectDTO s2 = new SubjectDTO("Física",8.0);
        SubjectDTO s3 = new SubjectDTO("Química",4.0);

        List<SubjectDTO> sujects = new ArrayList<>();
        sujects.add(s1);sujects.add(s2);sujects.add(s3);

        StudentDTO student = new StudentDTO(id,"Pedro", null, null, sujects);
        when(iObtenerDiplomaService.analyzeScores(id)).thenReturn(student);
        //act
        StudentDTO received = iObtenerDiplomaService.analyzeScores(id);
        //assert
        verify(iObtenerDiplomaService, Mockito.atLeastOnce()).analyzeScores(id);
        Assertions.assertEquals(received,student );

    }
}
