package com.example.diploma.unit;

import com.example.diploma.model.StudentDTO;
import com.example.diploma.model.SubjectDTO;
import com.example.diploma.repository.IStudentRepository;
import com.example.diploma.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class StudentRepositoryTest {
    IStudentRepository studentRepository = new StudentRepository();

    @Test
    public void findAll() {
        //ARRANGE
        StudentDTO student1 = new StudentDTO(1L, "Juan", null, null, new ArrayList<>() {
            {
                add(new SubjectDTO("Matemática", 9.0));
                add(new SubjectDTO("Física", 7.0));
                add(new SubjectDTO("Química", 6.0));
            }
        });

        StudentDTO student2 = new StudentDTO(2L, "Pedro", null, null, new ArrayList<>() {
            {
                add(new SubjectDTO("Matemática", 10.0));
                add(new SubjectDTO("Física", 8.0));
                add(new SubjectDTO("Química", 4.0));
            }
        });

        Set<StudentDTO> expected = new HashSet<>();
        expected.add(student1);
        expected.add(student2);

        //ACT
        Set<StudentDTO> received = studentRepository.findAll();

        //ASSERT
        Assertions.assertEquals(expected, received);
    }
}
