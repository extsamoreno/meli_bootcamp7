package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTests {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    IStudentDAO iStudentDAO;

    Long studentId;
    SubjectDTO subject1;
    SubjectDTO subject2 = new SubjectDTO( "Lengua", 10.0);
    List<SubjectDTO> subjects;
    StudentDTO student1;


    @Test
    public void should_register_a_new_student_successfully() throws Exception {
        studentId = 1L;
        subject1 = new SubjectDTO( "Matematica", 9.0);
        subject2 = new SubjectDTO( "Lengua", 9.0);
        subjects = new ArrayList<SubjectDTO>();
        subjects.add(subject1);
        subjects.add(subject2);
        student1 =  new StudentDTO(studentId,"Juan", "hola", 1.0, subjects);

    ObjectWriter writer =
        new ObjectMapper()
            .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
            .writer()
            .withDefaultPrettyPrinter();
        String payloadJson = writer.writeValueAsString(student1);

        doNothing().when(iStudentDAO).save(student1);

        // Act & Assert
        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void should_validate_capital_letters_and_null_values() throws Exception {
        studentId = 1L;
        subject1 = new SubjectDTO( "Matematica", 9.0);
        subject2 = new SubjectDTO( "lengua", 9.0);
        subjects = new ArrayList<SubjectDTO>();
        subjects.add(subject1);
        subjects.add(subject2);
        student1 =  new StudentDTO(studentId,"juan", "hola", 1.0, subjects);

        ObjectWriter writer =
                new ObjectMapper()
                        .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                        .writer()
                        .withDefaultPrettyPrinter();
        String payloadJson = writer.writeValueAsString(student1);

        doNothing().when(iStudentDAO).save(student1);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("studentName").value("El nombre del estudiante debe comenzar con mayúscula."));
//                .andExpect(MockMvcResultMatchers.jsonPath("subjects[*].name").value("El nombre de la materia debe comenzar con mayúscula."));

    }


}


