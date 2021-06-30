package com.meli.obtenerdiploma.integration;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.unit.repository.IStudentDAO;
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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    IStudentDAO iStudentDAO;

    @Test
    public void analyzeScoresOK() throws Exception {
        //arrange
        Long id = 1L;
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        SubjectDTO subject1 = new SubjectDTO("Historia",8.00);
        SubjectDTO subject2 = new SubjectDTO("Biologia",4.00);
        subjectDTOList.add(subject1);
        subjectDTOList.add(subject2);

        StudentDTO student = new StudentDTO(id, "Pedro", "Felicitaciones Pedro!", 6.00, subjectDTOList);
        Mockito.when(iStudentDAO.findById(id)).thenReturn(student);

        //act
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders
                .get("/analyzeScores/{studentId}", 1L))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.studentName").value(student.getStudentName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("El alumno "+student.getStudentName()+" ha obtenido un promedio de "+student.getAverageScore()+"0. Puedes mejorar."))
                .andExpect(MockMvcResultMatchers.jsonPath("$.averageScore").value(student.getAverageScore()))
                .andReturn();
    }

    @Test
    public void analyzeScoresERROR() throws Exception {
        //arrange
        Long id = 1L;
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        SubjectDTO subject1 = new SubjectDTO("Historia",8.00);
        SubjectDTO subject2 = new SubjectDTO("Biologia",4.00);
        subjectDTOList.add(subject1);
        subjectDTOList.add(subject2);

        StudentDTO student = new StudentDTO(id, "Pedro", "Felicitaciones Pedro!", 6.00, subjectDTOList);
        Mockito.when(iStudentDAO.findById(id)).thenReturn(StudentNotFoundException.class);

        //act
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders
                .get("/analyzeScores/{studentId}", 1L))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content(StudentNotFoundException))
                .andExpect(MockMvcResultMatchers.jsonPath("$.studentName").value(student.getStudentName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("El alumno "+student.getStudentName()+" ha obtenido un promedio de "+student.getAverageScore()+"0. Puedes mejorar."))
                .andExpect(MockMvcResultMatchers.jsonPath("$.averageScore").value(student.getAverageScore()))
                .andReturn();
    }
}
