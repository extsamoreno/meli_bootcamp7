package com.meli.obtenerdiploma.units;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentRepository;
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
import java.util.List;
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
    public void createTest() {
        long id = 2;

        List<SubjectDTO> subj2 = new ArrayList<>();
        subj2.add(new SubjectDTO("Matemática", 10.00));
        subj2.add(new SubjectDTO("Física", 8.00));
        subj2.add(new SubjectDTO("Química", 4.00));
        StudentDTO student = new StudentDTO(2L, "Pedro", null, null, subj2);

        //act
        studentService.create(student);

        //asert
        Mockito.verify(studentDAO,Mockito.atLeast(1)).save(student);
    }

    @Test
    public void readTest() {
        long id = 1;
        List<SubjectDTO> subj2 = new ArrayList<>();
        subj2.add(new SubjectDTO("Matemática", 9.0));
        subj2.add(new SubjectDTO("Física", 7.0));
        subj2.add(new SubjectDTO("Química", 6.0));
        StudentDTO student = new StudentDTO(1L, "Juan", null, null, subj2);

        Mockito.when(studentDAO.findById(id)).thenReturn(student);

        StudentDTO received = studentService.read(id);

        Mockito.verify(studentDAO,Mockito.atLeast(1)).findById(id);
        Assertions.assertEquals(student,received);
    }

    public void updateTest() {
        long id = 2;

        List<SubjectDTO> subj2 = new ArrayList<>();
        subj2.add(new SubjectDTO("Matemática", 10.00));
        subj2.add(new SubjectDTO("Física", 8.00));
        subj2.add(new SubjectDTO("Química", 4.00));
        StudentDTO student = new StudentDTO(2L, "Pedro", null, null, subj2);

        //act
        studentService.update(student);

        //asert
        Mockito.verify(studentDAO,Mockito.atLeast(1)).save(student);

    }

    @Test
    public void deleteTest(){
        long id = 2;

        List<SubjectDTO> subj2 = new ArrayList<>();
        subj2.add(new SubjectDTO("Matemática", 10.00));
        subj2.add(new SubjectDTO("Física", 8.00));
        subj2.add(new SubjectDTO("Química", 4.00));
        StudentDTO student = new StudentDTO(2L, "Pedro", null, null, subj2);

        Mockito.when(studentDAO.delete(id)).thenReturn(true);

        //act
        studentService.delete(id);

        //assert
        Mockito.verify(studentDAO,Mockito.atLeast(1)).delete(id);
    }


    @Test
    public void getAllTest() {

        Set<StudentDTO> expected = new HashSet<>();
        List<SubjectDTO> subjects1 = new ArrayList<>();
        subjects1.add(new SubjectDTO("Matemática",9.0));
        subjects1.add(new SubjectDTO("Fisica",7.0));
        subjects1.add(new SubjectDTO("Quimica",6.0));
        List<SubjectDTO> subjects2 = new ArrayList<>();
        subjects2.add(new SubjectDTO("Matemática",10.0));
        subjects2.add(new SubjectDTO("Fisica",8.0));
        subjects2.add(new SubjectDTO("Quimica",4.0));

        //arange
        expected.add(
                new StudentDTO(1L,"Juan",null,null,subjects1)
        );
        expected.add(
                new StudentDTO(2L,"Pedro",null,null,subjects2)
        );

        Mockito.when(studentRepository.findAll()).thenReturn(expected);

        //act
        Set<StudentDTO> received = studentService.getAll();

        Mockito.verify(studentRepository,Mockito.atLeast(1)).findAll();
        Assertions.assertEquals(expected,received);
    }



}
