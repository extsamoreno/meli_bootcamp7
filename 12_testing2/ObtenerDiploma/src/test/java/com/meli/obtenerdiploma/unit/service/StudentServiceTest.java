package com.meli.obtenerdiploma.unit.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
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
    public void create() {
        //arrange
        StudentDTO studentDTO = new StudentDTO();
        Mockito.doNothing().when(studentDAO).save(studentDTO);

        //act
        studentService.create(studentDTO);

        //assert
        Mockito.verify(studentDAO, Mockito.atLeast(1)).save(studentDTO);
    }

    @Test
    public void readHappyPath() {
        //arrange
        Long id = 1L;
        StudentDTO expected = new StudentDTO(1L, "Juan", null, null, new ArrayList<>() {
            {
                add(new SubjectDTO("Matemática", 9.0));
                add(new SubjectDTO("Física", 7.0));
                add(new SubjectDTO("Química", 6.0));
            }
        });

        Mockito.when(studentDAO.findById(id)).thenReturn(expected);

        //act
        StudentDTO received = studentService.read(id);

        //assert
        Mockito.verify(studentDAO, Mockito.atLeast(1)).findById(id);
        Assertions.assertEquals(expected, received);
    }

    @Test
    public void readThrowStudentNotFoundException() {
        //arrange
        Long id = 4L;

        Mockito.when(studentDAO.findById(id)).thenThrow(StudentNotFoundException.class);

        //act

        //assert
        Assertions.assertThrows(StudentNotFoundException.class, () -> studentService.read(id));
        Mockito.verify(studentDAO, Mockito.atLeast(1)).findById(id);
    }

    @Test
    public void update() {
        //arrange
        StudentDTO studentDTO = new StudentDTO();
        Mockito.doNothing().when(studentDAO).save(studentDTO);

        //act
        studentService.update(studentDTO);

        //assert
        Mockito.verify(studentDAO, Mockito.atLeast(1)).save(studentDTO);
    }

    @Test
    public void delete() {
        //arrange
        Long id = 1L;
        Mockito.when(studentDAO.delete(id)).thenReturn(true);

        //act
        studentService.delete(id);

        //assert
        Mockito.verify(studentDAO, Mockito.atLeast(1)).delete(id);
    }

    @Test
    public void fidAll(){
        //arrange
        StudentDTO student1 = new StudentDTO(1L, "Juan", null, null, new ArrayList<>() {
            {
                add(new SubjectDTO("Matemática", 9.0));
                add(new SubjectDTO("Física", 7.0));
                add(new SubjectDTO("Química", 6.0));
            }
        });

        StudentDTO student2 = new StudentDTO(2L, "Pedro", null, null, new ArrayList<>() {
            {
                add(new SubjectDTO("Matemática", 10.0));
                add(new SubjectDTO("Física", 8.0));
                add(new SubjectDTO("Química", 4.0));
            }
        });

        //arrange
        Set<StudentDTO> expected = new HashSet<>();
        expected.add(student1);
        expected.add(student2);
        Mockito.when(studentRepository.findAll()).thenReturn(expected);


        //act
        Set<StudentDTO> received = studentService.getAll();

        //assert
        Assertions.assertEquals(expected, received);

    }

}
