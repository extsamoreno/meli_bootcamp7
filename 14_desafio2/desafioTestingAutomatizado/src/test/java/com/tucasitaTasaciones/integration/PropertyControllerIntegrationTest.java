package com.tucasitaTasaciones.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tucasitaTasaciones.dto.PropertyDTO;
import com.tucasitaTasaciones.model.District;
import com.tucasitaTasaciones.model.Property;
import com.tucasitaTasaciones.repository.IDistrictRepository;
import com.tucasitaTasaciones.repository.IPropertyRepository;
import com.tucasitaTasaciones.unit.TestUtilGenerator;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import java.io.IOException;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.mockito.Mockito.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PropertyControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    IPropertyRepository propertyRepository;

    @MockBean
    IDistrictRepository districtRepository;


    @Test
    void addNewPropertyTest() throws Exception {
        String districtName = "King";
        PropertyDTO property = TestUtilGenerator.getPropertyDTO(districtName);

        ObjectMapper objectMapper = new ObjectMapper();
        String payload = objectMapper.writeValueAsString(property);

        Mockito.when(districtRepository.findDistrictByName(districtName))
                .thenReturn(new District(districtName, 3100.0));

        this.mockMvc.perform(post("/newProperty")
                .contentType("application/json")
                .content(payload))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void addNewPropertyWithExceptionTest() throws Exception {
        String districtName = "Capital";
        PropertyDTO property = TestUtilGenerator.getPropertyDTO(districtName);

        ObjectMapper objectMapper = new ObjectMapper();
        String payload = objectMapper.writeValueAsString(property);

        this.mockMvc.perform(post("/newProperty")
                .contentType("application/json")
                .content(payload))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    void getPropertiesTest() throws Exception {
        List<Property> propertiesList = TestUtilGenerator.getProperties();

        Mockito.when(propertyRepository.getProperties()).thenReturn(propertiesList);

        mockMvc.perform(
                get("/getProperties"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].prop_name").value("MyHome"));
    }


}
