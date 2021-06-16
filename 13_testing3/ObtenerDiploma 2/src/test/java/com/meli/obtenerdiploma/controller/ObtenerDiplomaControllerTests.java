package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import com.meli.obtenerdiploma.util.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTests {

    @Mock
    IObtenerDiplomaService service;

    @InjectMocks
    ObtenerDiplomaController controller;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void obtenerDiploma() {
        // arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");

        // act
        controller.analyzeScores(stu.getId());

        // assert
        verify(service, atLeastOnce()).analyzeScores(stu.getId());
    }

    @Test
    public void testAnalyzeScoresCongratulationsMessageOutput() throws Exception {

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        StudentDTO studentDTO = Utils.getExcelentStudentDTO();
        studentDTO.setAverageScore(10.0D);
        studentDTO.setId(3L);
        studentDTO.setMessage("El alumno Test ha obtenido un promedio de 10. Felicitaciones!");
        String responseJson = writer.writeValueAsString(studentDTO);
        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 3L))
                .andDo(print()).andExpect(status().isOk()).andExpect(content().contentType("application/json"))
                //.andExpect(MockMvcResultMatchers.jsonPath("$.averageScore").value("10"))
                .andReturn();
        Assertions.assertEquals(responseJson, result.getResponse().getContentAsString());
    }


    @Test
    public void testAnalyzeScoresOutput() throws Exception {

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        StudentDTO studentDTO = Utils.getStudentDTO();
        studentDTO.setAverageScore(6.5D);
        studentDTO.setId(4L);
        studentDTO.setMessage("El alumno Test2 ha obtenido un promedio de 6.5. Puedes mejorar.");

        String responseJson = writer.writeValueAsString(studentDTO);

        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", "4"))
                .andDo(print()).andExpect(status().isOk()).andExpect(content().contentType("application/json"))
                //.andExpect(MockMvcResultMatchers.jsonPath("$.averageScore").value("6.5"))
                .andReturn();

        Assertions.assertEquals(responseJson, result.getResponse().getContentAsString());

    }
}
