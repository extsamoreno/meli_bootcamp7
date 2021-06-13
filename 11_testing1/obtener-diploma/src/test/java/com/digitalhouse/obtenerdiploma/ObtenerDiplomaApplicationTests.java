package com.digitalhouse.obtenerdiploma;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ObtenerDiplomaApplicationTests {
  @Autowired
  private MockMvc mockMvc;
/*
  @Test
  void analyzeNotesBadAverageTest() throws Exception {
    String request = "{\"name\": \"Rodrigo Díaz de Vivar\", \"subjects\": [" +
            "        {\"subject\":\"Paradigmas de Programación\",\"note\": 8}," +
            "        {\"subject\":\"Diseño\",\"note\": 5}," +
            "{\"subject\":\"Programación Avanzada\",\"note\": 9}," +
            "{\"subject\":\"Inteligencia Artificial\",\"note\": 7}," +
            "{\"subject\":\"Matemática Superior\",\"note\": 10}" +
            "]" +
            "}" ;
    this.mockMvc.perform(
            post("/analyzeNotes")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(request))
            .andDo(print()).andExpect(status().isOk())
            .andExpect(jsonPath("$.average").value(7.8));
  }

  @Test
  void analyzeNotesBadMessageTest() throws Exception {
    String request = "{\"name\": \"Rodrigo Díaz de Vivar\", \"subjects\": [" +
            "        {\"subject\":\"Paradigmas de Programación\",\"note\": 8}," +
            "        {\"subject\":\"Diseño\",\"note\": 5}," +
            "{\"subject\":\"Programación Avanzada\",\"note\": 9}," +
            "{\"subject\":\"Inteligencia Artificial\",\"note\": 7}," +
            "{\"subject\":\"Matemática Superior\",\"note\": 10}" +
            "]" +
            "}" ;
    this.mockMvc.perform(
        post("/analyzeNotes")
            .contentType(MediaType.APPLICATION_JSON)
            .content(request))
        .andDo(print()).andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Rodrigo Díaz de Vivar usted ha conseguido el promedio de 7.8"));
  }

  @Test
  void analyzeNotesGoodAverageTest() throws Exception {
    String request = "{\"name\": \"Genghis Kan\", \"subjects\": [" +
            "        {\"subject\":\"Paradigmas de Programación\",\"note\": 8}," +
            "        {\"subject\":\"Diseño\",\"note\": 10}," +
            "{\"subject\":\"Programación Avanzada\",\"note\": 9}," +
            "{\"subject\":\"Inteligencia Artificial\",\"note\": 9}," +
            "{\"subject\":\"Matemática Superior\",\"note\": 10}" +
            "]" +
            "}" ;
    this.mockMvc.perform(
            post("/analyzeNotes")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(request))
            .andDo(print()).andExpect(status().isOk())
            .andExpect(jsonPath("$.average").value(9.2));
  }


  @Test
  void analyzeNotesGoodMessageTest() throws Exception {
    String request = "{\"name\": \"Genghis Kan\", \"subjects\": [" +
            "        {\"subject\":\"Paradigmas de Programación\",\"note\": 8}," +
            "        {\"subject\":\"Diseño\",\"note\": 10}," +
            "{\"subject\":\"Programación Avanzada\",\"note\": 9}," +
            "{\"subject\":\"Inteligencia Artificial\",\"note\": 9}," +
            "{\"subject\":\"Matemática Superior\",\"note\": 10}" +
            "]" +
            "}" ;
    this.mockMvc.perform(
            post("/analyzeNotes")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(request))
            .andDo(print()).andExpect(status().isOk())
            .andExpect(jsonPath("$.message").value("¡Felicitaciones Genghis Kan! Usted tiene el gran promedio de 9.2"));
  }

 */
}
