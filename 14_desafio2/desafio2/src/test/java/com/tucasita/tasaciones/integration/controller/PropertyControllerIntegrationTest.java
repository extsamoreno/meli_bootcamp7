package com.tucasita.tasaciones.integration.controller;

import com.tucasita.tasaciones.TestUtils.TestUtils;
import com.tucasita.tasaciones.project.controllers.PropertyController;
import com.tucasita.tasaciones.project.exceptions.PropertyAlreadyExistsException;
import com.tucasita.tasaciones.project.exceptions.PropertyDistrictNameNotFoundException;
import com.tucasita.tasaciones.project.exceptions.PropertyNameNotFoundException;
import com.tucasita.tasaciones.project.models.District;
import com.tucasita.tasaciones.project.models.Property;
import com.tucasita.tasaciones.project.repository.IPropertyRepository;
import com.tucasita.tasaciones.project.services.Dto.PropertyDto;
import com.tucasita.tasaciones.project.services.Dto.PropertyEnvironmentDto;
import com.tucasita.tasaciones.project.services.mapper.mapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.bind.MethodArgumentNotValidException;

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

    @InjectMocks
    PropertyController propertyController;

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

    @Test
    public void propertyNameNotFoundExceptionThrown() throws Exception {
        String propertyName = "Casa1";
        PropertyNameNotFoundException exception = new PropertyNameNotFoundException(propertyName);

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String error = writer.writeValueAsString(exception.getError());

        when(iPropertyRepository.findPropertyByName(propertyName)).thenThrow(exception);

        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/properties/{propertyName}/meters", propertyName))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string(error))
                .andReturn();

        verify(iPropertyRepository,atLeastOnce()).findPropertyByName(propertyName);

    }

    @Test
    public void districtNameNotFoundExceptionThrown() throws Exception {
        String propertyName = "Casa1";
        Property property = TestUtils.getNewProperty(propertyName);

        PropertyDistrictNameNotFoundException exception = new PropertyDistrictNameNotFoundException(property.getProp_district_name());

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();


        when(iPropertyRepository.findPropertyByName(propertyName)).thenReturn(property);
        when(iPropertyRepository.findDistrictByName(property.getProp_district_name())).thenThrow(exception);


        String error = writer.writeValueAsString(exception.getError());

        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/properties/{propertyName}/value", propertyName))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string(error))
                .andReturn();


        verify(iPropertyRepository,atLeastOnce()).findPropertyByName(propertyName);
        verify(iPropertyRepository,atLeastOnce()).findDistrictByName(property.getProp_district_name());

    }


}
