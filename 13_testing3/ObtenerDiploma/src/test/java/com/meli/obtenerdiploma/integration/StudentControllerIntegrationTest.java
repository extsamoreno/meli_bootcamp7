package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.IStudentService;
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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.io.FileNotFoundException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;
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

    @MockBean
    IStudentService studentService;

    @Test
    public void getByIdHappyPath() throws Exception {

        StudentDTO studentExpected = TestUtilsGenerator.getStudentWith3Subjects("Manuel");
        Mockito.when(studentDAO.findById(studentExpected.getId())).thenReturn(studentExpected);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String responseJson = writer.writeValueAsString(studentExpected);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders
                .get("/student/getStudent/{id}", studentExpected.getId()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(responseJson, mvcResult.getResponse().getContentAsString());

    }

    @Test
    public void registerStudentHappyPath() throws Exception {
        StudentDTO studentExpected = TestUtilsGenerator.getStudentWith3Subjects("Manuel");
        Mockito.when(studentDAO.findById(studentExpected.getId())).thenReturn(studentExpected);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payLoadJson = writer.writeValueAsString(studentExpected);

        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payLoadJson))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void modifyStudentTest() throws Exception {
        StudentDTO studentExpected = TestUtilsGenerator.getStudentWith3Subjects("Manuel");
        Mockito.when(studentDAO.findById(studentExpected.getId())).thenReturn(studentExpected);

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

    @Test
    public void removeStudentTest() throws Exception {
        Long id = 4L;
        Mockito.when(studentDAO.delete(id)).thenReturn(true);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders
                .get("/student/removeStudent/{id}", id))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        Assertions.assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
    }

    @Test
    public void getStudentListTest() throws Exception {
        Set<StudentDTO> expected = TestUtilsGenerator.getStudentSet();
        Mockito.when(studentRepository.findAll()).thenReturn(expected);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String responseJson = writer.writeValueAsString(expected);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders
                .get("/student/listStudents"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(responseJson, mvcResult.getResponse().getContentAsString());
    }

    @Test()
    public void getStudentListFileNotFoundTest() throws Exception {
        Mockito.when(studentRepository.findAll()).thenThrow(new FileNotFoundException());
       // Mockito.doThrow( new FileNotFoundException()).when(studentRepository.findAll());

        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents"))
                .andDo( print()).andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value(""));
                //.andExpect(result -> assertTrue(result.getResolvedException() instanceof FileNotFoundException));

    }
}
