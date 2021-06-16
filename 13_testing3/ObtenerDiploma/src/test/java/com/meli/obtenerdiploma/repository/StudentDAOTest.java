package com.meli.obtenerdiploma.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class StudentDAOTest {

    Set<StudentDTO> students = new HashSet<>();
    IStudentDAO studentDAO = new StudentDAO();

    @BeforeEach
    public void setUp() {
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
    public void findById() {
        assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(1L));

    }


    @Test
    public void deleteTest() {
//        boolean result = studentDAO.delete(1L);
        assertFalse(studentDAO.delete(1L));
//        assertThrows(StudentNotFoundException.class, () -> studentDAO.delete(1L));
    }

    @Test
    public void exists() {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(2L);
        boolean result = studentDAO.exists(studentDTO);
        assertTrue(result);
    }
}
