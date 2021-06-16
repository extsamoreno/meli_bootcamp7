package com.meli.obtenerdiploma.unit;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StudentDAOTest {
    @Test
    public void testForSaveStudentNoFound(){
        //Arrange
        StudentDAO studentDAO = new StudentDAO();
        //act

        //assert
        assertThrows(NullPointerException.class, ()->studentDAO.save(null));
    }
    @Test
    public void testForSaveExistentStudentDTO(){
        //arrange
        StudentDAO studentDAO = new StudentDAO();
        StudentDTO student= new StudentDTO(1L,"",null,null,null);
        //act

        //assert
        assertDoesNotThrow(()-> studentDAO.save(student));
    }
    @Test
    public void testForFindByNullId(){
        // arrange
        StudentDAO studentDAO = new StudentDAO();
        // act
        // assert
        Assertions.assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(null));
    }

    @Test
    public void testForFindByValidId(){

        // arrange
        StudentDAO studentDAO = new StudentDAO();
        long id= 2L;
        StudentDTO expected= new StudentDTO(id,null,null,null,null);
        studentDAO.save(expected);
        // act
        StudentDTO received= studentDAO.findById(id);
        // assert
        Assertions.assertEquals(expected,received);
    }

    @Test
    public void testForDeleteANullStudentDTO(){
        // arrange
        StudentDAO studentDAO = new StudentDAO();
        // act
        boolean received= studentDAO.delete(null);
        // assert
        assertEquals(false,received);
    }

    @Test
    public void testForDeleteANonSavedStudentDTO(){
        // arrange
        StudentDAO studentDAO = new StudentDAO();
        long id= 3000L;
        // act
        boolean received= studentDAO.delete(id);
        // assert
       assertEquals(false,received);
    }

    @Test
    public void testForDeleteExistStudent(){
        //Arrange
        StudentDAO studentDAO = new StudentDAO();

        Long id=5L;
        SubjectDTO s1 = new SubjectDTO("Math",8.5);
        List<SubjectDTO> sujects = new ArrayList<>();
        sujects.add(s1);
        StudentDTO student = new StudentDTO(id,"Juan", null, null, sujects);

        //act
        Boolean received = studentDAO.delete(id);

        //Asseter
        Assertions.assertTrue(received);
    }




}
