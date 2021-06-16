package com.meli.obtenerdiploma.integration.test;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.ErrorDTO;
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

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.rmi.StubNotFoundException;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    IStudentDAO iStudentDAO;

    @Test
    public void testAnalyzeScoresHappyPatch () throws Exception {
        Long id = 1L;

        StudentDTO std = new StudentDTO();
        std.setId(1L);
        std.setStudentName("Juan");
        std.setAverageScore(7.333333333333333);
        std.setMessage("El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar.");
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(new SubjectDTO("Matematica", 9.0));
        subjects.add(new SubjectDTO("Fisica", 7.0));
        subjects.add(new SubjectDTO("Quimica", 6.0));
        std.setSubjects(subjects);


        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        String responseJson = writer.writeValueAsString(std);

        Mockito.when(iStudentDAO.findById(id)).thenReturn(std);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 1L))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string(responseJson))
                .andReturn();
    }

    @Test
    public void testAnalyzeScoresStudentNotFound () throws Exception {

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        String responseJson = writer.writeValueAsString(new ErrorDTO("StudentNotFoundException", "El alumno con Id 10 no se encuetra registrado." ));

        Mockito.when(iStudentDAO.findById(10L)).thenThrow(new StudentNotFoundException(10L));

        this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 10L))
                .andDo(print()).andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string(responseJson))
                .andReturn();
    }
}
