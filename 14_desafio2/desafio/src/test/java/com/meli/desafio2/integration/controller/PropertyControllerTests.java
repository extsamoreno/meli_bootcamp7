package com.meli.desafio2.integration.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.desafio2.model.Property;
import com.meli.desafio2.unit.repository.IPropertyRepository;
import com.meli.desafio2.unit.service.dto.PropertyDTO;
import com.meli.desafio2.util.TestUtilsGenerator;
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
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PropertyControllerTests {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    IPropertyRepository iPropertyRepository;

    @Test
    public void createHappyPath() throws Exception {

        // arrange
        PropertyDTO propDTO = TestUtilsGenerator.getPropertyDTO("Juan");

        Mockito.when(iPropertyRepository.fetch(propDTO.getDistrict().getName())).thenReturn(420d);
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payloadJson = writer.writeValueAsString(propDTO);

        //act
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/propiedad/registerProperty")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isOk())
                .andReturn();

    }

    @Test
    public void calculateSquareMetersHappyPath() throws Exception {

        // arrange
        Property prop = TestUtilsGenerator.getProperty("Juan");
        long propId = prop.getId();
        Mockito.when(iPropertyRepository.fetch(propId)).thenReturn(prop);
        Double expected = 680d;

        // act
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/propiedad/metros/{id}",propId))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(expected, Double.parseDouble(mvcResult.getResponse().getContentAsString()));
    }

    @Test
    public void calculateValueHappyPath() throws Exception {

        // arrange
        Property prop = TestUtilsGenerator.getProperty("Juan");
        long propId = prop.getId();
        Mockito.when(iPropertyRepository.fetch(propId)).thenReturn(prop);
        Double expected = 680d*420d;

        // act
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/propiedad/valor/{id}",propId))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(expected, Double.parseDouble(mvcResult.getResponse().getContentAsString()));
    }

    @Test
    public void getBiggestRoom() throws Exception {

        // arrange
        Property prop = TestUtilsGenerator.getProperty("Juan");
        long propId = prop.getId();
        Mockito.when(iPropertyRepository.fetch(propId)).thenReturn(prop);


        // act
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/propiedad/habMasGrande/{id}",propId))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(prop.getRooms().get(1).getName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.length").value(prop.getRooms().get(1).getLength()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.width").value(prop.getRooms().get(1).getWidth()))
                .andReturn();
    }

    @Test
    public void squareMetersRooms() throws Exception {

        // arrange
        Property prop = TestUtilsGenerator.getProperty("Juan");
        long propId = prop.getId();
        Mockito.when(iPropertyRepository.fetch(propId)).thenReturn(prop);

        // act
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/propiedad/habitaciones/{id}",propId))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0]name").value(prop.getRooms().get(0).getName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0]length").value(prop.getRooms().get(0).getLength()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0]width").value(prop.getRooms().get(0).getWidth()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0]squareMeters").value(prop.getRooms().get(0).getWidth()*prop.getRooms().get(0).getLength()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[1]name").value(prop.getRooms().get(1).getName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[1]length").value(prop.getRooms().get(1).getLength()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[1]width").value(prop.getRooms().get(1).getWidth()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[1]squareMeters").value(prop.getRooms().get(1).getWidth()*prop.getRooms().get(1).getLength()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[2]name").value(prop.getRooms().get(2).getName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[2]length").value(prop.getRooms().get(2).getLength()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[2]width").value(prop.getRooms().get(2).getWidth()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[2]squareMeters").value(prop.getRooms().get(2).getWidth()*prop.getRooms().get(2).getLength()))
                .andReturn();
    }


}
