package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
class StudentDAOTest {

    @InjectMocks
    StudentDAO studentDAO;

    @Test
    public void StudentExist(){

        //arrange
        long id = 1;
        ArrayList<SubjectDTO> subjects = new ArrayList<>();
        SubjectDTO subject1 = new SubjectDTO("Matemática", 9.0);
        SubjectDTO subject2 = new SubjectDTO("Física", 7.0);
        SubjectDTO subject3 = new SubjectDTO("Química", 6.0);
        subjects.add(subject1);
        subjects.add(subject2);
        subjects.add(subject3);
        StudentDTO studentDTO = new StudentDTO(1L, "Juan", null, null, subjects);
        //act
        StudentDTO response = studentDAO.findById(id);

        //assert
        verify(studentDAO, atLeast(1)).findById(id);
        assertEquals(studentDTO,response);
    }

    @Test
    public void findByIdNull(){
        //Arrange
        Long id = null;
        //Assert
        assertThrows(StudentNotFoundException.class, ()-> studentDAO.findById(id));
    }

    @Test
    public void findByIdInvalid(){
        //Assert
        Long id = -1L;
        assertThrows(StudentNotFoundException.class, ()-> studentDAO.findById(id));
    }

    @Test
    public void createStudentDTONull(){
        //Arrange
        StudentDTO studentDTO = new StudentDTO();
        //Assert
        assertThrows(StudentNotFoundException.class, ()-> studentDAO.save(studentDTO));
    }
    @Test
    public void createStudentDTOInvalid(){
        //Arrange
        StudentDTO studentDTO = new StudentDTO(-1L);
        //Assert
        assertThrows(StudentNotFoundException.class, ()-> studentDAO.save(studentDTO));
    }
    @Test
    public void editStudentDTOHappyPath(){
        //Arrange
        ArrayList<SubjectDTO> subjects = new ArrayList<>();
        SubjectDTO subject1 = new SubjectDTO("Matemática", 9.0);
        SubjectDTO subject2 = new SubjectDTO("Física", 7.0);
        subjects.add(subject1);
        subjects.add(subject2);
        StudentDTO studentDTO = new StudentDTO(2L, "Juan", null, null, subjects);
        //act
        studentDAO.save(studentDTO);
        //Assert
        System.out.println(studentDAO.findById(2L));
    }

    @Test
    public void editStudentDTOInvalid(){
        //Arrange
        ArrayList<SubjectDTO> subjects = new ArrayList<>();
        SubjectDTO subject1 = new SubjectDTO("Matemática", 9.0);
        SubjectDTO subject2 = new SubjectDTO("Física", 7.0);
        subjects.add(subject1);
        subjects.add(subject2);
        StudentDTO studentDTO = new StudentDTO(2L, "Juan", null, null, subjects);
        //act
        studentDAO.save(studentDTO);
        //Assert
        verify(studentDAO, atLeast(1)).save(studentDTO);
    }

}