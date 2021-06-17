package com.meli.calculatorHouseSquareMeters.integration.controller;

import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.calculatorHouseSquareMeters.model.dao.model.District;
import com.meli.calculatorHouseSquareMeters.model.dao.model.House;
import com.meli.calculatorHouseSquareMeters.model.dao.model.Room;
import com.meli.calculatorHouseSquareMeters.model.dao.repository.RepositoryDistrict;
import com.meli.calculatorHouseSquareMeters.model.dao.repository.RepositoryHouse;
import com.meli.calculatorHouseSquareMeters.model.dto.HouseRequestDTO;
import com.meli.calculatorHouseSquareMeters.model.mapper.HouseMapper;
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

import java.util.ArrayList;
import java.util.Arrays;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
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

    @Test
    public void createNewHouseBeansDTOValidationErrorWithEmpty() throws Exception {
        HouseRequestDTO payloadDTO = new HouseRequestDTO("casa1casa1casa1casa1casa1casa1casa1casa1casa1casa1",
                "barrio Bajo barrio Bajo barrio Bajo barrio Bajo barrio Bajo barrio Bajo barrio Bajo barrio Bajo",
                new ArrayList<Room>(Arrays.asList(new Room("habitación 1", -10 ,34))));

        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE, false).
                writer();

        String responseJson = "{\"houseName\":\"The 'houseName' attribute cannot exceed 30 characters\",\"districtName\":\"The 'districName' attribute cannot exceed 45 characters\",\"rooms[0].name\":\"The attribute 'name' must start in uppercase\",\"rooms[0].width\":\"The 'width' must be positive\",\"rooms[0].length\":\"The 'length' must be maximum 25\"}";
        String payloadJson = writer.writeValueAsString(payloadDTO);

       this.mockMvc.perform(MockMvcRequestBuilders.post("/createHouse")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andReturn();
    }

    @Test
    public void createNewDistrictCorrectly() throws Exception {

        District payloadDTO = new District("Barrio Nuevo", 1000);

        Mockito.when((repositoryDistrict.getDistrictByName("Barrio Nuevo"))).thenReturn(null);

        Mockito.when(repositoryDistrict.putDistrict(payloadDTO)).thenReturn(true);

        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE, false).
                writer().withDefaultPrettyPrinter();

        String payloadJson = writer.writeValueAsString(payloadDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/createDistrict")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isOk());

        Mockito.verify(repositoryDistrict, Mockito.atLeast(1))
                .putDistrict(payloadDTO);

    }

    @Test
    public void createNewDistrictBeansDTOValidationError() throws Exception {
        District payloadDTO = new District("barrio Nuevo", 4001);

        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE, false).
                writer();

        String responseJson = "{\"districtName\":\"The attribute 'districtName' must start in uppercase\",\"squareMeterPrice\":\"The 'squareMeterPrice' must be maximum 4000\"}";
        String payloadJson = writer.writeValueAsString(payloadDTO);

        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/createDistrict")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(responseJson, response.getResponse().getContentAsString());

    }

    @Test
    public void getTotalQuantityCorrectly() throws Exception {

        House house = new House("Casa1", new District("Barrio Bajo", 800),
                1,
                100,
                80000,
                new ArrayList<Room>(Arrays.asList(new Room("Habitación 1", 10, 10))));

        String responseJson = "{\"houseName\":\"Casa1\",\"totalPrice\":80000.0,\"totalSquareMeters\":100.0}";

        Mockito.when(repositoryHouse.getHouseByName("Casa1")).thenReturn(house);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/totalQuantity/{houseName}","Casa1"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string(responseJson))
                .andReturn();

    }

    @Test
    public void getTotalQuantityHouseNotFoundException() throws Exception {

        String responseJson = "{\"message\":\"The house with the name 'Casa1' was not found in the Database\",\"name\":\"HouseNotFoundException\"}";

        Mockito.when(repositoryHouse.getHouseByName("Casa1")).thenReturn(null);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/totalQuantity/{houseName}","Casa1"))
                .andDo(print()).andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string(responseJson))
                .andReturn();

    }

    @Test
    public void getBiggestRoomCorrectly() throws Exception {

        House house = new House("Casa1", new District("Barrio Bajo", 800),
                1,
                100,
                80000,
                new ArrayList<Room>(Arrays.asList(new Room("Habitacion 1", 10, 10),
                        new Room("Habitacion 2", 9, 9),
                        new Room("Habitacion 3", 8, 8))));

        String responseJson = "{\"nameHouse\":\"Casa1\",\"nameRoom\":\"Habitacion 1\",\"totalSquareMeters\":100.0}";

        Mockito.when(repositoryHouse.getHouseByName("Casa1")).thenReturn(house);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/biggestRoom/{houseName}","Casa1"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string(responseJson))
                .andReturn();

    }

    @Test
    public void getBiggestRoomHouseNotFoundException() throws Exception {

        String responseJson = "{\"message\":\"The house with the name 'Casa1' was not found in the Database\",\"name\":\"HouseNotFoundException\"}";

        Mockito.when(repositoryHouse.getHouseByName("Casa1")).thenReturn(null);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/biggestRoom/{houseName}","Casa1"))
                .andDo(print()).andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string(responseJson))
                .andReturn();

    }

    @Test
    public void getRoomListCorrectly() throws Exception {

        House house = new House("Casa1", new District("Barrio Bajo", 800),
                1,
                100,
                80000,
                new ArrayList<Room>(Arrays.asList(new Room("Habitacion 1", 10, 10),
                        new Room("Habitacion 2", 9, 9),
                        new Room("Habitacion 3", 8, 8))));

        String responseJson = "{\"houseName\":\"Casa1\",\"rooms\":[{\"name\":\"Habitacion 1\",\"totalSquareMeters\":100.0},{\"name\":\"Habitacion 2\",\"totalSquareMeters\":81.0},{\"name\":\"Habitacion 3\",\"totalSquareMeters\":64.0}]}";

        Mockito.when(repositoryHouse.getHouseByName("Casa1")).thenReturn(house);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/list/{houseName}","Casa1"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string(responseJson))
                .andReturn();

    }

    @Test
    public void getRoomListHouseNotFoundException() throws Exception {

        String responseJson = "{\"message\":\"The house with the name 'Casa1' was not found in the Database\",\"name\":\"HouseNotFoundException\"}";

        Mockito.when(repositoryHouse.getHouseByName("Casa1")).thenReturn(null);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/list/{houseName}","Casa1"))
                .andDo(print()).andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string(responseJson))
                .andReturn();

    }

}
