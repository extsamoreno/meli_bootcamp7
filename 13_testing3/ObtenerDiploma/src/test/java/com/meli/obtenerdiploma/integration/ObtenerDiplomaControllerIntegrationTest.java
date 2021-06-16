package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.mockito.Mockito.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    IStudentDAO dao;

    @Test
    public void analyzeScoresTest() throws Exception {
        Long id = 1L;
        List<SubjectDTO> subjectDTOS = new ArrayList<>();
        SubjectDTO subject = new SubjectDTO("Matematica", 10.0);
        subjectDTOS.add(subject);
        StudentDTO studentDTO = new StudentDTO(1L, "Pepe", "Pepito", 10.0, subjectDTOS);
        when(dao.findById(id)).thenReturn(studentDTO);
        ObjectMapper objectMapper = new ObjectMapper();

        mockMvc.perform(get("/analyzeScores/{id}", 1))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string(containsString("{\"id\":1,\"studentName\":\"Pepe\",\"message\":")))
                .andExpect(content().string(containsString("Felicitaciones!")))
                .andReturn();
    }

    @Test
    public void analyzeScoresTestBelowTen() throws Exception {
        Long id = 1L;
        List<SubjectDTO> subjectDTOS = new ArrayList<>();
        SubjectDTO subject = new SubjectDTO("Matematica", 8.0);
        SubjectDTO subject2 = new SubjectDTO("Matematica", 9.0);
        subjectDTOS.add(subject);
        subjectDTOS.add(subject2);
        StudentDTO studentDTO = new StudentDTO(1L, "Pepe", "Pepito", 0.0, subjectDTOS);
        when(dao.findById(id)).thenReturn(studentDTO);

        mockMvc.perform(get("/analyzeScores/{id}", 1))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string(containsString("{\"id\":1,\"studentName\":\"Pepe\",\"message\":")))
                .andExpect(content().string(containsString("Puedes mejorar")))
                .andReturn();
    }
}

