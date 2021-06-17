package com.meli.desafio2.integration.controller;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerTests {

    /*@Autowired
    MockMvc mockMvc;

    @MockBean
    IStudentDAO iStudentDAO;

    @Test
    public void analyzeScoresHappyPath() throws Exception {

        // arrange
        PropertyDTO student = TestUtilsGenerator.getStudentWith3Subjects("Juan");
        List<RoomDTO> subjects = student.getSubjects();
        long studentID = student.getId();
        Mockito.when(iStudentDAO.findById(studentID)).thenReturn(student);


        // act
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}",studentID))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.studentName").value(student.getStudentName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.averageScore").value(6.0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.subjects").isArray()) // works
                .andExpect(MockMvcResultMatchers.jsonPath("$.subjects.length()").value(subjects.size()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.subjects[0].name").value("Matematica"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.subjects[0].score").value(8.0))
                .andReturn();

    }

    @Test
    public void analyzeScoresNoHappyPath() throws Exception {

        // arrange
        PropertyDTO student = TestUtilsGenerator.getStudentWith3Subjects("Juan");
        List<RoomDTO> subjects = student.getSubjects();
        long studentID = student.getId();

        // act
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}",studentID))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.studentName").value(student.getStudentName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.averageScore").value(6.0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.subjects").isArray()) // works
                .andExpect(MockMvcResultMatchers.jsonPath("$.subjects.length()").value(subjects.size()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.subjects[0].name").value("Matematica"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.subjects[0].score").value(8.0))
                .andReturn();

    }*/

}
