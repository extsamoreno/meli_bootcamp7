package com.example.CalculadoraMetrosCuadrados;

import com.example.CalculadoraMetrosCuadrados.dto.HouseDTO;
import com.example.CalculadoraMetrosCuadrados.dto.RoomDTO;
import lombok.Data;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Data
public class BaseTest {

    protected static HouseDTO payloadHouseDTO;

    /*
     * Method to create a HouseDTO object before all tests,
     * which will be used as input for each test.
     */
    @BeforeAll()
    public static void setUp(){
        // Rooms initialize
        RoomDTO room1 = new RoomDTO("Habitacion", 3, 2);
        RoomDTO room2 = new RoomDTO("Cocina", 2, 4);
        RoomDTO room3 = new RoomDTO("Banio", 2, 2);

        // RoomList initialize
        List<RoomDTO> rooms = new ArrayList<>();
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);

        // House initialize
        payloadHouseDTO = new HouseDTO("Alpaca", rooms, "Belgrano", 1000.0);
    }

    @AfterAll()
    public static void tearDown(){
        payloadHouseDTO = null;
    }
}
