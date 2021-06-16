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
    public void registerStudent(){
        //arrange

        StudentDTO studentDTO = new StudentDTO(8L, null, null, null, new ArrayList<>() {
            {
                add(new SubjectDTO("Matemática", 9.0));
                add(new SubjectDTO("Física", 7.0));
                add(new SubjectDTO("Química", 6.0));
            }
        });
        Mockito.doNothing().when(iStudentService).create(studentDTO);

        //act
        studentController.registerStudent(studentDTO);

        //assert
        Mockito.verify(iStudentService, Mockito.atLeast(1)).create(studentDTO);

    }

    @Test
    public void getStudent(){
        StudentDTO expected = new StudentDTO(2L, "Pedro", null, null, new ArrayList<>() {
            {
                add(new SubjectDTO("Matemática", 10.0));
                add(new SubjectDTO("Física", 8.0));
                add(new SubjectDTO("Química", 4.0));
            }
        });
        //arrage
        Mockito.when(iStudentService.read(2L)).thenReturn(expected);

        //act
        StudentDTO received = studentController.getStudent(2L);


        //assert
        Mockito.verify(iStudentService, Mockito.atLeast(1)).read(2L);
        Assertions.assertEquals(expected, received);

    }

    @Test
    public void modifyStudent(){

        //arrange

        StudentDTO studentDTO = new StudentDTO(1L, null, null, null, new ArrayList<>() {
            {
                add(new SubjectDTO("Matemática", 9.0));
                add(new SubjectDTO("Física", 7.0));
                add(new SubjectDTO("Química", 6.0));
            }
        });
        Mockito.doNothing().when(iStudentService).update(studentDTO);

        //act
        studentController.modifyStudent(studentDTO);

        //assert
        Mockito.verify(iStudentService, Mockito.atLeast(1)).update(studentDTO);


    }


    @Test
    public void deleteStudent(){

        //arrange
        Long id=1L;

        Mockito.doNothing().when(iStudentService).delete(id);

        //act
        studentController.removeStudent(id);

        //assert
        Mockito.verify(iStudentService, Mockito.atLeast(1)).delete(id);


    }


    @Test
    public void getAllStudent(){

        //arrange
        Set<StudentDTO> expected = new HashSet<>();

        Mockito.when(iStudentService.getAll()).thenReturn(expected);

        //act
        Set<StudentDTO> received= studentController.listStudents();

        //assert
        Mockito.verify(iStudentService, Mockito.atLeast(1)).getAll();
        Assertions.assertEquals(expected,received);


    }

}
