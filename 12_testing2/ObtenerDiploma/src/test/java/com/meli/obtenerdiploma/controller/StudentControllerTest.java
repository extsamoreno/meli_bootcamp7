package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

    @Mock
    IStudentService studentService;

    @InjectMocks
    StudentController controller;

    @Test
    public void registerStudentTest() {
        List<SubjectDTO> subjectDTOS = new ArrayList<>();
        SubjectDTO subject = new SubjectDTO("Matematica", 10.0);
        subjectDTOS.add(subject);
        StudentDTO studentDTO = new StudentDTO(1L, "Pepe", "Pepito", 10.0, subjectDTOS);
        assertEquals(ResponseEntity.ok(null), controller.registerStudent(studentDTO));
    }

    @Test
    public void getStudentTest() {
        List<SubjectDTO> subjectDTOS = new ArrayList<>();
        SubjectDTO subject = new SubjectDTO("Matematica", 10.0);
        subjectDTOS.add(subject);
        StudentDTO studentDTO = new StudentDTO(1L, "Pepe", "Pepito", 10.0, subjectDTOS);
        when(studentService.read(1L)).thenReturn(studentDTO);
        assertEquals(studentDTO, controller.getStudent(1L));
    }

    @Test
    public void modifyStudentTest() {
        List<SubjectDTO> subjectDTOS = new ArrayList<>();
        SubjectDTO subject = new SubjectDTO("Matematica", 10.0);
        subjectDTOS.add(subject);
        StudentDTO studentDTO = new StudentDTO(1L, "Pepe", "Pepito", 10.0, subjectDTOS);
        assertEquals(ResponseEntity.ok(null), controller.modifyStudent(studentDTO));
    }

    @Test
    public void removeStudentTest() {
        assertEquals(ResponseEntity.ok(null), controller.removeStudent(1L));
    }

    @Test
    public void listStudentsTest() {
        Set<StudentDTO> set = new HashSet<>();
        List<SubjectDTO> subjectDTOS = new ArrayList<>();
        SubjectDTO subject = new SubjectDTO("Matematica", 10.0);
        subjectDTOS.add(subject);
        StudentDTO studentDTO = new StudentDTO(1L, "Pepe", "Pepito", 10.0, subjectDTOS);
        set.add(studentDTO);
        when(studentService.getAll()).thenReturn(set);
        assertEquals(set, controller.listStudents());
    }
}
