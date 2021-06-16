package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.unit.repository.StudentDAO;
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

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    StudentDAO studentDAO;

    @Test
    public void ObtenerDiplomaHappyPath() throws Exception {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Alberto");
        studentDTO.setMessage("El alumno Alberto ha obtenido un promedio de 6,00. Puedes mejorar.");
        studentDTO.setAverageScore(6.0);
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();
        String expected = writer.writeValueAsString(studentDTO);

        when(studentDAO.findById(1L)).thenReturn(studentDTO);

        MvcResult mvcResult =
                this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}",1))
                        .andDo(print()).andExpect(status().isOk())
                        .andExpect(content().contentType("application/json;charset=UTF-8")).andReturn();

        verify(studentDAO,atLeastOnce()).findById(1L);
        Assertions.assertEquals(expected, mvcResult.getResponse().getContentAsString());
    }
}
