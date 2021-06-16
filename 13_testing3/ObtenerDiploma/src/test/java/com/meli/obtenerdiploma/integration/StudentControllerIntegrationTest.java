package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
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
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

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

    @Test
    public void registerStudentHappyPath() throws Exception {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Juan");
        String payloadJson = toJson(studentDTO);

        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void registerStudentNullPayload() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/student/registerStudent"))
                .andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    public void registerStudentEmptyStudent() throws Exception {
        String payloadJson = toJson(new StudentDTO());
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    public void getStudentHappyPath() throws Exception {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Juan");
        Mockito.when(iStudentDAO.findById(studentDTO.getId())).thenReturn(studentDTO);

        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders
                .get("/student/getStudent/{id}", 9999))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        StudentDTO studentDTO1 = (StudentDTO) fromJson(response.getResponse().getContentAsString(), StudentDTO.class);
        Assertions.assertEquals(studentDTO, studentDTO1);
    }

    @Test
    public void getStudentNonExistingId() throws Exception {
        Mockito.when(iStudentDAO.findById(1L)).thenThrow(new StudentNotFoundException(1L));
        String expectedDescription = "El alumno con Id 1 no se encuetra registrado.";

        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/student/getStudent/{id}", 1))
                .andDo(print()).andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value(expectedDescription));
    }

    @Test
    public void modifyStudentHappyPath() throws Exception {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Juan");
        String payloadJson = toJson(studentDTO);

        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void modifyStudentNullPayload() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/student/modifyStudent"))
                .andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    public void modifyStudentEmptyStudent() throws Exception {
        String payloadJson = toJson(new StudentDTO());
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    public void removeStudentHappyPath() throws Exception {
        Mockito.when(iStudentDAO.delete(9999L)).thenReturn(true);

        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/student/removeStudent/{id}", 9999))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void removeStudentNonExistingId() throws Exception {
        Mockito.when(iStudentDAO.delete(8888L)).thenReturn(false);
        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/student/removeStudent/{id}", 8888))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void listStudentsHappyPath() throws Exception {
        Set<StudentDTO> students = TestUtilsGenerator.getStudentSet();
        Mockito.when(iStudentRepository.findAll()).thenReturn(students);

        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders
                .get("/student/listStudents"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        Set<StudentDTO> responseSet = fromJsonToSet(response.getResponse().getContentAsString(), StudentDTO.class);
        Assertions.assertEquals(students, responseSet);
    }

    private <T> String toJson(T object) throws JsonProcessingException {
        ObjectWriter writer = mapper
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer()
                .withDefaultPrettyPrinter();

        return writer.writeValueAsString(object);
    }

    private <T> T fromJson(String payloadJson, Class<T> oClass) throws JsonProcessingException {
        return mapper.readValue(payloadJson, oClass);
    }

    private <T> Set<T> fromJsonToSet(String payloadJson, Class<T> oClass) throws JsonProcessingException {
        new ObjectMapper();
        return mapper
                .readValue(payloadJson, mapper.getTypeFactory().constructCollectionType(HashSet.class, oClass));
    }
}
