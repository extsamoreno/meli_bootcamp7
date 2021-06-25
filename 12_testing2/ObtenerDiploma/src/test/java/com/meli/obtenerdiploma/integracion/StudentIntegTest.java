package com.meli.obtenerdiploma.integracion;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.Utils.Utils;
import com.meli.obtenerdiploma.model.ErrorDTO;
import com.meli.obtenerdiploma.model.StudentDTO;
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

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Locale;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentIntegTest {

    @Autowired
    MockMvc mockMvc;


    @Test
    public void testRegisterStudentOutput() throws Exception {
        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        StudentDTO studentDTO = Utils.getStudentDTO();
        studentDTO.setId(null);
        String payloadJson = writer.writeValueAsString(studentDTO);
        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON).content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").doesNotExist())
                .andReturn();
    }

    @Test
    public void testRegisterStudentSubjectsNonCapitalLetterOutput() throws Exception {
        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        StudentDTO studentDTO = Utils.getStudentDTO();
        studentDTO.getSubjects().get(0).setName(studentDTO.getSubjects().get(0).getName().toLowerCase(Locale.ROOT));
        studentDTO.setId(null);
        String payloadJson = writer.writeValueAsString(studentDTO);

        ErrorDTO errorResultJson = new ErrorDTO("MethodArgumentNotValidException","El nombre de la materia debe comenzar con mayúscula.");
        String errorExpectJson = writer.writeValueAsString(errorResultJson);

        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON).content(payloadJson))
                .andDo(print())
                .andExpect(status().isBadRequest()).andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(errorExpectJson, result.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }


    @Test
    public void testRegisterStudentSubjectsNullOutput() throws Exception {
        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        StudentDTO studentDTO = Utils.getStudentDTO();
        studentDTO.setSubjects(null);
        studentDTO.setId(null);
        String payloadJson = writer.writeValueAsString(studentDTO);

        ErrorDTO errorResultJson = new ErrorDTO("MethodArgumentNotValidException","La lista de materias no puede estar vacía.");
        String errorExpectJson = writer.writeValueAsString(errorResultJson);

        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON).content(payloadJson))
                .andDo(print())
                .andExpect(status().isBadRequest()).andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(errorExpectJson, result.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    @Test
    public void testRegisterStudentSubjectsEmptyOutput() throws Exception {
        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        StudentDTO studentDTO = Utils.getStudentDTO();
        studentDTO.setSubjects(new ArrayList<>());
        studentDTO.setId(null);
        String payloadJson = writer.writeValueAsString(studentDTO);

        ErrorDTO errorResultJson = new ErrorDTO("MethodArgumentNotValidException","La lista de materias no puede estar vacía.");
        String errorExpectJson = writer.writeValueAsString(errorResultJson);

        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON).content(payloadJson))
                .andDo(print())
                .andExpect(status().isBadRequest()).andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(errorExpectJson, result.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    @Test
    public void testRegisterStudentSubjectsNameNullOutput() throws Exception {
        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        StudentDTO studentDTO = Utils.getStudentDTO();
        studentDTO.getSubjects().get(0).setName(null);
        studentDTO.setId(null);
        String payloadJson = writer.writeValueAsString(studentDTO);

        ErrorDTO errorResultJson = new ErrorDTO("MethodArgumentNotValidException","El nombre de la materia no puede estar vacío.");
        String errorExpectJson = writer.writeValueAsString(errorResultJson);

        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON).content(payloadJson))
                .andDo(print())
                .andExpect(status().isBadRequest()).andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(errorExpectJson, result.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    @Test
    public void testRegisterStudentSubjectsNameOverMaxSizeOutput() throws Exception {
        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        StudentDTO studentDTO = Utils.getStudentDTO();
        studentDTO.getSubjects().get(0).setName("La materia debe tener como maximo una cantidad de 30 caracteres de lo contrario tira error");
        studentDTO.setId(null);
        String payloadJson = writer.writeValueAsString(studentDTO);

        ErrorDTO errorResultJson = new ErrorDTO("MethodArgumentNotValidException","La longitud del nombre de la materia no puede superar los 30 caracteres.");
        String errorExpectJson = writer.writeValueAsString(errorResultJson);

        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON).content(payloadJson))
                .andDo(print())
                .andExpect(status().isBadRequest()).andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(errorExpectJson, result.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }


    @Test
    public void testRegisterStudentSubjectScoreNullOutput() throws Exception {
        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        StudentDTO studentDTO = Utils.getStudentDTO();
        studentDTO.getSubjects().get(0).setScore(null);
        studentDTO.setId(null);
        String payloadJson = writer.writeValueAsString(studentDTO);

        ErrorDTO errorResultJson = new ErrorDTO("MethodArgumentNotValidException","La nota de la materia no puede estar vacía.");
        String errorExpectJson = writer.writeValueAsString(errorResultJson);

        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON).content(payloadJson))
                .andDo(print())
                .andExpect(status().isBadRequest()).andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(errorExpectJson, result.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }


    @Test
    public void testRegisterStudentSubjectScoreOverMaxOutput() throws Exception {
        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        StudentDTO studentDTO = Utils.getStudentDTO();
        studentDTO.getSubjects().get(0).setScore(12.0);
        studentDTO.setId(null);
        String payloadJson = writer.writeValueAsString(studentDTO);

        ErrorDTO errorResultJson = new ErrorDTO("MethodArgumentNotValidException","La nota máxima de la materia es de 10 pts.");
        String errorExpectJson = writer.writeValueAsString(errorResultJson);

        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON).content(payloadJson))
                .andDo(print())
                .andExpect(status().isBadRequest()).andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(errorExpectJson, result.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    @Test
    public void testRegisterStudentSubjectScoreUnderMinOutput() throws Exception {
        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        StudentDTO studentDTO = Utils.getStudentDTO();
        studentDTO.getSubjects().get(0).setScore(-1.0);
        studentDTO.setId(null);
        String payloadJson = writer.writeValueAsString(studentDTO);

        ErrorDTO errorResultJson = new ErrorDTO("MethodArgumentNotValidException","La nota mínima de la materia es de 0 pts.");
        String errorExpectJson = writer.writeValueAsString(errorResultJson);

        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON).content(payloadJson))
                .andDo(print())
                .andExpect(status().isBadRequest()).andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(errorExpectJson, result.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }



    @Test
    public void testGetStudentOutput() throws Exception {

        MvcResult getResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", "1"))
                .andDo(print()).andExpect(status().isOk()).andExpect(content().contentType("application/json"))
                .andReturn();
    }


    @Test
    public void testGetStudentNotFoundOutput() throws Exception {
        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        MvcResult getResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", "1000000"))
                .andDo(print()).andExpect(status().isNotFound()).andExpect(content().contentType("application/json"))
                .andReturn();
        ErrorDTO errorResultJson = new ErrorDTO("StudentNotFoundException","El alumno con Id 1000000 no se encuetra registrado.");
        String errorExpectJson = writer.writeValueAsString(errorResultJson);
        Assertions.assertEquals(errorExpectJson, getResult.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }




    @Test
    public void testModifyStudentOutput() throws Exception {
        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        StudentDTO studentDTO = Utils.getStudentDTO();
        studentDTO.setStudentName("Italo Test");
        studentDTO.setId(6L);
        studentDTO.setMessage(null);
        studentDTO.setAverageScore(null);
        String payloadJson = writer.writeValueAsString(studentDTO);

        //ErrorDTO errorResultJson = new ErrorDTO("MethodArgumentNotValidException","La nota mínima de la materia es de 0 pts.");
        //String errorExpectJson = writer.writeValueAsString(errorResultJson);


        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.post("/student//modifyStudent")
                .contentType(MediaType.APPLICATION_JSON).content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").doesNotExist())
                .andReturn();

        //Assertions.assertEquals(studenExpect, result.getResponse().getContentAsString());
        //Assertions.assertEquals(errorExpectJson, result.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    @Test
    public void testModifyStudentNameNonCapitalLetterOutput() throws Exception {
        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        StudentDTO studentDTO = Utils.getStudentDTO();
        studentDTO.setStudentName("talo");
        studentDTO.setId(6L);
        studentDTO.setMessage(null);
        studentDTO.setAverageScore(null);
        String payloadJson = writer.writeValueAsString(studentDTO);

        ErrorDTO errorResultJson = new ErrorDTO("MethodArgumentNotValidException","El nombre del estudiante debe comenzar con mayúscula.");
        String errorExpectJson = writer.writeValueAsString(errorResultJson);


        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.post("/student//modifyStudent")
                .contentType(MediaType.APPLICATION_JSON).content(payloadJson))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andReturn();


        Assertions.assertEquals(errorExpectJson, result.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    @Test
    public void testModifyStudentNameOverMaxLengthOutput() throws Exception {
        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        StudentDTO studentDTO = Utils.getStudentDTO();
        studentDTO.setStudentName("EL Nombre del estudiante no debe ser mayor a 50 caracteres, de lo contrario se expondra la excepcion de este test.");
        studentDTO.setId(6L);
        studentDTO.setMessage(null);
        studentDTO.setAverageScore(null);
        String payloadJson = writer.writeValueAsString(studentDTO);

        ErrorDTO errorResultJson = new ErrorDTO("MethodArgumentNotValidException","La longitud del nombre del estudiante no puede superar los 50 caracteres.");
        String errorExpectJson = writer.writeValueAsString(errorResultJson);


        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON).content(payloadJson))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(errorExpectJson, result.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }


    @Test
    public void testRemoveStudentOutput() throws Exception {
        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}", "5"))
                .andDo(print()).andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$").doesNotExist())
                .andReturn();
    }


    @Test
    public void testGetListStudentOutput() throws Exception {
        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents"))
                .andDo(print()).andExpect(status().isOk()).andExpect(content().contentType("application/json"))
                .andReturn();
    }
}
