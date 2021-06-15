package com.meli.obtenerdiploma.unit;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.bind.MethodArgumentNotValidException;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class StudentDAOTest {

    //StudentDAO studentDAO = new StudentDAO();
    @MockBean
    StudentDAO studentDAO = new StudentDAO();

    @Test
    public void addStudentHappyPath() {
        //Arrange
        SubjectDTO subjectOne = new SubjectDTO("Programación", 10d);
        SubjectDTO subjectTwo = new SubjectDTO("Algoritmos", 10d);
        SubjectDTO subjectThree = new SubjectDTO("Base de datos", 10d);

        List<SubjectDTO> listSubjects = new ArrayList<>();
        listSubjects.add(subjectOne);
        listSubjects.add(subjectTwo);
        listSubjects.add(subjectThree);

        StudentDTO student = new StudentDTO(3L, "Genardo", "No se", 10d, listSubjects);

        //act
        studentDAO.save(student);

        //assert
        Assertions.assertEquals(student, studentDAO.findById(3L));

    }

   // @Test
    public void addStudentWrongValues() {
        //Arrange

        //Act


        //Assert
        Assertions.assertThrows(MethodArgumentNotValidException.class, () -> new @Valid StudentDTO(4L, "genaro", "", 10d, null));
    }
}
