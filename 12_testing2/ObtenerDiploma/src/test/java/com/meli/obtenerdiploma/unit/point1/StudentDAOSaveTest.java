package com.meli.obtenerdiploma.unit.point1;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.unit.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StudentDAOSaveTest {

    StudentDAO studentDAO = new StudentDAO();
    Long id;

    @Test
    public void saveHappyPath() {
        //arrange
        StudentDTO studentDTO = Utils.getStudentDTO();

        //act
        id = studentDAO.save(studentDTO);
        StudentDTO received = studentDAO.findById(id);
        //assert
        Assertions.assertEquals(studentDTO, received);
        studentDAO.delete(id);
    }


    @Test
    public void updateHappyPath() {
        //arrange
        StudentDTO studentDTO = Utils.getStudentDTO();
        Long idLocal = studentDAO.save(studentDTO);
        String name = "OTRO NOMBRE";

        studentDTO.setStudentName(name);

        //act
        studentDAO.save(studentDTO);
        StudentDTO received = studentDAO.findById(idLocal);
        //assert
        Assertions.assertEquals(name, received.getStudentName());
        studentDAO.delete(idLocal);
    }

    @Test
    public void deleteHappyPath() {
        //Arrange
        id = studentDAO.save(Utils.getStudentDTO());
        //arrange
        //act
        boolean result = studentDAO.delete(id);
        //assert
        Assertions.assertTrue(result);

    }
}
