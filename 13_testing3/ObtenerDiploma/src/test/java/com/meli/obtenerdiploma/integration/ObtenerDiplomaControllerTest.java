package com.meli.obtenerdiploma.integration;

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

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerTest {

    //Integracion del controller con el service

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    IStudentDAO studentDAO;

    @Test
    public void analyzeScoresHappyPath() throws Exception {
        //Data to test

        //student to add
        StudentDTO student = new StudentDTO(1L, "Juan", null, 10d, new ArrayList<>() {
            {
                add(new SubjectDTO("Matemática", 9.0));
                add(new SubjectDTO("Física", 7.0));
                add(new SubjectDTO("Química", 6.0));
            }
        });


        Mockito.when(studentDAO.findById(1L)).thenReturn(student);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 1))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string(containsString("{\"id\":1,\"studentName\":\"Juan\",\"message\":\"El alumno Juan ha obtenido un promedio de 7,33. Puedes mejorar.\",\"averageScore\":7.333333333333333,\"subjects\":[{\"name\":\"MatemÃ¡tica\",\"score\":9.0},{\"name\":\"FÃ\u00ADsica\",\"score\":7.0},{\"name\":\"QuÃ\u00ADmica\",\"score\":6.0}]}")))
                .andReturn();
    }

    @Test
    public void analyzeScoresStudentNotFound() throws Exception {

        Long id = -1L;

        //Check the result
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", id))
                .andDo(print()).andExpect(status().isNotFound())
                .andReturn();

    }
}
