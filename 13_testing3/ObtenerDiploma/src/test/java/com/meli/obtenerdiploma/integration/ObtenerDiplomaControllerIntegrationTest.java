package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.unit.repository.IStudentDAO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
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
public class ObtenerDiplomaControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    IStudentDAO iStudentDAO;

    @Test
    public void generateDiplomaHighAverage() throws Exception {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3SubjectsAverageOver9("Pedro");
        Mockito.when(iStudentDAO.findById(studentDTO.getId())).thenReturn(studentDTO);
        String expectedMessage = "El alumno Pedro ha obtenido un promedio de 9.00. Felicitaciones!";

        this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", studentDTO.getId()))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value(expectedMessage))
                .andExpect(MockMvcResultMatchers.jsonPath("$.averageScore").value(9.0));
    }

    @Test
    public void generateDiplomaLowAverage() throws Exception {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Pedro");
        Mockito.when(iStudentDAO.findById(studentDTO.getId())).thenReturn(studentDTO);
        String expectedMessage = "El alumno Pedro ha obtenido un promedio de 6.00. Puedes mejorar.";

        this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", studentDTO.getId()))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value(expectedMessage))
                .andExpect(MockMvcResultMatchers.jsonPath("$.averageScore").value(6.0));
    }

    @Test
    public void generateDiplomaWithNonExistingId() throws Exception {
        Mockito.when(iStudentDAO.findById(1L)).thenThrow(new StudentNotFoundException(1L));
        String expectedDescription = "El alumno con Id 1 no se encuetra registrado.";

        this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 1))
                .andDo( print()).andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value(expectedDescription));
    }

}
