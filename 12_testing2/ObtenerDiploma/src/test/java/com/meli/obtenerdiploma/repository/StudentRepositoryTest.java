package com.meli.obtenerdiploma.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class StudentRepositoryTest {

    Set<StudentDTO> students = new HashSet<>();

    IStudentRepository studentRepository = new StudentRepository();

    @BeforeEach
    public void setUp() {
        ReflectionTestUtils.setField(studentRepository, "SCOPE", "main");
        ObjectMapper objectMapper = new ObjectMapper();
        File file;
        try {
            file = ResourceUtils.getFile("./src/main/resources/users.json");
            this.students = objectMapper.readValue(file, new TypeReference<Set<StudentDTO>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findAllTest() {
        assertEquals(this.students.size(), studentRepository.findAll().size());
    }

}
