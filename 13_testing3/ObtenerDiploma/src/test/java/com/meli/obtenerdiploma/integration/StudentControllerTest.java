package com.meli.obtenerdiploma.integration;

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

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IStudentDAO studentDAO;
    @MockBean
    private IStudentRepository studentRepository;

    @Test
    public void registerStudentHappyPath() throws Exception {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Jose");
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer().withDefaultPrettyPrinter();
        String json = writer.writeValueAsString(studentDTO);

        doNothing().when(studentDAO).save(studentDTO);

        MvcResult mvcResult =
                this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andDo(print()).andExpect(status().isOk()).andReturn();

        verify(studentDAO,atLeastOnce()).save(studentDTO);
    }

    @Test
    public void getStudentHappyPath() throws Exception {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Alberto");
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();
        String expected = writer.writeValueAsString(studentDTO);

        when(studentDAO.findById(1L)).thenReturn(studentDTO);

        MvcResult mvcResult =
                this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}",1))
                        .andDo(print()).andExpect(status().isOk())
                        .andExpect(content().contentType("application/json;charset=UTF-8")).andReturn();

        verify(studentDAO,atLeastOnce()).findById(1L);
        Assertions.assertEquals(expected, mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void modifyStudentHappyPath() throws Exception {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Jose");
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer().withDefaultPrettyPrinter();
        String json = writer.writeValueAsString(studentDTO);

        doNothing().when(studentDAO).save(studentDTO);

        MvcResult mvcResult =
                this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                        .andDo(print()).andExpect(status().isOk()).andReturn();

        verify(studentDAO,atLeastOnce()).save(studentDTO);
    }

    @Test
    public void removeStudentHappyPath() throws Exception {
        when(studentDAO.delete(1L)).thenReturn(true);

        MvcResult mvcResult =
                this.mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}",1))
                        .andDo(print()).andExpect(status().isOk()).andReturn();

        verify(studentDAO,atLeastOnce()).delete(1L);
    }

    @Test
    public void listStudentsHappyPath() throws Exception {
        Set<StudentDTO> studentSet = new HashSet<>();
        studentSet.add(TestUtilsGenerator.getStudentWith3Subjects("Alberto"));
        studentSet.add(TestUtilsGenerator.getStudentWith3Subjects("Laura"));
        studentSet.add(TestUtilsGenerator.getStudentWith3Subjects("Federico"));
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();
        String expected = writer.writeValueAsString(studentSet);

        when(studentRepository.findAll()).thenReturn(studentSet);

        MvcResult mvcResult =
                this.mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents",1))
                        .andDo(print()).andExpect(status().isOk())
                        .andExpect(content().contentType("application/json;charset=UTF-8")).andReturn();

        verify(studentRepository,atLeastOnce()).findAll();
        Assertions.assertEquals(expected, mvcResult.getResponse().getContentAsString());
    }

    /*MvcResult mvcResult =
            this.mockMvc.perform(MockMvcRequestBuilders.get("/student/"))
                    .andDo(print()).andExpect(status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("a").value("a"))
                        .andExpect(content().contentType("application/json;charset=UTF-8"))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("a")).andReturn();*/
}
