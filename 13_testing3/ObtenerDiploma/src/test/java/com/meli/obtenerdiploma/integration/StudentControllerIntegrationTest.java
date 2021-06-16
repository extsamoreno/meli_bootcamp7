package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.mockito.Mockito.*;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    IStudentRepository repository;

    @MockBean
    IStudentDAO dao;

    @Test
    public void registerStudent() throws Exception {
        List<SubjectDTO> subjectDTOS = new ArrayList<>();
        SubjectDTO subject = new SubjectDTO("Matematica", 8.0);
        SubjectDTO subject2 = new SubjectDTO("Matematica", 9.0);
        subjectDTOS.add(subject);
        subjectDTOS.add(subject2);
        StudentDTO studentDTO = new StudentDTO(1L, "Pepe", "Pepito", 0.0, subjectDTOS);
        ObjectMapper objectMapper = new ObjectMapper();
        String request = objectMapper.writeValueAsString(studentDTO);

        mockMvc.perform(post("/student/registerStudent")
                .content(request).contentType("application/json"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void getStudentTest() throws Exception {
        List<SubjectDTO> subjectDTOS = new ArrayList<>();
        SubjectDTO subject = new SubjectDTO("Matematica", 8.0);
        SubjectDTO subject2 = new SubjectDTO("Matematica", 9.0);
        subjectDTOS.add(subject);
        subjectDTOS.add(subject2);
        StudentDTO studentDTO = new StudentDTO(1L, "Pepe", "Pepito", 0.0, subjectDTOS);
        when(dao.findById(1L)).thenReturn(studentDTO);
        ObjectMapper objectMapper = new ObjectMapper();
        String response = objectMapper.writeValueAsString(studentDTO);

        mockMvc.perform(get("/student/getStudent/{id}", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(response)))
                .andReturn();
    }

    @Test
    public void modifyStudentTest() throws Exception {
        List<SubjectDTO> subjectDTOS = new ArrayList<>();
        SubjectDTO subject = new SubjectDTO("Matematica", 8.0);
        SubjectDTO subject2 = new SubjectDTO("Matematica", 9.0);
        subjectDTOS.add(subject);
        subjectDTOS.add(subject2);
        StudentDTO studentDTO = new StudentDTO(1L, "Pepe", "Pepito", 0.0, subjectDTOS);
        ObjectMapper objectMapper = new ObjectMapper();
        String request = objectMapper.writeValueAsString(studentDTO);

        mockMvc.perform(post("/student/modifyStudent")
                .content(request).contentType("application/json"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void removeStudentTest() throws Exception {

        mockMvc.perform(get("/student/removeStudent/{id}", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void listStudents() throws Exception {
        List<SubjectDTO> subjectDTOS = new ArrayList<>();
        SubjectDTO subject = new SubjectDTO("Matematica", 10.0);
        subjectDTOS.add(subject);
        StudentDTO studentDTO = new StudentDTO(1L, "Pepe", "Pepito", 10.0, subjectDTOS);
        Set<StudentDTO> set = new HashSet<>();
        set.add(studentDTO);
        ObjectMapper objectMapper = new ObjectMapper();
        String response = objectMapper.writeValueAsString(set);

        when(repository.findAll()).thenReturn(set);

        mockMvc.perform(get("/student/listStudents"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string(containsString(response)))
                .andReturn();
    }
}
