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
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTests {

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    public void calculateAverageHappyPath(){
        //arr
        SubjectDTO subject1= new SubjectDTO("mate1",9.5);
        SubjectDTO subject2= new SubjectDTO("mate2",8.0);
        SubjectDTO subject3= new SubjectDTO("mate3",6.5);

        List<SubjectDTO> list= (Arrays.asList(subject1,subject2,subject3));

        double expected= list.stream().mapToDouble(SubjectDTO::getScore).sum()/ list.size();

        StudentDTO studentDTO= new StudentDTO();

        Long id=1L;

        studentDTO.setId(id);
        studentDTO.setStudentName("Test");
        studentDTO.setSubjects(list);


        Mockito.when(studentDAO.findById(id)).thenReturn(studentDTO);

        // act
        StudentDTO received= obtenerDiplomaService.analyzeScores(id);

        //assert
        Mockito.verify(studentDAO,Mockito.atLeastOnce()).findById(id);

        assertEquals(expected,received.getAverageScore());

    }



}
