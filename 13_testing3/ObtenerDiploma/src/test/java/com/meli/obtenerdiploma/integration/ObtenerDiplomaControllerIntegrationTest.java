package com.meli.obtenerdiploma.integration;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
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
public class ObtenrDiplomaControllerIntegrationTest {

  @Autowired
  private MockMvc mockMvc;

  private StudentDTO getStudentDto() {
    Long id = 1L;
    String name = "Test";
    String message = "";
    Double average = 0.00;
    SubjectDTO subjectA = new SubjectDTO("Matemática", 8.00);
    SubjectDTO subjectB = new SubjectDTO("Lengua", 9.0);
    SubjectDTO subjectC = new SubjectDTO("Ed. Física", 7.00);
    List<SubjectDTO> subjects = Arrays.asList(subjectA, subjectB, subjectC);

    StudentDTO expectedStudent = new StudentDTO(id, name, message, average, subjects);
    return expectedStudent;
  }

  @Test
  public void analyzeScoresOfStudent() throws Exception {
    StudentDTO studentDTO = getStudentDto();

    this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}",
            1L))
            .andDo(print()).andExpect(status().isOk())
            .andExpect(content().contentType("application/json"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.studentName").value(studentDTO.getStudentName()))
            .andExpect(MockMvcResultMatchers.jsonPath("$.averageScore").value(8.0d))
            .andExpect(MockMvcResultMatchers.jsonPath("$.subjects").value(studentDTO.getSubjects()))
            .andExpect(MockMvcResultMatchers.jsonPath("$.message").value(
                    "El alumno Test ha obtenido un promedio de 8.00. Puedes mejorar."));
  }
}