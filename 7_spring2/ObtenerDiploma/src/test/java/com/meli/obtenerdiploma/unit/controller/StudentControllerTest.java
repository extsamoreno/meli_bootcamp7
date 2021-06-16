package com.meli.obtenerdiploma.unit.controller;

import com.meli.obtenerdiploma.controller.StudentController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

    @Mock
    IStudentService iStudentService;

    @InjectMocks
    StudentController studentController;

    @Test
    public void registerStudentHappyPath() {
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
        Mockito.doNothing().when(iStudentService).create(studentDTO);

        //Act
        ResponseEntity<?> received = studentController.registerStudent(studentDTO);

        //Assert
        Mockito.verify(iStudentService,Mockito.atLeastOnce()).create(studentDTO);
        Assertions.assertEquals(HttpStatus.OK,received.getStatusCode());
    }

    @Test
    public void getStudentHappyPath() {
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
        Mockito.when(iStudentService.read(studentId)).thenReturn(studentDTO);

        //Act
        StudentDTO received = studentController.getStudent(studentId);

        //Assert
        Mockito.verify(iStudentService,Mockito.atLeastOnce()).read(studentId);
        Assertions.assertEquals(studentDTO,received);
    }

    @Test
    public void modifyStudentHappyPath() {
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
        Mockito.doNothing().when(iStudentService).update(studentDTO);

        //Act
        ResponseEntity<?> received = studentController.modifyStudent(studentDTO);

        //Assert
        Mockito.verify(iStudentService,Mockito.atLeastOnce()).update(studentDTO);
        Assertions.assertEquals(HttpStatus.OK,received.getStatusCode());
    }
    @Test
    public void removeStudentHappyPath() {
        //Arrange
        Long studentId = 1L;
        Mockito.doNothing().when(iStudentService).delete(studentId);

        //Act
        ResponseEntity<?> received = studentController.removeStudent(studentId);

        //Assert
        Mockito.verify(iStudentService,Mockito.atLeastOnce()).delete(studentId);
        Assertions.assertEquals(HttpStatus.OK,received.getStatusCode());
    }

    @Test
    public void listStudentsHappyPath() {
        //Arrange
        Set<StudentDTO> students = new HashSet<>();
        students.add(new StudentDTO());
        students.add(new StudentDTO());
        Mockito.when(iStudentService.getAll()).thenReturn(students);

        //Act
        Set<StudentDTO> received = studentController.listStudents();

        //Assert
        Mockito.verify(iStudentService,Mockito.atLeastOnce()).getAll();
        Assertions.assertEquals(students,received);
    }
}
