package com.meli.obtenerdiploma.unit;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class StudentRepositoryTest {


    @InjectMocks
    StudentRepository studentRepository;

    @Value("${api.scope}")
    private String SCOPE;

    @Test
    public void findAllTest() throws IOException {

        Set<StudentDTO> expectedStudents = new HashSet<>();

        ObjectMapper objectMapper = new ObjectMapper();

        File file = ResourceUtils.getFile("classpath:users.json");
        expectedStudents = objectMapper.readValue(file, new TypeReference<Set<StudentDTO>>(){});


        Set<StudentDTO> students = studentRepository.findAll();

        students.stream().sorted();
        expectedStudents.stream().sorted();

        assertTrue(students.containsAll(expectedStudents));

    }


}
