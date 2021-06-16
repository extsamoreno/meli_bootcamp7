package com.meli.obtenerdiploma.integration;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerTests {

    Long studentId;
    SubjectDTO subject1;
    SubjectDTO subject2;
    SubjectDTO subject3;
    List<SubjectDTO> subjects;
    List<SubjectDTO> subjects2;
    StudentDTO student1;
    StudentDTO student2;

    @Autowired
    MockMvc mockMvc;

    @MockBean
    IStudentDAO iStudentDAO;

    @BeforeEach
    public void init(){
        studentId = 1L;
        subject1 = new SubjectDTO( "Matematica", 9.0);
        subject2 = new SubjectDTO( "Lengua", 9.0);
        subjects = new ArrayList<SubjectDTO>();
        subjects.add(subject1);
        subjects.add(subject2);
        student1 =  new StudentDTO(studentId,"Juan", "hola", 1.0, subjects);
        subject3 = new SubjectDTO( "Filosofia", 10.0);
        subjects2 = new ArrayList<SubjectDTO>();
        subjects2.add(subject1);
        subjects2.add(subject3);
        student2 = new StudentDTO(studentId,"Juan", "hola", 1.0, subjects2);
    }

    @Test
    public void should_return_a_certificate_successfully() throws Exception {


        when(iStudentDAO.findById(studentId)).thenReturn(student1);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", studentId))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("message").value("El alumno Juan ha obtenido un promedio de 9. Puedes mejorar."))
                .andExpect(MockMvcResultMatchers.jsonPath("averageScore").value("9.0"));

    }

    @Test
    public void should_return_a_certificate_congrats_successfully() throws Exception {

        when(iStudentDAO.findById(studentId)).thenReturn(student2);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", studentId))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("message").value("El alumno Juan ha obtenido un promedio de 9.5. Felicitaciones!"))
                .andExpect(MockMvcResultMatchers.jsonPath("averageScore").value("9.5"));

    }
}
