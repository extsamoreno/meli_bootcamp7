package com.tuCasita.tuCasita.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.tuCasita.tuCasita.models.DTO.HouseDTO;
import com.tuCasita.tuCasita.models.DTO.ResponseRoomsDTO;
import com.tuCasita.tuCasita.models.DTO.RoomDTO;
import com.tuCasita.tuCasita.models.District;
import com.tuCasita.tuCasita.models.House;
import com.tuCasita.tuCasita.models.Room;
import com.tuCasita.tuCasita.repository.iDistrictRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
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

import java.util.ArrayList;
import java.util.HashMap;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TestTuCasitaIntegration {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private iDistrictRepository repository;

    House house;
    District district;

    @BeforeEach
    void initHouse(){
        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(new Room("Living", 10D, 5D));
        rooms.add(new Room("Comedor", 6D, 4D));
        rooms.add(new Room("Habitacion", 15D, 9D));
        district = new District("Flores", 250D);
        house = new House("Monoambiente en Flores", district, rooms);
    }


    @Test
    public void calculateTotalM2OK() throws Exception {
        //arrange
        HouseDTO houseDTO = new HouseDTO("Monoambiente en Flores", 209d);
        Mockito.when(repository.getDistricts()).thenReturn(new HashMap<>() {{put(district.getName(), district.getPrice());}});
        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();
        String payloadJson = writer.writeValueAsString(house);

        //act
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/tuCasita/totalM2").contentType(MediaType.APPLICATION_JSON).content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(houseDTO.getName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(houseDTO.getResult()))
                .andReturn();
    }

    @Test
    public void calculateHouseValueOK() throws Exception {
        //arrange
        HouseDTO houseDTO = new HouseDTO("Monoambiente en Flores", 52250d);
        Mockito.when(repository.getDistricts()).thenReturn(new HashMap<>() {{put(district.getName(), district.getPrice());}});
        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();
        String payloadJson = writer.writeValueAsString(house);

        //act
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/tuCasita/houseValue").contentType(MediaType.APPLICATION_JSON).content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(houseDTO.getName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(houseDTO.getResult()))
                .andReturn();
    }

    @Test
    public void biggestRoomOK() throws Exception {
        //arrange
        Room room = new Room("Habitacion", 15D, 9D);
        Mockito.when(repository.getDistricts()).thenReturn(new HashMap<>() {{put(district.getName(), district.getPrice());}});
        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();
        String payloadJson = writer.writeValueAsString(house);

        //act
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/tuCasita/biggestRoom").contentType(MediaType.APPLICATION_JSON).content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(room.getName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.width").value(room.getWidth()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.length").value(room.getLength()))
                .andReturn();
    }

    @Test
    public void calcularM2HabitacionOK() throws Exception {
        //arrange
        ArrayList<RoomDTO> resultList = new ArrayList<>();
        resultList.add(new RoomDTO("Living", 50d));
        resultList.add(new RoomDTO("Comedor", 24d));
        resultList.add(new RoomDTO("Habitacion", 135d));

        ResponseRoomsDTO response = new ResponseRoomsDTO("Monoambiente en Flores", resultList);
        Mockito.when(repository.getDistricts()).thenReturn(new HashMap<>() {{put(district.getName(), district.getPrice());}});
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();
        String payloadJson = writer.writeValueAsString(house);

        //act
        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders
                .post("/tuCasita/roomM2").contentType(MediaType.APPLICATION_JSON).content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.houseName").value(response.getHouseName()))
                .andReturn();

        //assert
        ResponseRoomsDTO response2 = mapper.readValue(result.getResponse().getContentAsString(), ResponseRoomsDTO.class);
        Assertions.assertEquals(response, response2);
    }


}
