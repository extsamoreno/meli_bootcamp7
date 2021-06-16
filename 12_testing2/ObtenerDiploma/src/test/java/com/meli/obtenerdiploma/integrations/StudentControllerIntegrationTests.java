package com.meli.obtenerdiploma.integrations;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    IStudentDAO studentDAO;

    @MockBean
    IStudentRepository studentRepository;

    @Test
    public void registerStudent() throws Exception {
        StudentDTO payloadDTO = new StudentDTO();
        payloadDTO.setStudentName("Edu");
        payloadDTO.setSubjects(Arrays.asList(new SubjectDTO("A", 10.0),
                new SubjectDTO("B", 7.0),
                new SubjectDTO("C", 10.0)));

        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE, false).
                writer().withDefaultPrettyPrinter();
        String payloadJson = writer.writeValueAsString(payloadDTO);

        Mockito.doNothing().when(studentDAO).save(new StudentDTO());

        var result = this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }
}