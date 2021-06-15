package com.example.diploma.unit;

import com.example.diploma.exception.StudentNotFoundException;
import com.example.diploma.model.StudentDTO;
import com.example.diploma.model.SubjectDTO;
import com.example.diploma.repository.IStudentDAO;
import com.example.diploma.repository.StudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class StudentDAOTest {

    IStudentDAO iStudentDAO;

    @BeforeEach
    public void init() {
        iStudentDAO = new StudentDAO();
    }

    //EXIST

    @Test
    public void testExistExistentStudent() {
        //ARRANGE
        StudentDTO student = new StudentDTO(1L, "Juan", null, null, new ArrayList<>() { {
            add(new SubjectDTO("Matemática", 9.0));
            add(new SubjectDTO("Física", 7.0));
            add(new SubjectDTO("Química", 6.0));
        }});

        //ACT
        boolean received = iStudentDAO.exists(student);

        //ASSERT
        Assertions.assertTrue(received);
    }

    @Test
    public void testExistInexistentStudent() {
        //ARRANGE
        StudentDTO student = new StudentDTO(4L, "Marcos", null, null, new ArrayList<>());

        //ACT
        boolean received = iStudentDAO.exists(student);

        //ASSERT
        Assertions.assertFalse(received);
    }

    @Test
    public void testExistNullStudent() {
        //ARRANGE
        StudentDTO student = null;

        //ACT

        //ASSERT
        Assertions.assertThrows(NullPointerException.class, () -> iStudentDAO.exists(student));
    }

    @Test
    public void testExistEmptyStudent() {
        //ARRANGE
        StudentDTO student = new StudentDTO();

        //ACT
        boolean received = iStudentDAO.exists(student);

        //ASSERT
        Assertions.assertFalse(received);
    }

    //SAVE

    @Test
    public void testSaveNewStudent() {
        //ARRANGE
        StudentDTO newStudent = new StudentDTO(3L, "José", null, 9.0, new ArrayList<>());

        //ACT
        iStudentDAO.save(newStudent);

        //ASSERT
        Assertions.assertTrue(iStudentDAO.exists(newStudent));
    }

    @Test
    public void testSaveExistentStudent() {
        //ARRANGE
        StudentDTO existentStudent = new StudentDTO(3L, "José", null, 9.0, new ArrayList<>());

        //ACT
        iStudentDAO.save(existentStudent);

        //ASSERT
        Assertions.assertTrue(iStudentDAO.exists(existentStudent)); //If the userId sent is already in DB, the method works as an update of the user. Therefore, the user is modified in DB.
    }

    @Test
    public void testSaveNullStudent() {
        //ARRANGE
        StudentDTO newStudent = null;

        //ACT

        //ASSERT
        Assertions.assertThrows(NullPointerException.class, () -> iStudentDAO.save(newStudent));
    }

    @Test
    public void testSaveEmptyStudent() {
        //ARRANGE
        StudentDTO newStudent = new StudentDTO();

        //ACT
        iStudentDAO.save(newStudent);

        //ASSERT
        Assertions.assertTrue(iStudentDAO.exists(newStudent)); //There is no validation for saving empty students. Therefore, the student is created in DB.
    }

    //FIND BY ID

    @Test
    public void testFindByIdExistentStudent() {
        //ARRANGE
        StudentDTO studentExpected = new StudentDTO(3L, "José", null, 9.0, new ArrayList<>());

        //ACT
        StudentDTO studentReceived = iStudentDAO.findById(3L);

        //ASSERT
        Assertions.assertEquals(studentExpected, studentReceived);
    }

    @Test
    public void testFindByIdInexistentStudent() {
        //ARRANGE
        Long id = 5L;

        //ACT

        //ASSERT
        Assertions.assertThrows(StudentNotFoundException.class, () -> iStudentDAO.findById(id));
    }

    @Test
    public void testFindByIdNullId() {
        //ARRANGE
        Long id = null;

        //ACT

        //ASSERT
        Assertions.assertThrows(StudentNotFoundException.class, () -> iStudentDAO.findById(id));
    }

    //MODIFY (A.K.A. SAVE)

    @Test
    public void testModifyStudent() {
        //ARRANGE
        StudentDTO modifiedStudent = new StudentDTO(3L, "José", null, 9.0, new ArrayList<>() { {
            add(new SubjectDTO("Matemática", 9.0));
            add(new SubjectDTO("Física", 7.0));
            add(new SubjectDTO("Química", 6.0));
        }});

        //ACT
        iStudentDAO.save(modifiedStudent);

        //ASSERT
        Assertions.assertTrue(iStudentDAO.exists(modifiedStudent));
    }

    //DELETE

    @Test
    public void testDeleteExistentStudent() {
        //ARRANGE
        Long id = 3L;

        //ACT
        boolean deleteReceived = iStudentDAO.delete(id);

        //ASSERT
        Assertions.assertTrue(deleteReceived);
    }

    @Test
    public void testDeleteInexistentStudent() {
        //ARRANGE
        Long id = 4L;

        //ACT
        boolean deleteReceived = iStudentDAO.delete(id);

        //ASSERT
        Assertions.assertFalse(deleteReceived);
    }

    @Test
    public void testDeleteNullId() {
        //ARRANGE
        Long id = null;

        //ACT
        boolean deleteReceived = iStudentDAO.delete(id);

        //ASSERT
        Assertions.assertFalse(deleteReceived);
    }
}
