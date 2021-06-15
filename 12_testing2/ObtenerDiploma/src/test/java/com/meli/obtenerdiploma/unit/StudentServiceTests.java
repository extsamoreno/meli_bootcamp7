package com.meli.obtenerdiploma.unit;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTests {

    @Mock
    IStudentDAO studentDAO;
    @Mock
    IStudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    @Test
    public void createNewStudentHappyPath() {
        //arr
        StudentDTO studentDTO = Utils.getStudentDTO();
        // act
        studentService.create(studentDTO);
        //assert
        Mockito.verify(studentDAO, Mockito.atLeastOnce()).save(studentDTO);
    }

    @Test
    public void updateStudentHappyPath() {
        //arr
        StudentDTO studentDTO = Utils.getStudentDTO();
        // act
        studentService.update(studentDTO);
        //assert
        Mockito.verify(studentDAO, Mockito.atLeastOnce()).save(studentDTO);
    }

    @Test
    public void deleteStudentHappyPath() {
        //arr
        Long id = 2L;
        // act
        studentService.delete(id);
        //assert
        Mockito.verify(studentDAO, Mockito.atLeastOnce()).delete(id);
    }

    @Test
    public void readStudentHappyPath() {
        //arr
        StudentDTO studentDTO = Utils.getStudentDTO();
        Long id = 2L;
        Mockito.when(studentDAO.findById(id)).thenReturn(studentDTO);
        // act
        StudentDTO received = studentService.read(id);
        //assert
        Mockito.verify(studentDAO, Mockito.atLeastOnce()).findById(id);
        assertEquals(studentDTO, received);
    }


    @Test
    public void getAllStudentHappyPath() {
        //arr
        StudentDTO studentDTO1 = Utils.getStudentDTO();
        StudentDTO studentDTO2 = Utils.getStudentDTO();
        Set<StudentDTO> list = new HashSet<>();
        list.add(studentDTO1);
        list.add(studentDTO2);

        Mockito.when(studentRepository.findAll()).thenReturn(list);
        // act
        Set<StudentDTO> received = studentService.getAll();
        //assert
        Mockito.verify(studentRepository, Mockito.atLeastOnce()).findAll();
        assertEquals(list, received);
    }

}
