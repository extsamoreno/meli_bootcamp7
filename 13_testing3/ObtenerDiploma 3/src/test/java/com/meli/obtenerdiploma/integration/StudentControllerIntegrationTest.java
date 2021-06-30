package com.meli.obtenerdiploma.integration;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.unit.repository.IStudentDAO;
import com.meli.obtenerdiploma.unit.repository.StudentDAO;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    IStudentDAO iStudentDAO;


    @Test
    public void registerStudentOK() {
        Long id = 1L;
        StudentDTO student = new StudentDTO(id, "Pedro", "Felicitaciones Pedro!", 6.00, subjectDTOList);
        Mockito.when(iStudentDAO.save(Mockito.any())).thenReturn(null);
    }


}
