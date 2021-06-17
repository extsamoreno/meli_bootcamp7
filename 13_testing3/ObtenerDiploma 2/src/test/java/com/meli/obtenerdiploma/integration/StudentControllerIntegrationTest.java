package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.ResourceUtils;

import java.io.File;
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
    private MockMvc mockMvc;

    @Test
    public void registerStudentTest() throws Exception {
        SubjectDTO subjectDTOOne = new SubjectDTO("Matemática",9d);
        SubjectDTO subjectDTOTwo = new SubjectDTO("Física",7d);
        SubjectDTO subjectDTOThree = new SubjectDTO("Química",6d);

        List<SubjectDTO> listSubjects = new ArrayList<>();
        listSubjects.add(subjectDTOOne);
        listSubjects.add(subjectDTOTwo);
        listSubjects.add(subjectDTOThree);

        StudentDTO payloadDTO = new StudentDTO(null,"Leandro"
                ,null//"El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar."
                ,null//7.33d
                ,listSubjects);

        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE, false).
                writer().withDefaultPrettyPrinter();

        String payloadJson = writer.writeValueAsString(payloadDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isOk());
                //.andExpect(content().contentType("application/json"));
                //.andExpect(MockMvcResultMatchers.jsonPath("$.studentName").value("Juan"));
    }

    @Test
    public void getStudentTest() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}",1L))
                .andDo( print()).andExpect( status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers. jsonPath("$.studentName" ).value("Leandro"));
    }

    @Test
    public void modifyStudentTest() throws Exception {
        SubjectDTO subjectDTOOne = new SubjectDTO("Matemáticas",9d);
        SubjectDTO subjectDTOTwo = new SubjectDTO("Físicas",7d);
        SubjectDTO subjectDTOThree = new SubjectDTO("Químicas",6d);

        List<SubjectDTO> listSubjects = new ArrayList<>();
        listSubjects.add(subjectDTOOne);
        listSubjects.add(subjectDTOTwo);
        listSubjects.add(subjectDTOThree);

        StudentDTO payloadDTO = new StudentDTO(1L,"Juan"
                ,null//"El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar."
                ,null//7.33d
                ,listSubjects);

        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE, false).
                writer().withDefaultPrettyPrinter();

        String payloadJson = writer.writeValueAsString(payloadDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isOk());
                //.andExpect(content().contentType("application/json"));
                //.andExpect(MockMvcResultMatchers.jsonPath("$.studentName").value("Juan"));
    }

    @Test
    public void removeStudentTest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}", 5L))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").doesNotExist());
                //.andReturn();
    }
    /*@Test
    public void listStudentsTest() throws Exception {
        Set<StudentDTO> loadedData = new HashSet<>();

        ObjectMapper objectMapper = new ObjectMapper();
        File file = ResourceUtils.getFile("./src/test/resources/users.json");
        loadedData = objectMapper.readValue(file, new TypeReference<Set<StudentDTO>>(){});
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(loadedData);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers. jsonPath("$" ).value(loadedData));
    }
*/
}
