package com.meli.calculatorHouseSquareMeters.integration.controller;

import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.calculatorHouseSquareMeters.model.dao.model.District;
import com.meli.calculatorHouseSquareMeters.model.dao.model.Room;
import com.meli.calculatorHouseSquareMeters.model.dao.repository.RepositoryDistrict;
import com.meli.calculatorHouseSquareMeters.model.dao.repository.RepositoryHouse;
import com.meli.calculatorHouseSquareMeters.model.dto.HouseRequestDTO;
import com.meli.calculatorHouseSquareMeters.model.mapper.HouseMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculatorHouseControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    RepositoryDistrict repositoryDistrict;

    @MockBean
    RepositoryHouse repositoryHouse;

    @Test
    public void createNewHouseCorrectly() throws Exception {

        HouseRequestDTO payloadDTO = new HouseRequestDTO("Casa1",
                "Barrio Bajo",
                new ArrayList<Room>(Arrays.asList(new Room("Habitación 1", 10 ,10),
                        new Room("Habitación 2", 9 ,9),
                        new Room("Habitación 3", 8 ,8))));

        District district = new District("Barrio Bajo", 800);

        Mockito.when(repositoryDistrict.getDistrictByName("Barrio Bajo"))
                .thenReturn(new District("Barrio Bajo", 800));

        Mockito.when((repositoryHouse.getHouseByName("Casa 1"))).thenReturn(null);

        Mockito.when(repositoryHouse.putHouse(HouseMapper.toHouseModel(payloadDTO, district))).thenReturn(true);

        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE, false).
                writer().withDefaultPrettyPrinter();

        String payloadJson = writer.writeValueAsString(payloadDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/createHouse")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isOk());

        Mockito.verify(repositoryHouse, Mockito.atLeast(1))
                .putHouse(HouseMapper.toHouseModel(payloadDTO, district));
    }

}
