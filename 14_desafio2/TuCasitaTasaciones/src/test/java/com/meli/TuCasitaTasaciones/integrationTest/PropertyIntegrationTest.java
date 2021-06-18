package com.meli.TuCasitaTasaciones.integrationTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.TuCasitaTasaciones.model.*;
import com.meli.TuCasitaTasaciones.repository.IPropertyDAO;
import com.meli.TuCasitaTasaciones.util.TestUtilsGenerator;
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

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PropertyIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    IPropertyDAO iPropertyDAO;

    @Test
    public void calculateAreaTest() throws Exception {

        EnvironmentListDTO payloadDTO = TestUtilsGenerator.getEnvironments();
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payloadJson = writer.writeValueAsString(payloadDTO);
        String responseJson = writer.writeValueAsString(1219.0);

        MvcResult response = this.mockMvc.perform((MockMvcRequestBuilders.post("/Property/calculateArea"))
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(responseJson, response.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    @Test
    public void calculatePriceTest() throws Exception {

        HouseDTO payloadDTO = TestUtilsGenerator.getHouseDTO();
        HashMap<String, Double> hm = TestUtilsGenerator.getDistrictsList();

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payloadJson = writer.writeValueAsString(payloadDTO);
        String responseJson = writer.writeValueAsString(5995000.0);

        when(iPropertyDAO.getDistrictList()).thenReturn(hm);

        MvcResult response = this.mockMvc.perform((MockMvcRequestBuilders.post("/Property/calculatePrice"))
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(responseJson, response.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    @Test
    public void environmentsBiggestTest() throws Exception {

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        EnvironmentListDTO payloadDTO = TestUtilsGenerator.getEnvironments();

        EnvironmentAreaResponseDTO responseDTO = TestUtilsGenerator.getEnvironmentAreaResponseDTO();

        String payloadJson = writer.writeValueAsString(payloadDTO);
        String responseJson = writer.writeValueAsString(responseDTO);

        MvcResult response = this.mockMvc.perform((MockMvcRequestBuilders.post("/Property/environmentsBiggest"))
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(responseJson, response.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    @Test
    public void environmentAreaTest() throws Exception {

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        EnvironmentListDTO payloadDTO = TestUtilsGenerator.getEnvironments();
        List<EnvironmentAreaResponseDTO> responseDTO = TestUtilsGenerator.getListEnvironmentAreaResponseDTO();

        String payloadJson = writer.writeValueAsString(payloadDTO);
        String responseJson = writer.writeValueAsString(responseDTO);

        MvcResult response = this.mockMvc.perform((MockMvcRequestBuilders.post("/Property/environmentArea"))
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(responseJson, response.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    @Test
    public void addPropertyTest() throws Exception {

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        PropertyDTO payloadDTO = TestUtilsGenerator.getPropertyDTO();
        Mockito.doNothing().when(iPropertyDAO).addProperty(payloadDTO);

        String payloadJson = writer.writeValueAsString(payloadDTO);

        MvcResult response = this.mockMvc.perform((MockMvcRequestBuilders.post("/Property/addProperty"))
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isCreated())
                .andReturn();
    }

    @Test
    public void addPropertyWithErrorsTest() throws Exception {

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        PropertyDTO payloadDTO = TestUtilsGenerator.getPropertyDTOWithErrors();
        Mockito.doNothing().when(iPropertyDAO).addProperty(payloadDTO);

        String payloadJson = writer.writeValueAsString(payloadDTO);

        MvcResult response = this.mockMvc.perform((MockMvcRequestBuilders.post("/Property/addProperty"))
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andReturn();
    }

    @Test
    public void addPropertyRepeatedTest() throws Exception {

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        PropertyDTO payloadDTO = TestUtilsGenerator.getPropertyRepeatedDTO();
        HashMap<String, Double> hm = TestUtilsGenerator.getDistrictsList();

        Mockito.doNothing().when(iPropertyDAO).addProperty(payloadDTO);
        Mockito.when(iPropertyDAO.getDistrictList()).thenReturn(hm);

        String payloadJson = writer.writeValueAsString(payloadDTO);

        MvcResult response = this.mockMvc.perform((MockMvcRequestBuilders.post("/Property/addProperty"))
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        Assertions.assertEquals("{\"name\":\"DistrictRepeatedException\",\"description\":\"El barrio Palermo ya se encuentra registrado.\"}", response.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }
}
