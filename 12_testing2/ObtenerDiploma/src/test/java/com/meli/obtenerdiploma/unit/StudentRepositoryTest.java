package com.meli.obtenerdiploma.unit;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentRepositoryTest {
    StudentRepository studentRepository = new StudentRepository();
    @Test
    public void getAllTest() {
        //arrange
        Set<StudentDTO> studentDTOS = new HashSet<>();
        StudentDTO studentDTO = new StudentDTO();
        StudentDTO studentDTO1 = new StudentDTO();
        studentDTOS.add(studentDTO);
        studentDTOS.add(studentDTO1);
        //act
        Set<StudentDTO> received = studentRepository.findAll();
        //assert
        assertEquals(studentDTOS, received);
    }
}
