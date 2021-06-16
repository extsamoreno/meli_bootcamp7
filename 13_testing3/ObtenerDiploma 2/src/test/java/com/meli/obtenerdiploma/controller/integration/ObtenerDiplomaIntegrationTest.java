package com.meli.obtenerdiploma.controller.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testAnalyzeScoresWithCorrectId() throws Exception {

        StudentDTO student = new StudentDTO(1L, "Juan", null, null, new ArrayList<>() {
            {
                add(new SubjectDTO("Matemática", 9.0));
                add(new SubjectDTO("Física", 7.0));
                add(new SubjectDTO("Química", 6.0));
            }
        });

        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE, false).
                writer().withDefaultPrettyPrinter();
        String payloadJson = writer.writeValueAsString(student);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}",1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string(containsString("{\"id\":1,\"studentName\":\"Juan\",\"message\":\"El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar.\",\"averageScore\":7.333333333333333,\"subjects\":[{\"name\":\"MatemÃ¡tica\",\"score\":9.0},{\"name\":\"FÃ\u00ADsica\",\"score\":7.0},{\"name\":\"QuÃ\u00ADmica\",\"score\":6.0}]}")))
                .andReturn();

    }

    @Test
    public void testAnalyzeScoresWithUnknownId() throws Exception {

        StudentDTO student = new StudentDTO(10L, "Juan", null, null, new ArrayList<>() {
            {
                add(new SubjectDTO("Matemática", 9.0));
                add(new SubjectDTO("Física", 7.0));
                add(new SubjectDTO("Química", 6.0));
            }
        });

        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE, false).
                writer().withDefaultPrettyPrinter();
        String payloadJson = writer.writeValueAsString(student);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}",10)
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andReturn();

    }
}
