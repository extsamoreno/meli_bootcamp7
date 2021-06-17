package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    IStudentDAO iStudentDAO;
    @MockBean
    IStudentRepository iStudentRepository;

    @Test
    public void getByIdHappyPath() throws Exception {
        Long studentId = 1L;
        SubjectDTO subjectOne = new SubjectDTO("Matematica", 10d);
        SubjectDTO subjectTwo = new SubjectDTO("Fisica", 10d);
        SubjectDTO subjectThree = new SubjectDTO("Quimica", 10d);

        ArrayList<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(subjectOne);
        subjectDTOList.add(subjectTwo);
        subjectDTOList.add(subjectThree);

        StudentDTO studentDTO = new StudentDTO(studentId,"Juan","Asd",10d,subjectDTOList);
        Mockito.when(iStudentDAO.findById(studentId)).thenReturn(studentDTO);


        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String responseJson = writer.writeValueAsString(studentDTO);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders
                .get("/student/getStudent/{id}", studentId))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(responseJson, mvcResult.getResponse().getContentAsString());


    }

    @Test
    public void getByIdThrowStudentNotFoundException() throws Exception {
        Mockito.when(iStudentDAO.findById(1L)).thenThrow(new StudentNotFoundException(1L));

        String expectedDescription = "El alumno con Id 1 no se encuentra registrado";

        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", 1))
                .andDo( print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value(expectedDescription));

    }


    @Test
    public void registerStudentHappyPath() throws Exception {
        Long studentId = 1L;
        SubjectDTO subjectOne = new SubjectDTO("Matematica", 10d);
        SubjectDTO subjectTwo = new SubjectDTO("Fisica", 10d);
        SubjectDTO subjectThree = new SubjectDTO("Quimica", 10d);

        ArrayList<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(subjectOne);
        subjectDTOList.add(subjectTwo);
        subjectDTOList.add(subjectThree);

        StudentDTO studentDTO = new StudentDTO(studentId,"Juan","Asd",10d,subjectDTOList);
        Mockito.when(iStudentDAO.findById(studentId)).thenReturn(studentDTO);



        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payloadJson = writer.writeValueAsString(studentDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isOk());

    }

    @Test
    public void modifyStudentTest() throws Exception {
        Long studentId = 1L;
        SubjectDTO subjectOne = new SubjectDTO("Matematica", 10d);
        SubjectDTO subjectTwo = new SubjectDTO("Fisica", 10d);
        SubjectDTO subjectThree = new SubjectDTO("Quimica", 10d);

        ArrayList<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(subjectOne);
        subjectDTOList.add(subjectTwo);
        subjectDTOList.add(subjectThree);

        StudentDTO studentDTO = new StudentDTO(studentId,"Juan","Asd",10d,subjectDTOList);
        Mockito.when(iStudentDAO.findById(studentId)).thenReturn(studentDTO);



        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payloadJson = writer.writeValueAsString(studentDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isOk());

    }

    @Test
    public void removeStudentTest() throws Exception {
        Long studentId = 1L;
        SubjectDTO subjectOne = new SubjectDTO("Matematica", 10d);
        SubjectDTO subjectTwo = new SubjectDTO("Fisica", 10d);
        SubjectDTO subjectThree = new SubjectDTO("Quimica", 10d);

        ArrayList<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(subjectOne);
        subjectDTOList.add(subjectTwo);
        subjectDTOList.add(subjectThree);

        StudentDTO studentDTO = new StudentDTO(studentId,"Juan","Asd",10d,subjectDTOList);
        Mockito.when(iStudentDAO.delete(studentId)).thenReturn(true);


        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders
                .get("/student/getStudent/{id}", studentId))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        Assertions.assertEquals(HttpStatus.OK.value(),mvcResult.getResponse().getStatus());
    }

    @Test
    public void getStudentsTest() throws Exception {
        Long studentId = 1L;
        SubjectDTO subjectOne = new SubjectDTO("Matematica", 10d);
        SubjectDTO subjectTwo = new SubjectDTO("Fisica", 10d);
        SubjectDTO subjectThree = new SubjectDTO("Quimica", 10d);

        ArrayList<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(subjectOne);
        subjectDTOList.add(subjectTwo);
        subjectDTOList.add(subjectThree);

        Set<StudentDTO> studentDTOS = new HashSet<>();
        StudentDTO studentDTOone = new StudentDTO(studentId,"Juan","Asd",10d,subjectDTOList);
        StudentDTO studentDTOtwo = new StudentDTO(studentId,"Pablo","Asd",10d,subjectDTOList);
        studentDTOS.add(studentDTOone);
        studentDTOS.add(studentDTOtwo);

        Mockito.when(iStudentRepository.findAll()).thenReturn(studentDTOS);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String responseJson = writer.writeValueAsString(studentDTOS);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders
                .get("/student/listStudents"))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(responseJson, mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void registerStudentNullPayload() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent"))
                .andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    public void registerStudentEmptyStudent() throws Exception {
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payloadJson = writer.writeValueAsString(new StudentDTO());

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isBadRequest());
    }
}
