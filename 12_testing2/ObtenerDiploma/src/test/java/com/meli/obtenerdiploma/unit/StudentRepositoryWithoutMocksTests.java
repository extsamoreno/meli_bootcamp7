package com.meli.obtenerdiploma.unit;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StudentRepositoryWithoutMocksTests {

    @Test
    public void findAllTest() {
        Set<StudentDTO> expected = new HashSet<>();
        Set<StudentDTO> real;
        IStudentRepository iStudentRepository = new StudentRepository();

        List<SubjectDTO> subj1 = new ArrayList<>();
        subj1.add(new SubjectDTO("Matemática", 9.00));
        subj1.add(new SubjectDTO("Física", 7.00));
        subj1.add(new SubjectDTO("Química", 6.00));
        List<SubjectDTO> subj2 = new ArrayList<>();
        subj2.add(new SubjectDTO("Matemática", 10.00));
        subj2.add(new SubjectDTO("Física", 8.00));
        subj2.add(new SubjectDTO("Química", 4.00));

        expected.add(new StudentDTO(1L, "Juan", null, null, subj1));
        expected.add(new StudentDTO(2L, "Pedro", null, null, subj2));

        real = iStudentRepository.findAll();

        Assertions.assertEquals(expected, real);
    }
}
