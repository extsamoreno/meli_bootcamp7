package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
public class StudentControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void registerStudentHappyPath() throws Exception {
        SubjectDTO subjectDTO = new SubjectDTO("Fisica", 9.0);
        ArrayList<SubjectDTO> subjectList= new ArrayList<>();
        subjectList.add(subjectDTO);
        StudentDTO payloadDTO = new StudentDTO(4L, "George", null, null, subjectList);
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String payloadJson = writer.writeValueAsString(payloadDTO);
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void registerStudentEmptySubjects() throws Exception {
        StudentDTO payloadDTO = new StudentDTO(4L, "George", null, null, new ArrayList<SubjectDTO>());
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String payloadJson = writer.writeValueAsString(payloadDTO);
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().string(containsString("{\"name\":\"MethodArgumentNotValidException\",\"description\":\"La lista de materias no puede estar vacÃ\u00ADa.\"}")))
                .andReturn();
    }

    @Test
    public void registerStudentBlankSubjectName() throws Exception {
        SubjectDTO subjectDTO = new SubjectDTO(null, 9.0);
        ArrayList<SubjectDTO> subjectList= new ArrayList<>();
        subjectList.add(subjectDTO);
        StudentDTO payloadDTO = new StudentDTO(4L, "George", null, null, subjectList);
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String payloadJson = writer.writeValueAsString(payloadDTO);
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().string(containsString("{\"name\":\"MethodArgumentNotValidException\",\"description\":\"El nombre de la materia no puede estar vacÃ\u00ADo.\"}")))
                .andReturn();
    }

    @Test
    public void registerStudentNoMayusSubjectName() throws Exception {
        SubjectDTO subjectDTO = new SubjectDTO("materia", 9.0);
        ArrayList<SubjectDTO> subjectList= new ArrayList<>();
        subjectList.add(subjectDTO);
        StudentDTO payloadDTO = new StudentDTO(4L, "George", null, null, subjectList);
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String payloadJson = writer.writeValueAsString(payloadDTO);
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().string(containsString("{\"name\":\"MethodArgumentNotValidException\",\"description\":\"El nombre de la materia debe comenzar con mayÃºscula.\"}")))
                .andReturn();
    }

    @Test
    public void registerStudentLargeSubjectName() throws Exception {
        SubjectDTO subjectDTO = new SubjectDTO("Materiaconmasdetreintacaracteresensunombre", 9.0);
        ArrayList<SubjectDTO> subjectList= new ArrayList<>();
        subjectList.add(subjectDTO);
        StudentDTO payloadDTO = new StudentDTO(4L, "George", null, null, subjectList);
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String payloadJson = writer.writeValueAsString(payloadDTO);
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().string(containsString("{\"name\":\"MethodArgumentNotValidException\",\"description\":\"La longitud del nombre de la materia no puede superar los 30 caracteres.\"}")))
                .andReturn();
    }

    @Test
    public void registerStudentNegativeScore() throws Exception {
        SubjectDTO subjectDTO = new SubjectDTO("Fisica", -1.0);
        ArrayList<SubjectDTO> subjectList= new ArrayList<>();
        subjectList.add(subjectDTO);
        StudentDTO payloadDTO = new StudentDTO(4L, "George", null, null, subjectList);
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String payloadJson = writer.writeValueAsString(payloadDTO);
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().string(containsString("{\"name\":\"MethodArgumentNotValidException\",\"description\":\"La nota mÃ\u00ADnima de la materia es de 0 pts.\"}")))
                .andReturn();
    }

    @Test
    public void registerStudentGreaterThanTenScore() throws Exception {
        SubjectDTO subjectDTO = new SubjectDTO("Fisica", 11.0);
        ArrayList<SubjectDTO> subjectList= new ArrayList<>();
        subjectList.add(subjectDTO);
        StudentDTO payloadDTO = new StudentDTO(4L, "George", null, null, subjectList);
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String payloadJson = writer.writeValueAsString(payloadDTO);
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().string(containsString("{\"name\":\"MethodArgumentNotValidException\",\"description\":\"La nota mÃ¡xima de la materia es de 10 pts.\"}")))
                .andReturn();
    }
    @Test
    public void registerStudentBlankScore() throws Exception {
        SubjectDTO subjectDTO = new SubjectDTO("Fisica", null);
        ArrayList<SubjectDTO> subjectList= new ArrayList<>();
        subjectList.add(subjectDTO);
        StudentDTO payloadDTO = new StudentDTO(4L, "George", null, null, subjectList);
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String payloadJson = writer.writeValueAsString(payloadDTO);
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andReturn();
    }

    @Test
    public void registerStudentBlankStudentName() throws Exception {
        SubjectDTO subjectDTO = new SubjectDTO("Fisica", 10.0);
        ArrayList<SubjectDTO> subjectList= new ArrayList<>();
        subjectList.add(subjectDTO);
        StudentDTO payloadDTO = new StudentDTO(4L, null, null, null, subjectList);
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String payloadJson = writer.writeValueAsString(payloadDTO);
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().string(containsString("{\"name\":\"MethodArgumentNotValidException\",\"description\":\"El nombre del estudiante no puede estar vacÃ\u00ADo.\"}")))
                .andReturn();
    }

    @Test
    public void registerStudentNoMayusStudentName() throws Exception {
        SubjectDTO subjectDTO = new SubjectDTO("Fisica", 10.0);
        ArrayList<SubjectDTO> subjectList= new ArrayList<>();
        subjectList.add(subjectDTO);
        StudentDTO payloadDTO = new StudentDTO(4L, "mariano", null, null, subjectList);
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String payloadJson = writer.writeValueAsString(payloadDTO);
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().string(containsString("{\"name\":\"MethodArgumentNotValidException\",\"description\":\"El nombre del estudiante debe comenzar con mayÃºscula.\"}")))
                .andReturn();
    }

    @Test
    public void registerStudentLargeStudentName() throws Exception {
        SubjectDTO subjectDTO = new SubjectDTO("Fisica", 10.0);
        ArrayList<SubjectDTO> subjectList= new ArrayList<>();
        subjectList.add(subjectDTO);
        StudentDTO payloadDTO = new StudentDTO(4L, "LargeStudentNamewhitmorethan50caractersLargeStudentNamewhitmorethan50caracters", null, null, subjectList);
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String payloadJson = writer.writeValueAsString(payloadDTO);
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().string(containsString("{\"name\":\"MethodArgumentNotValidException\",\"description\":\"La longitud del nombre del estudiante no puede superar los 50 caracteres.\"}")))
                .andReturn();
    }

    @Test
    public void getStudentOutput() throws Exception {

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}",3))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string(containsString("{\"id\":3,\"studentName\":\"George\"," +
                        "\"message\":null,\"averageScore\":null," +
                        "\"subjects\":[" +
                        "{\"name\":\"Fisica\",\"score\":9.0}]}"))).andReturn();
    }

    @Test
    public void getStudentThrowStudentNotFoundException () throws Exception {

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}",6L))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string(containsString("{\"name\":\"StudentNotFoundException\",\"description\":\"El alumno con Id 6 no se encuetra registrado.\"}")))
                .andReturn();
    }

//    @Test
//    public void listStudentHappyPath() throws Exception {
//        SubjectDTO subjectDTO = new SubjectDTO("Fisica", 9.0);
//        ArrayList<SubjectDTO> subjectList= new ArrayList<>();
//        subjectList.add(subjectDTO);
//        StudentDTO payloadDTO = new StudentDTO(4L, "George", null, null, subjectList);
//        ObjectWriter writer = new ObjectMapper()
//                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
//                .writer();
//        String payloadJson = writer.writeValueAsString(payloadDTO);
//        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/student/listStudent")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(payloadJson))
//                .andDo(print()).andExpect(status().isOk())
//                .andReturn();
//    }

    @Test
    public void modifyStudentEmptySubjects() throws Exception {
        StudentDTO payloadDTO = new StudentDTO(4L, "George", null, null, new ArrayList<SubjectDTO>());
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String payloadJson = writer.writeValueAsString(payloadDTO);
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().string(containsString("{\"name\":\"MethodArgumentNotValidException\",\"description\":\"La lista de materias no puede estar vacÃ\u00ADa.\"}")))
                .andReturn();
    }

    @Test
    public void modifyStudentBlankSubjectName() throws Exception {
        SubjectDTO subjectDTO = new SubjectDTO(null, 9.0);
        ArrayList<SubjectDTO> subjectList= new ArrayList<>();
        subjectList.add(subjectDTO);
        StudentDTO payloadDTO = new StudentDTO(4L, "George", null, null, subjectList);
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String payloadJson = writer.writeValueAsString(payloadDTO);
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().string(containsString("{\"name\":\"MethodArgumentNotValidException\",\"description\":\"El nombre de la materia no puede estar vacÃ\u00ADo.\"}")))
                .andReturn();
    }

    @Test
    public void modifyStudentNoMayusSubjectName() throws Exception {
        SubjectDTO subjectDTO = new SubjectDTO("materia", 9.0);
        ArrayList<SubjectDTO> subjectList= new ArrayList<>();
        subjectList.add(subjectDTO);
        StudentDTO payloadDTO = new StudentDTO(4L, "George", null, null, subjectList);
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String payloadJson = writer.writeValueAsString(payloadDTO);
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().string(containsString("{\"name\":\"MethodArgumentNotValidException\",\"description\":\"El nombre de la materia debe comenzar con mayÃºscula.\"}")))
                .andReturn();
    }

    @Test
    public void modifyStudentLargeSubjectName() throws Exception {
        SubjectDTO subjectDTO = new SubjectDTO("Materiaconmasdetreintacaracteresensunombre", 9.0);
        ArrayList<SubjectDTO> subjectList= new ArrayList<>();
        subjectList.add(subjectDTO);
        StudentDTO payloadDTO = new StudentDTO(4L, "George", null, null, subjectList);
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String payloadJson = writer.writeValueAsString(payloadDTO);
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().string(containsString("{\"name\":\"MethodArgumentNotValidException\",\"description\":\"La longitud del nombre de la materia no puede superar los 30 caracteres.\"}")))
                .andReturn();
    }

    @Test
    public void modifyStudentNegativeScore() throws Exception {
        SubjectDTO subjectDTO = new SubjectDTO("Fisica", -1.0);
        ArrayList<SubjectDTO> subjectList= new ArrayList<>();
        subjectList.add(subjectDTO);
        StudentDTO payloadDTO = new StudentDTO(4L, "George", null, null, subjectList);
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String payloadJson = writer.writeValueAsString(payloadDTO);
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().string(containsString("{\"name\":\"MethodArgumentNotValidException\",\"description\":\"La nota mÃ\u00ADnima de la materia es de 0 pts.\"}")))
                .andReturn();
    }

    @Test
    public void modifyStudentGreaterThanTenScore() throws Exception {
        SubjectDTO subjectDTO = new SubjectDTO("Fisica", 11.0);
        ArrayList<SubjectDTO> subjectList= new ArrayList<>();
        subjectList.add(subjectDTO);
        StudentDTO payloadDTO = new StudentDTO(4L, "George", null, null, subjectList);
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String payloadJson = writer.writeValueAsString(payloadDTO);
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().string(containsString("{\"name\":\"MethodArgumentNotValidException\",\"description\":\"La nota mÃ¡xima de la materia es de 10 pts.\"}")))
                .andReturn();
    }
    @Test
    public void modifyStudentBlankScore() throws Exception {
        SubjectDTO subjectDTO = new SubjectDTO("Fisica", null);
        ArrayList<SubjectDTO> subjectList= new ArrayList<>();
        subjectList.add(subjectDTO);
        StudentDTO payloadDTO = new StudentDTO(4L, "George", null, null, subjectList);
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String payloadJson = writer.writeValueAsString(payloadDTO);
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andReturn();
    }

    @Test
    public void modifyStudentBlankStudentName() throws Exception {
        SubjectDTO subjectDTO = new SubjectDTO("Fisica", 10.0);
        ArrayList<SubjectDTO> subjectList= new ArrayList<>();
        subjectList.add(subjectDTO);
        StudentDTO payloadDTO = new StudentDTO(4L, null, null, null, subjectList);
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String payloadJson = writer.writeValueAsString(payloadDTO);
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().string(containsString("{\"name\":\"MethodArgumentNotValidException\",\"description\":\"El nombre del estudiante no puede estar vacÃ\u00ADo.\"}")))
                .andReturn();
    }

    @Test
    public void modifyStudentNoMayusStudentName() throws Exception {
        SubjectDTO subjectDTO = new SubjectDTO("Fisica", 10.0);
        ArrayList<SubjectDTO> subjectList= new ArrayList<>();
        subjectList.add(subjectDTO);
        StudentDTO payloadDTO = new StudentDTO(4L, "mariano", null, null, subjectList);
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String payloadJson = writer.writeValueAsString(payloadDTO);
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().string(containsString("{\"name\":\"MethodArgumentNotValidException\",\"description\":\"El nombre del estudiante debe comenzar con mayÃºscula.\"}")))
                .andReturn();
    }

    @Test
    public void modifyStudentLargeStudentName() throws Exception {
        SubjectDTO subjectDTO = new SubjectDTO("Fisica", 10.0);
        ArrayList<SubjectDTO> subjectList= new ArrayList<>();
        subjectList.add(subjectDTO);
        StudentDTO payloadDTO = new StudentDTO(4L, "LargeStudentNamewhitmorethan50caractersLargeStudentNamewhitmorethan50caracters", null, null, subjectList);
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String payloadJson = writer.writeValueAsString(payloadDTO);
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().string(containsString("{\"name\":\"MethodArgumentNotValidException\",\"description\":\"La longitud del nombre del estudiante no puede superar los 50 caracteres.\"}")))
                .andReturn();
    }

    @Test
    public void removeStudentOutput() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}",1L))
                .andDo(print()).andExpect(status().isOk()).andReturn();
    }

    @Test
    public void modifyStudentHappyPath() throws Exception {
        SubjectDTO subjectDTO = new SubjectDTO("Fisica", 9.0);
        ArrayList<SubjectDTO> subjectList= new ArrayList<>();
        subjectList.add(subjectDTO);
        StudentDTO payloadDTO = new StudentDTO(4L, "George", null, null, subjectList);
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String payloadJson = writer.writeValueAsString(payloadDTO);
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void modifyStudentEmptySubjects() throws Exception {
        StudentDTO payloadDTO = new StudentDTO(4L, "George", null, null, new ArrayList<SubjectDTO>());
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String payloadJson = writer.writeValueAsString(payloadDTO);
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().string(containsString("{\"name\":\"MethodArgumentNotValidException\",\"description\":\"La lista de materias no puede estar vacÃ\u00ADa.\"}")))
                .andReturn();
    }

    @Test
    public void modifyStudentBlankSubjectName() throws Exception {
        SubjectDTO subjectDTO = new SubjectDTO(null, 9.0);
        ArrayList<SubjectDTO> subjectList= new ArrayList<>();
        subjectList.add(subjectDTO);
        StudentDTO payloadDTO = new StudentDTO(4L, "George", null, null, subjectList);
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String payloadJson = writer.writeValueAsString(payloadDTO);
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().string(containsString("{\"name\":\"MethodArgumentNotValidException\",\"description\":\"El nombre de la materia no puede estar vacÃ\u00ADo.\"}")))
                .andReturn();
    }

    @Test
    public void modifyStudentNoMayusSubjectName() throws Exception {
        SubjectDTO subjectDTO = new SubjectDTO("materia", 9.0);
        ArrayList<SubjectDTO> subjectList= new ArrayList<>();
        subjectList.add(subjectDTO);
        StudentDTO payloadDTO = new StudentDTO(4L, "George", null, null, subjectList);
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String payloadJson = writer.writeValueAsString(payloadDTO);
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().string(containsString("{\"name\":\"MethodArgumentNotValidException\",\"description\":\"El nombre de la materia debe comenzar con mayÃºscula.\"}")))
                .andReturn();
    }

    @Test
    public void modifyStudentLargeSubjectName() throws Exception {
        SubjectDTO subjectDTO = new SubjectDTO("Materiaconmasdetreintacaracteresensunombre", 9.0);
        ArrayList<SubjectDTO> subjectList= new ArrayList<>();
        subjectList.add(subjectDTO);
        StudentDTO payloadDTO = new StudentDTO(4L, "George", null, null, subjectList);
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String payloadJson = writer.writeValueAsString(payloadDTO);
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().string(containsString("{\"name\":\"MethodArgumentNotValidException\",\"description\":\"La longitud del nombre de la materia no puede superar los 30 caracteres.\"}")))
                .andReturn();
    }

    @Test
    public void modifyStudentNegativeScore() throws Exception {
        SubjectDTO subjectDTO = new SubjectDTO("Fisica", -1.0);
        ArrayList<SubjectDTO> subjectList= new ArrayList<>();
        subjectList.add(subjectDTO);
        StudentDTO payloadDTO = new StudentDTO(4L, "George", null, null, subjectList);
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String payloadJson = writer.writeValueAsString(payloadDTO);
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().string(containsString("{\"name\":\"MethodArgumentNotValidException\",\"description\":\"La nota mÃ\u00ADnima de la materia es de 0 pts.\"}")))
                .andReturn();
    }

    @Test
    public void modifyStudentGreaterThanTenScore() throws Exception {
        SubjectDTO subjectDTO = new SubjectDTO("Fisica", 11.0);
        ArrayList<SubjectDTO> subjectList= new ArrayList<>();
        subjectList.add(subjectDTO);
        StudentDTO payloadDTO = new StudentDTO(4L, "George", null, null, subjectList);
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String payloadJson = writer.writeValueAsString(payloadDTO);
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().string(containsString("{\"name\":\"MethodArgumentNotValidException\",\"description\":\"La nota mÃ¡xima de la materia es de 10 pts.\"}")))
                .andReturn();
    }
    @Test
    public void modifyStudentBlankScore() throws Exception {
        SubjectDTO subjectDTO = new SubjectDTO("Fisica", null);
        ArrayList<SubjectDTO> subjectList= new ArrayList<>();
        subjectList.add(subjectDTO);
        StudentDTO payloadDTO = new StudentDTO(4L, "George", null, null, subjectList);
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String payloadJson = writer.writeValueAsString(payloadDTO);
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andReturn();
    }

    @Test
    public void modifyStudentBlankStudentName() throws Exception {
        SubjectDTO subjectDTO = new SubjectDTO("Fisica", 10.0);
        ArrayList<SubjectDTO> subjectList= new ArrayList<>();
        subjectList.add(subjectDTO);
        StudentDTO payloadDTO = new StudentDTO(4L, null, null, null, subjectList);
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String payloadJson = writer.writeValueAsString(payloadDTO);
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().string(containsString("{\"name\":\"MethodArgumentNotValidException\",\"description\":\"El nombre del estudiante no puede estar vacÃ\u00ADo.\"}")))
                .andReturn();
    }

    @Test
    public void modifyStudentNoMayusStudentName() throws Exception {
        SubjectDTO subjectDTO = new SubjectDTO("Fisica", 10.0);
        ArrayList<SubjectDTO> subjectList= new ArrayList<>();
        subjectList.add(subjectDTO);
        StudentDTO payloadDTO = new StudentDTO(4L, "mariano", null, null, subjectList);
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String payloadJson = writer.writeValueAsString(payloadDTO);
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().string(containsString("{\"name\":\"MethodArgumentNotValidException\",\"description\":\"El nombre del estudiante debe comenzar con mayÃºscula.\"}")))
                .andReturn();
    }

    @Test
    public void modifyStudentLargeStudentName() throws Exception {
        SubjectDTO subjectDTO = new SubjectDTO("Fisica", 10.0);
        ArrayList<SubjectDTO> subjectList= new ArrayList<>();
        subjectList.add(subjectDTO);
        StudentDTO payloadDTO = new StudentDTO(4L, "LargeStudentNamewhitmorethan50caractersLargeStudentNamewhitmorethan50caracters", null, null, subjectList);
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String payloadJson = writer.writeValueAsString(payloadDTO);
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().string(containsString("{\"name\":\"MethodArgumentNotValidException\",\"description\":\"La longitud del nombre del estudiante no puede superar los 50 caracteres.\"}")))
                .andReturn();
    }

    @Test
    public void removeStudentOutput() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}",1L))
                .andDo(print()).andExpect(status().isOk()).andReturn();
    }





}
