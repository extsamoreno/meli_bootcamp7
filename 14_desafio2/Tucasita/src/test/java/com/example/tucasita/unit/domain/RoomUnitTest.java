package com.example.tucasita.unit.domain;

import com.example.tucasita.domain.Room;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoomUnitTest {
    Room room1;
    Room room2;

    @BeforeEach
    private void init() {
        room1 = new Room("Test Room", 2, 3.5);
        room2 = new Room("Test Room", 4, 3.5);
    }

    @Test
    public void calculateSquareMetersHappyPath1() {
        double expected = 7;
        double received = room1.squareMeters();
        assertEquals(expected, received);
    }

    @Test
    public void calculateSquareMetersHappyPath2() {
        double expected = 14;
        double received = room2.squareMeters();
        assertEquals(expected, received);
    }

}
