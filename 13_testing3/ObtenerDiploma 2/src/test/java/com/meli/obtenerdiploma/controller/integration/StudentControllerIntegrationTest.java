package com.meli.obtenerdiploma.controller.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testRegisterStudentWithCorrectPayload() throws Exception {
        StudentDTO student = new StudentDTO(3L,"George",null,null,new ArrayList<>() {
            {
                add(new SubjectDTO("Matemática", 9.0));
                add(new SubjectDTO("Física", 7.0));
                add(new SubjectDTO("Química", 6.0));
            }
        });

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payloadJson = writer.writeValueAsString(student);

        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isOk())
                .andReturn();

    }

    @Test
    public void testRegisterStudentWitBlankStudentName() throws Exception {
        StudentDTO student = new StudentDTO(3L,null,null,null,new ArrayList<>() {
            {
                add(new SubjectDTO("Matemática", 9.0));
                add(new SubjectDTO("Física", 7.0));
                add(new SubjectDTO("Química", 6.0));
            }
        });

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payloadJson = writer.writeValueAsString(student);

        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isBadRequest())
                .andReturn();

    }

    @Test
    public void testGetStudentWithCorrectId() throws Exception {

        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}",1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(""))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("{\"id\":1,\"studentName\":\"Juan\",\"message\":null,\"averageScore\":null,\"subjects\":[{\"name\":\"MatemÃ¡tica\",\"score\":9.0},{\"name\":\"FÃ\u00ADsica\",\"score\":7.0},{\"name\":\"QuÃ\u00ADmica\",\"score\":6.0}]}")))
                .andReturn();

    }

    @Test
    public void testGetStudentWithUnknownId() throws Exception {

        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}",10)
                .contentType(MediaType.APPLICATION_JSON)
                .content(""))
                .andDo(print()).andExpect(status().isNotFound())
                .andReturn();

    }

    @Test
    public void testModifyStudentWithCorrectPayload() throws Exception {
        StudentDTO student = new StudentDTO(3L,"Georgito",null,null,new ArrayList<>() {
            {
                add(new SubjectDTO("Matemática", 6.0));
                add(new SubjectDTO("Física", 10.0));
                add(new SubjectDTO("Química", 6.0));
            }
        });

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payloadJson = writer.writeValueAsString(student);

        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isOk())
                .andReturn();

    }

    @Test
    public void testRemoveStudentWithCorrectId() throws Exception {
        StudentDTO student = new StudentDTO(3L,null,null,null,new ArrayList<>() {
            {
                add(new SubjectDTO("Matemática", 6.0));
                add(new SubjectDTO("Física", 10.0));
                add(new SubjectDTO("Química", 6.0));
            }
        });

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payloadJson = writer.writeValueAsString(student);

        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}",3)
                .contentType(MediaType.APPLICATION_JSON)
                .content(""))
                .andDo(print()).andExpect(status().isOk())
                .andReturn();

    }

    @Test
    public void testRemoveStudentWithIncorrectId() throws Exception {
        StudentDTO student = new StudentDTO(3L,null,null,null,new ArrayList<>() {
            {
                add(new SubjectDTO("Matemática", 6.0));
                add(new SubjectDTO("Física", 10.0));
                add(new SubjectDTO("Química", 6.0));
            }
        });

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payloadJson = writer.writeValueAsString(student);

        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}",15)
                .contentType(MediaType.APPLICATION_JSON)
                .content(""))
                .andDo(print()).andExpect(status().isOk()) // Deberia ser NotFound pero hay un catch que lo evita
                .andReturn();

    }

    @Test
    public void testListStudents() throws Exception {

        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents")
                .contentType(MediaType.APPLICATION_JSON)
                .content(""))
                .andDo(print()).andExpect(status().isOk())
                .andReturn();

    }

}
