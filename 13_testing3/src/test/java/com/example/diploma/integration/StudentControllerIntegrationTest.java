package com.example.diploma.integration;

import com.example.diploma.model.StudentDTO;
import com.example.diploma.repository.IStudentDAO;
import com.example.diploma.repository.IStudentRepository;
import com.example.diploma.unit.util.TestUtilsGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
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

import java.util.HashSet;
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
    IStudentRepository iStudentRepository;

    @MockBean
    IStudentDAO iStudentDAO;

    ObjectMapper mapper = new ObjectMapper();

    //REGISTER STUDENT

    @Test
    public void testRegisterExistentStudent() throws Exception {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Pedro");
        String responseJson = toJson(studentDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(responseJson))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void testRegisterNullStudent() throws Exception {
        StudentDTO studentDTO = null;
        String responseJson = toJson(studentDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(responseJson))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

    @Test
    public void testRegisterEmptyStudent() throws Exception {
        StudentDTO studentDTO = new StudentDTO();
        String responseJson = toJson(studentDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(responseJson))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

    //GET STUDENT

    @Test
    public void testGetExistentStudent() throws Exception {
        StudentDTO expected = TestUtilsGenerator.getStudentWith3Subjects("Juan");
        Mockito.when(iStudentDAO.findById(expected.getId())).thenReturn(expected);

        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", expected.getId()))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk())
                .andReturn();

        StudentDTO received = (StudentDTO) fromJson(response.getResponse().getContentAsString(), StudentDTO.class);
        Assertions.assertEquals(expected,received);
    }

    //MODIFY STUDENT

    @Test
    public void testModifyExistentStudent() throws Exception {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Juan");
        String responseJson = toJson(studentDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(responseJson))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void testModifyNullStudent() throws Exception {
        StudentDTO studentDTO = null;
        String responseJson = toJson(studentDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(responseJson))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

    @Test
    public void testModifyEmptyStudent() throws Exception {
        StudentDTO studentDTO = new StudentDTO();
        String responseJson = toJson(studentDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(responseJson))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

    //REMOVE STUDENT

    @Test
    public void testRemoveExistentStudent() throws Exception {
        long id = 3L;
        Mockito.when(iStudentDAO.delete(id)).thenReturn(true);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}", id))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void testRemoveInexistentStudent() throws Exception {
        long id = 5L;
        Mockito.when(iStudentDAO.delete(id)).thenReturn(false);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}", id))
                .andDo(print()).andExpect(status().isOk());
    }

    //LIST STUDENTS

    @Test
    public void testListStudents() throws Exception {
        Set<StudentDTO> expected = TestUtilsGenerator.getStudentSet();
        Mockito.when(iStudentRepository.findAll()).thenReturn(expected);

        MvcResult responseJson = this.mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        Set<StudentDTO> response = fromJsonToSet(responseJson.getResponse().getContentAsString(), StudentDTO.class);
        Assertions.assertEquals(expected,response);
    }

    private <T> String toJson(T object) throws JsonProcessingException {
        ObjectWriter writer = mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false). writer().withDefaultPrettyPrinter();

        return writer.writeValueAsString(object);
    }

    private <T> T fromJson(String payloadJson, Class<T> oClass) throws JsonProcessingException {
        new ObjectMapper();

        return mapper.readValue(payloadJson, oClass);
    }

    private <T> Set<T> fromJsonToSet(String payloadJson, Class<T> oClass) throws JsonProcessingException {
        return mapper.readValue(payloadJson, mapper.getTypeFactory().constructCollectionType(HashSet.class, oClass));
    }
}
