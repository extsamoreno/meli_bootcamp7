package com.meli.obtenerdiploma.unit.service;

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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {
    @Mock
    IStudentDAO iStudentDAO;

    @Mock
    IStudentRepository iStudentRepository;

    @InjectMocks
    StudentService studentService;

    @Test
    public void createStudentTestHappyPath(){
        //Arrange
        StudentDTO student = new StudentDTO(1L, "Juan", "Mensaje", 10d, new ArrayList<>());
        //Act
        studentService.create(student);
        //Assert
        Mockito.verify(iStudentDAO, Mockito.atLeast(1)).save(student);
    }

    @Test
    public void readStudentTestHappyPath(){
        //Arrange
        SubjectDTO subjectOne = new SubjectDTO("Matemática", 10d);
        SubjectDTO subjectTwo = new SubjectDTO("Física", 10d);
        SubjectDTO subjectThree = new SubjectDTO("Química", 10d);

        List<SubjectDTO> listSubjects = new ArrayList<>();
        listSubjects.add(subjectOne);
        listSubjects.add(subjectTwo);
        listSubjects.add(subjectThree);

        StudentDTO student = new StudentDTO(1L,"Juan","Asd",10d,listSubjects);

        when(iStudentDAO.findById(1L)).thenReturn(student);
        //Act
        StudentDTO studentResult = studentService.read(1L);
        //Assert
        Mockito.verify(iStudentDAO, Mockito.atLeastOnce()).findById(1L);
        Assertions.assertEquals(studentResult,student);
    }

    @Test
    public void deleteStudentHappyPath(){
        //Arrange
        Long id = 2L;

        //Act
        studentService.delete(id);

        //Assert
        Mockito.verify(iStudentDAO, Mockito.atLeastOnce()).delete(id);
    }

    @Test
    public void updateStudentHappyPath() {
        //Arrange
        SubjectDTO subjectOne = new SubjectDTO("Matemática", 10d);
        SubjectDTO subjectTwo = new SubjectDTO("Física", 10d);
        SubjectDTO subjectThree = new SubjectDTO("Química", 10d);

        List<SubjectDTO> listSubjects = new ArrayList<>();
        listSubjects.add(subjectOne);
        listSubjects.add(subjectTwo);
        listSubjects.add(subjectThree);

        StudentDTO student = new StudentDTO(1L,"Juan","Asd",10d,listSubjects);

        //Act
        studentService.update(student);

        //Assert
        Mockito.verify(iStudentDAO, Mockito.atLeastOnce()).save(student);
    }

    @Test
    public void getAllStudentHappyPath() {
        //Arrange
        SubjectDTO subjectOne = new SubjectDTO("Matemática", 10d);
        SubjectDTO subjectTwo = new SubjectDTO("Física", 10d);
        SubjectDTO subjectThree = new SubjectDTO("Química", 10d);

        List<SubjectDTO> listSubjects = new ArrayList<>();
        listSubjects.add(subjectOne);
        listSubjects.add(subjectTwo);
        listSubjects.add(subjectThree);

        StudentDTO student1 = new StudentDTO(1L,"Juan","Asd",10d,listSubjects);
        StudentDTO student2 = new StudentDTO(9L,"Jorge","Asd",10d,listSubjects);
        Set<StudentDTO> list = new HashSet<>();
        list.add(student1);
        list.add(student2);

        Mockito.when(iStudentRepository.findAll()).thenReturn(list);

        //Act
        Set<StudentDTO> received = studentService.getAll();

        //Assert
        Mockito.verify(iStudentRepository, Mockito.atLeastOnce()).findAll();
        Assertions.assertEquals(list, received);
    }
}
