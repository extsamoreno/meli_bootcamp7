package com.meli.obtenerdiploma.units;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class StudentDAOTests {
    static StudentDAO studentDAO = new StudentDAO();

    @Test
    public void findByIdNullValueShouldThrowStudentNotFoundException(){
        StudentDAO studentDAO = new StudentDAO();
        //arrange
        assertThrows(StudentNotFoundException.class,() -> studentDAO.findById(null));
    }

    @Test
    public void findByIdInvalidValueShouldThrowStudentNotFoundException(){
        //arrange
        assertThrows(StudentNotFoundException.class,() -> studentDAO.findById(-1L));
    }
    @Test
    public void ExistsInvalidValueShouldThrowStudentNotFoundException(){
        Long id = 999L;
        StudentDTO studentDTO = new StudentDTO(id, null,null,null, null);

        //arrange
        assertFalse(studentDAO.exists(studentDTO));
    }

    @Test
    public void DeleteInvalidValueShouldThrowStudentNotFoundException(){
        Long id = 999L;

        //arrange
        assertFalse(studentDAO.delete(id));
    }

    @Test
    public void DeleteNullValueShouldThrowStudentNotFoundException(){
        //arrange
        assertFalse(studentDAO.delete(null));
    }

    @Test
    public void ExistsShouldReturnTrue(){
        //arrange
        Long studentId = 1L;

        StudentDAO studentDAO = new StudentDAO();
        StudentDTO studentDTO = new StudentDTO(studentId, null,null,null, null);

        //act
        boolean studentExist = studentDAO.exists(studentDTO);

        //assert
        assertTrue(studentExist);
    }

    @Test
    public void ExistsShouldThrowStudentNotFoundException(){
        //arrange
        Long studentId = 9999L;

        StudentDAO studentDAO = new StudentDAO();
        StudentDTO studentDTO = new StudentDTO(studentId, null,null,null, null);

        //act
        boolean studentExist = studentDAO.exists(studentDTO);

        //assert
        assertFalse(studentExist);
    }
}
