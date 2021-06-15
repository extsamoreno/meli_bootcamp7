package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @Mock
    IStudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    @Test
    public void createHappyPath() throws Exception {
        //arrange
        StudentDTO student = new StudentDTO(1L);
        //act
        studentService.create(student);
        //assert
        verify(studentDAO, atLeastOnce()).save(student);
    }
    @Test
    public void createNullId(){
        //arrange
        StudentDTO student = new StudentDTO();
        //assert
        assertThrows(StudentNotFoundException.class, ()-> studentService.create(student));
    }

    @Test
    public void readHappyPath() {
        //arrange
        Long id = 1L;
        StudentDTO studentDTO = new StudentDTO();
        when(studentDAO.findById(id)).thenReturn(studentDTO);

        //act
        StudentDTO response = studentService.read(id);

        //assert
        verify(studentDAO, atLeast(1)).findById(id);
        assertEquals(studentDTO, response);
    }

    @Test
    public void readNull() {
        //arrange
        Long id = null;
        //assert
        assertThrows(StudentNotFoundException.class, ()-> studentService.read(id));
    }


    @Test
    public void updateHappyPath() {
        //arrange
        StudentDTO student = new StudentDTO(1L);
        //act
        studentService.update(student);
        //assert
        verify(studentDAO, atLeastOnce()).save(student);
    }

    @Test
    public void updateNullId(){
        //arrange
        StudentDTO student = new StudentDTO();
        //assert
        assertThrows(StudentNotFoundException.class, ()-> studentService.update(student));
    }

    @Test
    public void deletePathHappy() {
        //arrange
        Long id = 1L;
        //act
        studentService.delete(id);
        //assert
        verify(studentDAO, atLeastOnce()).delete(id);
    }

    @Test
    public void deleteNullId() {
        //arrange
        Long id = null;
        //assert
        assertThrows(StudentNotFoundException.class, ()-> studentService.delete(id));
    }

    @Test
    public void getAllHappyPath() {
        //Arrange
        Set<StudentDTO> expected = Set.of(new StudentDTO(), new StudentDTO(1L));
        when(studentRepository.findAll()).thenReturn(expected);
        //act
        Set<StudentDTO> studestResponse = studentService.getAll();
        //Assert
        assertTrue(!studestResponse.isEmpty());
    }


    @Test
    public void getAllNullResponse() {
        //Arrange
        when(studentRepository.findAll()).thenReturn(null);
        //act
        Set<StudentDTO> studestResponse = studentService.getAll();
        //Assert
        assertTrue(studestResponse == null);
    }


}