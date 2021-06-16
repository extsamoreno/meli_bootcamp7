package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;
    private ObjectWriter writer;

    @MockBean
    StudentDAO studentDAO;

    @MockBean
    StudentRepository studentRepository;

    @BeforeEach
    public void setup(){
        writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE, false).
                writer().withDefaultPrettyPrinter();
    }

    @Test
    void registerStudentHappyPath() throws Exception {

        StudentDTO studentDTO = new StudentDTO(1L,"JuanC", null, null,
                List.of(new SubjectDTO("Matematicas", 10.0), new SubjectDTO("Español", 8.0)));

        String payloadJson = writer.writeValueAsString(studentDTO);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent" )
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void registerStudentListEmpty() throws Exception {

        StudentDTO studentDTO = new StudentDTO(1L,"Juan", null, null,null);
        String payloadJson = writer.writeValueAsString(studentDTO);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent" )
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string("{\"name\":\"MethodArgumentNotValidException\",\"description\":\"La lista de materias no puede estar vacÃ\u00ADa.\"}"))
                .andReturn();
    }

    @Test
    void getStudent() throws Exception {
        Long id  = 1L;
        StudentDTO studentDTO = new StudentDTO();
        String response = writer.writeValueAsString(studentDTO);
        when(studentDAO.findById(any())).thenReturn(studentDTO);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", id))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(response))
                .andReturn();
    }

    @Test
    void modifyStudent() throws Exception {
        StudentDTO studentDTO = new StudentDTO(1L,"JuanC", null, null,
                List.of(new SubjectDTO("Matematicas", 10.0), new SubjectDTO("Español", 8.0)));
        String payloadJson = writer.writeValueAsString(studentDTO);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isOk())
                .andReturn();
        assertEquals(200,mvcResult.getResponse().getStatus());
        verify(studentDAO, atLeastOnce()).save(any());
    }

    @Test
    void ModifyStudentTestListEmpty() throws Exception {
        StudentDTO studentDTO = new StudentDTO(1L,"Juan", null, null,null);
        String payloadJson = writer.writeValueAsString(studentDTO);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent" )
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string("{\"name\":\"MethodArgumentNotValidException\",\"description\":\"La lista de materias no puede estar vacÃ\u00ADa.\"}"))
                .andReturn();
    }

    @Test
    void removeStudent() throws Exception {
        Long id  = 1L;
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}", id))
                .andDo(print()).andExpect(status().isOk())
                .andReturn();
        assertEquals(200,mvcResult.getResponse().getStatus());
        verify(studentDAO, atLeastOnce()).delete(any());
    }

    @Test
    void listStudents() throws Exception {
        Set<StudentDTO>  listStudents = Set.of(new StudentDTO(), new StudentDTO(1L));
        String response = writer.writeValueAsString(listStudents);
        when(studentRepository.findAll()).thenReturn(listStudents);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(response))
                .andReturn();
        verify(studentRepository, atLeastOnce()).findAll();
    }

}