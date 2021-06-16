package com.meli.obtenerdiploma.integration.controller;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.unit.repository.IStudentDAO;
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

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControlerIntTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    IStudentDAO iStudentDAO;

    @Test
    public void analyzeScoresHighAvg() throws Exception {
        Long id = 1L;
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        SubjectDTO subject1 = new SubjectDTO("Historia",8.00);
        SubjectDTO subject2 = new SubjectDTO("Biologia",10.00);
        subjectDTOList.add(subject1);
        subjectDTOList.add(subject2);

        StudentDTO student = new StudentDTO(1L,"Juan","",9.00,subjectDTOList);
        Mockito.when(iStudentDAO.findById(id)).thenReturn(student);

        String expectedMsg = "El alumno Juan ha obtenido un promedio de 9.00. Felicitaciones!";

        this.mockMvc.perform(MockMvcRequestBuilders
            .get("/analyzeScores/{studentId}",1))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().contentType("application/json"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.message" ).value(expectedMsg))
            .andExpect(MockMvcResultMatchers.jsonPath("$.averageScore" ).value(9.0))
            .andReturn() ;
    }

    @Test
    public void analyzeScoresLowAvg() throws Exception {
        Long id = 1L;
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        SubjectDTO subject1 = new SubjectDTO("Historia",6.00);
        SubjectDTO subject2 = new SubjectDTO("Biologia",6.00);
        subjectDTOList.add(subject1);
        subjectDTOList.add(subject2);

        StudentDTO student = new StudentDTO(1L,"Juan","",6.00,subjectDTOList);
        Mockito.when(iStudentDAO.findById(id)).thenReturn(student);

        String expectedMsg = "El alumno Juan ha obtenido un promedio de 6.00. Puedes mejorar.";

        this.mockMvc.perform(MockMvcRequestBuilders
            .get("/analyzeScores/{studentId}",1))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().contentType("application/json"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.message" ).value(expectedMsg))
            .andExpect(MockMvcResultMatchers.jsonPath("$.averageScore" ).value(6.0))
            .andReturn() ;
    }

    @Test
    public void analyzeScoresStudentNotExist() throws Exception {
        Mockito.when(iStudentDAO.findById(1L)).thenThrow(new StudentNotFoundException(1L));
        String expectedDescription = "El alumno con Id 1 no se encuetra registrado.";

        this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 1))
            .andDo( print()).andExpect(status().isNotFound())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.jsonPath("$.description").value(expectedDescription));
    }
}
