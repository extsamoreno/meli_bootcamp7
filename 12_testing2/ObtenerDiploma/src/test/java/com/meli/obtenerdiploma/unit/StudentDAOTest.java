package com.meli.obtenerdiploma.unit;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class StudentDAOTest {
    StudentDAO studentDAO = new StudentDAO();
    StudentDTO studentDTO = new StudentDTO();
    ArrayList<SubjectDTO> arrayList = new ArrayList<>();
    public void fillStudent () {
        studentDTO.setStudentName("Camilo");
        studentDTO.setMessage("El estudiante no es pilo xd");
        arrayList.add(new SubjectDTO("Matematica",5.0));
        arrayList.add(new SubjectDTO("Fisica",7.0));
        arrayList.add(new SubjectDTO("Quimica",6.0));
        studentDTO.setSubjects(arrayList);
    }

    @Test
    public void saveStudentTest() {
        this.fillStudent();
        studentDAO.save(studentDTO);
        Assertions.assertTrue(studentDAO.exists(studentDTO));
    }
    @Test
    public void deleteStudentTest() {
        this.fillStudent();
        studentDAO.save(studentDTO);
        studentDAO.delete(studentDTO.getId());
        Assertions.assertFalse(studentDAO.exists(studentDTO));
    }
}
