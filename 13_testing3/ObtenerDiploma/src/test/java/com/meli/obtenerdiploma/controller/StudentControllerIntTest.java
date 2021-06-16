package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.exception.ObtenerDiplomaException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.unit.util.TestUtilsGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerIntTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    IStudentDAO iStudentDAO;

    Long id;


    @Test
    public void readGetStudentByIdHappyPath() throws Exception
    {
        id = 999L;
        StudentDTO stu = TestUtilsGenerator.getStudentWithId(id);
        Mockito.when(iStudentDAO.findById(id)).thenReturn(stu);

        MvcResult mvcResult =
                this.mockMvc.perform(MockMvcRequestBuilders.get(
                        "/student/getStudent/{studentId}", id))
                        .andDo(print()).andExpect(status().isOk())
                        .andExpect(content().contentType("application/json"))
                        .andExpect(MockMvcResultMatchers.jsonPath(
                                "$.studentName").value("student1"))
                        .andReturn();

        Mockito.verify(iStudentDAO, Mockito.atLeastOnce()).findById(id);
        Assertions.assertEquals("application/json" ,
                mvcResult.getResponse().getContentType());
    }

    @Test
    public void analyzeScoresOfStudentNotFound() throws Exception {
        id = 99L;
        ObtenerDiplomaException exception = new ObtenerDiplomaException("Rompió", HttpStatus.NOT_FOUND);
        Mockito.when(iStudentDAO.findById(id)).thenThrow( new ObtenerDiplomaException("Rompió", HttpStatus.NOT_FOUND));

        MvcResult mvcResult =
                this.mockMvc.perform(MockMvcRequestBuilders.get(
                        "/student/getStudent/{id}", id))
                        .andDo(print()).andExpect(status().isNotFound())
                        .andExpect(content().contentType("application/json"))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("ObtenerDiplomaException"))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("Rompió"))
                        .andReturn();

        Mockito.verify(iStudentDAO, Mockito.atLeastOnce()).findById(id);
        Assertions. assertEquals("application/json" ,
                mvcResult.getResponse().getContentType()) ;

    }
}
