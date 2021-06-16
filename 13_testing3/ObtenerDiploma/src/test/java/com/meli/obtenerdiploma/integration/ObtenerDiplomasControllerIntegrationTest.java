package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.text.DecimalFormat;
import java.util.ArrayList;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomasControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    IObtenerDiplomaService iObtenerDiplomaService;
    @MockBean
    IStudentRepository iStudentRepository;

    @Test
    public void analyzeScoreTest() throws Exception {
        Long studentId = 1L;
        SubjectDTO subjectOne = new SubjectDTO("Matematica", 10d);
        SubjectDTO subjectTwo = new SubjectDTO("Fisica", 10d);
        SubjectDTO subjectThree = new SubjectDTO("Quimica", 10d);

        ArrayList<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(subjectOne);
        subjectDTOList.add(subjectTwo);
        subjectDTOList.add(subjectThree);

        StudentDTO studentDTO = new StudentDTO(studentId,"Juan","asd",10d,subjectDTOList);
        studentDTO.setMessage("El alumno " + studentDTO.getStudentName() + " ha obtenido un promedio de " + studentDTO.getAverageScore() + ". Puedes mejorar.");
        Mockito.when(iObtenerDiplomaService.analyzeScores(studentId)).thenReturn(studentDTO);


                ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String responseJson = writer.writeValueAsString(studentDTO);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders
                .get("/analyzeScores/{studentId}", studentId))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(responseJson, mvcResult.getResponse().getContentAsString());



    }
}
