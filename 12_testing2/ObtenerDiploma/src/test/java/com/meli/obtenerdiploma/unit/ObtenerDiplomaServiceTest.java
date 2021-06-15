package com.meli.obtenerdiploma.unit;


import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.service.IStudentService;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
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
    ObtenerDiplomaService ObtenerDiplomaService;

    @Test
    public void analyzeScores(){
        //arrange
        double expectedScore = 5.0;
        Long id = new Long(1);
        SubjectDTO subject1 = new SubjectDTO("Mate", 10.0);
        SubjectDTO subject2 = new SubjectDTO("Musica", 0.0);
        SubjectDTO subject3 = new SubjectDTO("Biologia", 5.0);
        List<SubjectDTO> subjects = new ArrayList<>(Arrays.asList(subject1, subject3, subject2));

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentName("Alex");
        studentDTO.setSubjects(subjects);

        when(iStudentDAO.findById(id)).thenReturn(studentDTO);

        //act

        StudentDTO student = ObtenerDiplomaService.analyzeScores(id);


        //assert
        verify(iStudentDAO,Mockito.atLeast(1)).findById(id);


        assertEquals(student.getAverageScore(), expectedScore);

    }

  /*  @Test
    public  void getProductByIdThrowProductIdNotFoundException() throws ProductIdNotFoundException {
        //arrange
        int id = 1;
        when(iProductRepository.getById(id)).thenReturn(null);

        //assert
        assertThrows(ProductIdNotFoundException.class, () -> productService.getProductById(id));

    }*/


}
