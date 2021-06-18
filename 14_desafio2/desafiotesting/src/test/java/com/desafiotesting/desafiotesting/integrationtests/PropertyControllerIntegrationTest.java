package com.desafiotesting.desafiotesting.integrationtests;
import com.desafiotesting.desafiotesting.models.District;
import com.desafiotesting.desafiotesting.models.Property;
import com.desafiotesting.desafiotesting.repositories.IDistrictRepository;
import com.desafiotesting.desafiotesting.repositories.IPropertyRepository;
import com.desafiotesting.desafiotesting.services.dtos.EnviromentDTO;
import com.desafiotesting.desafiotesting.services.dtos.EnviromentWithSquareMetersDTO;
import com.desafiotesting.desafiotesting.services.dtos.PropertyDTO;
import com.desafiotesting.desafiotesting.utils.TestUtilGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PropertyControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ModelMapper mapper;

    @MockBean
    IPropertyRepository propertyRepository;

    @MockBean
    IDistrictRepository DistrictRepository;

    @Test
    public void registerPropertyHappyPathTest() throws Exception {
        PropertyDTO propertyDTO = TestUtilGenerator.getPropertyDTO("District1");
        Property property = TestUtilGenerator.getProperty("District1");
        District district = TestUtilGenerator.getDistrict("District1");

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String payloadJson = writer.writeValueAsString(propertyDTO);

        Mockito.when(DistrictRepository.findByName(propertyDTO.getDistrictName())).thenReturn(district);
        Mockito.when(mapper.map(propertyDTO, Property.class)).thenReturn(property);

        MvcResult response =
                this.mockMvc.perform(MockMvcRequestBuilders.post("/property/registerproperty")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                        .andDo(print()).andExpect(status().isOk())
                        .andReturn();

        Mockito.verify(DistrictRepository,Mockito.atLeast(1)).findByName(propertyDTO.getDistrictName());
        Mockito.verify(propertyRepository,Mockito.atLeast(1)).save(property);
        Assertions.assertEquals(200,response.getResponse().getStatus());
    }

    @Test
    public void totalSquareMetersTest() throws Exception {
        Property property = TestUtilGenerator.getProperty("District1");
        int id = 1;

        Mockito.when(propertyRepository.findById(id)).thenReturn(property);

        MvcResult response =
                this.mockMvc.perform(MockMvcRequestBuilders.post("/property/totalsquaremeters/{id}",id)
                        .contentType(MediaType.APPLICATION_JSON))
                        .andDo(print()).andExpect(status().isOk())
                        .andReturn();

        Assertions.assertEquals(Double.toString(1826.5),response.getResponse().getContentAsString());
        Assertions.assertEquals(200,response.getResponse().getStatus());
    }

    @Test
    public void getPriceProperty() throws Exception{
        Property property = TestUtilGenerator.getProperty("District1");
        int id = 1;

        Mockito.when(propertyRepository.findById(id)).thenReturn(property);

        MvcResult response =
                this.mockMvc.perform(MockMvcRequestBuilders.post("/property/priceproperty/{id}",id)
                        .contentType(MediaType.APPLICATION_JSON))
                        .andDo(print()).andExpect(status().isOk())
                        .andReturn();

        Assertions.assertEquals(Double.toString(411875.75),response.getResponse().getContentAsString());
        Assertions.assertEquals(200,response.getResponse().getStatus());
    }

    @Test
    public void getBiggerEnviroment() throws Exception {
        Property property = TestUtilGenerator.getProperty("District1");
        EnviromentDTO enviromentDTO = TestUtilGenerator.getEnviromentDTO();
        int id = 1;

        Mockito.when(mapper.map(property.getEnviroments().get(0),EnviromentDTO.class)).thenReturn(enviromentDTO);
        Mockito.when(propertyRepository.findById(property.getId())).thenReturn(property);

        MvcResult response =
                this.mockMvc.perform(MockMvcRequestBuilders.post("/property/biggerenviroment/{id}",id)
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(enviromentDTO.getName()))
                        .andDo(print()).andExpect(status().isOk())
                        .andReturn();

        Assertions.assertEquals(200,response.getResponse().getStatus());;
    }

    @Test
    public void getEnviromentsInfoTest() throws Exception {
        Property property = TestUtilGenerator.getProperty("District1");
        List<EnviromentWithSquareMetersDTO> enviromentsDTO = TestUtilGenerator.getEnviromentsWithSquareMetersDTO();
        int id = 1;

        Mockito.when(propertyRepository.findById(property.getId())).thenReturn(property);

        MvcResult response =
                this.mockMvc.perform(MockMvcRequestBuilders.post("/property/enviromentsinfo/{id}",id)
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value(enviromentsDTO.get(0).getName()))
                        .andExpect(MockMvcResultMatchers.jsonPath("$[0].squareMeters").value(enviromentsDTO.get(0).getSquareMeters()))
                        .andDo(print()).andExpect(status().isOk())
                        .andReturn();

        Assertions.assertEquals(200,response.getResponse().getStatus());;
    }
}
