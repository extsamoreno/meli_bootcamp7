package com.example.desafio2.integration;

import com.example.desafio2.dtos.DistrictDTO;
import com.example.desafio2.dtos.PropertyDTO;
import com.example.desafio2.models.District;
import com.example.desafio2.repositories.IDistrictRepository;
import com.example.desafio2.repositories.IPropertyRepository;
import com.example.desafio2.services.mappers.DistrictMapper;
import com.example.desafio2.services.mappers.PropertyMapper;
import com.example.desafio2.util.TestUtilsGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class DistrictIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    IPropertyRepository iPropertyRepository;

    @MockBean
    IDistrictRepository iDistrictRepository;

    @Test
    public void addHappyPath() throws Exception {
        //arrange
        int generatedId = 1;
        DistrictDTO dist = new DistrictDTO("district", 500);
        Mockito.when(iDistrictRepository.add(DistrictMapper.toModel(dist))).thenReturn(generatedId);

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

        String propJson = writer.writeValueAsString(dist);
        //act

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post("/districts/add")
                .contentType("application/json")
                .content(propJson))
                .andDo(print()).andExpect(status().isCreated())
                .andReturn();
    }
}
