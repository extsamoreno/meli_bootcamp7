package com.meli.desafio.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.desafio.exceptions.dto.ErrorDTO;
import com.meli.desafio.models.dto.DistrictDTO;
import com.meli.desafio.models.dto.HouseDTO;
import com.meli.desafio.models.Room;
import com.meli.desafio.repositories.ICalculateRepository;
import com.meli.desafio.utils.TestUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class HouseDistrictDTOValidations {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ICalculateRepository calculateRepository;

    private final ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

    @Test
    public void addHouseShouldThrowExceptioinWhenHouseHaveMore30Characters() throws Exception {
        HouseDTO houseDTO = TestUtils.getTotalHouse("A".repeat(31));
        ErrorDTO error = TestUtils.getValidationError("The name of the house cannot contain more than 30 characters");
        callForValidationErrorAddHouse(houseDTO, error);
    }

    @Test
    public void addHouseShouldThrowExceptioinWhenHouseNotHaveName() throws Exception {
        HouseDTO houseDTO = TestUtils.getTotalHouse(null);
        ErrorDTO error = TestUtils.getValidationError("The house must have a name");
        callForValidationErrorAddHouse(houseDTO, error);
    }

    @Test
    public void addHouseShouldThrowExceptionWhenHouseNameDoesntBeingWithCapitalLetter() throws Exception {
        HouseDTO houseDTO = TestUtils.getTotalHouse("house");
        ErrorDTO error = TestUtils.getValidationError("The name of the house must begin with a capital letter");
        callForValidationErrorAddHouse(houseDTO, error);
    }

    @Test
    public void addHouseShouldThrowExceptionWhenHouseDontHaveDistrict() throws Exception {
        HouseDTO houseDTO = TestUtils.getTotalHouse("House");
        houseDTO.setDistrict(null);
        ErrorDTO error = TestUtils.getValidationError("The house must be have a district");
        callForValidationErrorAddHouse(houseDTO, error);
    }

    @Test
    public void addHouseShouldThrowExceptionWhenDistrictDontHaveName() throws Exception {
        HouseDTO houseDTO = TestUtils.getTotalHouse("House");
        houseDTO.setDistrict(DistrictDTO.builder().name(null).price(100).build());
        ErrorDTO error = TestUtils.getValidationError("The district must have a name");
        callForValidationErrorAddHouse(houseDTO, error);
    }

    @Test
    public void addHouseShouldThrowExceptionWhenDistrictHaveMore45Characters() throws Exception {
        HouseDTO houseDTO = TestUtils.getTotalHouse("House");
        houseDTO.setDistrict(DistrictDTO.builder().name("A".repeat(46)).price(100).build());
        ErrorDTO error = TestUtils.getValidationError("The name of the district cannot contain more than 45 characters");
        callForValidationErrorAddHouse(houseDTO, error);
    }

    @Test
    public void addHouseShouldThrowExceptionWhenDistrictHavePriceHigherThan4000() throws Exception {
        HouseDTO houseDTO = TestUtils.getTotalHouse("House");
        houseDTO.setDistrict(DistrictDTO.builder().name("District").price(4001).build());
        ErrorDTO error = TestUtils.getValidationError("The price cant be higher of 4000");
        callForValidationErrorAddHouse(houseDTO, error);
    }

    @Test
    public void addHouseShouldThrowExceptionWhenDistrictHavePriceEqualsZero() throws Exception {
        HouseDTO houseDTO = TestUtils.getTotalHouse("House");
        houseDTO.setDistrict(DistrictDTO.builder().name("District").price(0).build());
        ErrorDTO error = TestUtils.getValidationError("The price cannot be less than or equal to 0");
        callForValidationErrorAddHouse(houseDTO, error);
    }

    @Test
    public void addHouseShouldThrowExceptionWhenDistrictHavePriceThanToZero() throws Exception {
        HouseDTO houseDTO = TestUtils.getTotalHouse("House");
        houseDTO.setDistrict(DistrictDTO.builder().name("District").price(-1).build());
        ErrorDTO error = TestUtils.getValidationError("The price cannot be less than or equal to 0");
        callForValidationErrorAddHouse(houseDTO, error);
    }

    @Test
    public void addHouseShouldThrowExceptionWhenRoomsLengthIsZero() throws Exception {
        HouseDTO houseDTO = TestUtils.getTotalHouse("House");
        houseDTO.setRooms(new ArrayList<>());
        ErrorDTO error = TestUtils.getValidationError("The house mut be have a room");
        callForValidationErrorAddHouse(houseDTO, error);
    }

    @Test
    public void addHouseShouldThrowExceptionWhenRoomNameDoesntBeingWithCapitalLetter() throws Exception {
        HouseDTO houseDTO = TestUtils.getTotalHouse("House");
        List<Room> rooms = new ArrayList<>();
        rooms.add(Room.builder().name("room").width(10.00).length(10.00).build());
        houseDTO.setRooms(rooms);
        ErrorDTO error = TestUtils.getValidationError("The name of the room must begin with a capital letter");
        callForValidationErrorAddHouse(houseDTO, error);
    }

    @Test
    public void addHouseShouldThrowExceptionWhenRoomNameHaveMoreThan30Characters() throws Exception {
        HouseDTO houseDTO = TestUtils.getTotalHouse("House");
        List<Room> rooms = new ArrayList<>();
        rooms.add(Room.builder().name("R".repeat(31)).width(10.00).length(10.00).build());
        houseDTO.setRooms(rooms);
        ErrorDTO error = TestUtils.getValidationError("The name of the room cannot contain more than 30 characters");
        callForValidationErrorAddHouse(houseDTO, error);
    }

    @Test
    public void addHouseShouldThrowExceptionWhenRoomWidthIsGreaterThan30() throws Exception {
        HouseDTO houseDTO = TestUtils.getTotalHouse("House");
        List<Room> rooms = new ArrayList<>();
        rooms.add(Room.builder().name("Room").width(35.00).length(10.00).build());
        houseDTO.setRooms(rooms);
        ErrorDTO error = TestUtils.getValidationError("The width of the room must be less than or equal to 25");
        callForValidationErrorAddHouse(houseDTO, error);
    }

    @Test
    public void addHouseShouldThrowExceptionWhenRoomLengthIsGreaterThan33() throws Exception {
        HouseDTO houseDTO = TestUtils.getTotalHouse("House");
        List<Room> rooms = new ArrayList<>();
        rooms.add(Room.builder().name("Room").width(10.00).length(35.00).build());
        houseDTO.setRooms(rooms);
        ErrorDTO error = TestUtils.getValidationError("The length of the room bust be lees than or equal to 33");
        callForValidationErrorAddHouse(houseDTO, error);
    }

    @Test
    public void addHouseShouldThrowExceptionWhenRoomNotHaveName() throws Exception {
        HouseDTO houseDTO = TestUtils.getTotalHouse("House");
        List<Room> rooms = new ArrayList<>();
        rooms.add(Room.builder().name(null).width(10.00).length(10.00).build());
        houseDTO.setRooms(rooms);
        ErrorDTO error = TestUtils.getValidationError("The house must have a name");
        callForValidationErrorAddHouse(houseDTO, error);
    }

    public void callForValidationErrorAddHouse(HouseDTO houseDTO, ErrorDTO errorDTO) throws Exception {
        when(calculateRepository.save(houseDTO)).thenReturn(1);

        String payloadJson = writer.writeValueAsString(houseDTO);

        String error = writer.writeValueAsString(errorDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string(error))
                .andReturn();

        verify(calculateRepository, atMost(0)).save(houseDTO);
    }
}
