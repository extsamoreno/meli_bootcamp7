package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    IObtenerDiplomaService obtenerDiplomaService;

    @Test
    public void analyzeScoresTest() throws Exception {
        Long id = 4L;
        StudentDTO studentExpected = TestUtilsGenerator.getStudentWithId(id);
        studentExpected.setAverageScore(6.0);
        studentExpected.setMessage("El alumno " + studentExpected.getStudentName() + " ha obtenido un promedio de " + studentExpected.getAverageScore() + ". Puedes mejorar.");

        Mockito.when(obtenerDiplomaService.analyzeScores(id)).thenReturn(studentExpected);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,
                        false)
                .writer();
        String responseJson = writer.writeValueAsString(studentExpected);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders
                .get("/analyzeScores/{studentId}", id))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(responseJson, mvcResult.getResponse().getContentAsString());
    }

}
