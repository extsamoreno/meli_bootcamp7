package com.tucasitatasaciones.tucasitatasaciones.units;

import com.tucasitatasaciones.tucasitatasaciones.controllers.RoomController;
import com.tucasitatasaciones.tucasitatasaciones.exceptions.OwnershipNotFoundException;
import com.tucasitatasaciones.tucasitatasaciones.services.IRoomService;
import com.tucasitatasaciones.tucasitatasaciones.services.dtos.RoomWithSquareMeterDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class RoomControllerUTest {

    @Mock
    private IRoomService roomService;

    @InjectMocks
    private RoomController roomController;

    @Test
    public void getBiggestRoomByOwnershipOkWithDataTest() throws OwnershipNotFoundException {
        int expectedId = 1;
        List<RoomWithSquareMeterDTO> expected = Arrays.asList(
                new RoomWithSquareMeterDTO("Room 1", 2D, 3D, 6D),
                new RoomWithSquareMeterDTO("Room 2", 5D, 4D, 20D),
                new RoomWithSquareMeterDTO("Room 3", 3D, 7D, 21D)
        );

        Mockito.when(roomService.getRoomsByOwnership(expectedId)).thenReturn(expected);

        var received = roomController.getRoomsByOwnership(expectedId);

        Mockito.verify(roomService, Mockito.atLeastOnce()).getRoomsByOwnership(expectedId);
        Assertions.assertEquals(HttpStatus.OK, received.getStatusCode());
        Assertions.assertEquals(expected, received.getBody());
    }

    @Test
    public void getBiggestRoomByOwnershipOkWithoutDataTest() throws OwnershipNotFoundException {
        int expectedId = 1;
        List<RoomWithSquareMeterDTO> expected = new ArrayList<>();

        Mockito.when(roomService.getRoomsByOwnership(expectedId)).thenReturn(expected);

        var received = roomController.getRoomsByOwnership(expectedId);

        Mockito.verify(roomService, Mockito.atLeastOnce()).getRoomsByOwnership(expectedId);
        Assertions.assertEquals(HttpStatus.OK, received.getStatusCode());
        Assertions.assertEquals(0, received.getBody().size());
    }

    @Test
    public void getRoomsByOwnershipOkWithDataTest() throws OwnershipNotFoundException {
        int expectedId = 1;

        RoomWithSquareMeterDTO expected = new RoomWithSquareMeterDTO("Room 1", 2D, 3D, 6D);

        Mockito.when(roomService.getBiggestRoomByOwnership(expectedId)).thenReturn(expected);

        var received = roomController.getBiggestRoomByOwnership(expectedId);

        Mockito.verify(roomService, Mockito.atLeastOnce()).getBiggestRoomByOwnership(expectedId);
        Assertions.assertEquals(HttpStatus.OK, received.getStatusCode());
        Assertions.assertEquals(expected, received.getBody());
    }

    @Test
    public void getRoomsByOwnershipWithoutData() throws OwnershipNotFoundException {
        int expectedId = 1;

        Mockito.when(roomService.getBiggestRoomByOwnership(expectedId)).thenReturn(null);

        var received = roomController.getBiggestRoomByOwnership(expectedId);

        Mockito.verify(roomService, Mockito.atLeastOnce()).getBiggestRoomByOwnership(expectedId);
        Assertions.assertEquals(HttpStatus.OK, received.getStatusCode());
        Assertions.assertNull(received.getBody());
    }
}
