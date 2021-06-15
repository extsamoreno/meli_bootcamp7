package com.meli.obtenerdiploma.unit.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

//ExtendWith(MockitoExtension.class)
public class StudentDAOTest {

    // Instancia de StudentDAO, para no tener que inyectar
    //IStudentDAO studentDAO;
    StudentDAO studentDAO = new StudentDAO();


    // Agregar un alumno.
    @Test
    public void addStudentInStudentsDB(){

        // arrange
        SubjectDTO subjectDTO1 = new SubjectDTO("Matemática", 10.0);
        SubjectDTO subjectDTO2 = new SubjectDTO("Física", 8.0);
        SubjectDTO subjectDTO3 = new SubjectDTO("Química", 4.0);
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(subjectDTO1);
        subjects.add(subjectDTO2);
        subjects.add(subjectDTO3);

        StudentDTO newStudent = new StudentDTO();
        //newStudent.setId(5L);
        newStudent.setStudentName("Pablo");
        newStudent.setSubjects(subjects);

        //int expectedSize = 3;

        // act
        studentDAO.save(newStudent);
        //int actualSize = studentDAO.getStudents().size();

        // assert
        StudentDTO received = studentDAO.findById(3L);
        assertEquals(newStudent, received);
    }


    //Buscar un alumno por Id.
    @Test
    public void findStudentByIdInStudentsDB(){

        //arrange
        SubjectDTO subjectDTO1 = new SubjectDTO("Matemática", 10.0);
        SubjectDTO subjectDTO2 = new SubjectDTO("Física", 8.0);
        SubjectDTO subjectDTO3 = new SubjectDTO("Química", 4.0);
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(subjectDTO1);
        subjects.add(subjectDTO2);
        subjects.add(subjectDTO3);

        Long studentId = Long.valueOf(2);
        StudentDTO expected = new StudentDTO();
        expected.setId(2L);
        expected.setStudentName("Pedro");
        expected.setSubjects(subjects);

        //act
        StudentDTO received = studentDAO.findById(studentId);

        //assert
        assertEquals(expected, received);
    }


    //Modificar los datos de un alumno.
    @Test
    public void updateStudentData(){

        // arrange
        Long studentId = Long.valueOf(3);
        String newName = "Camila";
        int expectedSize = 3;

        // act
        StudentDTO modifidedStudent = studentDAO.findById(studentId);
        modifidedStudent.setStudentName(newName);
        studentDAO.save(modifidedStudent);
        //int actualSize = studentDAO.getStudents().size();

        // assert
        String actualName = studentDAO.findById(studentId).getStudentName();
        assertEquals(newName, actualName);
        //assertEquals(expectedSize, actualSize);

    }



    // Eliminar un alumno.
    @Test
    public void deleteStudentInStudentsDB(){

        // arrange
        Long studentId = Long.valueOf(2);

        // act
        boolean received = studentDAO.delete(studentId);

        // assert
        assertTrue(received);
    }
}
