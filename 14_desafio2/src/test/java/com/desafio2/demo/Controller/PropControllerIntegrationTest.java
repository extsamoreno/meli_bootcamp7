package com.desafio2.demo.Controller;

import com.desafio2.demo.Model.DTO.*;
import com.desafio2.demo.Model.District;
import com.desafio2.demo.Repository.IPropRepository;
import com.desafio2.demo.Util.Util;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PropControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IPropRepository iPropRepository;

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

        District district = new District("Villa Prado", 400.0);
        when(iPropRepository.getDistrictByName(any())).thenReturn(district);

        PropDTOTPrice response = new PropDTOTPrice("House1", 16800.0);
        String responseExpect =  writer.writeValueAsString(response);

        //act
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post("/TuCasita/totalPrice")
                .contentType(MediaType.APPLICATION_JSON).content(payLoadJson))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().json(responseExpect))
                .andReturn();

        //assert
        verify(iPropRepository, atLeastOnce()).getDistrictByName(any());
    }

    @Test
    void bigEnvironment() throws Exception {
        //arrange
        PropRequest propRequest = Util.getPropRequest();
        String payLoadJson = writer.writeValueAsString(propRequest);

        EnvironmentDTO response = new EnvironmentDTO("Habitation", 30.0);
        String responseExpect = writer.writeValueAsString(response);

        //act
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post("/TuCasita/bigEnvironment")
                .contentType(MediaType.APPLICATION_JSON).content(payLoadJson))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().json(responseExpect))
                .andReturn();
    }

    @Test
    void totalMetersByEnvironments() throws Exception {
        PropRequest propRequest = Util.getPropRequest();
        String payLoadJson = writer.writeValueAsString(propRequest);

        PropDTOTMeterByEnvironment response = new PropDTOTMeterByEnvironment("House1", List.of(new EnvironmentDTO("Kitchen", 12.0), new EnvironmentDTO("Habitation", 30.0)));
        String responseExpect = writer.writeValueAsString(response);

        //act
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post("/TuCasita/totalMetersByMeters")
                .contentType(MediaType.APPLICATION_JSON).content(payLoadJson))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().json(responseExpect))
                .andReturn();
    }
}