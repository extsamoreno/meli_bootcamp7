package com.meli.testingchallenge.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.testingchallenge.dtos.*;
import com.meli.testingchallenge.models.District;
import com.meli.testingchallenge.repositories.IDistrictRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class EstateControllerTests {

    private String districtName;
    private DistrictDTO districtDto;
    private District district;
    private EstateAssessmentDTO expected;
    private EstateDTO estateDto;

    @Autowired
    MockMvc mockMvc;

    @MockBean
    IDistrictRepository repository;

    @BeforeEach
    public void init(){

        String propName = "House1";
        districtName= "District1";
        String environmentName1 = "Bigger";
        String environmentName2 = "Medium";
        String environmentName3 = "Smaller";
        districtDto = new DistrictDTO(districtName, 2.0);
        district = new District(districtName, 2.0);
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

        when(repository.findDistrictByName(districtName)).thenReturn(district);

        // Act & Assert
        this.mockMvc.perform(MockMvcRequestBuilders.post("/estate/assessment")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("name").value("House1"))
                .andExpect(MockMvcResultMatchers.jsonPath("totalSquareMeters").value(7.0))
                .andExpect(MockMvcResultMatchers.jsonPath("totalPrice").value(14.0))
                .andExpect(MockMvcResultMatchers.jsonPath("biggerEnvironment.name").value("Bigger"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.environmentsSqrMeters[0].name").value("Bigger"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.environmentsSqrMeters[1].name").value("Medium"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.environmentsSqrMeters[2].name").value("Smaller"));
    }

    @Test
    public void should_return_exceptions_when_the_district_is_not_saved() throws Exception {

        ObjectWriter writer =
                new ObjectMapper()
                        .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                        .writer()
                        .withDefaultPrettyPrinter();
        String payloadJson = writer.writeValueAsString(estateDto);

        when(repository.findDistrictByName(districtName)).thenReturn(null);

        // Act & Assert
        this.mockMvc.perform(MockMvcRequestBuilders.post("/estate/assessment")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("name").value("DistrictNotFoundException"));
    }

    @Test
    public void should_return_exceptions_when_fields_are_null() throws Exception {
        estateDto.setProp_name(null);
        estateDto.setDistrict_name(null);
        estateDto.setEnvironments(null);
        ObjectWriter writer =
                new ObjectMapper()
                        .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                        .writer()
                        .withDefaultPrettyPrinter();
        String payloadJson = writer.writeValueAsString(estateDto);

        when(repository.findDistrictByName(districtName)).thenReturn(null);

        // Act & Assert
        this.mockMvc.perform(MockMvcRequestBuilders.post("/estate/assessment")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("prop_name").value("El nombre de la propiedad no puede estar vacío."))
                .andExpect(MockMvcResultMatchers.jsonPath("district_name").value("El barrio no puede estar vacío."))
                .andExpect(MockMvcResultMatchers.jsonPath("environments").value("Cada propiedad debe tener al menos un ambiente."));
    }

}
