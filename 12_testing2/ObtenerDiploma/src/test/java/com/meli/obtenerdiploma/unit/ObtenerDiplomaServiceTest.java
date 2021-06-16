package com.meli.obtenerdiploma.unit;


import com.meli.obtenerdiploma.exception.StudentNotFoundException;
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
    public void getGreetingMessageTest(){
        //arrange
        String expectedMessage = "El alumno Alex ha obtenido un promedio de 5. Puedes mejorar.";

        Long id = 1L;
        SubjectDTO subject1 = new SubjectDTO("Mate", 10.0);
        SubjectDTO subject2 = new SubjectDTO("Musica", 0.0);
        SubjectDTO subject3 = new SubjectDTO("Biologia", 5.0);
        List<SubjectDTO> subjects = new ArrayList<>(Arrays.asList(subject1, subject3, subject2));

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentName("Alex");
        studentDTO.setSubjects(subjects);
        studentDTO.setId(id);

        when(iStudentDAO.findById(id)).thenReturn(studentDTO);

        //act

        StudentDTO student = ObtenerDiplomaService.analyzeScores(id);


        //assert
        verify(iStudentDAO,Mockito.atLeast(1)).findById(id);


        assertEquals(student.getMessage(), expectedMessage);

    }
    @Test
    public void getGreetingCongratulationMessageTest(){
        //arrange
        String expectedMessage = "El alumno Alex ha obtenido un promedio de 9.67. Felicitaciones!";

        Long id = 1L;
        SubjectDTO subject1 = new SubjectDTO("Mate", 10.0);
        SubjectDTO subject2 = new SubjectDTO("Musica", 10.0);
        SubjectDTO subject3 = new SubjectDTO("Biologia", 9.0);
        List<SubjectDTO> subjects = new ArrayList<>(Arrays.asList(subject1, subject3, subject2));

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentName("Alex");
        studentDTO.setSubjects(subjects);
        studentDTO.setId(id);

        when(iStudentDAO.findById(id)).thenReturn(studentDTO);

        //act

        StudentDTO student = ObtenerDiplomaService.analyzeScores(id);


        //assert
        verify(iStudentDAO,Mockito.atLeast(1)).findById(id);


        assertEquals(student.getMessage(), expectedMessage);

    }
    @Test
    public void calculateAverageThrowNullPointerException(){
        //arrange
        double expectedScore = 50.0;
        Long id = new Long(1);
        SubjectDTO subject1 = new SubjectDTO("Mate", 100.0);
        SubjectDTO subject2 = new SubjectDTO();
        SubjectDTO subject3 = new SubjectDTO();
        List<SubjectDTO> subjects = new ArrayList<>(Arrays.asList(subject1, subject3, subject2));

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentName("Alex");
        studentDTO.setSubjects(subjects);

        when(iStudentDAO.findById(id)).thenReturn(studentDTO);

        //act

     //   StudentDTO student = ObtenerDiplomaService.analyzeScores(id);


        //assert
       // verify(iStudentDAO,Mockito.atLeast(1)).findById(id);

        assertThrows(NullPointerException.class, () -> ObtenerDiplomaService.analyzeScores(id));


    }
    @Test
    public void calculateAverageTest(){
        //arrange
        double expectedScore = 50.0;
        Long id = new Long(1);
        SubjectDTO subject1 = new SubjectDTO("Mate", 100.0);
        SubjectDTO subject2 = new SubjectDTO("Musica", 0.0);
        SubjectDTO subject3 = new SubjectDTO("Biologia", 50.0);
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

  @Test
    public  void findByIdThrowProductIdNotFoundExceptionTest() throws StudentNotFoundException {
        //arrange
        Long id = new Long(1);
        when(iStudentDAO.findById(id)).thenThrow(new StudentNotFoundException(id));

        //assert
        assertThrows(StudentNotFoundException.class, () -> iStudentDAO.findById(id));

    }


}
