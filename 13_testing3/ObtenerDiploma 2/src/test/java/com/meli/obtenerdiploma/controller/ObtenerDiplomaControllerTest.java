package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.Writer;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ObtenerDiplomaControllerTest {

    @Autowired
    private MockMvc mockMvc;
    private ObjectWriter writer;

    @MockBean
    StudentDAO studentDAO;

    @BeforeEach
    public void setup(){
        writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE, false).
                writer().withDefaultPrettyPrinter();
    }

    @Test
    void analyzeScoresTestMessageHonor() throws Exception {
        Long id = 1L;
        StudentDTO studentDTO = new StudentDTO(1L,"JuanC", null, null,
                List.of(new SubjectDTO("Matematicas", 10.0), new SubjectDTO("Español", 8.0)));

        when(studentDAO.findById(id)).thenReturn(studentDTO);
        studentDTO.setMessage("El alumno JuanC ha obtenido un promedio de 9.00. Felicitaciones!");
        studentDTO.setAverageScore(9.00);
        String response = writer.writeValueAsString(studentDTO);
        //act
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", id))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(response))
                .andReturn();
    }

    @Test
    void analyzeScoresTestMessageLowAverage() throws Exception {
        Long id = 1L;
        StudentDTO studentDTO = new StudentDTO(1L,"JuanC", null, null,
                List.of(new SubjectDTO("Matematicas", 0.0), new SubjectDTO("Español", 8.0)));

        when(studentDAO.findById(id)).thenReturn(studentDTO);
        studentDTO.setMessage("El alumno JuanC ha obtenido un promedio de 4.00. Puedes mejorar.");
        studentDTO.setAverageScore(4.00);
        String response = writer.writeValueAsString(studentDTO);
        //act
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", id))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(response))
                .andReturn();
    }
}