package com.meli.obtenerdiploma.unit;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOTest {

    IStudentDAO iStudentDAO;

    @BeforeEach
    public void init(){
        iStudentDAO = new StudentDAO();
    }

    @Test
    public void createNewStudentDAOOK(){
        //Arrange
        StudentDAO expected = new StudentDAO();

        //assert
        Assertions.assertNotNull(expected);
    }

    /*@Test
    public void createNewStudentError(){
        StudentDAO expected = new StudentDAO();
        Assertions.assertNotNull(expected);
    }*/

    @Test
    public void saveNewStudentOk(){
        //Arrange
        StudentDTO newStudent = new StudentDTO(1l, "Andres", null, null, new ArrayList<>());

        //Act
        iStudentDAO.save(newStudent);

        //Assert
        Assertions.assertTrue(iStudentDAO.exists(newStudent));
    }

    @Test
    public void saveExistentStudentOk(){
        //Arrange
        StudentDTO existentStudent = new StudentDTO(1l, "Andres", null, null, new ArrayList<>());

        //Act
        iStudentDAO.save(existentStudent);

        //Assert
        Assertions.assertTrue(iStudentDAO.exists(existentStudent));
    }

    @Test
    public void deleteStudentOk(){
        //Arrange
        boolean expected;

        //Act
        expected = iStudentDAO.delete(1l);

        //Assert
        Assertions.assertTrue(expected);
    }

    @Test
    public void deleteStudentError(){
        //Arrange
        boolean expected;

        //Act
        expected = iStudentDAO.delete(5L);

        //Assert
        Assertions.assertFalse(expected);
    }

    @Test
    public void existStudentOk(){
        //Arrange
        boolean expected;
        StudentDTO existentStudent = new StudentDTO(1l, "Andres", null, null, new ArrayList<>());

        //Act
        expected = iStudentDAO.exists(existentStudent);

        //Assert
        Assertions.assertTrue(iStudentDAO.exists(existentStudent));
    }

    @Test
    public void existStudentError(){
        //Arrange
        boolean expected;
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(new SubjectDTO("Matematica", 7d));
        subjects.add(new SubjectDTO("Quimica", 5d));
        StudentDTO existentStudent = new StudentDTO(6l, "Ana", "", 6d, subjects);

        //Act
        expected = iStudentDAO.exists(existentStudent);

        //Assert
        Assertions.assertFalse(iStudentDAO.exists(existentStudent));
    }

    @Test
    public void findByIdOk(){
        //Arrange
        StudentDTO expected = new StudentDTO(1l, "Andres", null, null, new ArrayList<>());

        //Act
        StudentDTO obtained = iStudentDAO.findById(1l );

        //Assert
        Assertions.assertEquals(expected, obtained);
    }

   /* @Test
    public void findByIdError(){
        //Arrange

        //Act
        StudentDTO obtained = iStudentDAO.findById(60l );

        //Assert
        Assertions.assertThrows(StudentNotFoundException.class);
    }*/

}
