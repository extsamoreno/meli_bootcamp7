package com.meli.obtenerdiploma.controller.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
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
import org.springframework.http.HttpStatus;
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
    MockMvc mockMvc;

    @MockBean
    IStudentDAO iStudentDAO;

    @MockBean
    IStudentRepository iStudentRepository;

    @Test
    public void getByIdHappyPath() throws Exception{


        StudentDTO student = TestUtilsGenerator.getStudentWith3Subjects("Pepe");
        Mockito.when(iStudentDAO.findById(student.getId())).thenReturn(student);

        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE, false).
                writer();
        String responseJson = writer.writeValueAsString(student);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", student.getId()))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(responseJson, mvcResult.getResponse().getContentAsString());

    }

    @Test
    public void registerStudentHappyPath() throws Exception{

        StudentDTO student = TestUtilsGenerator.getStudentWith3Subjects("Pepe");
        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE, false).
                writer().withDefaultPrettyPrinter();
        String payloadJson = writer.writeValueAsString(student);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isOk());

    }

    @Test
    public void removeStudentHappyPath() throws Exception {
        Long id = 4L;
        Mockito.when(iStudentDAO.delete(id)).thenReturn(true);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders
                .get("/student/removeStudent/{id}", id))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        Assertions.assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
    }

    @Test
    public void getStudentsHappyPath() throws Exception {
        Set<StudentDTO> studentDTOSet = TestUtilsGenerator.getStudentSet();
        Mockito.when(iStudentRepository.findAll()).thenReturn(studentDTOSet);


        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String responseJson = writer.writeValueAsString(studentDTOSet);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders
                .get("/student/listStudents"))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(responseJson, mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void updateStudentsHappyPath() throws Exception{
        StudentDTO studentExpected = TestUtilsGenerator.getStudentWith3Subjects("Manuel");
        Mockito.when(iStudentDAO.findById(studentExpected.getId())).thenReturn(studentExpected);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payLoadJson = writer.writeValueAsString(studentExpected);

        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payLoadJson))
                .andDo(print()).andExpect(status().isOk());
    }



}