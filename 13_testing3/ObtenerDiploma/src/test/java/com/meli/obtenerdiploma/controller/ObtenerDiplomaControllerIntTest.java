package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.exception.ObtenerDiplomaException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.json.JSONArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
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


    Long id;
    private StudentDTO getStudentDto() {

        String name = "Test";
        String message = "";
        Double average = 0.0;
        SubjectDTO subjectA = new SubjectDTO("Matemática", 8.00);
        SubjectDTO subjectB = new SubjectDTO("Lengua", 9.0);
        SubjectDTO subjectC = new SubjectDTO("Ed. Física", 7.00);
        List<SubjectDTO> subjects = Arrays.asList(subjectA, subjectB, subjectC);


        StudentDTO expectedStudent = new StudentDTO(1L, name, message, average, subjects);
        return expectedStudent;
    }

    @Test
    public void analyzeScoresOfStudentHappyPath() throws Exception {
        id = 1L;
        StudentDTO studentDTO = getStudentDto();
        Mockito.when(iStudentDAO.findById(id)).thenReturn(studentDTO);
        List<SubjectDTO> subjectDTOS = studentDTO.getSubjects();

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();

        String payloadJson = writer.writeValueAsString(studentDTO.getSubjects());

        MvcResult mvcResult =
            this.mockMvc.perform(MockMvcRequestBuilders.get(
                    "/analyzeScores/{studentId}", id))
                    .andDo(print()).andExpect(status().isOk())
                    .andExpect(content().contentType("application/json"))
                    .andExpect(MockMvcResultMatchers.jsonPath(
                            "$.studentName").value("Test"))
                    .andExpect(MockMvcResultMatchers.jsonPath(
                            "$.averageScore").value(8.0))
                    .andExpect(MockMvcResultMatchers.jsonPath(
                            "$.subjects").value(payloadJson))
                    .andReturn();

        Mockito.verify(iStudentDAO, Mockito.atLeastOnce()).findById(id);
        //Assertions. assertEquals("application/json" ,
        //        mvcResult.getResponse().getContentType()) ;

    }

    @Test
    void getStudent() throws Exception {
        Long id  = 1L;
        StudentDTO studentDTO = new StudentDTO();

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();

        String response = writer.writeValueAsString(studentDTO);

        Mockito.when(iStudentDAO.findById(any())).thenReturn(studentDTO);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", id))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(response))
                .andReturn();

        Mockito.verify(iStudentDAO, Mockito.atLeastOnce()).findById(id);
        Assertions. assertEquals("application/json" ,
                mvcResult.getResponse().getContentType()) ;
    }

    @Test
    public void analyzeScoresOfStudentNotFound() throws Exception {
        id = 99L;
        ObtenerDiplomaException exception = new ObtenerDiplomaException("Rompió", HttpStatus.NOT_FOUND);
        Mockito.when(iStudentDAO.findById(id)).thenThrow( new ObtenerDiplomaException("Rompió", HttpStatus.NOT_FOUND));

        MvcResult mvcResult =
                this.mockMvc.perform(MockMvcRequestBuilders.get(
                        "/analyzeScores/{studentId}", id))
                        .andDo(print()).andExpect(status().isNotFound())
                        .andExpect(content().contentType("application/json"))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("ObtenerDiplomaException"))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("Rompió"))
                        .andReturn();

        Mockito.verify(iStudentDAO, Mockito.atLeastOnce()).findById(id);
        Assertions. assertEquals("application/json" ,
                mvcResult.getResponse().getContentType()) ;

    }

}
