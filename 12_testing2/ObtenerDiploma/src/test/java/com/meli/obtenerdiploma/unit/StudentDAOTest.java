package com.meli.obtenerdiploma.unit;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class StudentDAOTest {

    StudentDAO studentDAO = new StudentDAO();
    StudentRepository studentRepository=new StudentRepository();

    @Test
    public void listAllHappyPath() {
        //arrange
        //act
        Set<StudentDTO> list = studentRepository.findAll();
        //assert
        Assertions.assertEquals(2,list.size());
    }

    @Test
    public void findByIdHappyPath() {
        //arrange
        //act
        StudentDTO student = studentDAO.findById(1L);
        //assert
        Assertions.assertEquals("Juan", student.getStudentName());
    }

    @Test
    public void findByIdNonExistingId() {
        //arrange
        //act
        //assert
        Assertions.assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(99L));
    }

    @Test
    public void existsHappyPath() {
        //arrange
        StudentDTO student = new StudentDTO();
        student.setId(1L);
        //act
        boolean result = studentDAO.exists(student);
        //assert
        Assertions.assertTrue(result);
    }

    @Test
    public void notExistsHappyPath() {
        //arrange
        StudentDTO student = new StudentDTO();
        student.setId(99L);
        //act
        boolean result = studentDAO.exists(student);
        //assert
        Assertions.assertFalse(result);
    }



}
