package com.meli.obtenerdiploma.unit.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

//@ExtendWith(MockitoExtension.class)
public class StudentRepositoryTest {

    // instancia del Repository
    //IStudentRepository studentRepository;
    StudentRepository studentRepository = new StudentRepository();

    @Test
    public void listAllStudents(){
        // arrange
        int expectedSize = 2;

        // act
        Set<StudentDTO> listOfStudents = studentRepository.findAll();
        int actualSize = listOfStudents.size();

        // assert
        assertEquals(expectedSize, actualSize);
    }


}
