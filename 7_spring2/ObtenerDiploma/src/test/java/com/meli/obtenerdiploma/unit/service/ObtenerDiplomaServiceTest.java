package com.meli.obtenerdiploma.unit.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.DecimalFormat;
import java.util.ArrayList;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    @Mock
    private IStudentDAO iStudentDAO;

    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;

    @Test
    public void calculateAverageTestHappyPath(){
        //Arrange
        Long studentId = 1L;
        SubjectDTO subjectOne = new SubjectDTO("Matemática", 10d);
        SubjectDTO subjectTwo = new SubjectDTO("Física", 10d);
        SubjectDTO subjectThree = new SubjectDTO("Química", 10d);

        ArrayList<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(subjectOne);
        subjectDTOList.add(subjectTwo);
        subjectDTOList.add(subjectThree);


        StudentDTO student = new StudentDTO(studentId,"Juan","Asd",10d,subjectDTOList);
        when(iStudentDAO.findById(studentId)).thenReturn(student);

        //Act
        StudentDTO received = obtenerDiplomaService.analyzeScores(studentId);


        //Assert
        verify(iStudentDAO,Mockito.atLeast(1)).findById(studentId);
        Assertions.assertEquals(student.getAverageScore(),received.getAverageScore());

    }
    @Test
    public void messageAverageTestHappyPath(){
        //Arrange
        Long studentId = 1L;
        SubjectDTO subjectOne = new SubjectDTO("Matemática", 10d);
        SubjectDTO subjectTwo = new SubjectDTO("Física", 10d);
        SubjectDTO subjectThree = new SubjectDTO("Química", 10d);

        ArrayList<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(subjectOne);
        subjectDTOList.add(subjectTwo);
        subjectDTOList.add(subjectThree);

        StudentDTO student = new StudentDTO(studentId,"Juan","Asd",10d,subjectDTOList);
        when(iStudentDAO.findById(studentId)).thenReturn(student);

        //Act
        StudentDTO received = obtenerDiplomaService.analyzeScores(studentId);


        //Assert
        verify(iStudentDAO,Mockito.atLeast(1)).findById(studentId);
        Assertions.assertEquals("El alumno " + student.getStudentName() + " ha obtenido un promedio de " + new DecimalFormat("#.##").format(student.getAverageScore())
                + ((student.getAverageScore() > 9) ? ". Felicitaciones!" : ". Puedes mejorar."), received.getMessage());
    }

    @Test
    public void emptyStudentTestHappyPath(){
        //Arrange
        Long studentId = 1L;
        Mockito.when(iStudentDAO.findById(studentId)).thenReturn(new StudentDTO());

        //Act

        //Assert
        Assertions.assertThrows(NullPointerException.class, () -> obtenerDiplomaService.analyzeScores(studentId));
        Mockito.verify(iStudentDAO, Mockito.atLeast(1)).findById(studentId);
    }


}




















/*
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {
    @Mock
    IStudentDAO iStudentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    public void analyzeScoresTestHappyPath(){
        //Arrange
        SubjectDTO subjectOne = new SubjectDTO("Matemática", 10d);
        SubjectDTO subjectTwo = new SubjectDTO("Física", 10d);
        SubjectDTO subjectThree = new SubjectDTO("Química", 10d);

        List<SubjectDTO> listSubjects = new ArrayList<>();
        listSubjects.add(subjectOne);
        listSubjects.add(subjectTwo);
        listSubjects.add(subjectThree);

        StudentDTO student = new StudentDTO(1L,"Juan","Asd",10d,listSubjects);

        Mockito.when(iStudentDAO.findById(1L)).thenReturn(student);

        //Act
        StudentDTO result = obtenerDiplomaService.analyzeScores(1L);

        //Assert
        Assertions.assertEquals(result, student);
        Assertions.assertEquals(result.getAverageScore(), student.getAverageScore());
        Assertions.assertEquals("El alumno " + student.getStudentName() + " ha obtenido un promedio de " + new DecimalFormat("#.##").format(student.getAverageScore())
                + ((student.getAverageScore() > 9) ? ". Felicitaciones!" : ". Puedes mejorar."), result.getMessage());

    }

    @Test
    public void analyzeScoresTestNull(){
        //Arrange
        Mockito.when(iStudentDAO.findById(1L)).thenReturn(null);

        //Asserts
        Assertions.assertThrows(NullPointerException.class,() -> obtenerDiplomaService.analyzeScores(1L));
    }
}*/
