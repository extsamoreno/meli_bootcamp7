package com.meli.obtenerdiploma.unit.controller;

import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
import com.meli.obtenerdiploma.controller.StudentController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

    @Mock
    IStudentService studentService;

    @InjectMocks
    StudentController studentController;

    // Registrar Nuevo Estudiente
    @Test
    public void registerStudentVerifyService() {
        // arrange
        // Nuevo alumno
        SubjectDTO subjectDTO1 = new SubjectDTO("Matemática", 10.0);
        SubjectDTO subjectDTO2 = new SubjectDTO("Física", 9.0);
        SubjectDTO subjectDTO3 = new SubjectDTO("Química", 10.0);
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(subjectDTO1);
        subjects.add(subjectDTO2);
        subjects.add(subjectDTO3);

        StudentDTO newStudent = new StudentDTO();
        newStudent.setStudentName("Yisel");
        newStudent.setSubjects(subjects);

        // act
        ResponseEntity<?> received = studentController.registerStudent(newStudent);

        // assert
        Mockito.verify(studentService,Mockito.atLeastOnce()).create(newStudent);
    }


    // Registrar Nuevo Estudiente
    @Test
    public void registerStudentCheckData() {
        // arrange
        // Nuevo alumno
        SubjectDTO subjectDTO1 = new SubjectDTO("Matemática", 10.0);
        SubjectDTO subjectDTO2 = new SubjectDTO("Física", 9.0);
        SubjectDTO subjectDTO3 = new SubjectDTO("Química", 10.0);
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(subjectDTO1);
        subjects.add(subjectDTO2);
        subjects.add(subjectDTO3);

        StudentDTO newStudent = new StudentDTO();
        newStudent.setStudentName("Yisel");
        newStudent.setSubjects(subjects);

        // act
        ResponseEntity<?> received = studentController.registerStudent(newStudent);

        // assert
        assertNull(received.getBody());
    }


    // Registrar Nuevo Estudiente
    @Test
    public void registerStudentCheckStatus() {
        // arrange
        // Nuevo alumno
        SubjectDTO subjectDTO1 = new SubjectDTO("Matemática", 10.0);
        SubjectDTO subjectDTO2 = new SubjectDTO("Física", 9.0);
        SubjectDTO subjectDTO3 = new SubjectDTO("Química", 10.0);
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(subjectDTO1);
        subjects.add(subjectDTO2);
        subjects.add(subjectDTO3);

        StudentDTO newStudent = new StudentDTO();
        newStudent.setStudentName("Yisel");
        newStudent.setSubjects(subjects);

        // act
        ResponseEntity<?> received = studentController.registerStudent(newStudent);

        // assert
        assertEquals(HttpStatus.OK, received.getStatusCode());
    }


    //Obtener los datos de un alumno buscando por Id.
    @Test
    public void getStudentByIdCompareData(){
        //arrange
        SubjectDTO subjectDTO1 = new SubjectDTO("Matemática", 10.0);
        SubjectDTO subjectDTO2 = new SubjectDTO("Física", 8.0);
        SubjectDTO subjectDTO3 = new SubjectDTO("Química", 10.0);
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(subjectDTO1);
        subjects.add(subjectDTO2);
        subjects.add(subjectDTO3);

        Long studentId = Long.valueOf(2);
        StudentDTO expected = new StudentDTO();
        expected.setId(2L);
        expected.setStudentName("Pedro");
        expected.setSubjects(subjects);

        Mockito.when(studentService.read(studentId)).thenReturn(expected);

        //act
        StudentDTO received = studentController.getStudent(studentId);

        //assert
        assertEquals(expected, received);
    }


    // Eliminar un alumno.
    @Test
    public void removeStudentCheckStatus(){
        // arrange
        Long studentId = Long.valueOf(2);

        // act
        ResponseEntity<?> received = studentController.removeStudent(studentId);

        // assert
        assertEquals(HttpStatus.OK, received.getStatusCode());
    }


    // Eliminar un alumno.
    @Test
    public void removeStudentVerifyService(){
        // arrange
        Long studentId = Long.valueOf(2);

        // act
        ResponseEntity<?> received = studentController.removeStudent(studentId);

        // assert
        Mockito.verify(studentService,Mockito.atLeastOnce()).delete(studentId);

    }


    // Obtener todos los Students
    @Test
    public void listAllStudentsVerifyService(){
        // arrange

        // act
        Set<StudentDTO> studentsList = studentController.listStudents();

        // assert
        Mockito.verify(studentService,Mockito.atLeastOnce()).getAll();
    }


    // Obtener todos los Students
    @Test
    public void listAllStudentsCompareData(){
        // arrange

        // Estudiente 1
        SubjectDTO subjectDTO1_1 = new SubjectDTO("Matemática", 9.0);
        SubjectDTO subjectDTO2_1 = new SubjectDTO("Física", 7.0);
        SubjectDTO subjectDTO3_1 = new SubjectDTO("Química", 6.0);
        List<SubjectDTO> subjects1 = new ArrayList<>();
        subjects1.add(subjectDTO1_1);
        subjects1.add(subjectDTO2_1);
        subjects1.add(subjectDTO3_1);
        StudentDTO student1 = new StudentDTO();
        student1.setStudentName("Juan");
        student1.setId(1L);
        student1.setSubjects(subjects1);

        // Estudiente 2
        SubjectDTO subjectDTO1_2 = new SubjectDTO("Matemática", 10.0);
        SubjectDTO subjectDTO2_2 = new SubjectDTO("Física", 8.0);
        SubjectDTO subjectDTO3_2 = new SubjectDTO("Química", 10.0);
        List<SubjectDTO> subjects2 = new ArrayList<>();
        subjects1.add(subjectDTO1_2);
        subjects1.add(subjectDTO2_2);
        subjects1.add(subjectDTO3_2);
        StudentDTO student2 = new StudentDTO();
        student1.setStudentName("Pedro");
        student1.setId(2L);
        student1.setSubjects(subjects2);

        Set<StudentDTO> expectedList = new HashSet<>();
        expectedList.add(student1);
        expectedList.add(student2);

        Mockito.when(studentService.getAll()).thenReturn(expectedList);

        // act
        Set<StudentDTO> actualList = studentService.getAll();

        // assert
        assertEquals(expectedList, actualList);
    }

}
