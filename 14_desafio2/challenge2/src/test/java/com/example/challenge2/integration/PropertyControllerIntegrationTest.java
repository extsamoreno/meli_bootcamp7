package com.example.challenge2.integration;

import com.example.challenge2.dtos.SizeResponseDTO;
import com.example.challenge2.models.District;
import com.example.challenge2.models.Environment;
import com.example.challenge2.models.Property;
import com.example.challenge2.repositories.IDistrictDAO;
import com.example.challenge2.repositories.IPropertyDAO;
import com.example.challenge2.util.TestUtilGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.modelmapper.ModelMapper;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import java.util.ArrayList;

@SpringBootTest
@AutoConfigureMockMvc
public class PropertyControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    IPropertyDAO propertyDAO;

    @MockBean
    IDistrictDAO districtDAO;

    @MockBean
    ModelMapper mapper;

    @Test
    public void createProperty() throws Exception {
        Property property = TestUtilGenerator.getProperty();


        ObjectWriter writer =
                new ObjectMapper()
                        .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                        .writer()
                        .withDefaultPrettyPrinter();
        String payloadJson = writer.writeValueAsString(property);

        Mockito.when(propertyDAO.save(property)).thenReturn(property);
        District district = new District("Carrasco", 400.0);
        Mockito.when(districtDAO.exist(property.getDistrictName())).thenReturn(true);

        // Act & Assert
        this.mockMvc.perform(MockMvcRequestBuilders.post("/property/record")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print())
                .andExpect(content().json(payloadJson))
                .andExpect(status().isCreated());
    }

    @Test
    public void getSizeWithExistingProperty() throws Exception {
        Property property = TestUtilGenerator.getProperty();
        String name = property.getName();
        Mockito.when(propertyDAO.findByName(name)).thenReturn(property);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/property/getTotalSize/{propertyName}", name))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Propiedad1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.size").value(57.25));

    }


    @Test
    public void getPriceWithExistingProperty() throws Exception {
        Property property = TestUtilGenerator.getProperty();
        String name = property.getName();
        District district = new District("Carrasco", 400.0);
        Mockito.when(propertyDAO.findByName(name)).thenReturn(property);
        Mockito.when(districtDAO.findByName(district.getName())).thenReturn(district);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/property/getPrice/{propertyName}", name))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Propiedad1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(22900.0));

    }

    @Test
    public void getBiggerEnvironmentsWithExistingProperty() throws Exception {
        Property property = TestUtilGenerator.getProperty();
        String name = property.getName();
        Mockito.when(propertyDAO.findByName(name)).thenReturn(property);

        Environment env2 = new Environment("Cuarto2", 3.5, 9.5);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/property/getBiggerEnvironment/{propertyName}", name))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Propiedad1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.biggerEnvironment").value(env2));
    }


    @Test
    public void getEnvironmentsWithExistingProperty() throws Exception {
        Property property = TestUtilGenerator.getProperty();
        String name = property.getName();
        Mockito.when(propertyDAO.findByName(name)).thenReturn(property);
        List<SizeResponseDTO> environments = new ArrayList<>();
        environments.add(new SizeResponseDTO("Cuarto1", 24.00));
        environments.add(new SizeResponseDTO("Cuarto2", 33.25));

        this.mockMvc.perform(MockMvcRequestBuilders.get("/property/getEnviromentsSizes/{propertyName}", name))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Propiedad1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.environments[0].name").value("Cuarto1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.environments[0].size").value(24.0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.environments[1].name").value("Cuarto2"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.environments[1].size").value(33.25));
    }


}