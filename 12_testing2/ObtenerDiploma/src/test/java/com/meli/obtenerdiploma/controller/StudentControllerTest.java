package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentControllerTest {

    @Mock
    IStudentService studentService;

    @InjectMocks
    StudentController studentController;

    @Test
    public void registerStudent() throws Exception {
        //arange
        StudentDTO studentDTO = new StudentDTO();
        //act
        ResponseEntity<?> response  = studentController.registerStudent(studentDTO);
        //assert
        verify(studentService, atLeastOnce()).create(studentDTO);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void getStudent() throws Exception {
        //arange
        long id = 1;
        StudentDTO studentDTO = new StudentDTO();
        when(studentService.read(id)).thenReturn(studentDTO);
        //act
        StudentDTO response  = studentController.getStudent(id);
        //assert
        verify(studentService, atLeastOnce()).read(id);
        assertEquals(studentDTO, response);
    }

    @Test
    public void getStudentNullId() throws Exception {
        //arange
        Long id = null;
        when(studentService.read(id)).thenReturn(null);
        //act
        StudentDTO response  = studentController.getStudent(id);
        //assert
        assertNull(response);
    }

    @Test
    public void modifyStudent(){
        //arrange
        StudentDTO studentDTO = new StudentDTO();
        //act
        ResponseEntity<?>  response = studentController.modifyStudent(studentDTO);
        //assert
        assertTrue(response.getStatusCode() == HttpStatus.OK);
        verify(studentService, atLeastOnce()).update(studentDTO);
    }

    @Test
    public void removeStudent() {
        //arrange
        Long id = 1L;
        //act
        ResponseEntity<?> response  = studentController.removeStudent(id);
        //assert
        assertTrue(response.getStatusCode() == HttpStatus.OK);
        verify(studentService, atLeastOnce()).delete(id);
    }

    @Test
    public void listStudents() {
        //arrange
        Set<StudentDTO> listStudents= Set.of(new StudentDTO(1L), new StudentDTO());
        when(studentService.getAll()).thenReturn(listStudents);
        //act
        Set<StudentDTO> response = studentController.listStudents();
        //assert
        assertEquals(listStudents,response);
        verify(studentService, atLeastOnce()).getAll();
    }

}