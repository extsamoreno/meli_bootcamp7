package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.ErrorDTO;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.bind.MethodArgumentNotValidException;

import static org.mockito.Mockito.when;
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

    @Test
    public void getStudentWithValidIdShouldReturnStudent() throws Exception {
        long studentId = 1L;
        StudentDTO studentExpected = TestUtilsGenerator.getStudentWithId(studentId);
        when(iStudentDAO.findById(studentId)).thenReturn(TestUtilsGenerator.getStudentWithId(studentId));

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String responseJson = writer.writeValueAsString(studentExpected);

        MvcResult mvcResult = this.mockMvc.perform(
                MockMvcRequestBuilders.get("/student/getStudent/{id}", studentId))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(responseJson, mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void getStudentWithInvalidIdShouldReturnErrorDTO() throws Exception{
        long studentId = 1L;
        StudentNotFoundException ex = new StudentNotFoundException(studentId);
        when(iStudentDAO.findById(studentId)).thenThrow(new StudentNotFoundException(studentId));

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String errorDTOJSON = writer.writeValueAsString(ex.getError());

        MvcResult mvcResult = this.mockMvc.perform(
                MockMvcRequestBuilders.get("/student/getStudent/{id}", studentId))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(errorDTOJSON, mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void registerStudentWithValidStudentShouldReturnOk() throws Exception{
        long studentId = 1L;
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Pepe");
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payloadJson = writer.writeValueAsString(studentDTO);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void registerStudentWithInvalidNameShouldReturnError() throws Exception{
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("pepe");
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payloadJson = writer.writeValueAsString(studentDTO);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andExpect(status().isBadRequest())
                .andReturn();
    }

    @Test
    public void registerStudentWithInvalidSubjectsListShouldReturnError() throws Exception{
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Pepe");
        studentDTO.setSubjects(null);
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payloadJson = writer.writeValueAsString(studentDTO);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();
    }

    @Test
    public void modifyStudentWithValidStudentShouldReturnOk() throws Exception {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Pepe");
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payloadJson = writer.writeValueAsString(studentDTO);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void modifyStudentWithInvalidNameShouldReturnError() throws Exception{
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("pepe");
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payloadJson = writer.writeValueAsString(studentDTO);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andExpect(status().isBadRequest())
                .andReturn();
    }

    @Test
    public void modifyStudentWithInvalidSubjectsListShouldReturnError() throws Exception{
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Pepe");
        studentDTO.setSubjects(null);
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payloadJson = writer.writeValueAsString(studentDTO);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();
    }

    @Test
    public void removeStudentWithValidIdShouldReturnOk() throws Exception {
        long studentId = 1L;
        MvcResult mvcResult = this.mockMvc
                .perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}", studentId))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void removeStudentWithInvalidIdShouldReturnOk() throws Exception {
        long studentId = 1L;
        StudentNotFoundException ex = new StudentNotFoundException(studentId);
        when(iStudentDAO.delete(studentId)).thenThrow(new StudentNotFoundException(studentId));

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String errorDTOJSON = writer.writeValueAsString(ex.getError());

        MvcResult mvcResult = this.mockMvc
                .perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}", studentId))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(errorDTOJSON, mvcResult.getResponse().getContentAsString());
    }
}
