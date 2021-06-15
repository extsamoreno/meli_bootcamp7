package com.meli.obtenerdiploma.unit;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {
    @Mock
    IStudentDAO studentDAO;

    @Mock
    IStudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    @Test
    public void createStudentTestHappytPath() {
        //Arrange

        StudentDTO student = new StudentDTO(4L, "Juan", "Mensaje", 10d, new ArrayList<>());

        //act
        studentService.create(student);

        //assert
        Mockito.verify(studentDAO, Mockito.atLeast(1)).save(student);
    }

    //check in the next, null student
    @Test
    public void readStudentTestHappyPath() {
        //Arrange
        SubjectDTO subjectOne = new SubjectDTO("Programación", 10d);
        SubjectDTO subjectTwo = new SubjectDTO("Algoritmos", 10d);
        SubjectDTO subjectThree = new SubjectDTO("Base de datos", 10d);

        List<SubjectDTO> listSubjects = new ArrayList<>();
        listSubjects.add(subjectOne);
        listSubjects.add(subjectTwo);
        listSubjects.add(subjectThree);

        StudentDTO student = new StudentDTO(3L, "Genardo", "No se", 10d, listSubjects);

        Mockito.when(studentDAO.findById(3L)).thenReturn(student);
        //Act

        StudentDTO studentResult = studentService.read(3L);

        //Assert
        Assertions.assertEquals(studentResult, student);
    }


    @Test
    public void readStudentNull() {
        //Arrange
        Mockito.when(studentDAO.findById(42L)).thenReturn(null);

        //Act
        StudentDTO studentResult = studentService.read(42L);

        //Assert
        Assertions.assertNull(studentResult);
    }
}
