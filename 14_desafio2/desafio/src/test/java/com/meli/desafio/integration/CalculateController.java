package com.meli.desafio.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.desafio.exceptions.dto.ErrorDTO;
import com.meli.desafio.models.District;
import com.meli.desafio.models.House;
import com.meli.desafio.repositories.ICalculateRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculateController {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ICalculateRepository calculateRepository;

    private final ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

    @Test
    public void addHouseShouldThrowExceptionWhenHouseNameIsBlank() throws Exception {
        House house = House.builder()
                .build();
        callForValidationErrorAddHouse(house, new ErrorDTO("MethodArgumentNotValidException", ""));
    }

    public void callForValidationErrorAddHouse(House house, ErrorDTO errorDTO) throws Exception {
        when(calculateRepository.save(house)).thenReturn(1);

        String payloadJson = writer.writeValueAsString(house);

        String error = writer.writeValueAsString(errorDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string(error))
                .andReturn();

        verify(calculateRepository, atMost(0)).save(house);
    }
}
