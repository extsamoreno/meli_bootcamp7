package com.meli.obtenerdiploma.units;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaServiceTest {

    @Mock
    IStudentDAO iStudentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    public void analyzeScoresHappyPath(){
        //arrange (declaracion de variables)
        Long studentId = 1L;
        Double studentDTOAverageExpected = 7.5D;

        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Matematicas" , 10D));
        subjectDTOList.add(new SubjectDTO("Fisica" , 5D));

        StudentDTO studentDTOReturn = new StudentDTO(studentId, "Pedro",null,studentDTOAverageExpected, subjectDTOList);
        when(iStudentDAO.findById(studentId)).thenReturn(studentDTOReturn);

        //act (pasarle las variables)
        StudentDTO studentDTOReceived = obtenerDiplomaService.analyzeScores(studentId);

        //assert
        verify(iStudentDAO, Mockito.atLeast(1)).findById(studentId);
        assertEquals(studentDTOAverageExpected, studentDTOReceived.getAverageScore());

    }

    @Test
    public void msgForLowerNote(){

        Long studentId = 1L;
        Double studentDTOAverageExpected = 7.5D;
        String studentName = "Pedro";
        String msg = "El alumno " + studentName + " ha obtenido un promedio de " + "7.5" + ". Puedes mejorar.";

        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Matematicas" , 10D));
        subjectDTOList.add(new SubjectDTO("Fisica" , 5D));

        StudentDTO studentDTOreturn = new StudentDTO(studentId, "Pedro", msg,studentDTOAverageExpected, subjectDTOList);
        when(iStudentDAO.findById(studentId)).thenReturn(studentDTOreturn);

        //act
        StudentDTO studentDTOreceived = obtenerDiplomaService.analyzeScores(1L);

        assertEquals(msg, studentDTOreceived.getMessage());
    }

    @Test
    public void msgForHigherNote(){
        Long studentId = 1L;
        Double studentDTOAverageExpected = 10D;
        String studentName = "Pedro";
        String msg = "El alumno " + studentName + " ha obtenido un promedio de " + "10" + ". Felicitaciones!";

        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Matematicas" , 10D));
        subjectDTOList.add(new SubjectDTO("Fisica" , 10D));

        StudentDTO studentDTOreturn = new StudentDTO(studentId, "Pedro", msg,studentDTOAverageExpected, subjectDTOList);
        when(iStudentDAO.findById(studentId)).thenReturn(studentDTOreturn);

        //act
        StudentDTO studentDTOreceived = obtenerDiplomaService.analyzeScores(1L);

        assertEquals(msg, studentDTOreceived.getMessage());
    }

    @Test
    public void AnalizeSubjectAverage(){
        //arrange
        Long studentId = 1L;
        Double expected = 7.5;
        List<SubjectDTO> subjectDTOList = new ArrayList<>();

        subjectDTOList.add(new SubjectDTO("Matematicas" , 10D));
        subjectDTOList.add(new SubjectDTO("Fisica" , 5D));
        StudentDTO studentDTO = new StudentDTO(studentId, "","",10D,subjectDTOList);

        when(iStudentDAO.findById(studentId)).thenReturn(studentDTO);

        //act
        Double received = obtenerDiplomaService.analyzeScores(studentId).getAverageScore();

        //assert
        Assertions.assertEquals(expected, received);
    }

}