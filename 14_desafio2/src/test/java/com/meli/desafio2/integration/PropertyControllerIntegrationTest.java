package com.meli.desafio2.integration;

import com.meli.desafio2.model.District;
import com.meli.desafio2.model.Property;
import com.meli.desafio2.repository.DistrictRepository;
import com.meli.desafio2.repository.PropertyRepository;
import com.meli.desafio2.util.TestUtilGenerator;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
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
        String payLoad = TestUtilGenerator.toJson(new District());

        this.mockMvc.perform(MockMvcRequestBuilders.post("/property/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payLoad))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void calculateMts2HappyPath() throws Exception{

    }
}
