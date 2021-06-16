package com.meli.obtenerdiploma.unit;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StudentDAOTestWithoutMocks {

    //arrange
    //StudentDAO studentDAO = new StudentDAO();

    @Test
    public void findStudentByIdNull() {

        //arrange
        StudentDAO studentDAO = new StudentDAO();
        long id = -1;

        //assert
        Assertions.assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(id));
    }

    @Test
    public void findStudentByIdOk() {

        //arrange
        StudentDAO studentDAO = new StudentDAO();
        //studentDAO.loadData();
        long id = 1;
        StudentDTO expected = new StudentDTO();
        expected.setStudentName("Juan");

        //act
        StudentDTO received = studentDAO.findById(id);

        //assert
        Assertions.assertEquals(expected.getStudentName(), received.getStudentName());
    }

    @Test
    public void findStudentByIdThrowStudentNotFoundException() {

        //arrange
       StudentDAO studentDAO = new StudentDAO();
        long id = -1;

        //assert
        Assertions.assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(id));
    }

    @Test
    public void deleteStudentByIdOk() {

        //arrange
        StudentDAO studentDAO = new StudentDAO();
        long id = 1;
        StudentDTO expected = new StudentDTO();
        expected.setStudentName("Juan");

        //act
        boolean received = studentDAO.delete(id);

        //assert
        Assertions.assertTrue(received);
    }

    @Test
    public void saveStudentOk() {

        //arrange;
        StudentDAO studentDAO = new StudentDAO();
        long id = 2;
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(id);
        studentDTO.setStudentName("New Name");

        //act
        studentDAO.save(studentDTO);
        String received = studentDAO.findById(id).getStudentName();

        //assert
        Assertions.assertEquals(studentDTO.getStudentName(), received);
    }

    @Test
    public void addStudentOk() {

        //arrange;
        StudentDAO studentDAO = new StudentDAO();
        long id = 1;
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(id);
        studentDTO.setStudentName("Juan");

        //act
        studentDAO.save(studentDTO);
        String received = studentDAO.findById(id).getStudentName();

        //assert
        Assertions.assertEquals(studentDTO.getStudentName(), received);
    }

}
