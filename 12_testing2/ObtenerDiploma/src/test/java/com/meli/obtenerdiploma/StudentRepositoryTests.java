package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class StudentRepositoryTests {
    private StudentRepository studentRepository;

    public StudentRepositoryTests() {
        this.studentRepository = new StudentRepository();
    }

    @Test
    public void findAllOkTest() {
        Set<StudentDTO> received = studentRepository.findAll();

        Assertions.assertNotNull(received);
    }
}
