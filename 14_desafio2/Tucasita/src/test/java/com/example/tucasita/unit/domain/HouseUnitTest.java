package com.example.tucasita.unit.domain;

import com.example.tucasita.TestUtil;
import com.example.tucasita.domain.District;
import com.example.tucasita.domain.House;
import com.example.tucasita.domain.Room;
import com.example.tucasita.exception.NotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HouseUnitTest {
    House house1;
    House house2;
    District district1;
    District district2;
    double lower;
    double higher;

    @BeforeEach
    private void init() {
        lower = 1;
        higher = 2;
        district1 = new District("Barrio1", 500);
        district2 = new District("Barrio2", 750);
        house1 = new House("Casa 1", district1, TestUtil.listOf3Rooms("room", lower, higher));
        house2 = new House("Casa 2", district2, new ArrayList<>());
    }

    @Test
    public void getTotalMetersHappyPath1() {
        double expected = lower * lower + lower * higher + higher * higher;
        double received = house1.getTotalMeters();
        assertEquals(expected, received);
    }

    @Test
    public void getTotalMetersEmptyRooms() {
        double expected = 0;
        double received = house2.getTotalMeters();
        assertEquals(expected, received);
    }

    @Test
    public void getTotalValueHappyPath1() {
        double area = lower * lower + lower * higher + higher * higher;
        double expected = district1.getPrice() * area;
        double received = house1.getTotalValue();
        assertEquals(expected, received);
    }

    @Test
    public void getTotalValueEmptyRooms() {
        double expected = 0;
        double received = house2.getTotalValue();
        assertEquals(expected, received);
    }

    @Test
    public void getLargestRoomHappyPath1() {
        double expectedArea = higher * higher;
        Room received = house1.getLargestRoom();
        assertEquals(expectedArea, received.squareMeters());
        assertEquals(house1.getRooms().get(2), received);
    }

    @Test
    public void getLargestRoomEmptyRooms() {
        assertThrows(NotFoundException.class, () -> house2.getLargestRoom());
    }

}
