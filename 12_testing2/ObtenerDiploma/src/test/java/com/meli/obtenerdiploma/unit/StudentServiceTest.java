package com.meli.obtenerdiploma.unit;

import com.meli.obtenerdiploma.model.StudentDTO;
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

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @Mock
    IStudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    @Test
    public void createNewStudentTest(){

        //Arrange
        StudentDTO studentDTO = Utils.getStudentDTO();

        //Act
        studentService.create(studentDTO);

        //Assert
        Mockito.verify(studentDAO, Mockito.atLeastOnce()).save(studentDTO);
    }

    @Test
    public void updateStudentTest(){

        //Arrange
        StudentDTO studentDTO = Utils.getStudentDTO();

        //Act
        studentService.update(studentDTO);

        //Assert
        Mockito.verify(studentDAO, Mockito.atLeastOnce()).save(studentDTO);

    }

    @Test
    public void deleteStudentTest(){

        //Arrange
        long id = 2;

        //Act
        studentService.delete(id);

        //Assert
        Mockito.verify(studentDAO, Mockito.atLeastOnce()).delete(id);
    }

    @Test
    public void readStudentTest(){

        //Arrange
        long id = 2;
        StudentDTO studentDTO = Utils.getStudentDTO();
        when(studentDAO.findById(id)).thenReturn(studentDTO);

        //Act
        StudentDTO received = studentService.read(id);

        //Assert
        Mockito.verify(studentDAO, Mockito.atLeastOnce()).findById(id);
        Assertions.assertEquals(studentDTO, received);
    }

    @Test
    public void getAllStudentTest(){

        //Arrange
        StudentDTO studentDTO1 = Utils.getStudentDTO();
        StudentDTO studentDTO2 = Utils.getStudentDTO();
        Set<StudentDTO> list = new HashSet<>();
        list.add(studentDTO1);
        list.add(studentDTO2);

        Mockito.when(studentRepository.findAll()).thenReturn(list);

        //Act
        Set<StudentDTO> received = studentService.getAll();

        //Assert
        Mockito.verify(studentRepository, Mockito.atLeastOnce()).findAll();
        Assertions.assertEquals(list, received);

    }
}
