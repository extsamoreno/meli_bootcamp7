package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
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

import java.util.ArrayList;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    IStudentDAO studentDAO;

    //create invalid case
    @Test
    public void registerStudentHappyPath() throws Exception {
        //registerStudent

        //student to add
        StudentDTO student = new StudentDTO(3L, "Genaro", "mensaje", 10d, new ArrayList<>() {
            {
                add(new SubjectDTO("Matemática", 10d));
                add(new SubjectDTO("Física", 10d));
                add(new SubjectDTO("Química", 10d));
            }
        });

        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE, false).
                writer().withDefaultPrettyPrinter();

        String payloadJson = writer.writeValueAsString(student);
//falta mockito when coso
        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void getStudentHappyPath() throws Exception {

        StudentDTO student = new StudentDTO(1L, "Juan", null, 10d, new ArrayList<>() {
            {
                add(new SubjectDTO("Matemática", 9.0));
                add(new SubjectDTO("Física", 7.0));
                add(new SubjectDTO("Química", 6.0));
            }
        });

        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE, false).
                writer().withDefaultPrettyPrinter();

        String payloadJson = writer.writeValueAsString(student);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}",1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(""))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString(payloadJson)))
                .andReturn();
    }

    @Test
    public void testGetStudentWithCorrectId() throws Exception {

        StudentDTO student = new StudentDTO(1L, "Juan", null, 10d, new ArrayList<>() {
            {
                add(new SubjectDTO("Matemática", 9.0));
                add(new SubjectDTO("Física", 7.0));
                add(new SubjectDTO("Química", 6.0));
            }
        });

        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE, false).
                writer().withDefaultPrettyPrinter();

        String payloadJson = writer.writeValueAsString(student);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}",1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(""))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString(payloadJson)))
                .andReturn();

    }
}
