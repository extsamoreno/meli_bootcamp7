package com.example.demo.integration;

import com.example.demo.Utils.Utils;
import com.example.demo.dtos.*;
import com.example.demo.model.Property;
import com.example.demo.repositories.PropertyRepository;
import com.example.demo.services.mappers.MapperProperty;
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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
public class PropertyControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    PropertyRepository propertyRepository;

    @Test
    public void addPropertyHappyPath() throws Exception {


        PropertyRequestDTO payloadDTO = Utils.getPropertyRequestDTO();

        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE, false).
                writer().withDefaultPrettyPrinter();

        String payloadJson = writer.writeValueAsString(payloadDTO);

         this.mockMvc.perform(MockMvcRequestBuilders.post("/properties/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isCreated())
                .andExpect(content().contentType("application/json"))
                 .andExpect(MockMvcResultMatchers.jsonPath("$.prop_name").value(payloadDTO.getProp_name()));

    }

    @Test
    public void getSquareMetersHappyPath() throws Exception {
        int id = 1;
        Property property = Utils.getProperty();
        PropertyM2ResponseDTO expected = Utils.getPropertyM2ResponseDTO();
        expected.setProp_square_meters(148d);
        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE, false).
                writer().withDefaultPrettyPrinter();

        Mockito.when(propertyRepository.findPropertyById(id)).thenReturn(property);

        String expectedStr = writer.writeValueAsString(expected).replace(" ","").replace("\n","");

        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders. get("/properties/squaremetersProp/{propId}",1))
                .andDo(print()).andExpect(status().isOk())
                .andExpect( content().contentType( "application/json" ))
                .andExpect(MockMvcResultMatchers.jsonPath("$.prop_name").value("Prop1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.prop_square_meters").value(148))
                .andReturn();

        String received = response.getResponse().getContentAsString();
        Assertions.assertEquals(expectedStr,received);

    }

   @Test
    public void getPrice() throws Exception {

        int id = 1;
        Property property = Utils.getProperty();
        PropertyPriceResponseDTO expected = Utils.getPropertyPriceResponseDTO();
        expected.setProp_price(74000d);
        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE, false).
                writer().withDefaultPrettyPrinter();

        String expectedStr = writer.writeValueAsString(expected).replace(" ","").replace("\n","");

        Mockito.when(propertyRepository.findPropertyById(id)).thenReturn(property);

        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.get("/properties/propPrice/{propId}",id))
                .andDo(print()).andExpect(status().isOk())
                .andExpect( content().contentType( "application/json" ))
                .andExpect(MockMvcResultMatchers.jsonPath("$.prop_name").value("Prop1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.prop_price").value(74000d))
                .andReturn();

        String received = response.getResponse().getContentAsString();
        Assertions.assertEquals(expectedStr,received);

    }

    @Test
    public void getBiggestEnvPropHappyPath() throws Exception {

        int id = 1;
        Property property = Utils.getProperty();
        BiggestPropResponseDTO expected = Utils.getBiggestEnvPropDTO();
        BiggestEnvironmentDTO biggestEnvironmentDTO = new BiggestEnvironmentDTO("Environment3",56d);
        expected.setBiggestEnvironment(biggestEnvironmentDTO);
        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE, false).
                writer().withDefaultPrettyPrinter();

        String expectedStr = writer.writeValueAsString(expected).replace(" ","").replace("\n","");

        Mockito.when(propertyRepository.findPropertyById(id)).thenReturn(property);

        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.get("/properties/biggestEnv/{propId}",1))
                .andDo(print()).andExpect(status().isOk())
                .andExpect( content().contentType( "application/json" ))
                .andExpect(MockMvcResultMatchers.jsonPath("$.prop_name").value("Prop1"))
                .andReturn();

        String received = response.getResponse().getContentAsString();
        Assertions.assertEquals(expectedStr,received);

    }


    @Test
    public void getSquareMetersEnvHappyPath() throws Exception {
        int id = 1;
        Property property = Utils.getProperty();
        PropertyM2EnvsResponseDTO expected = Utils.getSquareMetersEnvDTO();

        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE, false).
                writer().withDefaultPrettyPrinter();

        String expectedStr = writer.writeValueAsString(expected).replace(" ","").replace("\n","");

        Mockito.when(propertyRepository.findPropertyById(id)).thenReturn(property);

         MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.get("/properties/squaremetersEnvs/{propId}",1))
                .andDo(print()).andExpect(status().isOk())
                .andExpect( content().contentType( "application/json" ))
                .andExpect(MockMvcResultMatchers.jsonPath("$.prop_name").value("Prop1"))
                .andReturn();

      String received = response.getResponse().getContentAsString();
        Assertions.assertEquals(expectedStr,received);

    }

    @Test
    public void findPropertyByIdHappyPath() throws Exception {
        Property property = Utils.getProperty();
        int id =1;
        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE, false).
                writer().withDefaultPrettyPrinter();

        String expectedStr = writer.writeValueAsString(property).replace(" ","").replace("\n","");

        Mockito.when(propertyRepository.findPropertyById(id)).thenReturn(property);

        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.get("/properties/property/{propId}",1))
                .andDo(print()).andExpect(status().isOk())
                .andExpect( content().contentType( "application/json" ))
                .andExpect(MockMvcResultMatchers.jsonPath("$.prop_name").value("Prop1"))
                .andReturn();

        String received = response.getResponse().getContentAsString();
        Assertions.assertEquals(expectedStr,received);

    }

}
