package com.meli.obtenerdiploma.integration.controller_service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.util.GeneratingObjectsUtils;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ITObtenerDiplomaController {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IStudentDAO studentDAO;

    @Test
    public void getScoreOver9() throws Exception {

        StudentDTO expectedStudent = GeneratingObjectsUtils.getGoodStudent();
        Long studentId = expectedStudent.getId();
        Mockito.when(studentDAO.findById(studentId)).thenReturn(expectedStudent);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", studentId))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers .jsonPath("averageScore").value("9.333333333333334"));
    }


    @Test
    public void getMessageWithScoreOver9() throws Exception {

        StudentDTO expectedStudent = GeneratingObjectsUtils.getGoodStudent();
        Long studentId = expectedStudent.getId();
        Mockito.when(studentDAO.findById(studentId)).thenReturn(expectedStudent);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", studentId))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("message").value("El alumno Pedro ha obtenido un promedio de 9.33. Felicitaciones!"));
    }


    @Test
    public void getMessageWithScoreUnder9() throws Exception {

        StudentDTO expectedStudent = GeneratingObjectsUtils.getBadStudent();
        Long studentId = expectedStudent.getId();
        Mockito.when(studentDAO.findById(studentId)).thenReturn(expectedStudent);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", studentId))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("message").value("El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar."));
    }


}
