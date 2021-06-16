package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    IStudentDAO studentDAO;

    @MockBean
    IStudentRepository studentRepository;

    private StudentDTO student;
    private Set<StudentDTO> listStudents;

    @BeforeEach @AfterEach
    public void init(){
        student = TestUtilsGenerator.getStudentWith3Subjects("Santiago Garcia");
        student.setId(1L);

        listStudents = TestUtilsGenerator.getStudentSet();
    }

    @Test
    public void testRegisterStudentWithValidPayload() throws Exception {
        ObjectWriter writer =
                new ObjectMapper()
                        .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                        .writer()
                        .withDefaultPrettyPrinter();
        String payloadJson = writer.writeValueAsString(student);

        doNothing().when(studentDAO).save(student);

        // Act & Assert
        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testGetStudentWithValidStudent() throws Exception{
        ObjectWriter writer =
                new ObjectMapper()
                        .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                        .writer();

        String responseJson = writer.writeValueAsString(student);

        when(studentDAO.findById(student.getId())).thenReturn(student);

        MvcResult response =
                this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", 1))
                            .andDo(print())
                            .andExpect(content().contentType("application/json"))
                            .andExpect(status().isOk())
                            .andReturn();

        assertEquals(responseJson, response.getResponse().getContentAsString());

    }

    @Test
    public void testModifyStudentWithValidPayload() throws Exception {
        ObjectWriter writer =
                new ObjectMapper()
                        .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                        .writer()
                        .withDefaultPrettyPrinter();

        String payloadJson = writer.writeValueAsString(student);

        doNothing().when(studentDAO).save(student);

        // Act & Assert
        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testRemoveStudentWithValidStudent() throws Exception{
        Long studentId = student.getId();

        when(studentDAO.delete(studentId)).thenReturn(true);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}", studentId))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testListStudents() throws Exception {
        ObjectWriter writer =
                new ObjectMapper()
                        .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                        .writer();

        String responseJson = writer.writeValueAsString(listStudents);

        when(studentRepository.findAll()).thenReturn(listStudents);

        MvcResult response =
                this.mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents"))
                        .andDo(print())
                        .andExpect(content().contentType("application/json"))
                        .andExpect(status().isOk())
                        .andReturn();

        assertEquals(responseJson, response.getResponse().getContentAsString());
    }

}
