package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.unit.repository.IStudentDAO;
import com.meli.obtenerdiploma.unit.repository.IStudentRepository;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    IStudentDAO studentDAO;

    @MockBean
    IStudentRepository studentRepository;

    @Test
    public void getStudentHappyPath() throws Exception {

        Long studentId = 1L;
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWithId(studentId);
        when(studentDAO.findById(studentId)).thenReturn(studentDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", 1))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string(containsString("{\"id\":1,\"studentName\":\"Carlos\",\"message\":null," +
                        "\"averageScore\":null,\"subjects\":[{\"name\":\"Matematica\",\"score\":8.0},{\"name\":\"Lengua\",\"score\":6.0},{\"name\":\"Fisica\",\"score\":4.0}]}")));
        //.andReturn();
    }

    // GET with pathRequest. VOID
    @Test
    public void removeStudentHappyPath() throws Exception {

        Long studentId = 1L;
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWithId(studentId);
        when(studentDAO.delete(studentId)).thenReturn(true);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}", 1))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").doesNotExist());
        //.andReturn();
    }

    // GET without pathRequest/RequestBody
    @Test
    public void listStudentsOk() throws Exception {

        // Arrange
        Set<StudentDTO> studentSet = TestUtilsGenerator.getStudentSet();

        // Convert studentSet to JSON
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String expected = writer.writeValueAsString(studentSet);
        when(studentRepository.findAll()).thenReturn(studentSet);

        // Act
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/student//listStudents"))
                .andDo(print()).andExpect(status().isOk())
                .andReturn();

        // Assert
        verify(studentRepository, Mockito.atLeastOnce()).findAll();
        Assertions.assertEquals(expected, mvcResult.getResponse().getContentAsString());
    }

    // POST with requestBody
    @Test
    public void modifyStudentHappyBody() throws Exception {

        // Arrange
        Long id = 2L;
        StudentDTO payLoadDTO = TestUtilsGenerator.getStudentWithId(id);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payloadJson = writer.writeValueAsString(payLoadDTO);

        // Act
        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").doesNotExist());
    }

    // POST with RequestBody
    @Test
    public void registerStudentHappyBody() throws Exception {

        Long id = 2L;
        StudentDTO payLoadDTO = TestUtilsGenerator.getStudentWithId(id);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payloadJson = writer.writeValueAsString(payLoadDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").doesNotExist());
    }
}
