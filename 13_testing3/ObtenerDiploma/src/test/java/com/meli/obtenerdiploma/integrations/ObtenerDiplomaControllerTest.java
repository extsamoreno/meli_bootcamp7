package com.meli.obtenerdiploma.integrations;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Matches;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.*;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    IStudentDAO iStudentDAO;

    @Test
    public void testAnalyzeScores() throws Exception{
        Long iStudent = 1L;
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        SubjectDTO subjectDTO1 = new SubjectDTO("Matematica", 9D);
        SubjectDTO subjectDTO2 = new SubjectDTO("Lengua", 9D);
        subjectDTOList.add(subjectDTO1);
        subjectDTOList.add(subjectDTO2);
        StudentDTO studentDTO = new StudentDTO(iStudent, "Pepe", "", 0D, subjectDTOList);

        Mockito.when(iStudentDAO.findById(iStudent)).thenReturn(studentDTO);
        String resultRequestMessage = "El alumno " + studentDTO.getStudentName() + " ha obtenido un promedio de 9. Felicitaciones!";
        ObjectMapper objectMapper = new ObjectMapper();
        String responseSubjectsList = objectMapper.writeValueAsString(subjectDTOList);
        MvcResult mvcResult = (MvcResult) this.mockMvc.perform(MockMvcRequestBuilders
                .get("/analyzeScores/{studentId}", 1L))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.subjects.length()", Matchers.is(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1D))
                .andExpect(MockMvcResultMatchers.jsonPath("$.studentName").value("Pepe"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value(resultRequestMessage))
                .andExpect(MockMvcResultMatchers.jsonPath("$.averageScore").value(9D))
                .andExpect(MockMvcResultMatchers.jsonPath("$.subjects[0].name", Matchers.is("Matematica"))
                ).andReturn();
    }





}
