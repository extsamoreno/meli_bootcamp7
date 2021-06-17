package com.desafrio2.Desafio1.Controller;

import com.desafrio2.Desafio1.Model.DTO.PropDTOTMeters;
import com.desafrio2.Desafio1.Model.DTO.PropRequest;
import com.desafrio2.Desafio1.Util.Util;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PropControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    ObjectWriter writer;

    @BeforeEach
    void setup(){
        this.writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_EXCEPTIONS, false).writer();
    }

    @Test
    void totalMeters() throws Exception {
        //arrange
        PropRequest propRequest = Util.getPropRequest();
        String payLoadJson = writer.writeValueAsString(propRequest);
        PropDTOTMeters response = new PropDTOTMeters("House1", 42.0);
        String responseExpect =  writer.writeValueAsString(response);
        //act
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post("/TuCasita/totalMeters")
                .contentType(MediaType.APPLICATION_JSON).content(payLoadJson))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().json(responseExpect))
                .andReturn();
    }

    @Test
    void totalPrice() throws Exception {
        //arrange
        PropRequest propRequest = Util.getPropRequest();
        String payLoadJson = writer.writeValueAsString(propRequest);
        PropDTOTMeters response = new PropDTOTMeters("House1", 42.0);
        String responseExpect =  writer.writeValueAsString(response);
        //act
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post("/TuCasita/totalMeters")
                .contentType(MediaType.APPLICATION_JSON).content(payLoadJson))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().json(responseExpect))
                .andReturn();
    }

    @Test
    void bigEnvironment() {
    }

    @Test
    void totalMetersByEnvironments() {
    }
}