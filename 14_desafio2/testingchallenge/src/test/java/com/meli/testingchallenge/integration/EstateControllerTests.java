package com.meli.testingchallenge.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.testingchallenge.dtos.EnvironmentDTO;
import com.meli.testingchallenge.dtos.EstateDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class EstateControllerTests {

    List<EnvironmentDTO> rightEnvironments;
    List<EnvironmentDTO> wrongEnvironments;
    EstateDTO rightHouse;
    EstateDTO wrongHouse;

    @Autowired
    MockMvc mockMvc;

    @BeforeEach
    public void init(){
        rightEnvironments = new ArrayList<>();
        rightEnvironments.add(new EnvironmentDTO("Living", 5.0,5.0));
        rightEnvironments.add(new EnvironmentDTO("Bedroom", 1.0,5.0));
        wrongEnvironments = new ArrayList<>();
        wrongEnvironments.add(new EnvironmentDTO("bedroom 999", 50.0,50.0));

        rightHouse = new EstateDTO("House1", "Manhattan", 100.0, rightEnvironments);
        wrongHouse = new EstateDTO("house1", "manhattan", 100.0, wrongEnvironments);
    }

    @Test
    public void should_return_assessment_successfully() throws Exception {

        ObjectWriter writer =
                new ObjectMapper()
                        .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                        .writer()
                        .withDefaultPrettyPrinter();
        String payloadJson = writer.writeValueAsString(rightHouse);

//        doNothing().when(iStudentDAO).save(student1);

        // Act & Assert
        this.mockMvc.perform(MockMvcRequestBuilders.post("/estate/assessment")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isOk());

    }

}
