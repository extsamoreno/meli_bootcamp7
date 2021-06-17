package com.meli.calculatorHouseSquareMeters.unit.repository;

import com.meli.calculatorHouseSquareMeters.model.dao.model.District;
import com.meli.calculatorHouseSquareMeters.model.dao.model.House;
import com.meli.calculatorHouseSquareMeters.model.dao.model.Room;
import com.meli.calculatorHouseSquareMeters.model.dao.repository.RepositoryHouseImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class RepositoryHouseImplTest {

    private RepositoryHouseImpl repositoryHouse = new RepositoryHouseImpl();

    @BeforeEach
    public void resetDataBase() {
        repositoryHouse.resetDataBase();
    }

    @Test
    public void getHouseByNameCorrectly() {
        // Arrage
        House expected = new House("Casa1", new District("Barrio Bajo",
                800),
                1,
                100,
                80000, new ArrayList<Room>(Arrays.asList(new Room("Habitación 1", 10, 10))));

        // Act
        House received = repositoryHouse.getHouseByName("Casa1");

        // Assert
        Assertions.assertEquals(expected, received);
    }

    @Test
    public void getHouseByNameError() {
        // Act
        House received = repositoryHouse.getHouseByName("Casa No Encontrada");

        // Assert
        assertNull(received);
    }

    @Test
    public void putHouseCorrectly() {
        // Arrage
        House house = new House("Casa Nueva", new District("Barrio Bajo",
                800),
                1,
                100,
                80000, new ArrayList<Room>(Arrays.asList(new Room("Habitación 1", 10, 10))));

        // Act
        boolean received = repositoryHouse.putHouse(house);

        // Assert
        assertTrue(received);
    }

    @Test
    public void putHouseError() {
        // Arrage
        House house = new House("Casa1", new District("Barrio Bajo",
                800),
                1,
                100,
                80000, new ArrayList<Room>(Arrays.asList(new Room("Habitación 1", 10, 10))));

        // Act
        boolean received = repositoryHouse.putHouse(house);

        // Assert
        assertFalse(received);
    }
}
