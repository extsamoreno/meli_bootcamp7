package com.meli.desafio2.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.desafio2.dto.environment.ResponseBigEnvironmentDTO;
import com.meli.desafio2.dto.environment.ResponseEnvironmentDTO;
import com.meli.desafio2.dto.property.PropertyDTO;
import com.meli.desafio2.dto.property.ResponsePropTotalAreaDTO;
import com.meli.desafio2.dto.property.ResponsePropValueDTO;
import com.meli.desafio2.exception.DistrictIdNotFoundException;
import com.meli.desafio2.exception.PropertyIdNotFoundException;
import com.meli.desafio2.model.District;
import com.meli.desafio2.model.Property;
import com.meli.desafio2.repository.IDistrictRepository;
import com.meli.desafio2.repository.IPropertyRepository;
import com.meli.desafio2.util.TestUtilsGen;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PropertyControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    IPropertyRepository propertyRepository;

    @MockBean
    IDistrictRepository districtRepository;

    static ObjectWriter createWriter() {
        return new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
    }

    // EndPoint 1
    @Test
    public void calcTotalAreaHappyPathOk() throws Exception {

        // Arrange
        int propId = 0;
        Property prop = TestUtilsGen.getPropWithId(propId);
        ResponsePropTotalAreaDTO propDTO = TestUtilsGen.getResponsePropTotalAreaDTO(propId);
        String expectedJson = createWriter().writeValueAsString(propDTO);

        when(propertyRepository.getPropertybyId(propId)).thenReturn(prop);

        // Act
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/prop/calcTotalM2/{propId}", propId))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        // Assert
        verify(propertyRepository, atLeastOnce()).getPropertybyId(propId);
        Assertions.assertEquals(expectedJson, mvcResult.getResponse().getContentAsString());
    }

    // EndPoint 2
    @Test
    public void calcPropValueHappyPathOk() throws Exception {

        // Arrange
        int propId = 0;
        Property prop = TestUtilsGen.getPropWithId(propId);
        ResponsePropValueDTO propDTO = TestUtilsGen.getResponsePropValueDTO(propId);
        District dist = TestUtilsGen.getDistWithId(prop.getDistrictId());

        String expectedJson = createWriter().writeValueAsString(propDTO);

        when(propertyRepository.getPropertybyId(propId)).thenReturn(prop);
        when(districtRepository.getDistrictbyId(prop.getDistrictId())).thenReturn(dist);

        // Act
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/prop/calcValue/{propId}", propId))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        // Assert
        verify(propertyRepository, atLeastOnce()).getPropertybyId(propId);
        verify(districtRepository, atLeastOnce()).getDistrictbyId(prop.getDistrictId());
        Assertions.assertEquals(expectedJson, mvcResult.getResponse().getContentAsString());
    }

    // EndPoint 3
    @Test
    public void getBigEnvironmentHappyPathOk() throws Exception {

        // Arrange
        int propId = 0;
        Property prop = TestUtilsGen.getPropWithId(propId);
        ResponseBigEnvironmentDTO bigEnvDTO = TestUtilsGen.getResponseBigEnvironmentDTO();
        String expectedJson = createWriter().writeValueAsString(bigEnvDTO);

        when(propertyRepository.getPropertybyId(propId)).thenReturn(prop);

        // Act
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/prop/getBiggestEnv/{propId}", propId))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        // Assert
        verify(propertyRepository, atLeastOnce()).getPropertybyId(propId);
        Assertions.assertEquals(expectedJson, mvcResult.getResponse().getContentAsString());

    }

    // EndPoint 4
    @Test
    public void listEnvAreaHappyPathOk() throws Exception {

        // Arrange
        int propId = 0;
        Property prop = TestUtilsGen.getPropWithId(propId);
        List<ResponseEnvironmentDTO> listEnvDTO = TestUtilsGen.getListResponseEnvironmentDTO();

        String expectedJson = createWriter().writeValueAsString(listEnvDTO);

        when(propertyRepository.getPropertybyId(propId)).thenReturn(prop);

        // Act
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/prop/listEnvInM2/{propId}", propId))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        // Assert
        verify(propertyRepository, atLeastOnce()).getPropertybyId(propId);
        Assertions.assertEquals(expectedJson, mvcResult.getResponse().getContentAsString());
    }

    // EndPoint 5
    @Test
    public void createNewPropHappyPath() throws Exception {

        // Arrange
        int propId = 0;
        PropertyDTO propDTO = TestUtilsGen.getPropDTOWithId(propId);
        Property prop = TestUtilsGen.getPropWithId(propId);
        String message = "Property successfully created";

        String payloadJson = createWriter().writeValueAsString(propDTO);

        // Act
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post("/prop/newProp")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isOk())
                .andReturn();

        // Assert
        verify(propertyRepository, atLeastOnce()).createProperty(prop);
        Assertions.assertEquals(message, mvcResult.getResponse().getContentAsString());
    }
}
