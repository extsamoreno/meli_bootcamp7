package com.meli.obtenerdiploma.unit.repository;


import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class StudentDAOTest {

    StudentDAO studentDAO;

    @BeforeEach
    public void init() {
        studentDAO = new StudentDAO();
    }

    @Test
    public void existHappyPath() {
        //arrange
        StudentDTO studentDTO = new StudentDTO(1L, "Juan", "hola", 9.0, new ArrayList<>());

        //act
        boolean received = studentDAO.exists(studentDTO);

        //assert
        Assertions.assertTrue(received);
    }

    @Test
    public void existUnhappyPath() {
        //arrange
        StudentDTO studentDTO = new StudentDTO(4L, "Juan", "hola", 9.0, new ArrayList<>());

        //act
        boolean received = studentDAO.exists(studentDTO);

        //assert
        Assertions.assertFalse(received);
    }

    @Test
    public void existUnhappyPathNull() {
        //arrange

        //act
        boolean received = studentDAO.exists(null);

        //assert
        Assertions.assertFalse(received);
    }

    @Test
    public void saveHappyPath() {
        //arrange
        StudentDTO studentDTO = new StudentDTO(4L, "José", "hola", 9.0, new ArrayList<>());

        //act
        studentDAO.save(studentDTO);

        //assert
        Assertions.assertTrue(studentDAO.exists(studentDTO));
    }

    @Test
    public void findByIdHappyPath() {
        //arrange
        StudentDTO studentDTO = new StudentDTO(1L, "Juan", null, null, new ArrayList<>() {
            {
                add(new SubjectDTO("Matemática", 9.0));
                add(new SubjectDTO("Física", 7.0));
                add(new SubjectDTO("Química", 6.0));
            }
        });

        //act
        StudentDTO received = studentDAO.findById(studentDTO.getId());

        //assert
        Assertions.assertEquals(studentDTO, received);
    }

    @Test
    public void findByIdUnhappyPath() {
        //arrange
        Long id = 4L;

        //act

        //assert
        Assertions.assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(id));
    }

    @Test
    public void deleteHappyPath() {
        //arrange
        Long id = 1L;

        //act
        boolean received = studentDAO.delete(id);

        //assert
        Assertions.assertTrue(received);
    }

    @Test
    public void deleteUnhappyPath() {
        //arrange
        Long id = 4L;

        //act
        boolean received = studentDAO.delete(id);

        //assert
        Assertions.assertFalse(received);
    }

}
