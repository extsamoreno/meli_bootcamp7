package com.tucasitatasaciones.tucasitatasaciones.units;

import com.tucasitatasaciones.tucasitatasaciones.controllers.RoomController;
import com.tucasitatasaciones.tucasitatasaciones.exceptions.OwnershipNotFoundException;
import com.tucasitatasaciones.tucasitatasaciones.services.IRoomService;
import com.tucasitatasaciones.tucasitatasaciones.services.dtos.RoomWithSquareMeterDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
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

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RoomControllerUTests {

    @Mock
    private IRoomService roomService;

    @InjectMocks
    private RoomController roomController;

    private int expectedId;
    private RoomWithSquareMeterDTO expectedRoomDTO;
    private List<RoomWithSquareMeterDTO> expectedRoomWithSquareMeterDTO;

    @BeforeEach
    public void InitData() {
        expectedId = 1;
        expectedRoomDTO = new RoomWithSquareMeterDTO("Room 1", 2D, 3D, 6D);
        expectedRoomWithSquareMeterDTO = Arrays.asList(
                expectedRoomDTO,
                new RoomWithSquareMeterDTO("Room 2", 5D, 4D, 20D),
                new RoomWithSquareMeterDTO("Room 3", 3D, 7D, 21D)
        );
    }

    @Test
    public void getBiggestRoomByOwnershipOkWithDataTest() throws OwnershipNotFoundException {
        when(roomService.getRoomsByOwnership(expectedId)).thenReturn(expectedRoomWithSquareMeterDTO);

        var received = roomController.getRoomsByOwnership(expectedId);

        verify(roomService, atLeastOnce()).getRoomsByOwnership(expectedId);
        Assertions.assertEquals(HttpStatus.OK, received.getStatusCode());
        Assertions.assertEquals(expectedRoomWithSquareMeterDTO, received.getBody());
    }

    @Test
    public void getBiggestRoomByOwnershipOkWithoutDataTest() throws OwnershipNotFoundException {
        List<RoomWithSquareMeterDTO> expected = new ArrayList<>();

        when(roomService.getRoomsByOwnership(expectedId)).thenReturn(expected);

        var received = roomController.getRoomsByOwnership(expectedId);

        verify(roomService, atLeastOnce()).getRoomsByOwnership(expectedId);
        Assertions.assertEquals(HttpStatus.OK, received.getStatusCode());
        Assertions.assertEquals(0, received.getBody().size());
    }

    @Test
    public void getRoomsByOwnershipOkWithDataTest() throws OwnershipNotFoundException {
        when(roomService.getBiggestRoomByOwnership(expectedId)).thenReturn(expectedRoomDTO);

        var received = roomController.getBiggestRoomByOwnership(expectedId);

        verify(roomService, atLeastOnce()).getBiggestRoomByOwnership(expectedId);
        Assertions.assertEquals(HttpStatus.OK, received.getStatusCode());
        Assertions.assertEquals(expectedRoomDTO, received.getBody());
    }

    @Test
    public void getRoomsByOwnershipWithoutData() throws OwnershipNotFoundException {
        when(roomService.getBiggestRoomByOwnership(expectedId)).thenReturn(null);

        var received = roomController.getBiggestRoomByOwnership(expectedId);

        verify(roomService, atLeastOnce()).getBiggestRoomByOwnership(expectedId);
        Assertions.assertEquals(HttpStatus.OK, received.getStatusCode());
        Assertions.assertNull(received.getBody());
    }
}
