package com.meli.obtenerdiploma.integration.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.unit.repository.IStudentDAO;
import com.meli.obtenerdiploma.unit.repository.IStudentRepository;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
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

import java.util.Set;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerIntTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    IStudentDAO iStudentDAO;

    @MockBean
    IStudentRepository iStudentRepository;

    @Test
    public void registerStudentHappyPath() throws Exception {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Juan");

        ObjectWriter writer = new ObjectMapper() .configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        String payloadJson = writer.writeValueAsString(studentDTO);

        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isOk())
                .andReturn();

        //Assertions.assertEquals(payloadJson, response.getResponse().getContentAsString());
    }

    @Test
    public void registerStudentNullPayload() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void registerStudentEmptyStudent() throws Exception {
        ObjectWriter writer = new ObjectMapper() .configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        String payloadJson = writer.writeValueAsString(new StudentDTO());

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    public void getStudentHappyPath() throws Exception {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Juan");
        Mockito.when(iStudentDAO.findById(1L)).thenReturn(studentDTO);

        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/student/getStudent/{id}",1 ))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
    }

    @Test
    public void getStudentWithNotExistIdStudentTest() throws Exception {
        Mockito.when(iStudentDAO.findById(1L)).thenThrow(new StudentNotFoundException(1L));
        String expectedDescription = "El alumno con Id 1 no se encuetra registrado.";

        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", 1))
                .andDo( print()).andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value(expectedDescription));
    }

    @Test
    public void modifyStudentHappyPath() throws Exception {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Juan");

        ObjectWriter writer = new ObjectMapper() .configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        String payloadJson = writer.writeValueAsString(studentDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void modifyStudentNullPayload() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent"))
            .andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    public void modifyStudentEmptyStudent() throws Exception {

        ObjectWriter writer = new ObjectMapper() .configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        String payloadJson = writer.writeValueAsString(new StudentDTO());

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
            .contentType(MediaType.APPLICATION_JSON)
            .content(payloadJson))
            .andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    public void removeStudentHappyPath() throws Exception {
        Mockito.when(iStudentDAO.delete(1l)).thenReturn(true);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}", 1))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void removeStudentNotExistId() throws Exception {
        Mockito.when(iStudentDAO.delete(1l)).thenReturn(false);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}", 1))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void listStudentsTest() throws Exception {
        Set<StudentDTO> students = TestUtilsGenerator.getStudentSet();

        Mockito.when(iStudentRepository.findAll()).thenReturn(students);

        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        /*ObjectWriter writer = new ObjectMapper() .configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        String payloadJson = writer.writeValueAsString(students);

        Assertions.assertEquals(payloadJson, response.getResponse().getContentAsString());*/
    }
}
