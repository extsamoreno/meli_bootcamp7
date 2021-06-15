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

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @Mock
    IStudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    @Test
    public void createHappyPath(){
        //arrange
        StudentDTO student = new StudentDTO(1L,"Juan","message",7.33,new ArrayList<>());

        //act
        studentService.create(student);

        //assert
        Mockito.verify(studentDAO, Mockito.atLeastOnce()).save(student);
    }

    @Test
    public void readHappyPath(){
        //arrange
        Long studentId = 1L;

        SubjectDTO subjectOne = new SubjectDTO("Matemática", 9.0);
        SubjectDTO subjectTwo = new SubjectDTO("Física", 7.0);
        SubjectDTO subjectThree = new SubjectDTO("Química", 6.0);

        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(subjectOne);
        subjectDTOList.add(subjectTwo);
        subjectDTOList.add(subjectThree);

        StudentDTO expectedStudent = new StudentDTO(studentId,"Juan","message",7.33,subjectDTOList);

        Mockito.when(studentDAO.findById(studentId)).thenReturn(expectedStudent);

        //act
        StudentDTO recived = studentService.read(studentId);

        //assert
        Mockito.verify(studentDAO,Mockito.atLeastOnce()).findById(studentId);
        Assertions.assertEquals(expectedStudent,recived);
    }

    @Test
    public void updateHappyPath(){
        //arrange
        StudentDTO stu = new StudentDTO(1L,"Juan","message",7.33,new ArrayList<>());

        //act
        studentDAO.save(stu);

        //assert
        Mockito.verify(studentDAO,Mockito.atLeastOnce()).save(stu);
    }

    @Test
    public void deleteHappypath(){
        //arrange
        Long id = 1L;

        //act
        studentDAO.delete(id);

        //assert
        Mockito.verify(studentDAO, Mockito.atLeastOnce()).delete(id);
    }

    @Test
    public void getAllHappyPath(){
        //arrange
        StudentDTO student1 = new StudentDTO(1L,"Juan","message",7.33,new ArrayList<>());
        StudentDTO student2 = new StudentDTO(2L,"Pedro","message",6.78,new ArrayList<>());

        Set<StudentDTO> expected = new HashSet<>();
        expected.add(student1);
        expected.add(student2);

        Mockito.when(studentRepository.findAll()).thenReturn(expected);

        //act
        Set<StudentDTO> recive = studentService.getAll();

        //assert
        Mockito.verify(studentRepository, Mockito.atLeastOnce()).findAll();
        Assertions.assertEquals(expected,recive);
    }
}
