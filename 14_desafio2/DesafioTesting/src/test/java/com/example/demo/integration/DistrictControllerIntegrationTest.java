package com.example.demo.integration;

import com.example.demo.Utils.Utils;
import com.example.demo.dtos.DistrictDTO;
import com.example.demo.dtos.DistrictRequestDTO;
import com.example.demo.repositories.DistrictRepository;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class DistrictControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    DistrictRepository districtRepository;

    @Test
    public void addDistrictHappyPath() throws Exception {


        DistrictRequestDTO payloadDTO = Utils.getDistrictRequestDTO();

        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE, false).
                writer().withDefaultPrettyPrinter();

        Mockito.when(districtRepository.createDistrict(payloadDTO)).thenReturn(payloadDTO);
        String payloadJson = writer.writeValueAsString(payloadDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/districts/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isCreated())
                .andReturn();

    }

    @Test
    public void findDistrictByIdHappyPath() throws Exception {
        DistrictDTO districtDTO = Utils.getDistrictDTO();
        int id =1;
        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE, false).
                writer().withDefaultPrettyPrinter();

        String expectedStr = writer.writeValueAsString(districtDTO).replace(" ","").replace("\n","");

        Mockito.when(districtRepository.findDistrictById(id)).thenReturn(districtDTO);

        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.get("/districts/district/{distId}",1))
                .andDo(print()).andExpect(status().isOk())
                .andExpect( content().contentType( "application/json" ))
                .andExpect(MockMvcResultMatchers.jsonPath("$.district_name").value("District1"))
                .andReturn();

        String received = response.getResponse().getContentAsString();
        Assertions.assertEquals(expectedStr,received);

    }

}
