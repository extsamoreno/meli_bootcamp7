package com.tucasitatasaciones.tucasitatasaciones.units;

import com.tucasitatasaciones.tucasitatasaciones.exceptions.OwnershipNotFoundException;
import com.tucasitatasaciones.tucasitatasaciones.repositories.IOwnerRepository;
import com.tucasitatasaciones.tucasitatasaciones.repositories.entities.Ownership;
import com.tucasitatasaciones.tucasitatasaciones.repositories.entities.Room;
import com.tucasitatasaciones.tucasitatasaciones.services.RoomService;
import com.tucasitatasaciones.tucasitatasaciones.services.dtos.RoomWithSquareMeterDTO;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RoomServiceUTests {

    @Mock
    private IOwnerRepository ownerRepository;

    @InjectMocks
    private RoomService roomService;

    private RoomWithSquareMeterDTO expectedRoomWithSquareMeterDTO;
    private Ownership expectedOwnership;
    private List<Room> expectedRooms;
    private Room biggestRoom;

    @BeforeEach
    public void InitData() {
        expectedRoomWithSquareMeterDTO = new RoomWithSquareMeterDTO();

        expectedRoomWithSquareMeterDTO.setName("Bedroom");
        expectedRoomWithSquareMeterDTO.setWidth(30D);
        expectedRoomWithSquareMeterDTO.setHigh(10D);
        expectedRoomWithSquareMeterDTO.setSquareMeter(300D);

        biggestRoom = new Room(1, "Bedroom", 30.0, 10.0);

        expectedRooms = Arrays.asList(
                new Room(2, "Kitchen", 5.0, 3.0),
                new Room(3, "Linving", 15.0, 7.0),
                biggestRoom
        );

        expectedOwnership = new Ownership(1, "Ownership Test", expectedRooms, 1);
    }

    @Test
    public void getBiggestRoomByOwnershipSameObjectOkTest() throws OwnershipNotFoundException {

        when(ownerRepository.findFirst(expectedOwnership.getId())).thenReturn(expectedOwnership);

        RoomWithSquareMeterDTO received = roomService.getBiggestRoomByOwnership(expectedOwnership.getId());

        verify(ownerRepository, atLeastOnce()).findFirst(expectedOwnership.getId());
        Assertions.assertEquals(expectedRoomWithSquareMeterDTO, received);
    }

    @Test
    public void getBiggestRoomByOwnershipCorrectValueSquareMeterOkTest() throws OwnershipNotFoundException {
        when(ownerRepository.findFirst(expectedOwnership.getId())).thenReturn(expectedOwnership);

        RoomWithSquareMeterDTO received = roomService.getBiggestRoomByOwnership(expectedOwnership.getId());

        verify(ownerRepository, atLeastOnce()).findFirst(expectedOwnership.getId());
        Assertions.assertEquals(biggestRoom.getWidth() * biggestRoom.getHigh(), received.getSquareMeter());
    }

    @Test
    public void getBiggestRoomByOwnershipNotFoundOwnershipIdErrorTest() throws OwnershipNotFoundException {
        int expectedId = 1;

        when(ownerRepository.findFirst(expectedId)).thenReturn(null);

        Assertions.assertThrows(OwnershipNotFoundException.class, () -> roomService.getBiggestRoomByOwnership(expectedId));
        verify(ownerRepository, atLeastOnce()).findFirst(expectedId);
    }

    //@Test
    // TODO: 17/06/2021 Without ownership's rooms
    public void getBiggestRoomByOwnershipNotFoundRoomsErrorTest() throws OwnershipNotFoundException {
        Ownership expectedOwnershipNullRooms = new Ownership(1, "Ownership Null Test", null, 1);

        when(ownerRepository.findFirst(expectedOwnershipNullRooms.getId()))
                .thenReturn(expectedOwnershipNullRooms);

        Assertions.assertThrows(Exception.class, () ->
                roomService.getBiggestRoomByOwnership(expectedOwnershipNullRooms.getId()));

        verify(ownerRepository, atLeastOnce()).findFirst(expectedOwnershipNullRooms.getId());
    }

    @Test
    public void getRoomsByOwnershipContainDataOkTest() throws OwnershipNotFoundException {
        Ownership expectedOwnership = new Ownership(1, "Ownership Test", expectedRooms, 1);

        when(ownerRepository.findFirst(expectedOwnership.getId())).thenReturn(expectedOwnership);

        var received = roomService.getRoomsByOwnership(expectedOwnership.getId());

        verify(ownerRepository, atLeastOnce()).findFirst(expectedOwnership.getId());
        Assertions.assertNotNull(received);
    }

    @Test
    public void getRoomsByOwnershipNotFoundOwnershipIdErrorTest() throws OwnershipNotFoundException {
        int expectedId = 1;

        when(ownerRepository.findFirst(expectedId)).thenReturn(null);

        Assertions.assertThrows(OwnershipNotFoundException.class, () -> roomService.getRoomsByOwnership(expectedId));
        verify(ownerRepository, atLeastOnce()).findFirst(expectedId);
    }

    //@Test
    // TODO: 17/06/2021 Without ownership's rooms
    public void getRoomsByOwnershipNotFoundRoomsErrorTest() throws OwnershipNotFoundException {
        Ownership expectedOwnershipNullRooms = new Ownership(1, "Ownership Null Test", null, 1);

        when(ownerRepository.findFirst(expectedOwnershipNullRooms.getId()))
                .thenReturn(expectedOwnershipNullRooms);

        Assertions.assertThrows(Exception.class, () ->
                roomService.getRoomsByOwnership(expectedOwnershipNullRooms.getId()));
        verify(ownerRepository, atLeastOnce()).findFirst(expectedOwnershipNullRooms.getId());
    }

    // TODO: 17/06/2021 getRoomsByOwnershipSameObjectRoomsOkTest
}
