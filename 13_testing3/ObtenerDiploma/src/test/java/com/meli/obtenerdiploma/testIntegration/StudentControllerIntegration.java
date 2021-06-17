package com.meli.obtenerdiploma.testIntegration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.ErrorDTO;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerIntegration {

        @MockBean
        IStudentDAO studentDAO;

        @Autowired
        private MockMvc mockMvc;
    @Test
    public void getStudentHappyPath() throws Exception {

        Long idStu = 1L;
        List<SubjectDTO> subjectList = new ArrayList<>();
        subjectList.add(new SubjectDTO("Matematicas",10D));
        subjectList.add(new SubjectDTO("Literatura",8D));
        StudentDTO student = new StudentDTO(idStu,"Juan",null,null,subjectList);

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

        String responseJson = writer.writeValueAsString(student);

        Mockito.when(studentDAO.findById(idStu)).thenReturn(student);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}",1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string(containsString(responseJson)))
                .andReturn();
    }



    @Test
    public void registerStudentHappyPath() throws Exception {

        Long idStu = 1L;
        List<SubjectDTO> subjectList = new ArrayList<>();
        subjectList.add(new SubjectDTO("Matematicas",10D));
        subjectList.add(new SubjectDTO("Literatura",8D));
        StudentDTO student = new StudentDTO(idStu,"Juan",null,null,subjectList);

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

        String responseJson = writer.writeValueAsString(student);

        Mockito.when(studentDAO.findById(idStu)).thenReturn(student);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType("application/json")
                .content(responseJson))
                .andDo(print()).andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void analyzeScoresHappyPath() throws Exception {
        Long idStu = 1L;
        List<SubjectDTO> subjectList = new ArrayList<>();
        subjectList.add(new SubjectDTO("Matematicas",10D));
        subjectList.add(new SubjectDTO("Literatura",8D));
        StudentDTO student = new StudentDTO(idStu,"Juan",null,null,subjectList);
        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        String responseJson = writer.writeValueAsString(student);
        Mockito.when(studentDAO.findById(idStu)).thenReturn(student);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}",idStu))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string(containsString("\"averageScore\":9.0")))
                .andReturn();
    }

}
