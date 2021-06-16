package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.Matchers.containsString;
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

    @MockBean
    IStudentRepository iStudentRepository;

    @Test
    public void getStudentHappyPath() throws Exception {

        Long idStu = 1L;
        List<SubjectDTO> subjectList = new ArrayList<>();
        subjectList.add(new SubjectDTO("Matematicas",10D));
        subjectList.add(new SubjectDTO("Literatura",8D));
        StudentDTO student = new StudentDTO(idStu,"Juan",null,null,subjectList);

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

        String responseJson = writer.writeValueAsString(student);

        Mockito.when(iStudentDAO.findById(idStu)).thenReturn(student);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}",idStu))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string(containsString(responseJson)))
                .andReturn();

        Mockito.verify(iStudentDAO,Mockito.atLeastOnce()).findById(idStu);
    }

    @Test
    public void registerStudentHappyPath() throws Exception {

        Long idStu = 1L;
        List<SubjectDTO> subjectList = new ArrayList<>();
        subjectList.add(new SubjectDTO("Matematicas",10D));
        subjectList.add(new SubjectDTO("Literatura",8D));
        StudentDTO student = new StudentDTO(idStu,"Juan",null,null,subjectList);
        Mockito.doNothing().when(iStudentDAO).save(student);

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

        String responseJson = writer.writeValueAsString(student);


        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                    .contentType("application/json")
                    .content(responseJson))
                .andDo(print()).andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void modifyStudentHappyPath() throws Exception {

        Long idStu = 1L;
        List<SubjectDTO> subjectList = new ArrayList<>();
        subjectList.add(new SubjectDTO("Matematicas",10D));
        subjectList.add(new SubjectDTO("Literatura",8D));
        StudentDTO student = new StudentDTO(idStu,"Juan",null,null,subjectList);
        Mockito.doNothing().when(iStudentDAO).save(student);

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

        String responseJson = writer.writeValueAsString(student);


        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                    .contentType("application/json")
                    .content(responseJson))
                .andDo(print()).andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void listStudentsStudentHappyPath() throws Exception {

        Long idStu = 1L;
        List<SubjectDTO> subjectList = new ArrayList<>();
        subjectList.add(new SubjectDTO("Matematicas",10D));
        subjectList.add(new SubjectDTO("Literatura",8D));
        //StudentDTO student = new StudentDTO(idStu,"Juan",null,null,subjectList);

        Set<StudentDTO> studentList = new HashSet<>();
        studentList.add(new StudentDTO(idStu,"Juan",null,null,subjectList));
        studentList.add(new StudentDTO(idStu,"Pedro",null,null,subjectList));
        studentList.add(new StudentDTO(idStu,"Pablo",null,null,subjectList));

        Mockito.when(iStudentRepository.findAll()).thenReturn(studentList);

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

        String responseJson = writer.writeValueAsString(studentList);


        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents/"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string(containsString(responseJson)))
                .andReturn();
    }


    @Test
    public void removeStudentHappyPath() throws Exception {

        Long idStu = 1L;
        List<SubjectDTO> subjectList = new ArrayList<>();
        subjectList.add(new SubjectDTO("Matematicas",10D));
        subjectList.add(new SubjectDTO("Literatura",8D));
        StudentDTO student = new StudentDTO(idStu,"Juan",null,null,subjectList);

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

        String responseJson = writer.writeValueAsString(student);

        Mockito.when(iStudentDAO.delete(idStu)).thenReturn(true);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}",idStu))
                .andDo(print()).andExpect(status().isOk())
                .andReturn();
    }

}
