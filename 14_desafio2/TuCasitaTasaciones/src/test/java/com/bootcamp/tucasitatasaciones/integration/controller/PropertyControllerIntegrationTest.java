package com.bootcamp.tucasitatasaciones.integration.controller;

import com.bootcamp.tucasitatasaciones.DTO.*;
import com.bootcamp.tucasitatasaciones.model.District;
import com.bootcamp.tucasitatasaciones.model.Environment;
import com.bootcamp.tucasitatasaciones.model.Property;
import com.bootcamp.tucasitatasaciones.repository.IDataRepository;
import com.bootcamp.tucasitatasaciones.util.JSONMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PropertyControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    IDataRepository dataRepository;

    static PropertyDTO propertyDTO;
    static Property property;
    static TotalSquareMetersDTO totalSquareMetersDTO;
    static Environment biggestEnvironment;
    static EnvironmentDTO biggestEnvironmentDTO;
    static List<EnvironmentWithSquareMetersDTO> environmentWithSquareMeters;
    static PropertyAppraisalDTO propertyAppraisalDTO;
    static District district;
    static String propertyDTOJSON;

    @BeforeAll
    public static void beforeAll() throws JsonProcessingException {
        propertyDTO = new PropertyDTO("Casa 1", new DistrictDTO("Bella Vista"),
                new ArrayList<>() {{
                    add(new EnvironmentDTO("Env1", 10.0, 20.0));
                    add(new EnvironmentDTO("Env2", 5.0, 7.0));
                    add(new EnvironmentDTO("Env3", 8.0, 5.0));
                }});

        property = new Property(1L, "Casa 1", 2L,
                new ArrayList<>() {{
                    add(new Environment("Env1", 10.0, 20.0));
                    add(new Environment("Env2", 5.0, 7.0));
                    add(new Environment("Env3", 8.0, 5.0));
                }});

        totalSquareMetersDTO = new TotalSquareMetersDTO("Casa 1", 275.0);

        biggestEnvironment = new Environment("Env1", 10.0, 20.0);
        biggestEnvironmentDTO = new EnvironmentDTO("Env1", 10.0, 20.0);

        environmentWithSquareMeters = new ArrayList<>() {{
            add(new EnvironmentWithSquareMetersDTO("Env1", 200.0));
            add(new EnvironmentWithSquareMetersDTO("Env2", 35.0));
            add(new EnvironmentWithSquareMetersDTO("Env3", 40.0));
        }};

        district = new District(2L, "Bella Vista", 900.0);
        propertyAppraisalDTO = new PropertyAppraisalDTO("Casa 1", 247500.0);
        propertyDTOJSON = JSONMapper.toJson(propertyDTO);
    }

    //==================================TESTS==================================================

    @Test
    public void registerPropertyHappyPath() throws Exception {
        Mockito.when(dataRepository.findDistrictByName(propertyDTO.getDistrict().getName())).thenReturn(district);
        Mockito.doNothing().when(dataRepository).saveProperty(property);

        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/properties/register-property")
                .contentType(MediaType.APPLICATION_JSON)
                .content(propertyDTOJSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void registerPropertyDistrictNotFound() throws Exception {
        Mockito.when(dataRepository.findDistrictByName(propertyDTO.getDistrict().getName())).thenReturn(null);

        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/properties/register-property")
                .contentType(MediaType.APPLICATION_JSON)
                .content(propertyDTOJSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("NotFoundException"));
    }

    @Test
    public void getTotalSquareMeters() throws Exception {
        Mockito.when(dataRepository.findPropertyById(property.getId())).thenReturn(property);

        MvcResult received = this.mockMvc.perform(MockMvcRequestBuilders
                .get("/properties/total-square-meters/{propertyId}", property.getId()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        TotalSquareMetersDTO body = JSONMapper.fromJson(received.getResponse().getContentAsString(), TotalSquareMetersDTO.class);

        Assertions.assertEquals(totalSquareMetersDTO, body);
    }

    @Test
    public void getTotalSquareMetersPropertyNotFound() throws Exception {
        Mockito.when(dataRepository.findPropertyById(property.getId())).thenReturn(null);

        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/properties/total-square-meters/{propertyId}", property.getId()))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("NotFoundException"));

    }

    @Test
    public void appraisePropertyHappyPath() throws Exception {
        Mockito.when(dataRepository.findPropertyById(property.getId())).thenReturn(property);
        Mockito.when(dataRepository.findDistrictById(district.getId())).thenReturn(district);

        MvcResult received = this.mockMvc.perform(MockMvcRequestBuilders
                .get("/properties/appraisal/{propertyId}", property.getId()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        PropertyAppraisalDTO body = JSONMapper.fromJson(received.getResponse().getContentAsString(), PropertyAppraisalDTO.class);

        Assertions.assertEquals(propertyAppraisalDTO, body);
    }

    @Test
    public void appraisePropertyPropertyNotFound() throws Exception {
        Mockito.when(dataRepository.findPropertyById(property.getId())).thenReturn(null);

        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/properties/appraisal/{propertyId}", property.getId()))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("NotFoundException"));
    }

    @Test
    public void getBiggestEnvironmentHappyPath() throws Exception {
        Mockito.when(dataRepository.findPropertyById(property.getId())).thenReturn(property);

        MvcResult received = this.mockMvc.perform(MockMvcRequestBuilders
                .get("/properties/get-biggest-environment/{propertyId}", property.getId()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        EnvironmentDTO body = JSONMapper.fromJson(received.getResponse().getContentAsString(), EnvironmentDTO.class);

        Assertions.assertEquals(biggestEnvironmentDTO, body);
    }

    @Test
    public void getBiggestEnvironmentPropertyNotFound() throws Exception {
        Mockito.when(dataRepository.findPropertyById(property.getId())).thenReturn(null);

        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/properties/get-biggest-environment/{propertyId}", property.getId()))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("NotFoundException"));
    }

    @Test
    public void getAllEnvironmentsWithSquareMetersHappyPath() throws Exception {
        Mockito.when(dataRepository.findPropertyById(property.getId())).thenReturn(property);

        MvcResult received = this.mockMvc.perform(MockMvcRequestBuilders
                .get("/properties/list-environments/{propertyId}", property.getId()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        List<EnvironmentWithSquareMetersDTO> body = JSONMapper.fromJsonToList(received.getResponse().getContentAsString(),
                EnvironmentWithSquareMetersDTO.class);

        Assertions.assertEquals(environmentWithSquareMeters, body);
    }

    @Test
    public void getAllEnvironmentsWithSquareMetersPropertyNotFound() throws Exception {
        Mockito.when(dataRepository.findPropertyById(property.getId())).thenReturn(null);

        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/properties/list-environments/{propertyId}", property.getId()))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("NotFoundException"));
    }

}
