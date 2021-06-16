package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import lombok.val;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerIntTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    IStudentDAO iStudentDAO;


    Long id = 1L;
    private StudentDTO getStudentDto() {

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
        Mockito.when(iStudentDAO.findById(id)).thenReturn(studentDTO);

        MvcResult mvcResult =
            this.mockMvc.perform(MockMvcRequestBuilders.get(
                    "/analyzeScores/{studentId}", 1L))
                    .andDo(print()).andExpect(status().isOk())
                    .andExpect(content().contentType("application/json"))
                    .andExpect(MockMvcResultMatchers.jsonPath(
                            "$.studentName").value("Test"))
                    .andReturn();

        Mockito.verify(iStudentDAO, Mockito.atLeastOnce()).findById(id);
        Assertions. assertEquals("application/json" ,
                mvcResult.getResponse().getContentType()) ;

    }


}
