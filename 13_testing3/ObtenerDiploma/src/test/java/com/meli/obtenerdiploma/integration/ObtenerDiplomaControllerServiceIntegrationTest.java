package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.ErrorDTO;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerServiceIntegrationTest {

    @MockBean
    IStudentDAO iStudentDAO;



    @Autowired
    MockMvc mockMvc;

    @Test
    public void analyzeScoresHappyPath() throws Exception {
        Long id = 1L;
        //==============
        SubjectDTO subject = new SubjectDTO( "Matematica", 9.0);
        SubjectDTO subject2 = new SubjectDTO( "Fisica", 7.0);
        SubjectDTO subject3 = new SubjectDTO( "Quimica", 6.0);

        List<SubjectDTO> subjects = new ArrayList<SubjectDTO>();
        subjects.add(subject);
        subjects.add(subject2);
        subjects.add(subject3);

        StudentDTO student =  new StudentDTO
                (id,"Juan", "El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar.", 7.333333333333333, subjects);

        when(iStudentDAO.findById(id)).thenReturn(student);

        //===============

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

        String responseJson = writer.writeValueAsString(student);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}",1L))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string(responseJson))
                .andReturn();

    }


    @Test
    public void analyzeScoresException() throws Exception {

        when(iStudentDAO.findById(1999L)).thenThrow(new StudentNotFoundException(1999L));

        //===============

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

        String error = writer.writeValueAsString(new ErrorDTO("StudentNotFoundException", "El alumno con Id 1999 no se encuetra registrado."));

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}",1999L))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string(error))
                .andReturn();

    }


}
