package com.meli.obtenerdiploma.unit.controller;

import com.meli.obtenerdiploma.controller.StudentController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {
    @Mock
    IStudentService studentService;

    @InjectMocks
    StudentController studentController;

    @Test
    public void registerStudentHappyPath(){
        //arrange
        Long studentId = 1L;
        StudentDTO stu = new StudentDTO(studentId,"Juan","message",7.33,new ArrayList<>());

        //Mockito.when(studentService.create(stu)).thenReturn(void);

        //act
        studentController.registerStudent(stu);

        //assert
        Mockito.verify(studentService, Mockito.atLeastOnce()).create(stu);
    }

    @Test
    public void getStudentHappyPath(){
        //arrange
        Long id = 1L;
        StudentDTO expected = new StudentDTO(id,"Juan","message",7.33,new ArrayList<>());
        Mockito.when(studentService.read(id)).thenReturn(expected);

        //act
        StudentDTO recive = studentController.getStudent(id);

        //assert
        Mockito.verify(studentService, Mockito.atLeastOnce()).read(id);
        Assertions.assertEquals(expected,recive);
    }

    @Test
    public void modifyStudentHappyPath(){
        //arrange
        Long id = 1L;
        StudentDTO stu = new StudentDTO(id,"Juan","message",7.33,new ArrayList<>());
        //Mockito.when(studentService.update(stu)).thenReturn(stu);

        //act
        studentController.modifyStudent(stu);

        //assert
        Mockito.verify(studentService, Mockito.atLeastOnce()).update(stu);
    }

    @Test
    public void removeStudentHappyPath(){
        //arrange
        Long id = 1L;

        //act
        studentController.removeStudent(id);

        //assert
        Mockito.verify(studentService,Mockito.atLeastOnce()).delete(id);
    }

    @Test
    public void listStudentsHappyPath(){
        //arrange
        StudentDTO student1 = new StudentDTO(1L,"Juan","message",7.33,new ArrayList<>());
        StudentDTO student2 = new StudentDTO(2L,"Pedro","message",6.78,new ArrayList<>());

        Set<StudentDTO> expected = new HashSet<>();
        expected.add(student1);
        expected.add(student2);
        
        Mockito.when(studentService.getAll()).thenReturn(expected);

        //act
        Set<StudentDTO> recived = studentController.listStudents();

        //assert
        Mockito.verify(studentService, Mockito.atLeastOnce()).getAll();
        Assertions.assertEquals(expected,recived);
    }
}
