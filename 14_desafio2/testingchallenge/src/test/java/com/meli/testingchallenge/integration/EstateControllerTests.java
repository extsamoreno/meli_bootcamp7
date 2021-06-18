package com.meli.testingchallenge.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.testingchallenge.dtos.*;
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

    private String districtName;
    private DistrictDTO districtDto;
    private EstateAssessmentDTO expected;
    private EstateDTO estateDto;

    @Autowired
    MockMvc mockMvc;

    @BeforeEach
    public void init(){
//        rightEnvironments = new ArrayList<>();
//        rightEnvironments.add(new EnvironmentDTO("Living", 5.0,5.0));
//        rightEnvironments.add(new EnvironmentDTO("Bedroom", 1.0,5.0));
//        wrongEnvironments = new ArrayList<>();
//        wrongEnvironments.add(new EnvironmentDTO("bedroom 999", 50.0,50.0));
//
//        rightHouse = new EstateDTO("House1", "Manhattan",  rightEnvironments);
//        wrongHouse = new EstateDTO("house1", "manhattan",  wrongEnvironments);
        String propName = "House1";
        districtName= "District1";
        String environmentName1 = "Bigger";
        String environmentName2 = "Medium";
        String environmentName3 = "Smaller";
        districtDto = new DistrictDTO(districtName, 2.0);
        EnvironmentDTO environment1 = new EnvironmentDTO(environmentName1, 2.0, 2.0);
        EnvironmentDTO environment2 = new EnvironmentDTO(environmentName2, 2.0, 1.0);
        EnvironmentDTO environment3 = new EnvironmentDTO(environmentName3, 1.0, 1.0);
        List<EnvironmentDTO> environmentList = new ArrayList();
        environmentList.add(environment1);
        environmentList.add(environment2);
        environmentList.add(environment3);
        EnvironmentDTORes environmentResDto1 = new EnvironmentDTORes(environmentName1, 4.0);
        EnvironmentDTORes environmentResDto2 = new EnvironmentDTORes(environmentName2, 2.0);
        EnvironmentDTORes environmentResDto3 = new EnvironmentDTORes(environmentName3, 1.0);
        List<EnvironmentDTORes> environmentResDtosList = new ArrayList();
        environmentResDtosList.add(environmentResDto1);
        environmentResDtosList.add(environmentResDto2);
        environmentResDtosList.add(environmentResDto3);
        expected = new EstateAssessmentDTO(propName, 7.0, 14, environmentResDto1, environmentResDtosList);
        estateDto = new EstateDTO(propName, districtName, environmentList);
    }

    @Test
    public void should_return_assessment_successfully() throws Exception {

        ObjectWriter writer =
                new ObjectMapper()
                        .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                        .writer()
                        .withDefaultPrettyPrinter();
        String payloadJson = writer.writeValueAsString(estateDto);

//        doNothing().when(iStudentDAO).save(student1);

        // Act & Assert
        this.mockMvc.perform(MockMvcRequestBuilders.post("/estate/assessment")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isOk());

    }

}
