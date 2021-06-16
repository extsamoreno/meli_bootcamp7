package com.meli.obtenerdiploma.integrations;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerIntegrationTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    IStudentDAO studentDAO;

    @Test
    public void obtenerDiplomaOkTest() throws Exception {
        List<SubjectDTO> subjects = Arrays.asList(new SubjectDTO("M", 7.0),
                new SubjectDTO("A", 8.0),
                new SubjectDTO("B", 9.0));
        StudentDTO expected = new StudentDTO();
        expected.setId(1L);
        expected.setStudentName("Edu");
        expected.setSubjects(subjects);

        Mockito.when(studentDAO.findById(1L)).thenReturn(expected);

        var result = this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();
    }

    @Test
    public void obtenerDiplomaNotFoundTest() throws Exception {
        Mockito.when(studentDAO.findById(2L)).thenThrow(new StudentNotFoundException(2L));

        var result = this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 2))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andReturn();
    }
}
