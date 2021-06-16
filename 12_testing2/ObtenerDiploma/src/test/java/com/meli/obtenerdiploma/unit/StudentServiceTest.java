package com.meli.obtenerdiploma.unit;


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
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;



@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    IStudentDAO iStudentDAO;
    @Mock
    IStudentRepository iStudentRepository;

    @InjectMocks
    StudentService studentService;


    @Test
    public void testForDeleteUser(){
        // arrange
        Long id= 1L;

        // act
        studentService.delete(id);
        // assert
        Mockito.verify(iStudentDAO, times(1)).delete(id);
    }

    @Test
    public void testForReadUser(){
        // arrange
        Long id=1L;
        SubjectDTO s1 = new SubjectDTO("Matemática",10.0);
        SubjectDTO s2 = new SubjectDTO("Física",8.0);
        SubjectDTO s3 = new SubjectDTO("Química",4.0);

        List<SubjectDTO> sujects = new ArrayList<>();
        sujects.add(s1);sujects.add(s2);sujects.add(s3);

        StudentDTO student = new StudentDTO(id,"Pedro", null, null, sujects);
        Mockito.when(studentService.read(id)).thenReturn(student);
        // act
        StudentDTO received=studentService.read(id);
        // assert
        Mockito.verify(iStudentDAO, times(1)).findById(id);
        Assertions.assertEquals(student,received);
    }


}
