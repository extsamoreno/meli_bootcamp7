package com.example.Challenge2.Integration;

import com.example.Challenge2.Models.District;
import com.example.Challenge2.Models.Property;
import com.example.Challenge2.Repositories.IDataRepository;
import com.example.Challenge2.Services.DTOs.*;
import com.example.Challenge2.Services.Mapper.DistrictMapper;
import com.example.Challenge2.Services.Mapper.PropertyMapper;
import com.example.Challenge2.Services.Mapper.RoomMapper;
import com.example.Challenge2.util.TestUtilsGenerator;
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
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class DistrictControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    IDataRepository iDataRepository;

    @Test
    public void storeHappyPath() throws Exception{

        DistrictDTO district = DistrictMapper.toDTO(TestUtilsGenerator.get100USDollarsDistrict(1L));

        Mockito.when(iDataRepository.getAllDistricts()).thenReturn(new ArrayList<>());


        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE, false).
                writer();
        String responseJson = writer.writeValueAsString(true);

        String payLoadJson = writer.writeValueAsString(district);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders
                .post("/districts")
                .contentType("application/json")
                .content(payLoadJson))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(responseJson, mvcResult.getResponse().getContentAsString());
    }
}