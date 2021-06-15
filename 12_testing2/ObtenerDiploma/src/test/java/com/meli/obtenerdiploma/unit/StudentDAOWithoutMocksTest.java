package com.meli.obtenerdiploma.unit;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


public class StudentDAOWithoutMocksTest {

    @Test
    public void saveTest() {
        IStudentDAO iStudentDAO = new StudentDAO();

        StudentDTO newStudent = new StudentDTO(3L, "Walter", null,
                null, null);

        iStudentDAO.save(newStudent);

        Assertions.assertTrue(iStudentDAO.exists(newStudent));
    }

    @Test
    public void findByIdTest() {
        IStudentDAO iStudentDAO = new StudentDAO();

        StudentDTO expected = new StudentDTO(3L, "Walter", null,
                null, null);

        StudentDTO received = iStudentDAO.findById(3L);

        Assertions.assertEquals(expected, received);
    }

    @Test
    public void deleteTest() {
        IStudentDAO iStudentDAO = new StudentDAO();

        List<SubjectDTO> subj1 = new ArrayList<>();
        subj1.add(new SubjectDTO("Matemática", 9.00));
        subj1.add(new SubjectDTO("Física", 7.00));
        subj1.add(new SubjectDTO("Química", 6.00));
        StudentDTO newStudent = new StudentDTO(1L, "Juan", null, null, subj1);

        iStudentDAO.delete(1L);

        Assertions.assertFalse(iStudentDAO.exists(newStudent));
    }

    //modify
}
