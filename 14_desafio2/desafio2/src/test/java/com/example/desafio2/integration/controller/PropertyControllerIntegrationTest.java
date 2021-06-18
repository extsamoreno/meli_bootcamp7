package com.example.desafio2.integration.controller;

import com.example.desafio2.TestUtils.TestUtils;
import com.example.desafio2.project.exceptions.PropertyAlreadyExistsException;
import com.example.desafio2.project.models.District;
import com.example.desafio2.project.models.Property;
import com.example.desafio2.project.repository.IPropertyRepository;
import com.example.desafio2.project.services.Dto.PropertyDto;
import com.example.desafio2.project.services.Dto.PropertyEnvironmentDto;
import com.example.desafio2.project.services.mapper.mapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
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
import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.totalMeters").value(300))
                .andExpect(content().contentType("application/json"))
                .andReturn();

        verify(iPropertyRepository,atLeastOnce()).findPropertyByName(propertyName);

    }
    @Test
    public void getPropertyValueHappyPath() throws Exception {
        String propertyName = "Casa 1";
        Property property = TestUtils.getNewProperty(propertyName);
        District district = new District("Villa Herrero",1000.00);

        when(iPropertyRepository.findPropertyByName(propertyName)).thenReturn(property);
        when(iPropertyRepository.findDistrictByName(property.getProp_district_name())).thenReturn(district);

        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/properties/{propertyName}/value", propertyName))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.property_value").value(300000))
                .andExpect(content().contentType("application/json"))
                .andReturn();

        verify(iPropertyRepository,atLeastOnce()).findPropertyByName(propertyName);
        verify(iPropertyRepository,atLeastOnce()).findDistrictByName(district.getDistrict_name());
    }

    @Test
    public void getBiggestEnvironmentHappyPath() throws Exception {
        String propertyName = "Casa 1";
        Property property = TestUtils.getNewProperty(propertyName);

        when(iPropertyRepository.findPropertyByName(propertyName)).thenReturn(property);

        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/properties/{propertyName}/environment/biggest", propertyName))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.environment_name").value("Cocina"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.environment_size").value(150))
                .andExpect(content().contentType("application/json"))
                .andReturn();

        verify(iPropertyRepository,atLeastOnce()).findPropertyByName(propertyName);
    }

    @Test
    public void getEnvironmentSizesListHappyPath() throws Exception {
        String propertyName = "Casa 1";
        Property property = TestUtils.getNewProperty(propertyName);

        ArrayList<PropertyEnvironmentDto> propertyEnvironmentDtos = new ArrayList<>();
        propertyEnvironmentDtos.add(new PropertyEnvironmentDto("Banio",50));
        propertyEnvironmentDtos.add(new PropertyEnvironmentDto("Cocina",150));
        propertyEnvironmentDtos.add(new PropertyEnvironmentDto("Living",100));


        when(iPropertyRepository.findPropertyByName(propertyName)).thenReturn(property);

        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/properties/{propertyName}/environment/sizelist", propertyName))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string(containsString("{\"environment_name\":\"Banio\",\"environment_size\":50.0},{\"environment_name\":\"Cocina\",\"environment_size\":150.0},{\"environment_name\":\"Living\",\"environment_size\":100.0}")))
                .andReturn();

        verify(iPropertyRepository,atLeastOnce()).findPropertyByName(propertyName);
    }
    @Test
    public void addNewPropertyHappyPath() throws Exception {
        String propertyName = "Casa 1";
        PropertyDto payloadDto = TestUtils.getNewPropertyDto(propertyName);

        String responseDto = "The property named: "+payloadDto.getProp_name()+" has been succesfully created";

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payloadJson = writer.writeValueAsString(payloadDto);
        String responseJson = writer.writeValueAsString(responseDto);

        doNothing().when(this.iPropertyRepository).saveProperty(mapper.propertyDtoToProperty(payloadDto));

            this.mockMvc
                .perform(MockMvcRequestBuilders.post("/properties/newproperty", propertyName)
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string(containsString(responseJson)))
                .andReturn();

        verify(this.iPropertyRepository,atLeastOnce()).saveProperty(mapper.propertyDtoToProperty(payloadDto));
    }

    @Test
    public void addNewPropertyThrowsPropertyAlreadyExistsException() throws Exception{
        String propertyName = "Casa 1";
        PropertyDto payloadDto = TestUtils.getNewPropertyDto(propertyName);

        PropertyAlreadyExistsException error = new PropertyAlreadyExistsException(propertyName);

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payloadJson = writer.writeValueAsString(payloadDto);
        String responseJson = writer.writeValueAsString(error.getError());

        doThrow(error)
                .when(iPropertyRepository).saveProperty(mapper.propertyDtoToProperty(payloadDto));

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/properties/newproperty", propertyName)
                .contentType(MediaType.APPLICATION_JSON).content(payloadJson))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string(containsString(responseJson)))
                .andReturn();

        verify(this.iPropertyRepository,atLeastOnce()).saveProperty(mapper.propertyDtoToProperty(payloadDto));
    }

    @Test
    public void addNewPropertyNullPayload() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/properties/newproperty","Casa 1"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }


}
