package com.meli.obtenerdiploma.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IStudentDAO iStudentDAO;

    @Test
    public void testAnalyzeScores() throws Exception {
        StudentDTO expected = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        expected.setMessage("El alumno Marco ha obtenido un promedio de 6.00. Puedes mejorar.");
        expected.setAverageScore(6.0);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String expectedJson = writer.writeValueAsString(expected);

        when(iStudentDAO.findById(expected.getId())).thenReturn(expected);

        MvcResult response =
                this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}",expected.getId()))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(expectedJson,response.getResponse().getContentAsString());
    }

    @Test
    public void testDiplomaWithHonors() throws Exception {
        StudentDTO expected = TestUtilsGenerator.getStudentWith3SubjectsAverageOver9("Marco");

        when(iStudentDAO.findById(expected.getId())).thenReturn(expected);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}",expected.getId()))
                        .andDo(print()).andExpect(status().isOk())
                        .andExpect(content().contentType("application/json"))
                        .andExpect(MockMvcResultMatchers.jsonPath("message").value("El alumno Marco ha obtenido un promedio de 9.00. Felicitaciones!"))
                        .andExpect(MockMvcResultMatchers.jsonPath("averageScore").value("9.0"))
                        .andReturn();
    }

    @Test
    public void testDiplomaWithoutHonors() throws Exception {
        StudentDTO expected = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        when(iStudentDAO.findById(expected.getId())).thenReturn(expected);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", expected.getId()))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("message").value("El alumno Marco ha obtenido un promedio de 6.00. Puedes mejorar."))
                .andExpect(MockMvcResultMatchers.jsonPath("averageScore").value("6.0"));
    }


}
