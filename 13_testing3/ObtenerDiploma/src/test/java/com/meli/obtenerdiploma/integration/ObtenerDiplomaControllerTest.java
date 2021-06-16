package com.meli.obtenerdiploma.integration;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    IStudentDAO studentDAO;

    private StudentDTO studentWithCongrats;
    private StudentDTO studentWithoutCongrats;

    @BeforeEach @AfterEach
    public void init(){
        studentWithoutCongrats = TestUtilsGenerator.getStudentWith3Subjects("Santiago Garcia");
        studentWithCongrats = TestUtilsGenerator.getStudentWith3SubjectsAverageOver9("Manuel Liendo");
    }

    @Test
    public void testAnalyzeScoresWithoutCongrats() throws Exception {
        Long studentId = studentWithoutCongrats.getId();
        when(studentDAO.findById(studentId)).thenReturn(studentWithoutCongrats);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", studentId))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("message").value("El alumno Santiago Garcia ha obtenido un promedio de 6.00. Puedes mejorar."))
                .andExpect(MockMvcResultMatchers.jsonPath("averageScore").value("6.0"));

    }

    @Test
    public void testAnalyzeScoresWithCongrats() throws Exception {
        Long studentId = studentWithCongrats.getId();
        when(studentDAO.findById(studentId)).thenReturn(studentWithCongrats);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", studentId))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("message").value("El alumno Manuel Liendo ha obtenido un promedio de 9.00. Felicitaciones!"))
                .andExpect(MockMvcResultMatchers.jsonPath("averageScore").value("9.0"));

    }
}

