package com.desafio2.Integration;

import com.desafio2.DTO.EnvironmentDTO;
import com.desafio2.Model.District;
import com.desafio2.Model.Environment;
import com.desafio2.Model.Property;
import com.desafio2.Repository.IDistrctRepository;
import com.desafio2.Repository.IPropertyRepository;
import com.desafio2.Utils.TestUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Assertions;
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
    IPropertyRepository iPropertyRepository;
    @MockBean
    IDistrctRepository iDistrctRepository;

    @Test
    public void createProperty() throws Exception {
        Property property = TestUtils.createProperty("Avenue1");
        Mockito.doNothing().when(iPropertyRepository).save(property);

        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE, false).
                writer().withDefaultPrettyPrinter();
        String payloadJson = writer.writeValueAsString(property);

        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/property/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getTotalSqaureMeters() throws Exception {
        Property property = TestUtils.createProperty("Avenue1");
        Mockito.when(iPropertyRepository.findByName(property.getProp_name())).thenReturn(property);

        String responseJson = "188.0";

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders
                .get("/property/totalSqaureMeters/{property_name}", "Avenue1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(responseJson, mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void getPropertyPrice() throws Exception {
        Property property = TestUtils.createProperty("Avenue1");
        District district = TestUtils.createWestDistrict100USD();
        Mockito.when(iPropertyRepository.findByName(property.getProp_name())).thenReturn(property);
        Mockito.when(iDistrctRepository.findByName(property.getDistrict_name())).thenReturn(district);

        String responseJson = "18800.0";

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders
                .get("/property/price/{property_name}", "Avenue1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(responseJson, mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void getBiggestEnvironment() throws Exception {
        Property property = TestUtils.createProperty("Avenue1");
        Environment environment = TestUtils.getBiggestEnvironment();
        Mockito.when(iPropertyRepository.findByName(property.getProp_name())).thenReturn(property);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String responseJson = writer.writeValueAsString(environment);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders
                .get("/property/biggestEnvironment/{property_name}", "Avenue1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(responseJson, mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void getEnvironmentListWithSquareMeters() throws Exception {
        Property property = TestUtils.createProperty("Avenue1");
        List<EnvironmentDTO> environments = TestUtils.getEnvironments();
        Mockito.when(iPropertyRepository.findByName(property.getProp_name())).thenReturn(property);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String responseJson = writer.writeValueAsString(environments);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders
                .get("/property/listEnvironments/{property_name}", "Avenue1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(responseJson, mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void createPropertyThrowsMethodArgumentNotValidException() throws Exception {
        Property property = TestUtils.createNotValidProperty();
        Mockito.doNothing().when(iPropertyRepository).save(property);

        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE, false).
                writer().withDefaultPrettyPrinter();
        String payloadJson = writer.writeValueAsString(property);

        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/property/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
}
