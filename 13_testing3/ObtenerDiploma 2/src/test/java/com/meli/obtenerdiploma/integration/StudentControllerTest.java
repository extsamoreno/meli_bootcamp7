package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void registerStudentTestHappyPath() throws Exception {
        StudentDTO expected = new StudentDTO(10L, "Juan", null, null, new ArrayList<>() {
            {
                add(new SubjectDTO("Matemática", 9.0));
                add(new SubjectDTO("Física", 7.0));
                add(new SubjectDTO("Química", 6.0));
            }
        });

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();
        String payloadJSON = writer.writeValueAsString(expected);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJSON))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(""))
                .andReturn();

    }

    @Test
    void registerStudentTestErrorPath() throws Exception {
        StudentDTO expected = new StudentDTO(10L, "Juan", null, null, new ArrayList<>() {
            {
                add(new SubjectDTO("Matemática", 95.0));
                add(new SubjectDTO("Física", 7.0));
                add(new SubjectDTO("Química", 6.0));
            }
        });

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();
        String payloadJSON = writer.writeValueAsString(expected);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJSON))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string(containsString("{\"name\":\"MethodArgumentNotValidException\",\"description\":\"La nota mÃ¡xima de la materia es de 10 pts.\"}")))
                .andReturn();

    }

    @Test
    void getStudentTestHappyPath() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}",1))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string(containsString("{\"id\":1,\"studentName\":\"Juan\",\"message\":null,\"averageScore\":null,\"subjects\":[{\"name\":\"MatemÃ¡tica\",\"score\":9.0},{\"name\":\"FÃ\u00ADsica\",\"score\":7.0},{\"name\":\"QuÃ\u00ADmica\",\"score\":6.0}]}")))
                .andReturn();
    }

    @Test
    void getStudentTestNotFound() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}",10))
                .andDo(print()).andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string(containsString("{\"name\":\"StudentNotFoundException\",\"description\":\"El alumno con Id 10 no se encuetra registrado.\"}")))
                .andReturn();
    }

    @Test
    void modifyStudent() throws Exception {
        StudentDTO expected = new StudentDTO(10L, "Juan", null, null, new ArrayList<>() {
            {
                add(new SubjectDTO("Matemática", 5.0));
                add(new SubjectDTO("Física", 7.0));
                add(new SubjectDTO("Química", 6.0));
            }
        });

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();
        String payloadJSON = writer.writeValueAsString(expected);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJSON))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(""))
                .andReturn();
    }

    @Test
    void removeStudentTestHappyPath() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}",2))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(""))
                .andReturn();
    }

    @Test
    void removeStudentTestNotFound() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}",10))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(""))
                .andReturn();
    }

    @Test
    void listStudentsTest() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string(containsString("[{\"id\":2,\"studentName\":\"Pedro\",\"message\":null,\"averageScore\":null,\"subjects\":[{\"name\":\"MatemÃ¡tica\",\"score\":10.0},{\"name\":\"FÃ\u00ADsica\",\"score\":8.0},{\"name\":\"QuÃ\u00ADmica\",\"score\":4.0}]}]")))
                .andReturn();
    }

    @Test
    void pathNotFoundTest() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudsdsdsents"))
                .andDo(print()).andExpect(status().isNotFound())
                .andExpect(content().string(""))
                .andReturn();
    }
}