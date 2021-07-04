package com.example.CalculadoraMetrosCuadrados.controller;

import com.example.CalculadoraMetrosCuadrados.dto.HouseDTO;
import com.example.CalculadoraMetrosCuadrados.dto.HouseResponseTotalSquareFeetDTO;
import com.example.CalculadoraMetrosCuadrados.dto.RoomDTO;
import com.example.CalculadoraMetrosCuadrados.service.ICalculateService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CalculateRestControllerValidationsTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    /*
     * The following tests where made to make sure that each of the DTOs' validations
     * are functioning correctly. Each test should be also applied to
     * every endpoint, but for practical purposes we only applied them to
     * 'calculateTotalSquareFeet' endpoint.
     */

    @Test
    void testCalculateTotalSquareFeetNullHouse() throws Exception {
        // Arrange
        HouseDTO houseDTO = null;
        String requestHouseDTO = objectMapper.writeValueAsString(houseDTO);

        // Act & Assert
        this.mockMvc.perform(
                post("/calculateTotalSquareFeet")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestHouseDTO))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.name").value("HttpMessageNotReadableException"));
    }

    @Test
    void testCalculateTotalSquareFeetNullHouseName() throws Exception {
        // Arrange
        // Rooms initialize
        RoomDTO room1 = new RoomDTO("Habitacion", 3, 2);
        RoomDTO room2 = new RoomDTO("Cocina", 2, 4);
        RoomDTO room3 = new RoomDTO("Baño", 2, 2);

        // RoomList initialize
        List<RoomDTO> rooms = new ArrayList<>();
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);

        // House initialize
        HouseDTO inputHouse = new HouseDTO(null, rooms, "Belgrano", 1000.0);

        String requestHouseDTO = objectMapper.writeValueAsString(inputHouse);

        this.mockMvc.perform(
                post("/calculateTotalSquareFeet")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestHouseDTO))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.name").value("MethodArgumentNotValidException"))
                .andExpect(jsonPath("$.description").value("El nombre de la propiedad no puede estar vacío."));
    }

    @Test
    void testCalculateTotalSquareFeetHouseNameFirstLetterLowerCase() throws Exception {
        // Arrange
        // Rooms initialize
        RoomDTO room1 = new RoomDTO("Habitacion", 3, 2);
        RoomDTO room2 = new RoomDTO("Cocina", 2, 4);
        RoomDTO room3 = new RoomDTO("Baño", 2, 2);

        // RoomList initialize
        List<RoomDTO> rooms = new ArrayList<>();
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);

        // House initialize
        HouseDTO inputHouse = new HouseDTO("alpaca", rooms, "Belgrano", 1000.0);

        String requestHouseDTO = objectMapper.writeValueAsString(inputHouse);

        this.mockMvc.perform(
                post("/calculateTotalSquareFeet")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestHouseDTO))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.name").value("MethodArgumentNotValidException"))
                .andExpect(jsonPath("$.description").value("El nombre de la propiedad debe comenzar con mayúscula."));
    }

    @Test
    void testCalculateTotalSquareFeetHouseNameExceedsMax() throws Exception {
        // Arrange
        // Rooms initialize
        RoomDTO room1 = new RoomDTO("Habitacion", 3, 2);
        RoomDTO room2 = new RoomDTO("Cocina", 2, 4);
        RoomDTO room3 = new RoomDTO("Baño", 2, 2);

        // RoomList initialize
        List<RoomDTO> rooms = new ArrayList<>();
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);

        // House initialize
        HouseDTO inputHouse = new HouseDTO("Alpacaaaaaaaaaaaaaaaaaaaaaaaaaaaa", rooms, "Belgrano", 1000.0);

        String requestHouseDTO = objectMapper.writeValueAsString(inputHouse);

        this.mockMvc.perform(
                post("/calculateTotalSquareFeet")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestHouseDTO))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.name").value("MethodArgumentNotValidException"))
                .andExpect(jsonPath("$.description").value("La longitud del nombre no puede superar los 30 caracteres."));
    }

    @Test
    void testCalculateTotalSquareFeetBlankDistrictName() throws Exception {
        // Arrange
        // Rooms initialize
        RoomDTO room1 = new RoomDTO("Habitacion", 3, 2);
        RoomDTO room2 = new RoomDTO("Cocina", 2, 4);
        RoomDTO room3 = new RoomDTO("Baño", 2, 2);

        // RoomList initialize
        List<RoomDTO> rooms = new ArrayList<>();
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);

        // House initialize
        HouseDTO inputHouse = new HouseDTO("Alpaca",
                                            rooms,
                                            "",
                                            1000.0);

        String requestHouseDTO = objectMapper.writeValueAsString(inputHouse);

        this.mockMvc.perform(
                post("/calculateTotalSquareFeet")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestHouseDTO))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.name").value("MethodArgumentNotValidException"))
                .andExpect(jsonPath("$.description").value("El barrio no puede estar vacio."));
    }

    @Test
    void testCalculateTotalSquareFeetDistrictNameExceedsMax() throws Exception {
        // Arrange
        // Rooms initialize
        RoomDTO room1 = new RoomDTO("Habitacion", 3, 2);
        RoomDTO room2 = new RoomDTO("Cocina", 2, 4);
        RoomDTO room3 = new RoomDTO("Baño", 2, 2);

        // RoomList initialize
        List<RoomDTO> rooms = new ArrayList<>();
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);

        // House initialize
        HouseDTO inputHouse = new HouseDTO("Alpaca",
                                            rooms,
                                            "Belgranooooooooooooooooooooooooooooooooooooooo",
                                            1000.0);

        String requestHouseDTO = objectMapper.writeValueAsString(inputHouse);

        this.mockMvc.perform(
                post("/calculateTotalSquareFeet")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestHouseDTO))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.name").value("MethodArgumentNotValidException"))
                .andExpect(jsonPath("$.description").value("La longitud del barrio no puede superar los 45 caracteres."));
    }

    @Test
    void testCalculateTotalSquareFeetNullDistrictPrice() throws Exception {
        // Arrange
        // Rooms initialize
        RoomDTO room1 = new RoomDTO("Habitacion", 3, 2);
        RoomDTO room2 = new RoomDTO("Cocina", 2, 4);
        RoomDTO room3 = new RoomDTO("Baño", 2, 2);

        // RoomList initialize
        List<RoomDTO> rooms = new ArrayList<>();
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);

        // House initialize
        HouseDTO inputHouse = new HouseDTO("Alpaca",
                rooms,
                "Belgrano",
                null);

        String requestHouseDTO = objectMapper.writeValueAsString(inputHouse);

        this.mockMvc.perform(
                post("/calculateTotalSquareFeet")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestHouseDTO))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.name").value("MethodArgumentNotValidException"))
                .andExpect(jsonPath("$.description").value("El precio de un barrio no puede estar vacio."));
    }

    @Test
    void testCalculateTotalSquareFeetDistrictPriceExceedsMax() throws Exception {
        // Arrange
        // Rooms initialize
        RoomDTO room1 = new RoomDTO("Habitacion", 3, 2);
        RoomDTO room2 = new RoomDTO("Cocina", 2, 4);
        RoomDTO room3 = new RoomDTO("Baño", 2, 2);

        // RoomList initialize
        List<RoomDTO> rooms = new ArrayList<>();
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);

        // House initialize
        HouseDTO inputHouse = new HouseDTO("Alpaca",
                rooms,
                "Belgrano",
                4001.0);

        String requestHouseDTO = objectMapper.writeValueAsString(inputHouse);

        this.mockMvc.perform(
                post("/calculateTotalSquareFeet")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestHouseDTO))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.name").value("MethodArgumentNotValidException"))
                .andExpect(jsonPath("$.description").value("El precio maximo permitido por metro cuadrado no puede superar los 4000 U$S."));
    }

    @Test
    void testCalculateTotalSquareFeetBlankRoomName() throws Exception {
        // Arrange
        // Rooms initialize
        RoomDTO room1 = new RoomDTO("", 3, 2);
        RoomDTO room2 = new RoomDTO("Cocina", 2, 4);
        RoomDTO room3 = new RoomDTO("Baño", 2, 2);

        // RoomList initialize
        List<RoomDTO> rooms = new ArrayList<>();
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);

        // House initialize
        HouseDTO inputHouse = new HouseDTO("Alpaca",
                rooms,
                "Belgrano",
                4000.0);

        String requestHouseDTO = objectMapper.writeValueAsString(inputHouse);

        this.mockMvc.perform(
                post("/calculateTotalSquareFeet")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestHouseDTO))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.name").value("MethodArgumentNotValidException"))
                .andExpect(jsonPath("$.description").value("El nombre del ambiente no puede estar vacío."));
    }

    @Test
    void testCalculateTotalSquareFeetRoomNameFirstLetterLowerCase() throws Exception {
        // Arrange
        // Rooms initialize
        RoomDTO room1 = new RoomDTO("habitacion", 3, 2);
        RoomDTO room2 = new RoomDTO("Cocina", 2, 4);
        RoomDTO room3 = new RoomDTO("Baño", 2, 2);

        // RoomList initialize
        List<RoomDTO> rooms = new ArrayList<>();
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);

        // House initialize
        HouseDTO inputHouse = new HouseDTO("Alpaca",
                rooms,
                "Belgrano",
                4000.0);

        String requestHouseDTO = objectMapper.writeValueAsString(inputHouse);

        this.mockMvc.perform(
                post("/calculateTotalSquareFeet")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestHouseDTO))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.name").value("MethodArgumentNotValidException"))
                .andExpect(jsonPath("$.description").value("El nombre del ambiente debe comenzar con mayúscula."));
    }

    @Test
    void testCalculateTotalSquareFeetRoomNameExceedsMax() throws Exception {
        // Arrange
        // Rooms initialize
        RoomDTO room1 = new RoomDTO("Habitacioooooooooooooooooooooooon", 3, 2);
        RoomDTO room2 = new RoomDTO("Cocina", 2, 4);
        RoomDTO room3 = new RoomDTO("Baño", 2, 2);

        // RoomList initialize
        List<RoomDTO> rooms = new ArrayList<>();
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);

        // House initialize
        HouseDTO inputHouse = new HouseDTO("Alpaca",
                rooms,
                "Belgrano",
                4000.0);

        String requestHouseDTO = objectMapper.writeValueAsString(inputHouse);

        this.mockMvc.perform(
                post("/calculateTotalSquareFeet")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestHouseDTO))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.name").value("MethodArgumentNotValidException"))
                .andExpect(jsonPath("$.description").value("La longitud del nombre no puede superar los 30 caracteres."));
    }

    @Test
    void testCalculateTotalSquareFeetNullRoomWidth() throws Exception {
        // Arrange
        // Rooms initialize
        RoomDTO room1 = new RoomDTO("Habitacion", null, 2);
        RoomDTO room2 = new RoomDTO("Cocina", 2, 4);
        RoomDTO room3 = new RoomDTO("Baño", 2, 2);

        // RoomList initialize
        List<RoomDTO> rooms = new ArrayList<>();
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);

        // House initialize
        HouseDTO inputHouse = new HouseDTO("Alpaca",
                rooms,
                "Belgrano",
                4000.0);

        String requestHouseDTO = objectMapper.writeValueAsString(inputHouse);

        this.mockMvc.perform(
                post("/calculateTotalSquareFeet")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestHouseDTO))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.name").value("MethodArgumentNotValidException"))
                .andExpect(jsonPath("$.description").value("El ancho del ambiente no puede estar vacío."));
    }

    @Test
    void testCalculateTotalSquareFeetRoomWidthExceedsMax() throws Exception {
        // Arrange
        // Rooms initialize
        RoomDTO room1 = new RoomDTO("Habitacion", 26, 2);
        RoomDTO room2 = new RoomDTO("Cocina", 2, 4);
        RoomDTO room3 = new RoomDTO("Baño", 2, 2);

        // RoomList initialize
        List<RoomDTO> rooms = new ArrayList<>();
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);

        // House initialize
        HouseDTO inputHouse = new HouseDTO("Alpaca",
                rooms,
                "Belgrano",
                4000.0);

        String requestHouseDTO = objectMapper.writeValueAsString(inputHouse);

        this.mockMvc.perform(
                post("/calculateTotalSquareFeet")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestHouseDTO))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.name").value("MethodArgumentNotValidException"))
                .andExpect(jsonPath("$.description").value("El máximo ancho permitido por propiedad es de 25 mts."));
    }

    @Test
    void testCalculateTotalSquareFeetNullRoomLength() throws Exception {
        // Arrange
        // Rooms initialize
        RoomDTO room1 = new RoomDTO("Habitacion", 3, null);
        RoomDTO room2 = new RoomDTO("Cocina", 2, 4);
        RoomDTO room3 = new RoomDTO("Baño", 2, 2);

        // RoomList initialize
        List<RoomDTO> rooms = new ArrayList<>();
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);

        // House initialize
        HouseDTO inputHouse = new HouseDTO("Alpaca",
                rooms,
                "Belgrano",
                4000.0);

        String requestHouseDTO = objectMapper.writeValueAsString(inputHouse);

        this.mockMvc.perform(
                post("/calculateTotalSquareFeet")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestHouseDTO))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.name").value("MethodArgumentNotValidException"))
                .andExpect(jsonPath("$.description").value("El largo del ambiente no puede estar vacío."));
    }

    @Test
    void testCalculateTotalSquareFeetRoomLengthExceedsMax() throws Exception {
        // Arrange
        // Rooms initialize
        RoomDTO room1 = new RoomDTO("Habitacion", 3, 34);
        RoomDTO room2 = new RoomDTO("Cocina", 2, 4);
        RoomDTO room3 = new RoomDTO("Baño", 2, 2);

        // RoomList initialize
        List<RoomDTO> rooms = new ArrayList<>();
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);

        // House initialize
        HouseDTO inputHouse = new HouseDTO("Alpaca",
                rooms,
                "Belgrano",
                4000.0);

        String requestHouseDTO = objectMapper.writeValueAsString(inputHouse);

        this.mockMvc.perform(
                post("/calculateTotalSquareFeet")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestHouseDTO))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.name").value("MethodArgumentNotValidException"))
                .andExpect(jsonPath("$.description").value("El máximo largo permitido por propiedad es de 33 mts."));
    }
}