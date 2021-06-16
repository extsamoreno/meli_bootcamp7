package com.meli.obtenerdiploma.integration;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.unit.repository.IStudentDAO;
import com.meli.obtenerdiploma.unit.repository.IStudentRepository;
import com.meli.obtenerdiploma.unit.service.IObtenerDiplomaService;
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

import static org.hamcrest.Matchers.containsString;
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
    public void analyzeScoresHappyPath() throws Exception {

        Long studentId = 1L;
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWithId(studentId);
        Mockito.when(studentDAO.findById(studentId)).thenReturn(studentDTO);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}",1))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string(containsString("{\"id\":1,\"studentName\":\"Carlos\",\"message\":\"El alumno Carlos ha obtenido un promedio de 6.00. Puedes mejorar.\"," +
                        "\"averageScore\":6.0,\"subjects\":[{\"name\":\"Matematica\",\"score\":8.0},{\"name\":\"Lengua\",\"score\":6.0},{\"name\":\"Fisica\",\"score\":4.0}]}")))
                .andReturn();
    }
}
