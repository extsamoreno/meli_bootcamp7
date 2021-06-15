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

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {
    @Mock
    IStudentDAO iStudentDAO;

    @Mock
    IStudentRepository iStudentRepository;

    @InjectMocks
    StudentService studentService;

    //TODO: Esta bien no tener assertions en estos tests?
    @Test
    public void createNewStudentHappyPath() {
        //Arrange
        StudentDTO studentDTO = Utils.getStudentDTO();

        //Act
        studentService.create(studentDTO);

        //Assert
        Mockito.verify(iStudentDAO, Mockito.atLeastOnce()).save(studentDTO);
    }

    @Test
    public void updateStudentHappyPath() {
        //Arrange
        StudentDTO studentDTO = Utils.getStudentDTO();

        //Act
        studentService.update(studentDTO);

        //Assert
        Mockito.verify(iStudentDAO, Mockito.atLeastOnce()).save(studentDTO);
    }

    @Test
    public void deleteStudentHappyPath() {
        //Arrange
        Long id = 2L;

        //Act
        studentService.delete(id);

        //Assert
        Mockito.verify(iStudentDAO, Mockito.atLeastOnce()).delete(id);
    }

    @Test
    public void readStudentHappyPath() {
        //Arrange
        StudentDTO studentDTO = Utils.getStudentDTO();
        Long id = 2L;
        Mockito.when(iStudentDAO.findById(id)).thenReturn(studentDTO);

        //Act
        StudentDTO received = studentService.read(id);

        //Assert
        Mockito.verify(iStudentDAO, Mockito.atLeastOnce()).findById(id);
        Assertions.assertEquals(studentDTO, received);
    }


    @Test
    public void getAllStudentHappyPath() {
        //Arrange
        StudentDTO studentDTO1 = Utils.getStudentDTO();
        StudentDTO studentDTO2 = Utils.getStudentDTO();
        Set<StudentDTO> list = new HashSet<>();
        list.add(studentDTO1);
        list.add(studentDTO2);

        Mockito.when(iStudentRepository.findAll()).thenReturn(list);

        //Act
        Set<StudentDTO> received = studentService.getAll();

        //Assert
        Mockito.verify(iStudentRepository, Mockito.atLeastOnce()).findAll();
        Assertions.assertEquals(list, received);
    }
}
