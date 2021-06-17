package com.example.tucasita.integration;

import com.example.tucasita.domain.District;
import com.example.tucasita.dto.DistrictDTO;
import com.example.tucasita.dto.HouseDTO;
import com.example.tucasita.dto.response.*;
import com.example.tucasita.repository.IDistrictRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
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

import java.util.Arrays;
import java.util.Optional;

import static com.example.tucasita.TestUtil.getSampleHouseDTO;
import static com.example.tucasita.UtilMapper.fromJson;
import static com.example.tucasita.UtilMapper.toJson;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.lenient;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TuCasitaControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    IDistrictRepository districtRepository;

    HouseDTO houseDTO;
    HouseDTO houseDTONonExistingDistrict;
    HouseDTO houseDTONotSamePriceDistrict;


    @BeforeEach
    private void init() throws JsonProcessingException {
        houseDTO = getSampleHouseDTO();

        houseDTONonExistingDistrict = getSampleHouseDTO();
        houseDTONonExistingDistrict.setDistrict(new DistrictDTO("Non Exists", 100D));

        houseDTONotSamePriceDistrict = getSampleHouseDTO();
        houseDTONotSamePriceDistrict.setDistrict(new DistrictDTO("Barrio", 3000D));

        Optional<District> optionalDistrict = Optional.of(new District("Barrio", 100D));
        Optional<District> optionalNull = Optional.ofNullable(null);

        lenient().when(districtRepository.findByName("Barrio")).thenReturn(optionalDistrict);
        lenient().when(districtRepository.findByName("Non Exists")).thenReturn(optionalNull);
    }

    /**
     * HAPPY PATHS
     */
    @Test
    public void calculateTotalMetersHappyPath() throws Exception {

        String payloadJson = toJson(houseDTO);
        HouseWithTotalMeters expected = new HouseWithTotalMeters("Casa", 80);

        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/house/total-square-meters")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isOk()).andReturn();

        String expectedJson = response.getResponse().getContentAsString();
        HouseWithTotalMeters received = fromJson(expectedJson, HouseWithTotalMeters.class);

        assertEquals(expected, received);
    }

    @Test
    public void calculateTotalValueHappyPath() throws Exception {
        String payloadJson = toJson(houseDTO);
        HouseWithTotalValue expected = new HouseWithTotalValue("Casa", 8000);

        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/house/total-value")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isOk()).andReturn();

        String expectedJson = response.getResponse().getContentAsString();
        HouseWithTotalValue received = fromJson(expectedJson, HouseWithTotalValue.class);

        assertEquals(expected, received);
    }

    @Test
    public void calculateLargestRoomHappyPath() throws Exception {
        String payloadJson = toJson(houseDTO);
        RoomWithMetersDTO largest = new RoomWithMetersDTO("Room2", 60);
        HouseWithLargestRoom expected = new HouseWithLargestRoom("Casa", largest);

        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/house/largest-room")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isOk()).andReturn();

        String expectedJson = response.getResponse().getContentAsString();
        HouseWithLargestRoom received = fromJson(expectedJson, HouseWithLargestRoom.class);

        assertEquals(expected, received);
    }

    @Test
    public void calculateRoomsSquareMetersHappyPath() throws Exception {
        String payloadJson = toJson(houseDTO);

        RoomWithMetersDTO room1 = new RoomWithMetersDTO("Room1", 20);
        RoomWithMetersDTO room2 = new RoomWithMetersDTO("Room2", 60);
        HouseWithRoomsMetersDTO expected = new HouseWithRoomsMetersDTO("Casa", Arrays.asList(room1, room2));


        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/house/rooms-square-meters")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isOk()).andReturn();

        String expectedJson = response.getResponse().getContentAsString();
        HouseWithRoomsMetersDTO received = fromJson(expectedJson, HouseWithRoomsMetersDTO.class);

        assertEquals(expected, received);
    }


}
