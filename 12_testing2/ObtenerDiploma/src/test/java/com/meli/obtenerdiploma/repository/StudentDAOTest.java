package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StudentDAOTest {

    @Test
    void save() {
        //arrange
        var studentDAO = new StudentDAO();
        var subjects = new ArrayList<SubjectDTO>(){{
            add(new SubjectDTO());
        }};
        var student = new StudentDTO(184L,"pepe","message",5.0,subjects);
        //act
        studentDAO.save(student);
        //assert
        assertTrue(studentDAO.exists(student));
    }

    @Test
    void deleteTest() {
        var studentDAO = new StudentDAO();

        var result = studentDAO.delete(1L);

        assertTrue(result);
        assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(1L));
    }

    @Test
    void deleteNotFoundTest() {
        var studentDAO = new StudentDAO();

        var result = studentDAO.delete(123L);

        assertFalse(result);
    }

    @Test
    void notExistsTest() {
        //arrange
        var studentDAO = new StudentDAO();
        var subjects = new ArrayList<SubjectDTO>(){{
                add(new SubjectDTO());
        }};
        var student = new StudentDTO(18L,"pepe","message",5.0,subjects);
        //act
        var result = studentDAO.exists(student);
        //assert
        assertFalse(result);
    }

    @Test
    void existsTest() {
        //arrange
        var studentDAO = new StudentDAO();
        var student = new StudentDTO(1L,"pepe","message",5.0,null);
        //act
        var result = studentDAO.exists(student);
        //assert
        assertTrue(result);
    }

    @Test
    void findByIdTest() {
        //arrange
        var studentDAO = new StudentDAO();
        //act
        var result = studentDAO.findById(1L);
        //assert
        assertEquals(result.getId(), 1);
    }

    @Test
    void findByIdFailsTest() {
        //arrange
        var studentDAO = new StudentDAO();
        //act
        //assert
        assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(1323L));
    }
}