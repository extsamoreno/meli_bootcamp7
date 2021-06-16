package com.example.diploma.integration;

import com.example.diploma.exception.StudentNotFoundException;
import com.example.diploma.model.StudentDTO;
import com.example.diploma.repository.IStudentDAO;
import com.example.diploma.repository.IStudentRepository;
import com.example.diploma.unit.util.TestUtilsGenerator;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
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

    @MockBean
    IStudentRepository iStudentRepository;

    //ANALYZE SCORES

    @Test
    public void testDiplomaWithHonors() throws Exception {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3SubjectsAverageOver9("Marcos");
        Mockito.when(iStudentDAO.findById(studentDTO.getId())).thenReturn(studentDTO);
        String expectedMessage = "El alumno Marcos ha obtenido un promedio de 9,00. Felicitaciones!";

        this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", studentDTO.getId()))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value(expectedMessage))
                .andExpect(MockMvcResultMatchers.jsonPath("$.averageScore").value(9.0));
    }

    @Test
    public void testDiplomaWithoutHonors() throws Exception {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Agustin");
        Mockito.when(iStudentDAO.findById(studentDTO.getId())).thenReturn(studentDTO);
        String expectedMessage = "El alumno Agustin ha obtenido un promedio de 6,00. Puedes mejorar.";

        this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", studentDTO.getId()))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value(expectedMessage))
                .andExpect(MockMvcResultMatchers.jsonPath("$.averageScore").value(6.0));
    }

    @Test
    public void testDiplomaInexistentStudentId() throws Exception {
        long id = 5L;

        Mockito.when(iStudentDAO.findById(id)).thenThrow(new StudentNotFoundException(id));
        String expectedDescription = "El alumno con Id 5 no se encuetra registrado.";

        this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", id))
                .andDo( print()).andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value(expectedDescription));
    }
}

