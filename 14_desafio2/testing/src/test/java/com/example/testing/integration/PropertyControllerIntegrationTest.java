package com.example.testing.integration;

import com.example.testing.dto.EnvironmentDTO;
import com.example.testing.model.District;
import com.example.testing.model.Environment;
import com.example.testing.model.Property;
import com.example.testing.repositories.PropertiesRepository;
import com.example.testing.services.PropertiesService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
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

import java.util.ArrayList;
import java.util.Arrays;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PropertyControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    PropertiesRepository propertiesRepository;

    static Property property;

    static ArrayList<EnvironmentDTO> environmentDTOS = new ArrayList<>();

    static Environment environment;

    @BeforeAll
    public static void setUp(){
        property = new Property(1,
                "House1",
                new District("District1", 1000.0),
                new ArrayList<Environment>(Arrays.asList(
                        new Environment("Bathroom", 4.0, 4.0),
                        new Environment("Kitchen", 6.0, 6.0),
                        new Environment("Bedroom", 5.0, 5.0),
                        new Environment("LivingRoom", 8.0, 8.0))));
        environment = new Environment("LivingRoom", 8.0, 8.0);

        environmentDTOS.add(new EnvironmentDTO("Bathroom", 16.0));
        environmentDTOS.add(new EnvironmentDTO("Kitchen", 36.0));
        environmentDTOS.add(new EnvironmentDTO("Bedroom", 25.0));
        environmentDTOS.add(new EnvironmentDTO("LivingRoom", 64.0));
    }

    @Test
    public void getSquareMetersIdHappyPath() throws Exception{

        Mockito.when(propertiesRepository.getPropertyById(property.getId())).thenReturn(property);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/totalSquareMeters/{id}", property.getId()))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(141.0, Double.parseDouble(mvcResult.getResponse().getContentAsString()));

    }

    @Test
    public void getPriceHappyPath() throws Exception{

        Mockito.when(propertiesRepository.getPropertyById(property.getId())).thenReturn(property);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/price/{id}", property.getId()))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(141000.0, Double.parseDouble(mvcResult.getResponse().getContentAsString()));
    }

    @Test
    public void getEnvironmentSquareMetersHappyPath() throws Exception{

        Mockito.when(propertiesRepository.getPropertyById(property.getId())).thenReturn(property);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payLoadJson = writer.writeValueAsString(environmentDTOS);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/environmentsSquareMeters/{id}", property.getId()))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(payLoadJson, mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void registerStudentHappyPath() throws Exception{

        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE, false).
                writer().withDefaultPrettyPrinter();
        String payloadJson = writer.writeValueAsString(property);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/createProperty")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isOk());

    }
}
