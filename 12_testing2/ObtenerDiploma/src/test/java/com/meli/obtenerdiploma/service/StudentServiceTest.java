package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    IStudentRepository studentRepository;

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    StudentService studentService;

    @Test
    public void createTest() {
       Long id = 1L;
       List<SubjectDTO> subjectDTOS = new ArrayList<>();
       SubjectDTO subject = new SubjectDTO("Matematica", 10.0);
       subjectDTOS.add(subject);
       StudentDTO studentDTO = new StudentDTO(1L, "Pepe", "Pepito", 10.0, subjectDTOS);
       studentService.create(studentDTO);
       verify(studentDAO,times(1)).save(studentDTO);
    }

    @Test
    public void readTest() {
        List<SubjectDTO> subjectDTOS = new ArrayList<>();
        SubjectDTO subject = new SubjectDTO("Matematica", 10.0);
        subjectDTOS.add(subject);
        StudentDTO studentDTO = new StudentDTO(1L, "Pepe", "Pepito", 10.0, subjectDTOS);
        when(studentDAO.findById(1L)).thenReturn(studentDTO);
        assertEquals(studentDTO, studentService.read(1L));
    }

    @Test
    public void updateTest() {
        List<SubjectDTO> subjectDTOS = new ArrayList<>();
        SubjectDTO subject = new SubjectDTO("Matematica", 10.0);
        subjectDTOS.add(subject);
        StudentDTO studentDTO = new StudentDTO(1L, "Pepe", "Pepito", 10.0, subjectDTOS);
        studentService.update(studentDTO);
        verify(studentDAO,times(1)).save(studentDTO);
    }

    @Test
    public void deleteTest() {
        studentService.delete(1L);
        verify(studentDAO,times(1)).delete(1L);
    }

    @Test
    public void getAllTest() {
        List<SubjectDTO> subjectDTOS = new ArrayList<>();
        SubjectDTO subject = new SubjectDTO("Matematica", 10.0);
        subjectDTOS.add(subject);
        StudentDTO studentDTO = new StudentDTO(1L, "Pepe", "Pepito", 10.0, subjectDTOS);
        Set<StudentDTO> set = new HashSet<>();
        set.add(studentDTO);
        when(studentRepository.findAll()).thenReturn(set);
        assertEquals(set, studentService.getAll());
    }


}
