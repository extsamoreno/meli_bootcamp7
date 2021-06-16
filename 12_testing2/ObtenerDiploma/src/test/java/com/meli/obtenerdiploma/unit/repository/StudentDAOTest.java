package com.meli.obtenerdiploma.unit.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.unit.utils.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StudentDAOTest {

    StudentDAO studentDAO = new StudentDAO();

    @Test
    public void addNewStudentHappyPath() {
        //Arrange
        StudentDTO studentDTO = Utils.getStudentDTO();

        //Act
        studentDAO.save(studentDTO);
        StudentDTO received = studentDAO.findById(studentDTO.getId());

        //Assert
        Assertions.assertEquals(studentDTO,received);
        studentDAO.delete(studentDTO.getId());
    }

    @Test
    public void findStudentByIdHappyPath() {
        //Arrange
        StudentDTO studentDTO = Utils.getStudentDTO();
        studentDAO.save(studentDTO);

        //Act
        StudentDTO student = studentDAO.findById(studentDTO.getId());

        //Assert
        Assertions.assertEquals("Test", student.getStudentName());
    }

    @Test
    public void findStudentByIdNonExistingId() {
        //Arrange

        //Act

        //Assert
        Assertions.assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(99L));
    }

    @Test
    public void updateStudentHappyPath() {
        //Arrange
        StudentDTO studentDTO = Utils.getStudentDTO();
        studentDAO.save(studentDTO);
        String name = "Another name";
        studentDTO.setStudentName(name);

        //Act
        studentDAO.save(studentDTO);
        StudentDTO received = studentDAO.findById(studentDTO.getId());

        //Assert
        Assertions.assertEquals(name,received.getStudentName());
        studentDAO.delete(studentDTO.getId());
    }

    @Test
    public void deleteStudentHappyPath() {
        //Arrange
        StudentDTO studentDTO = Utils.getStudentDTO();
        studentDAO.save(studentDTO);

        //Act
        boolean result = studentDAO.delete(studentDTO.getId());

        //Assert
        Assertions.assertTrue(result);
    }

    @Test
    public void deleteStudentNonExistingId() {
        //Arrange

        //Act
        boolean result = studentDAO.delete(99L);

        //Assert
        Assertions.assertFalse(result);
    }
}
