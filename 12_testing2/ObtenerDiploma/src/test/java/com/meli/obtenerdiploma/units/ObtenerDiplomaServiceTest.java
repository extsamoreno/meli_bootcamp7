package com.meli.obtenerdiploma.units;

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

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaServiceTest {

    @Mock
    IStudentDAO iStudentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    /*
    *       EJERCICIO 2
    */

    @Test
    public void analyzeScoresHappyPath(){
        //arrange
        Long id = 1L;
        List<SubjectDTO> subjectList = new ArrayList<>();
        subjectList.add(new SubjectDTO("Matematicas",10D));
        subjectList.add(new SubjectDTO("Literatura",8D));
        StudentDTO student = new StudentDTO(id,"Juan",null,null,subjectList);

        Mockito.when(iStudentDAO.findById(id)).thenReturn(student);

        //act
        StudentDTO expected = obtenerDiplomaService.analyzeScores(id);
        Mockito.verify(iStudentDAO,Mockito.atLeastOnce()).findById(id);

        //assert
        Assertions.assertEquals(expected.getAverageScore(),9.0);
    }
    @Test
    public void analyzeScoresAverageGreaterThanNineShouldReturnCongratulationsMessage(){
        //arrange
        Long id = 1L;
        List<SubjectDTO> subjectList = new ArrayList<>();
        subjectList.add(new SubjectDTO("Matematicas",10D));
        subjectList.add(new SubjectDTO("Literatura",9D));
        StudentDTO student = new StudentDTO(id,"Juan",null,null,subjectList);

        Mockito.when(iStudentDAO.findById(id)).thenReturn(student);

        //act
        StudentDTO expected = obtenerDiplomaService.analyzeScores(id);
        Mockito.verify(iStudentDAO,Mockito.atLeastOnce()).findById(id);

        //assert
        Assertions.assertEquals("El alumno " + student.getStudentName() + " ha obtenido un promedio de " + expected.getAverageScore() + ". Felicitaciones!",expected.getMessage());
    }
    @Test
    public void analyzeScoresAverageGreaterThanNineShouldReturnStandardMessage(){
        //arrange
        Long id = 1L;
        List<SubjectDTO> subjectList = new ArrayList<>();
        subjectList.add(new SubjectDTO("Matematicas",7D));
        subjectList.add(new SubjectDTO("Literatura",8D));
        StudentDTO student = new StudentDTO(id,"Juan",null,null,subjectList);

        Mockito.when(iStudentDAO.findById(id)).thenReturn(student);

        //act
        StudentDTO expected = obtenerDiplomaService.analyzeScores(id);
        Mockito.verify(iStudentDAO,Mockito.atLeastOnce()).findById(id);

        //assert
        Assertions.assertEquals("El alumno " + student.getStudentName() + " ha obtenido un promedio de " + expected.getAverageScore() + ". Puedes mejorar.", expected.getMessage());
    }

    @Test
    public void analyzeScoresNoSubjectsShouldReturnStandardMessage(){
        //arrange
        Long id = 1L;
        List<SubjectDTO> subjectList = new ArrayList<>();
        subjectList.add(new SubjectDTO("Matematicas",7D));
        subjectList.add(new SubjectDTO("Literatura",8D));
        StudentDTO student = new StudentDTO(id,"Juan",null,null,subjectList);

        Mockito.when(iStudentDAO.findById(id)).thenReturn(student);

        //act
        StudentDTO expected = obtenerDiplomaService.analyzeScores(id);
        Mockito.verify(iStudentDAO,Mockito.atLeastOnce()).findById(id);

        //assert
        Assertions.assertEquals("El alumno " + student.getStudentName() + " ha obtenido un promedio de " + expected.getAverageScore() + ". Puedes mejorar.", expected.getMessage());
    }



}