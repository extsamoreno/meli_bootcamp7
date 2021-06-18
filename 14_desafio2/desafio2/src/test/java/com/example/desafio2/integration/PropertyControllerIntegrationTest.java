package com.example.desafio2.integration;

import com.example.desafio2.model.Property;
import com.example.desafio2.repository.IPropertyRepository;
import com.example.desafio2.service.DTO.PropertyTotalMetresRoomDTO;
import com.example.desafio2.util.TestUtilsGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PropertyControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    IPropertyRepository repository;
    @Test
    public void getTotalMetresSuccessful() throws Exception {
        Property property = TestUtilsGenerator.getPropertyWith1Room("Centro");
        String route = "/properties/"+property.getName()+"/getTotalMetres";
        when(repository.findPropertyByName(property.getName())).thenReturn(property);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders
                .get(route))
                .andDo(print()).andExpect(status().isOk())
                .andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        Assertions.assertEquals(content, "1.0");
        Assertions.assertEquals("application/json", mvcResult.getResponse().getContentType());
    }
    @Test
    public void getValuesSuccessful() throws Exception {
        Property property = TestUtilsGenerator.getPropertyWith1Room("Centro");
        String route = "/properties/"+property.getName()+"/getValue";
        when(repository.findPropertyByName(property.getName())).thenReturn(property);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders
                .get(route))
                .andDo(print()).andExpect(status().isOk())
                .andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        Assertions.assertEquals(content, "10.0");
        Assertions.assertEquals("application/json", mvcResult.getResponse().getContentType());
    }
    @Test
    public void getBiggestRoomSuccessful() throws Exception {
        Property property = TestUtilsGenerator.getPropertyWith1Room("Centro");
        String route = "/properties/"+property.getName()+"/getBiggestRoom";
        when(repository.findPropertyByName(property.getName())).thenReturn(property);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders
                .get(route))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("name").value(property.getRooms().get(0).getName()))
                .andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        Assertions.assertEquals("application/json", mvcResult.getResponse().getContentType());
    }
    @Test
    public void getTotalEachRoomSuccessful() throws Exception {
        Property property = TestUtilsGenerator.getPropertyWith1Room("Centro");
        String route = "/properties/"+property.getName()+"/getBiggestRoom";
        when(repository.findPropertyByName(property.getName())).thenReturn(property);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders
                .get(route))
                .andDo(print()).andExpect(status().isOk())
                .andReturn();
        Object content = mvcResult.getResponse();
        Assertions.assertEquals("application/json", mvcResult.getResponse().getContentType());
    }

}