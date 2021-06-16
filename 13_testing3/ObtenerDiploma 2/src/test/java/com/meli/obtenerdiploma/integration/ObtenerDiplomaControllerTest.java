package com.meli.obtenerdiploma.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ObtenerDiplomaControllerTest {

    @Autowired
    MockMvc mockMvc;


    @Test
    void analyzeScoresTestHappyPath() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}",1))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string(containsString("{\"id\":1,\"studentName\":\"Juan\",\"message\":\"El alumno Juan ha obtenido un promedio de 7,33. Puedes mejorar.\",\"averageScore\":7.333333333333333,\"subjects\":[{\"name\":\"MatemÃ¡tica\",\"score\":9.0},{\"name\":\"FÃ\u00ADsica\",\"score\":7.0},{\"name\":\"QuÃ\u00ADmica\",\"score\":6.0}]}")))
                .andReturn();

        System.out.println("test");
    }

    @Test
    void analyzeScoresTestNotFound() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}",10))
                .andDo(print()).andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string(containsString("{\"name\":\"StudentNotFoundException\",\"description\":\"El alumno con Id 10 no se encuetra registrado.\"}")))
                .andReturn();

        System.out.println("test");
    }
}