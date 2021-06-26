package com.desafio.TuCasitaTasacionesApp.Integration;

import com.desafio.TuCasitaTasacionesApp.model.dao.repository.IPropietyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculateRestControllerIntegration {
    @MockBean
    IPropietyRepository iPropietyRepository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getSquareMeterForPropietyHappyPath() throws Exception {/*
        Long id = 1L;
        //==============
        SubjectDTO subject = new SubjectDTO("Matematica", 9.0);
        SubjectDTO subject2 = new SubjectDTO("Matematica", 7.0);
        SubjectDTO subject3 = new SubjectDTO("Quimica", 6.0);

        List<SubjectDTO> subjects = new ArrayList<SubjectDTO>();
        subjects.add(subject);
        subjects.add(subject2);
        subjects.add(subject3);

        StudentDTO student = new StudentDTO
                (id, "Juan", "El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar.", 7.333333333333333, subjects);

        when(iStudentDAO.findById(id)).thenReturn(student);

        //===============

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

        String responseJson = writer.writeValueAsString(student);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 1L))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string(responseJson))
                .andReturn();
    }



    @Test
    public void analyzeScoresException() throws Exception {
        Long id = 1L;

        when(iStudentDAO.findById(7000L)).thenThrow(new StudentNotFoundException(7000L));
        //===============

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

        String responseError = writer.writeValueAsString(new ErrorDTO("StudentNotFoundException", "El alumno con Id 7000 no se encuetra registrado."));

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 7000L))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string(responseError))
                .andReturn();*/
    }
}




