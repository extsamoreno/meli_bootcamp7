package com.meli.desafio.integration;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.desafio.exceptions.dto.ErrorDTO;
import com.meli.desafio.exceptions.models.HouseAlreadyExistsException;
import com.meli.desafio.exceptions.models.HouseNotFoundException;
import com.meli.desafio.models.dto.HouseDTO;
import com.meli.desafio.repositories.ICalculateRepository;
import com.meli.desafio.utils.TestUtils;
import com.meli.desafio.utils.URLBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculateControllerIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ICalculateRepository calculateRepository;

    private final ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

    @Test
    public void addHouseHappyPath() throws Exception {
        HouseDTO houseDTO = TestUtils.getTotalHouse("House1");
        Integer houseId = 1;

        String payloadJson = writer.writeValueAsString(houseDTO);
        when(calculateRepository.save(houseDTO)).thenReturn(houseId);

        String stringResponse = URLBuilder.buildURL("calculate/getHouse", houseId, "");

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(content().string(stringResponse))
                .andReturn();

        verify(calculateRepository, atMost(1)).save(houseDTO);
    }

    @Test
    public void addHouseShouldThrowHouseAlreadyExistsException() throws Exception {
        HouseDTO houseDTO = TestUtils.getTotalHouse("House1");

        HouseAlreadyExistsException error = new HouseAlreadyExistsException(houseDTO.getName());

        String payloadJson = writer.writeValueAsString(houseDTO);
        when(calculateRepository.save(houseDTO)).thenThrow(error);

        String errorDTO = writer.writeValueAsString(error.getError());

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string(errorDTO))
                .andReturn();

        verify(calculateRepository, atMost(1)).save(houseDTO);
    }

    @Test
    public void getHouseHappyPath() throws Exception{
        Integer houseId = 1;
        HouseDTO houseDto = TestUtils.getTotalHouse("House1");

        when(calculateRepository.getById(houseId)).thenReturn(houseDto);

        String houseDtoString = writer.writeValueAsString(houseDto);

        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/calculate/house/{id}", houseId))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string(houseDtoString))
                .andReturn();
    }

    @Test
    public void getHouseShouldThrowHouseNotFoundException() throws Exception{
        Integer houseId = 1;

        HouseNotFoundException exception = new HouseNotFoundException(houseId);

        when(calculateRepository.getById(houseId)).thenThrow(exception);

        String error = writer.writeValueAsString(exception.getError());

        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/calculate/house/{id}", houseId))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string(error))
                .andReturn();
    }

    @Test
    public void getHouseTotalMetersHappyPath() throws Exception{
        Integer houseId = 1;
        HouseDTO houseDTO = TestUtils.getTotalHouse("House1");

        when(calculateRepository.getById(houseId)).thenReturn(houseDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/calculate/house/{id}/totalMeters", houseId))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(content().string("865.0m2"))
                .andReturn();
    }

    @Test
    public void getHouseTotalMetersShouldThrowHouseNotFoundException() throws Exception{
        Integer houseId = 1;

        HouseNotFoundException exception = new HouseNotFoundException(houseId);

        when(calculateRepository.getById(houseId)).thenThrow(exception);

        String error = writer.writeValueAsString(exception.getError());

        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/calculate/house/{id}/totalMeters", houseId))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string(error))
                .andReturn();
    }
}
