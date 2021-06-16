package com.meli.obtenerdiploma.unit.point5;

import com.meli.obtenerdiploma.controller.StudentController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import com.meli.obtenerdiploma.unit.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

    @Mock
    IStudentService studentService;

    @InjectMocks
    StudentController studentController;

    @Test
    public void registerStudentHappyPath() {
        //arr
        StudentDTO studentDTO = Utils.getStudentDTO();
        // act
        ResponseEntity<?> received = studentController.registerStudent(studentDTO);
        //assert
        Mockito.verify(studentService, Mockito.atLeastOnce()).create(studentDTO);
        Assertions.assertNull(received.getBody());
        Assertions.assertEquals(200, received.getStatusCodeValue());
    }

    @Test
    public void getStudentHappyPath() {
        //arr
        StudentDTO studentDTO = Utils.getStudentDTO();
        Long id = 99L;
        Mockito.when(studentService.read(id)).thenReturn(studentDTO);
        // act
        StudentDTO received = studentController.getStudent(id);
        //assert
        Mockito.verify(studentService, Mockito.atLeastOnce()).read(id);
        assertEquals(studentDTO, received);
    }

    @Test
    public void modifyStudentHappyPath() {
        //arr
        StudentDTO studentDTO = Utils.getStudentDTO();
        // act
        ResponseEntity<?> received = studentController.modifyStudent(studentDTO);
        //assert
        Mockito.verify(studentService, Mockito.atLeastOnce()).update(studentDTO);
        Assertions.assertNull(received.getBody());
        Assertions.assertEquals(200, received.getStatusCodeValue());
    }

    @Test
    public void removeStudentHappyPath() {
        //arr
        Long id = 2L;
        // act
        ResponseEntity<?> received = studentController.removeStudent(id);
        //assert
        Mockito.verify(studentService, Mockito.atLeastOnce()).delete(id);
        Assertions.assertNull(received.getBody());
        Assertions.assertEquals(200, received.getStatusCodeValue());
    }


    @Test
    public void listStudentsHappyPath() {
        //arr
        StudentDTO studentDTO1 = Utils.getStudentDTO();
        StudentDTO studentDTO2 = Utils.getStudentDTO();
        Set<StudentDTO> list = new HashSet<>();
        list.add(studentDTO1);
        list.add(studentDTO2);

        Mockito.when(studentService.getAll()).thenReturn(list);
        // act
        Set<StudentDTO> received = studentController.listStudents();
        //assert
        Mockito.verify(studentService, Mockito.atLeastOnce()).getAll();
        assertEquals(list, received);
    }


}
