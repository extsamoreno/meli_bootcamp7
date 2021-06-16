package com.meli.obtenerdiploma.unit.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @Mock
    IStudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;


    // Crear un nuevo alumno.
    @Test
    public void createStudentVerifyStudentDAO(){

        // arrange
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

        Mockito.doNothing().when(studentDAO).save(newStudent);

        //int expectedSize = 3;

        // act
        studentService.create(newStudent);
        //int actualSize = studentDAO. .getStudents().size();

        // assert
        //Mockito.verify(studentDAO,Mockito.atLeastOnce()).save(newStudent);
        //assertTrue(studentDAO.exists(newStudent));
        //StudentDTO received = studentDAO.findById(3L);
        //assertEquals(newStudent, received);
    }


    //Leer los datos de un alumno buscando por Id.
    @Test
    public void readStudentByIdCompareData(){
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

        Mockito.when(studentDAO.findById(studentId)).thenReturn(expected);

        //act
        StudentDTO received = studentService.read(studentId);

        //assert
        assertEquals(expected, received);
    }


    @Test
    public void readStudentByIdVerifyStudentDAO(){
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

        Mockito.when(studentDAO.findById(studentId)).thenReturn(expected);


        //act
        StudentDTO received = studentService.read(studentId);

        //assert
        Mockito.verify(studentDAO,Mockito.atLeastOnce()).findById(studentId);
    }


    //Modificar los datos de un alumno.
    @Test
    public void updateStudentData(){
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
        expected.setStudentName("Kakaroto");
        expected.setSubjects(subjects);

        //Mockito.when(studentDAO.findById(studentId)).;

        // act
        studentService.update(expected);

        /*
        StudentDTO modifidedStudent = studentDAO.findById(studentId);
        modifidedStudent.setStudentName(newName);
        studentDAO.save(modifidedStudent);
        //int actualSize = studentDAO.getStudents().size();
         */

        // assert
        Mockito.verify(studentDAO,Mockito.atLeastOnce()).save(expected);
    }


    // Eliminar un alumno.
    @Test
    public void deleteStudent(){
        // arrange
        Long studentId = Long.valueOf(2);

        // act
        studentService.delete(studentId);

        // assert
        Mockito.verify(studentDAO,Mockito.atLeastOnce()).delete(studentId);
    }


    // Obtener todos los Students
    @Test
    public void getAllStudentsVerifyStudentDAO(){
        // arrange

        // act
        Set<StudentDTO> studentsList = studentService.getAll();

        // assert
        Mockito.verify(studentRepository,Mockito.atLeastOnce()).findAll();
    }


    // Obtener todos los Students
    @Test
    public void getAllStudentsCompareData(){
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

        Mockito.when(studentRepository.findAll()).thenReturn(expectedList);

        // act
        Set<StudentDTO> actualList = studentService.getAll();

        // assert
        assertEquals(expectedList, actualList);

    }

}
