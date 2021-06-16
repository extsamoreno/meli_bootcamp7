package com.meli.obtenerdiploma.controller;
import com.fasterxml.jackson.core.JsonProcessingException;
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

import java.util.Set;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    IStudentDAO iStudentDAO;

    @MockBean
    IStudentRepository iStudentRepository;


    @Test
    public void registerStudentTest() throws Exception {

        StudentDTO payloadDto = TestUtilsGenerator.getStudentWith3Subjects("Marco");

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String payloadJson = writer.writeValueAsString(payloadDto);

        MvcResult response =
                this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                      .andDo(print()).andExpect(status().isOk())
                      .andReturn();

        Assertions.assertEquals(200,response.getResponse().getStatus());

        Mockito.verify(iStudentDAO,Mockito.atLeastOnce()).save(payloadDto);
    }

    @Test
    public void getStudentTest() throws Exception {

        StudentDTO student = TestUtilsGenerator.getStudentWith3Subjects("Marco");

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String payloadJson = writer.writeValueAsString(student);

        Mockito.when(iStudentDAO.findById(student.getId())).thenReturn(student);

        MvcResult response =
                this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}",student.getId()))
                        .andExpect(content().contentType("application/json"))
                        .andDo(print()).andExpect(status().isOk())
                        .andReturn();

        Assertions.assertEquals(payloadJson,response.getResponse().getContentAsString());
    }

    @Test
    public void modifyStudentTest() throws Exception {
        StudentDTO student = TestUtilsGenerator.getStudentWith3Subjects("Marco");

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String payloadJson = writer.writeValueAsString(student);

        MvcResult response =
                this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                        .andDo(print()).andExpect(status().isOk())
                        .andReturn();

        Assertions.assertEquals(200,response.getResponse().getStatus());
        Mockito.verify(iStudentDAO,Mockito.atLeastOnce()).save(student);
    }

    @Test
    public void removeStudentTest() throws Exception {
        long id = 2;

        MvcResult response =
                this.mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}",id))
                        .andDo(print()).andExpect(status().isOk())
                        .andReturn();

        Assertions.assertEquals(200,response.getResponse().getStatus());
        Mockito.verify(iStudentDAO,Mockito.atLeastOnce()).delete(id);
    }

    @Test
    public void listOfStudentsTest() throws Exception {
        Set<StudentDTO> students = TestUtilsGenerator.getStudentSet();
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String payloadJson = writer.writeValueAsString(students);

        Mockito.when(iStudentRepository.findAll()).thenReturn(students);

        MvcResult response =
                this.mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents"))
                        .andDo(print()).andExpect(status().isOk())
                        .andReturn();

        Assertions.assertEquals(payloadJson,response.getResponse().getContentAsString());
        Mockito.verify(iStudentRepository,Mockito.atLeast(1)).findAll();
    }








}
