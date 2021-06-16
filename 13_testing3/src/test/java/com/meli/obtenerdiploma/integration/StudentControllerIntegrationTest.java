package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.HashSet;
import java.util.Set;

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
    public void getStudentByIdOk() throws Exception {

        long id = 1;
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Juan");

        when(studentDAO.findById(id)).thenReturn(studentDTO);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", id))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.studentName").value("Juan"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(9999))
                .andReturn();

    }

    @Test
    public void getStudentByIdOkAlternativeTest() throws Exception {

        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Juan");
        studentDTO.setAverageScore(6d);
        studentDTO.setMessage("El alumno Juan ha obtenido un promedio de 6.00. Puedes mejorar.");
        long id = 1;

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        when(studentDAO.findById(id)).thenReturn(studentDTO);
        String expectedJson = writer.writeValueAsString(studentDTO);

        MvcResult response =
                this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", id))
                        .andDo(print()).andExpect(status().isOk())
                        .andExpect(content().contentType("application/json"))
                        .andReturn();

        Mockito.verify(studentDAO, Mockito.atLeast(1)).findById(id);
        Assertions.assertEquals(expectedJson, response.getResponse().getContentAsString());
    }

    @Test
    public void registerStudentOk() throws Exception {

        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Juan");

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        String requestDTO = writer.writeValueAsString(studentDTO);

        MvcResult mvcResult = this.mockMvc
                .perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestDTO))
                .andDo(print()).andExpect(status().isOk())
                .andReturn();

        verify(studentDAO, atLeastOnce()).save(studentDTO);
    }

    @Test
    public void modifyStudentOk() throws Exception {

        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Juan");

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

        String requestDTO = writer.writeValueAsString(studentDTO);

        MvcResult mvcResult = this.mockMvc
                .perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestDTO))
                .andDo(print()).andExpect(status().isOk())
                .andReturn();

        verify(studentDAO, atLeastOnce()).save(studentDTO);
    }

    @Test
    public void removeStudentOk() throws Exception {

        long id = 1;
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Juan");
        when(studentDAO.delete(id)).thenReturn(true);

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

        String requestDTO = writer.writeValueAsString(studentDTO);

        MvcResult mvcResult = this.mockMvc
                .perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestDTO))
                .andDo(print()).andExpect(status().isOk())
                .andReturn();

        verify(studentDAO, atLeastOnce()).delete(id);
    }

    @Test
    public void listStudentsOk() throws Exception {

        long id = 1;
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Juan");
        StudentDTO studentDTO2 = TestUtilsGenerator.getStudentWith3Subjects("Jorge");

        Set<StudentDTO> studentDTOSet = new HashSet<>();
        studentDTOSet.add(studentDTO);
        studentDTOSet.add(studentDTO2);

        when(studentRepository.findAll()).thenReturn(studentDTOSet);

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

        String responseDtoJson = writer.writeValueAsString(studentDTOSet);

        MvcResult mvcResult = this.mockMvc
                .perform(MockMvcRequestBuilders.get("/student/listStudents"))
                .andDo(print()).andExpect(status().isOk())
                .andReturn();

        verify(studentRepository, atLeastOnce()).findAll();
        Assertions.assertEquals(responseDtoJson, mvcResult.getResponse().getContentAsString());
    }

}
