package com.tucasita.tasaciones.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tucasita.tasaciones.dto.PropertyDTO;
import com.tucasita.tasaciones.model.Neighborhood;
import com.tucasita.tasaciones.model.Property;
import com.tucasita.tasaciones.repository.NeighborhoodRepository;
import com.tucasita.tasaciones.repository.PropertyRepository;
import com.tucasita.tasaciones.util.TestUtilGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;


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
    MockMvc mockMvc;

    @MockBean
    NeighborhoodRepository neighborhoodRepository;

    @MockBean
    PropertyRepository repository;

    @Test
    public void savePropertyTest() throws Exception {
        Neighborhood neighborhood = TestUtilGenerator.getNeighborhood();
        PropertyDTO property = TestUtilGenerator.getPropertyDTOWithFourRooms();
        when(neighborhoodRepository.getByName(property.getNeighborhood())).thenReturn(neighborhood);
        ObjectMapper objectMapper = new ObjectMapper();
        String request = objectMapper.writeValueAsString(property);
        mockMvc.perform(post("/properties")
                .contentType("application/json")
                .content(request))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void savePropertyTestException() throws Exception {
        Neighborhood neighborhood = TestUtilGenerator.getNeighborhood();
        PropertyDTO property = TestUtilGenerator.getPropertyDTOWithFourRooms();
        when(neighborhoodRepository.getByName(property.getNeighborhood())).thenReturn(neighborhood);
        doThrow(new IOException()).when(repository).saveProperty(any());
        ObjectMapper objectMapper = new ObjectMapper();
        String request = objectMapper.writeValueAsString(property);
        mockMvc.perform(post("/properties")
                .contentType("application/json")
                .content(request))
                .andDo(print())
                .andExpect(status().isInternalServerError());
    }

    @Test
    public void getAllPropertiesTest() throws Exception {
        List<Property> properties = TestUtilGenerator.getListOfProperties();
        when(repository.getAllProperties()).thenReturn(properties);
        mockMvc.perform(get("/properties"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[?(@.prop_name == \"Home\")]").exists())
                .andExpect(jsonPath("$.[?(@.prop_name == \"Office\")]").exists());
    }

    @Test
    public void getSquareMetersTest() throws Exception {
        Property property = TestUtilGenerator.getPropertyWithTwoRooms();
        when(repository.getPropertyById(1)).thenReturn(property);
        mockMvc.perform(get("/properties/area/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string(containsString("45")));
    }

    @Test
    public void getSquareMetersTextException() throws Exception {
        when(repository.getPropertyById(1)).thenReturn(null);
        String error = "Property with id 1 not found";
        mockMvc.perform(get("/properties/area/1"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value(error));
    }

    @Test
    public void getPropertyPriceTest() throws Exception {
        Property property = TestUtilGenerator.getPropertyWithTwoRooms();
        when(repository.getPropertyById(1)).thenReturn(property);
        mockMvc.perform(get("/properties/price/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string(containsString("18000")));
    }

    @Test
    public void getPropertyPriceTestException() throws Exception {
        when(repository.getPropertyById(1)).thenReturn(null);
        mockMvc.perform(get("/properties/price/1"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Property with id 1 not found"));
    }

    @Test
    public void getBiggestRoomTest() throws Exception {
        Property property = TestUtilGenerator.getPropertyWithTwoRooms();
        when(repository.getPropertyById(1)).thenReturn(property);
        mockMvc.perform(get("/properties/biggest-room/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.environment_name").value("Bedroom"))
                .andExpect(jsonPath("$.environment_length").value(5))
                .andExpect(jsonPath("$.environment_width").value(5));
    }

    @Test
    public void getBiggestRoomTestException() throws Exception {
        when(repository.getPropertyById(1)).thenReturn(null);
        mockMvc.perform(get("/properties/biggest-room/1"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Property with id 1 not found"));
    }

    @Test
    public void getRoomsSquareMetersTest() throws Exception {
        Property property = TestUtilGenerator.getPropertyWithTwoRooms();
        when(repository.getPropertyById(1)).thenReturn(property);

        mockMvc.perform(get("/properties/rooms/area/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.[?(@.environment_name == \"Bedroom\" && @.environment_square_meters == 25)]").exists())
                .andExpect(jsonPath("$.[?(@.environment_name == \"Living room\" && @.environment_square_meters == 20)]").exists());
    }

    @Test
    public void getRoomSquareMetersTestException() throws Exception {
        when(repository.getPropertyById(1)).thenReturn(null);
        mockMvc.perform(get("/properties/rooms/area/1"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Property with id 1 not found"));
    }
}
