package com.tucasitatasaciones.demo.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.tucasitatasaciones.demo.dto.*;
import com.tucasitatasaciones.demo.models.Property;
import com.tucasitatasaciones.demo.repository.IPropertyRepository;
import com.tucasitatasaciones.demo.service.IPropertyService;
import com.tucasitatasaciones.demo.unit.Utils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.http.MediaType;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PropertyControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    IPropertyRepository propertyRepository;

    private PropertyDTO propertyDTO;
    private Property property;
    private PropertySquareMettersDTO propertySquareMetters;
    private PropertyPriceDTO propertyPrice;
    private PropertyBiggestEnvironmentDTO propertyBiggestEnvironment;
    private PropertyEnvironmentSquareMetterDTO propertyEnvironmentMetters;

    @BeforeEach @AfterEach
    public void setUp(){
        propertyDTO = Utils.getPropertyDTO();
        property = Utils.getProperty();
        propertySquareMetters = Utils.getPropertySquareMetters();
        propertyPrice = Utils.getPropertyPrice();
        propertyBiggestEnvironment = Utils.getPropertyBiggestEnvironment();
        propertyEnvironmentMetters = Utils.getPropertyEnviromentsSquareMetters();
    }

    @Test
    public void testCreatePropertyWithValidPayload() throws Exception {
        ObjectWriter writer =
                new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payloadJson = writer.writeValueAsString(propertyDTO);

        when(propertyRepository.addProperty(property)).thenReturn(property);
        when(propertyRepository.findPropertyByName(property.getName())).thenReturn(null);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/properties/new")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    public void testGetSquareMettersByIdWithValidId() throws Exception{
        ObjectWriter writer =
                new ObjectMapper()
                        .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                        .writer();

        String responseExpected = writer.writeValueAsString(propertySquareMetters);

        when(propertyRepository.findPropertyById(1)).thenReturn(property);

        MvcResult responseReceived =
                this.mockMvc.perform(MockMvcRequestBuilders.get("/api/properties/{id}/square-metters", 1))
                            .andDo(print())
                            .andExpect(content().contentType("application/json"))
                            .andExpect(status().isOk())
                            .andReturn();

        assertEquals(responseExpected, responseReceived.getResponse().getContentAsString());
    }

    @Test
    public void testGetPropertyPriceWithValidId() throws Exception{
        ObjectWriter writer =
                new ObjectMapper()
                        .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                        .writer();

        String responseExpected = writer.writeValueAsString(propertyPrice);

        when(propertyRepository.findPropertyById(1)).thenReturn(property);

        MvcResult responseReceived =
                this.mockMvc.perform(MockMvcRequestBuilders.get("/api/properties/{id}/price", 1))
                        .andDo(print())
                        .andExpect(content().contentType("application/json"))
                        .andExpect(status().isOk())
                        .andReturn();

        assertEquals(responseExpected, responseReceived.getResponse().getContentAsString());
    }

    @Test
    public void testGetBiggestEnvironmentByIdWithValidId() throws Exception {
        ObjectWriter writer =
                new ObjectMapper()
                        .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                        .writer();

        String responseExpected = writer.writeValueAsString(propertyBiggestEnvironment);

        when(propertyRepository.findPropertyById(1)).thenReturn(property);

        MvcResult responseReceived =
                this.mockMvc.perform(MockMvcRequestBuilders.get("/api/properties/{id}/biggest-environment", 1))
                        .andDo(print())
                        .andExpect(content().contentType("application/json"))
                        .andExpect(status().isOk())
                        .andReturn();

        assertEquals(responseExpected, responseReceived.getResponse().getContentAsString());
    }

    @Test
    public void testGetPropertyEnvironmentsSquareMetters() throws Exception {
        ObjectWriter writer =
                new ObjectMapper()
                        .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                        .writer();

        String responseExpected = writer.writeValueAsString(propertyEnvironmentMetters);

        when(propertyRepository.findPropertyById(1)).thenReturn(property);

        MvcResult responseReceived =
                this.mockMvc.perform(MockMvcRequestBuilders.get("/api/properties/{id}/environments-square-metters", 1))
                        .andDo(print())
                        .andExpect(content().contentType("application/json"))
                        .andExpect(status().isOk())
                        .andReturn();

        assertEquals(responseExpected, responseReceived.getResponse().getContentAsString());
    }

}
