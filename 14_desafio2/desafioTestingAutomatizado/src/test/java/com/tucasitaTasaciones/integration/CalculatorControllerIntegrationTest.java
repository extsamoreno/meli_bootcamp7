package com.tucasitaTasaciones.integration;

import com.tucasitaTasaciones.dto.CalculateResponseDTO;
import com.tucasitaTasaciones.exceptions.PropertyNotFoundException;
import com.tucasitaTasaciones.model.Environment;
import com.tucasitaTasaciones.model.Property;
import com.tucasitaTasaciones.repository.IDistrictRepository;
import com.tucasitaTasaciones.repository.IPropertyRepository;
import com.tucasitaTasaciones.service.ICalculateService;
import com.tucasitaTasaciones.unit.TestUtilGenerator;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculatorControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    IPropertyRepository repository;

    @MockBean
    IDistrictRepository districtRepository;

    @Test
    void calculateSquareMeters() throws Exception {
        Property property = TestUtilGenerator.getProperty();
        Mockito.when(repository.findProperty(1)).thenReturn(property);

        mockMvc.perform(
                get("/calculateSquareMeters/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.totalSquareFeet").value(8));
    }

    @Test
    void calculateSquareMetersWithException() throws Exception {

        Mockito.when(repository.findProperty(1)).thenThrow(new PropertyNotFoundException(1));;

        String messageName = "Property with ID: 1 doesn't exists";

        mockMvc.perform(
                get("/calculateSquareMeters/1"))
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(messageName));
    }


    @Test
    void calculatePropertyValue() throws Exception {
        Property property = TestUtilGenerator.getProperty();
        Mockito.when(repository.findProperty(1)).thenReturn(property);

        mockMvc.perform(
                get("/calculateValue/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.propertyPrice").value(18400.0));

    }

    @Test
    void calculateLargestRoom() throws Exception {

        Property property = TestUtilGenerator.getProperty();
        Mockito.when(repository.findProperty(1)).thenReturn(property);

        mockMvc.perform(
                get("/calculateLargestRoom/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.largestRoom").value("Living Room"));

    }

    @Test
    void calculateEnvironmentsSquareFeet() throws Exception {

        Property property = TestUtilGenerator.getProperty();
        Map<String, Integer> environmentsSquareFeetExpected = new HashMap<>();
        for (Environment r : property.getEnvironmentList()) {
            environmentsSquareFeetExpected.put(r.getEnvironment_name(), r.getSquareFeet());
        }

        Mockito.when(repository.findProperty(1)).thenReturn(property);

        mockMvc.perform(
                get("/calculateEnvironments/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.environmentsSquareFeet").value(environmentsSquareFeetExpected));

    }

}
