package com.meli.obtenerdiploma.integracion;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaIntegTest {

    @Autowired
    MockMvc mockMvc;


    @Test
    public void testAnalyzeScoresCongratulationsMessageOutput() throws Exception {

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        StudentDTO studentDTO = Utils.getExcelentStudentDTO();
        studentDTO.setAverageScore(10.0D);
        studentDTO.setId(1L);

        String payloadJson = writer.writeValueAsString(studentDTO);
        MvcResult register = this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON).content(payloadJson))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").doesNotExist())
                .andReturn();

        studentDTO.setMessage("El alumno Test ha obtenido un promedio de 10.00. Felicitaciones!");
        String responseJson = writer.writeValueAsString(studentDTO);
        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", "1"))
                .andDo(print()).andExpect(status().isOk()).andExpect(content().contentType("application/json"))
                //.andExpect(MockMvcResultMatchers.jsonPath("$.averageScore").value("10"))
                .andReturn();
        Assertions.assertEquals(responseJson, result.getResponse().getContentAsString());
    }


    @Test
    public void testAnalyzeScoresOutput() throws Exception {




        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        StudentDTO studentDTO = Utils.getStudentDTO();
        studentDTO.setAverageScore(6.5D);
        studentDTO.setMessage("El alumno Test2 ha obtenido un promedio de 6.50. Puedes mejorar.");
        studentDTO.setId(1L);

        String payloadJson = writer.writeValueAsString(studentDTO);
        MvcResult register = this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON).content(payloadJson))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").doesNotExist())
                .andReturn();

        String responseJson = writer.writeValueAsString(studentDTO);

        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", "1"))
                .andDo(print()).andExpect(status().isOk()).andExpect(content().contentType("application/json"))
                //.andExpect(MockMvcResultMatchers.jsonPath("$.averageScore").value("6.5"))
                .andReturn();

        Assertions.assertEquals(responseJson, result.getResponse().getContentAsString());

    }
}
