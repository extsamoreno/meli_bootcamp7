package com.meli.obtenerdiploma.units;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StudentDAOTest {

    @Test
    public void saveTest(){
        Set<StudentDTO> expected = new HashSet<>();
        Set<StudentDTO> repo = new HashSet<>();

        StudentDTO a = new StudentDTO(3L, "Jorge", null, null, null);

        SubjectDTO m1 = new SubjectDTO("Matemática", 9.0);
        SubjectDTO m2 = new SubjectDTO("Física", 7.0);
        SubjectDTO m3 = new SubjectDTO("Química", 6.0);
        List<SubjectDTO> materias = new ArrayList<>();
        materias.add(m1);
        materias.add(m2);
        materias.add(m3);
        a.setSubjects(materias);
        expected.add(a);
    }

    @Test
    public void findByIdTest(){
        IStudentDAO studentDAO = new StudentDAO();

        StudentDTO expected = new StudentDTO(2L, "Pedro", null, null, null);

        SubjectDTO m1 = new SubjectDTO("Matemática", 10.0);
        SubjectDTO m2 = new SubjectDTO("Física", 8.0);
        SubjectDTO m3 = new SubjectDTO("Química", 4.0);
        List<SubjectDTO> materias = new ArrayList<>();
        materias.add(m1);
        materias.add(m2);
        materias.add(m3);
        expected.setSubjects(materias);

        StudentDTO received = studentDAO.findById(2L);

        Assertions.assertEquals(expected,received);
    }

    @Test
    public void deleteTest() throws StudentNotFoundException {
        IStudentDAO iStudentDAO = new StudentDAO();

        List<SubjectDTO> subj1 = new ArrayList<>();
        subj1.add(new SubjectDTO("Matemática", 9.00));
        subj1.add(new SubjectDTO("Física", 7.00));
        subj1.add(new SubjectDTO("Química", 6.00));
        StudentDTO newStudent = new StudentDTO(1L, "Juan", null, null, subj1);

        iStudentDAO.delete(1L);

        Assertions.assertFalse(iStudentDAO.exists(newStudent));
    }



}
