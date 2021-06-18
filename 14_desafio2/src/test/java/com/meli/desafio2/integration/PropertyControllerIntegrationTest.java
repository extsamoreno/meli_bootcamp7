package com.meli.desafio2.integration;

import com.meli.desafio2.exception.PropertyException;
import com.meli.desafio2.model.District;
import com.meli.desafio2.model.Property;
import com.meli.desafio2.model.dto.EnvironmentDTO;
import com.meli.desafio2.repository.DistrictRepository;
import com.meli.desafio2.repository.PropertyRepository;
import com.meli.desafio2.util.TestUtilGenerator;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PropertyControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    PropertyRepository propertyRepository;

    @MockBean
    DistrictRepository districtRepository;

    @Test
    public void registerPropertyHappyPath() throws Exception {
        Property prop = TestUtilGenerator.getProperty();
        String payLoad = TestUtilGenerator.toJson(prop);
        Mockito.when(districtRepository.findDistrictByID(1)).thenReturn(new District(1,"Jardin Aeropuerto", 300.5));

        this.mockMvc.perform(MockMvcRequestBuilders.post("/property/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payLoad))
                .andDo(print())
                .andExpect(status().isOk());

        Mockito.verify(districtRepository, Mockito.atLeastOnce()).findDistrictByID(1);
    }

    @Test
    public void registerPropertyNullPayload() throws Exception{

        this.mockMvc.perform(MockMvcRequestBuilders.post("/property/save"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void registerPropertyEmptyDistrict() throws Exception{
        Property prop = TestUtilGenerator.getProperty();
        prop.setDistrict(null);
        String payLoad = TestUtilGenerator.toJson(prop);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/property/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payLoad))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void calculateMts2HappyPath() throws Exception{
        Property prop = TestUtilGenerator.getProperty();
        Mockito.when(propertyRepository.getProperty()).thenReturn(prop);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/property/calculateMts2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.prop_name").value("Casa del Barba"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.prop_mts2").value("131.0"));

    }

    @Test
    public void calculateMts2WithoutProperty() throws Exception{
        Mockito.when(propertyRepository.getProperty()).thenThrow(new PropertyException("", HttpStatus.NOT_FOUND));
        String expectedDescription = "Property not found";

        this.mockMvc.perform(MockMvcRequestBuilders.get("/property/calculateMts2"))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value(expectedDescription));
    }

    @Test
    public void calculatePriceHappyPath() throws Exception{
        Property prop = TestUtilGenerator.getProperty();
        Mockito.when(propertyRepository.getProperty()).thenReturn(prop);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/property/calculatePrice"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.prop_name").value("Casa del Barba"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.prop_mts2").value(131.0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.prop_price").value(39365.5));

    }

    @Test
    public void calculatePriceWithoutProperty() throws Exception{
        Mockito.when(propertyRepository.getProperty()).thenThrow(new PropertyException("", HttpStatus.NOT_FOUND));
        String expectedDescription = "Property not found";

        this.mockMvc.perform(MockMvcRequestBuilders.get("/property/calculatePrice"))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value(expectedDescription));
    }

    @Test
    public void obtainMostGreaterEnvironment() throws Exception{
        Property prop = TestUtilGenerator.getProperty();
        Mockito.when(propertyRepository.getProperty()).thenReturn(prop);
        EnvironmentDTO env = new EnvironmentDTO("Cocina",56);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/property/obtainMostGreaterEnvironment"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.prop_name").value("Casa del Barba"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.prop_mts2").value(131.0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.prop_environment_most_great").value(env));

    }

    @Test
    public void obtainMostGreaterEnvironmentWithoutProperty() throws Exception{
        Mockito.when(propertyRepository.getProperty()).thenThrow(new PropertyException("", HttpStatus.NOT_FOUND));
        String expectedDescription = "Property not found";

        this.mockMvc.perform(MockMvcRequestBuilders.get("/property/obtainMostGreaterEnvironment"))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value(expectedDescription));
    }

    @Test
    public void calculateEnvironmentMts2() throws Exception{
        Property prop = TestUtilGenerator.getProperty();
        Mockito.when(propertyRepository.getProperty()).thenReturn(prop);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/property/calculateEnvironmentMts2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.prop_name").value("Casa del Barba"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.prop_mts2").value(131.0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.environmentList[0].environment_name").value(TestUtilGenerator.environmentDTOList().get(0).getEnvironment_name()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.environmentList[0].environment_mts2").value(TestUtilGenerator.environmentDTOList().get(0).getEnvironment_mts2()));
    }

    @Test
    public void calculateEnvironmentMts2WithoutProperty() throws Exception{
        Mockito.when(propertyRepository.getProperty()).thenThrow(new PropertyException("", HttpStatus.NOT_FOUND));
        String expectedDescription = "Property not found";

        this.mockMvc.perform(MockMvcRequestBuilders.get("/property/calculateEnvironmentMts2"))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value(expectedDescription));
    }



}
