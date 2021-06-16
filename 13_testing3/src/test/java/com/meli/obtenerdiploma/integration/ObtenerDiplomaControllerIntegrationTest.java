package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
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

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    IStudentDAO studentDAO;

    @Test
    public void analyzeScoresOk() throws Exception {

        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Juan");
        studentDTO.setAverageScore(6d);
        studentDTO.setMessage("El alumno Juan ha obtenido un promedio de 6.00. Puedes mejorar.");
        long id = 1;

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        when(studentDAO.findById(id)).thenReturn(studentDTO);
        String expectedJson = writer.writeValueAsString(studentDTO);

        MvcResult response =
                this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", id))
                        .andDo(print()).andExpect(status().isOk())
                        .andExpect(content().contentType("application/json"))
                        .andReturn();

        Mockito.verify(studentDAO, Mockito.atLeast(1)).findById(id);
        Assertions.assertEquals(expectedJson, response.getResponse().getContentAsString());
    }

}
