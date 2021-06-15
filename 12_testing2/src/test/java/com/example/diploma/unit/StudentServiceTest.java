package com.example.diploma.unit;

import com.example.diploma.exception.StudentNotFoundException;
import com.example.diploma.model.StudentDTO;
import com.example.diploma.model.SubjectDTO;
import com.example.diploma.repository.IStudentDAO;
import com.example.diploma.repository.IStudentRepository;
import com.example.diploma.service.StudentService;
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
    IStudentDAO iStudentDAO;

    @Mock
    IStudentRepository iStudentRepository;

    @InjectMocks
    StudentService studentService;

    //CREATE

    @Test
    public void testCreate() {
        //ARRANGE
        StudentDTO studentDTO = new StudentDTO();
        Mockito.doNothing().when(iStudentDAO).save(studentDTO);

        //ACT
        studentService.create(studentDTO);

        //ASSERT
        Mockito.verify(iStudentDAO, Mockito.atLeast(1)).save(studentDTO);
    }

    //READ

    @Test
    public void testReadExistentStudent(){
        //ARRANGE
        Long id = 1L;
        StudentDTO expected = new StudentDTO(1L, "Juan", null, null, new ArrayList<>() {
            {
                add(new SubjectDTO("Matemática", 9.0));
                add(new SubjectDTO("Física", 7.0));
                add(new SubjectDTO("Química", 6.0));
            }
        });

        Mockito.when(iStudentDAO.findById(id)).thenReturn(expected);

        //ACT
        StudentDTO received = studentService.read(id);

        //ASSERT
        Mockito.verify(iStudentDAO, Mockito.atLeast(1)).findById(id);
        Assertions.assertEquals(expected, received);
    }

    @Test
    public void testReadInexistentStudent() {
        //AARANGE
        Long id = 5L;
        Mockito.when(iStudentDAO.findById(id)).thenThrow(StudentNotFoundException.class);

        //ACT

        //ASSERT
        Assertions.assertThrows(StudentNotFoundException.class,  () -> studentService.read(id));
        Mockito.verify(iStudentDAO, Mockito.atLeast(1)).findById(id);
    }

    @Test
    public void testReadNullStudent() {
        //ARANGE
        Long id = null;
        Mockito.when(iStudentDAO.findById(id)).thenThrow(StudentNotFoundException.class);

        //ACT

        //ASSERT
        Assertions.assertThrows(StudentNotFoundException.class,  () -> studentService.read(id));
        Mockito.verify(iStudentDAO, Mockito.atLeast(1)).findById(id);
    }

    //UPDATE

    @Test
    public void testUpdate() {
        //ARRANGE
        StudentDTO studentDTO = new StudentDTO();
        Mockito.doNothing().when(iStudentDAO).save(studentDTO);

        //ACT
        studentService.update(studentDTO);

        //ASSERT
        Mockito.verify(iStudentDAO, Mockito.atLeast(1)).save(studentDTO);
    }

    //DELETE

    @Test
    public void testDelete() {
        //ARRANGE
        Long id = 1L;
        Mockito.when(iStudentDAO.delete(id)).thenReturn(true);

        //ACT
        studentService.delete(id);

        //ASSERT
        Mockito.verify(iStudentDAO, Mockito.atLeast(1)).delete(id);
    }

    //GET ALL

    @Test
    public void testGetAll() {
        //ARRANGE
        HashSet<StudentDTO> expected = new HashSet<>() {{
            add(new StudentDTO(1L, "Juan", null, null, null));
            add(new StudentDTO(2L, "Pedro", null, null, null));
        }};
        Mockito.when(iStudentRepository.findAll()).thenReturn(expected);

        //ACT
        Set<StudentDTO> received = studentService.getAll();

        //ASSERT
        Assertions.assertEquals(expected, received);
    }

}
