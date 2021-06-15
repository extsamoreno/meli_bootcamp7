package com.meli.obtenerdiploma.unit;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class StudentRepositoryTest {
    StudentRepository studentRepository = new StudentRepository();

    @Test
    public void listAllStudentsHappyPath() {
        //Arrange

        //Act
        Set<StudentDTO> list = studentRepository.findAll();

        //Assert
        Assertions.assertEquals(2,list.size());
    }
}
