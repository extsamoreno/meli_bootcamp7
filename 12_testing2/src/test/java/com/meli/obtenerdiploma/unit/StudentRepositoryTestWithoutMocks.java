package com.meli.obtenerdiploma.unit;


import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class StudentRepositoryTestWithoutMocks {

    @Test
    public void findAllTestNotNull(){

        StudentRepository studentRepository = new StudentRepository();

        //act
        Set<StudentDTO> received = studentRepository.findAll();

        //assert
        Assertions.assertNotNull(received);
    }

    @Test
    public void findAllTestNotEmpty(){

        //arrange
        StudentRepository studentRepository = new StudentRepository();

        //act
        Set<StudentDTO> received = studentRepository.findAll();

        //assert
        Assertions.assertFalse(received.isEmpty());
    }

    @Test
    public void findStudentById(){

        //arrange
        StudentRepository studentRepository = new StudentRepository();

        //act
        Set<StudentDTO> received = studentRepository.findAll();

        //assert
        Assertions.assertFalse(received.isEmpty());
    }


}
