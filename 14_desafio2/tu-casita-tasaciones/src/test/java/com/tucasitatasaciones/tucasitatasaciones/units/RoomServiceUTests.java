package com.tucasitatasaciones.tucasitatasaciones.units;

import com.tucasitatasaciones.tucasitatasaciones.exceptions.OwnershipNotFoundException;
import com.tucasitatasaciones.tucasitatasaciones.repositories.IOwnerRepository;
import com.tucasitatasaciones.tucasitatasaciones.repositories.entities.Ownership;
import com.tucasitatasaciones.tucasitatasaciones.repositories.entities.Room;
import com.tucasitatasaciones.tucasitatasaciones.services.IRoomService;
import com.tucasitatasaciones.tucasitatasaciones.services.RoomService;
import com.tucasitatasaciones.tucasitatasaciones.services.dtos.RoomWithSquareMeterDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class RoomServiceUTests {

    @Mock
    private IOwnerRepository ownerRepository;

    @InjectMocks
    private RoomService roomService;

    @Test
    public void getBiggestRoomByOwnershipSameObjectOkTest() throws OwnershipNotFoundException {
        RoomWithSquareMeterDTO expectedRoom = new RoomWithSquareMeterDTO();
        expectedRoom.setName("Bedroom");
        expectedRoom.setWidth(30D);
        expectedRoom.setHigh(10D);
        expectedRoom.setSquareMeter(300D);

        List<Room> rooms = Arrays.asList(new Room(2, "Kitchen", 5.0, 3.0),
                new Room(3, "Linving", 15.0, 7.0),
                new Room(1, "Bedroom", 30.0, 10.0));

        Ownership expectedOwnership = new Ownership(1, "Ownership Test", rooms, 1);

        Mockito.when(ownerRepository.findFirst(expectedOwnership.getId())).thenReturn(expectedOwnership);

        RoomWithSquareMeterDTO received = roomService.getBiggestRoomByOwnership(expectedOwnership.getId());

        Mockito.verify(ownerRepository, Mockito.atLeastOnce()).findFirst(expectedOwnership.getId());
        Assertions.assertEquals(expectedRoom, received);
    }

    @Test
    public void getBiggestRoomByOwnershipCorrectValueSquareMeterOkTest() throws OwnershipNotFoundException {
        Room biggestRoom = new Room(1, "Bedroom", 30.0, 10.0);

        List<Room> rooms = Arrays.asList(new Room(2, "Kitchen", 5.0, 3.0),
                new Room(3, "Linving", 15.0, 7.0),
                biggestRoom);

        Ownership expectedOwnership = new Ownership(1, "Ownership Test", rooms, 1);

        Mockito.when(ownerRepository.findFirst(expectedOwnership.getId())).thenReturn(expectedOwnership);

        RoomWithSquareMeterDTO received = roomService.getBiggestRoomByOwnership(expectedOwnership.getId());

        Mockito.verify(ownerRepository, Mockito.atLeastOnce()).findFirst(expectedOwnership.getId());
        Assertions.assertEquals(biggestRoom.getWidth() * biggestRoom.getHigh(), received.getSquareMeter());
    }

    @Test
    public void getBiggestRoomByOwnershipNotFoundOwnershipIdErrorTest() throws OwnershipNotFoundException {
        int expectedId = 1;

        Mockito.when(ownerRepository.findFirst(expectedId)).thenReturn(null);

        Assertions.assertThrows(OwnershipNotFoundException.class, () -> roomService.getBiggestRoomByOwnership(expectedId));
        Mockito.verify(ownerRepository, Mockito.atLeastOnce()).findFirst(expectedId);
    }

    //@Test
    // TODO: 17/06/2021 No cuenta con habitaciones la propiedad
    public void getBiggestRoomByOwnershipNotFoundRoomsErrorTest() throws OwnershipNotFoundException {
        Ownership expectedOwnershipNullRooms = new Ownership(1, "Ownership Null Test", null, 1);

        Mockito.when(ownerRepository.findFirst(expectedOwnershipNullRooms.getId()))
                .thenReturn(expectedOwnershipNullRooms);

        Assertions.assertThrows(Exception.class, () ->
                roomService.getBiggestRoomByOwnership(expectedOwnershipNullRooms.getId()));

        Mockito.verify(ownerRepository, Mockito.atLeastOnce()).findFirst(expectedOwnershipNullRooms.getId());
    }

    @Test
    public void getRoomsByOwnershipContainDataOkTest() throws OwnershipNotFoundException {
        Room biggestRoom = new Room(1, "Bedroom", 30.0, 10.0);

        List<Room> rooms = Arrays.asList(new Room(2, "Kitchen", 5.0, 3.0),
                new Room(3, "Linving", 15.0, 7.0),
                biggestRoom);

        Ownership expectedOwnership = new Ownership(1, "Ownership Test", rooms, 1);

        Mockito.when(ownerRepository.findFirst(expectedOwnership.getId())).thenReturn(expectedOwnership);

        var received = roomService.getRoomsByOwnership(expectedOwnership.getId());

        Mockito.verify(ownerRepository, Mockito.atLeastOnce()).findFirst(expectedOwnership.getId());
        Assertions.assertNotNull(received);
    }

    @Test
    public void getRoomsByOwnershipNotFoundOwnershipIdErrorTest() throws OwnershipNotFoundException {
        int expectedId = 1;

        Mockito.when(ownerRepository.findFirst(expectedId)).thenReturn(null);

        Assertions.assertThrows(OwnershipNotFoundException.class, () -> roomService.getRoomsByOwnership(expectedId));
        Mockito.verify(ownerRepository, Mockito.atLeastOnce()).findFirst(expectedId);
    }

    //@Test
    // TODO: 17/06/2021 No cuenta con habitaciones la propiedad
    public void getRoomsByOwnershipNotFoundRoomsErrorTest() throws OwnershipNotFoundException {
        Ownership expectedOwnershipNullRooms = new Ownership(1, "Ownership Null Test", null, 1);

        Mockito.when(ownerRepository.findFirst(expectedOwnershipNullRooms.getId()))
                .thenReturn(expectedOwnershipNullRooms);

        Assertions.assertThrows(Exception.class, () ->
                roomService.getRoomsByOwnership(expectedOwnershipNullRooms.getId()));
        Mockito.verify(ownerRepository, Mockito.atLeastOnce()).findFirst(expectedOwnershipNullRooms.getId());
    }

    // TODO: 17/06/2021 getRoomsByOwnershipSameObjectRoomsOkTest
}
