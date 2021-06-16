package com.meli.obtenerdiploma.unit.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.unit.MockHelper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentRepositoryTest {

    @Mock
    private IStudentRepository studentRepository;

    @Test
    public void testFindAllWithExistStudents(){
        //Arrange
        StudentDTO student = MockHelper.getUserMockWithCongrats();
        Set<StudentDTO> expected = new HashSet<>();
        expected.add(student);
        when(studentRepository.findAll()).thenReturn(expected);

        //Act
        Set<StudentDTO> received = studentRepository.findAll();

        //Assert
        verify(studentRepository, atLeastOnce()).findAll();
        assertEquals(expected, received);
    }

    @Test
    public void testFindAllWithoutExistStudents(){
        //Arrange
        Set<StudentDTO> expected = new HashSet<>();
        when(studentRepository.findAll()).thenReturn(expected);

        //Act
        Set<StudentDTO> received = studentRepository.findAll();

        //Assert
        verify(studentRepository, atLeastOnce()).findAll();
        assertEquals(expected, received);

    }

}
