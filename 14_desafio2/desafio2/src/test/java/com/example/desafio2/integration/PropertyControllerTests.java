package com.example.desafio2.integration;

import com.example.desafio2.dtos.ResponseEnvironmentDTO;
import com.example.desafio2.models.EnvironmentDTO;
import com.example.desafio2.models.NeighborhoodDTO;
import com.example.desafio2.models.PropertyDTO;
import com.example.desafio2.repositories.INeighborhoodRepository;
import com.example.desafio2.repositories.IPropertyRepository;
import com.example.desafio2.utils.TestUtilsGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PropertyControllerTests {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    IPropertyRepository iPropertyRepository;

    @MockBean
    INeighborhoodRepository iNeighborhoodRepository;

    @Test
    public void shouldCreateAProperty() throws Exception {
        PropertyDTO property = TestUtilsGenerator.getPropertyWith305SquareMeters("Casa de Madera");

        ObjectWriter writer =
                new ObjectMapper()
                        .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                        .writer()
                        .withDefaultPrettyPrinter();
        String payloadJson = writer.writeValueAsString(property);

        when(iPropertyRepository.saveProperty(property)).thenReturn(property);

        // Act & Assert
        this.mockMvc.perform(MockMvcRequestBuilders.post("/properties/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print())
                .andExpect(content().json(payloadJson))
                .andExpect(status().isCreated());
    }

    @Test
    public void shouldGetSquareMeters() throws Exception {
        PropertyDTO property = TestUtilsGenerator.getPropertyWith305SquareMeters("Casa de Madera");

        when(iPropertyRepository.getPropertyById(property.getId())).thenReturn(property);

        // Act & Assert
        this.mockMvc.perform(MockMvcRequestBuilders.get(
                "/properties/{propertyId}/squareMeters", property.getId()))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.propertyName").value("Casa de Madera"))
                .andExpect(jsonPath("$.totalSquareMeters").value(305.00));
    }

    @Test
    public void shouldGetPropertyValue() throws Exception {
        PropertyDTO property = TestUtilsGenerator.getPropertyWith305SquareMeters("Casa de Madera");
        NeighborhoodDTO neighborhood = TestUtilsGenerator.getNeighborhoodPriceTen(property.getNeighborhood());
        double price = 305.00 * neighborhood.getPrice();

        when(iPropertyRepository.getPropertyById(property.getId())).thenReturn(property);
        when(iNeighborhoodRepository.getNeighborhoodByName(property.getNeighborhood())).thenReturn(neighborhood);

        // Act & Assert
        this.mockMvc.perform(MockMvcRequestBuilders.get(
                "/properties/{propertyId}/value", property.getId()))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.propertyName").value("Casa de Madera"))
                .andExpect(jsonPath("$.valueOfProperty").value(price));
    }

    @Test
    public void shouldGetBiggestEnvironment() throws Exception {
        PropertyDTO property = TestUtilsGenerator.getPropertyWith305SquareMeters("Casa de Madera");
        EnvironmentDTO environment = TestUtilsGenerator.getEnvironment264SquareMeters("Habitación 1");
        double squareMeters = 264.00;

        when(iPropertyRepository.getPropertyById(property.getId())).thenReturn(property);

        // Act & Assert
        this.mockMvc.perform(MockMvcRequestBuilders.get(
                "/properties/{propertyId}/biggestEnvironment", property.getId()))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.propertyName").value("Casa de Madera"))
                .andExpect(jsonPath("$.totalSquareMeters").value(squareMeters))
                .andExpect(jsonPath("$.environment").value(environment));
    }

    @Test
    public void shouldGetSquareMetersOfEnvironments() throws Exception {
        PropertyDTO property = TestUtilsGenerator.getPropertyWith305SquareMeters("Casa de Madera");
        List<ResponseEnvironmentDTO> environments = TestUtilsGenerator.getEnvironmentSquareMetersList(property);

        when(iPropertyRepository.getPropertyById(property.getId())).thenReturn(property);

        // Act & Assert
        this.mockMvc.perform(MockMvcRequestBuilders.get(
                "/properties/{propertyId}/environments/squareMeters", property.getId()))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.propertyName").value("Casa de Madera"))
                .andExpect(jsonPath("$.environments").isArray())
                .andExpect(jsonPath("$.environments", hasSize(3)))
                .andExpect(jsonPath("$.environments[0]").value(environments.get(0)))
                .andExpect(jsonPath("$.environments[1]").value(environments.get(1)))
                .andExpect(jsonPath("$.environments[2]").value(environments.get(2)));
    }
}
