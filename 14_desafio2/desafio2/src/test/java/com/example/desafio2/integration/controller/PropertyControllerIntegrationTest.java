package com.example.desafio2.integration.controller;

import com.example.desafio2.TestUtils.TestUtils;
import com.example.desafio2.project.models.Property;
import com.example.desafio2.project.repository.IPropertyRepository;
import com.example.desafio2.project.services.Dto.PropertyTotalSquareMetersDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
public class PropertyControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    IPropertyRepository iPropertyRepository;

    @Test
    public void getTotalSquareMetersHappyPath() throws Exception {
        String propertyName = "Casa 1";
        Property property = TestUtils.getNewProperty(propertyName);

        when(iPropertyRepository.findPropertyByName(propertyName)).thenReturn(property);

        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/properties/{propertyName}/meters", propertyName))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.totalMeters").value(300))
                .andReturn();

        verify(iPropertyRepository,atLeastOnce()).findPropertyByName(propertyName);

    }
}
