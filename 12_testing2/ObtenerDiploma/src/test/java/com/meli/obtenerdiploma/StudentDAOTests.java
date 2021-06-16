package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class StudentDAOTests {
    private StudentDAO studentDAO;

    public StudentDAOTests() {
        this.studentDAO = new StudentDAO();
    }

    @Test
    public void saveUserOkTest() {
        SubjectDTO subj1 = new SubjectDTO("Matematica", 10.0);
        SubjectDTO subj2 = new SubjectDTO("Literatura", 10.0);
        SubjectDTO subj3 = new SubjectDTO("Historia", 10.0);
        StudentDTO expected = new StudentDTO(123L,
                "Edu",
                "Congrats",
                10.0,
                Arrays.asList(subj1, subj2, subj3));

        studentDAO.save(expected);
        StudentDTO received = studentDAO.findById(expected.getId());

        Assertions.assertEquals(expected, received);

        studentDAO.delete(expected.getId());
    }

    @Test
    public void findByIdOkTest() {
        long expected = 1L;

        StudentDTO received = studentDAO.findById(expected);

        Assertions.assertEquals(expected, received.getId());
    }

    @Test
    public void findByIdNotFoundTest() {
        long id = 321L;
        Assertions.assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(id));
    }

    @Test
    public void existsTrueTest() {
        StudentDTO expected = new StudentDTO();
        expected.setId(1L);

        boolean received = studentDAO.exists(expected);

        Assertions.assertTrue(received);
    }

    @Test
    public void existsFalseTest() {
        StudentDTO expected = new StudentDTO();
        expected.setId(321L);

        boolean received = studentDAO.exists(expected);

        Assertions.assertFalse(received);
    }

    //@Test
    public void deleteOkTest() {
        SubjectDTO subj1 = new SubjectDTO("Matematica", 10.0);
        SubjectDTO subj2 = new SubjectDTO("Literatura", 10.0);
        SubjectDTO subj3 = new SubjectDTO("Historia", 10.0);
        StudentDTO expected = new StudentDTO(123L,
                "Edu",
                "Congrats",
                10.0,
                Arrays.asList(subj1, subj2, subj3));

        studentDAO.save(expected);

        boolean received = studentDAO.delete(expected.getId());

        Assertions.assertTrue(received);
    }

    @Test
    public void deleteIdNotFoundTest() {
        long expected = 321L;

        boolean received = studentDAO.delete(expected);

        Assertions.assertFalse(received);
    }
}