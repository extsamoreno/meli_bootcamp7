package com.meli.obtenerdiploma.unit;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StudentDAOSaveTest {

    StudentDAO studentDAO = new StudentDAO();

    @Test
    public void saveHappyPath() {
        //arrange
        StudentDTO studentDTO = Utils.getStudentDTO();
        //act
        studentDAO.save(studentDTO);
        StudentDTO received = studentDAO.findById(studentDTO.getId());
        //assert
        Assertions.assertNotNull(received.getId());
        //Assertions.assertEquals(studentDTO, received);
        studentDAO.delete(received.getId());
    }


    @Test
    public void updateHappyPath() {
        //arrange
        StudentDTO studentDTO = Utils.getStudentDTO();
        studentDAO.save(studentDTO);
        String name = "OTRO NOMBRE";

        studentDTO.setStudentName(name);

        //act
        studentDAO.save(studentDTO);
        StudentDTO received = studentDAO.findById(studentDTO.getId());
        //assert
        Assertions.assertEquals(name, received.getStudentName());
        studentDAO.delete(studentDTO.getId());
    }

    @Test
    public void deleteHappyPath() {
        //Arrange
        StudentDTO studentDTO = Utils.getStudentDTO();
        studentDAO.save(studentDTO);
        //arrange
        //act
        boolean result = studentDAO.delete(studentDTO.getId());
        //assert
        Assertions.assertTrue(result);

    }

}
