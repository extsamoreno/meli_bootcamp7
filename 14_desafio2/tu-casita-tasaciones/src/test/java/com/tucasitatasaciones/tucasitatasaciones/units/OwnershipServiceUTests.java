package com.tucasitatasaciones.tucasitatasaciones.units;

import com.tucasitatasaciones.tucasitatasaciones.exceptions.DistrictNotFoundException;
import com.tucasitatasaciones.tucasitatasaciones.exceptions.OwnershipNotFoundException;
import com.tucasitatasaciones.tucasitatasaciones.repositories.IDistrictRepository;
import com.tucasitatasaciones.tucasitatasaciones.repositories.IOwnerRepository;
import com.tucasitatasaciones.tucasitatasaciones.repositories.entities.District;
import com.tucasitatasaciones.tucasitatasaciones.repositories.entities.Ownership;
import com.tucasitatasaciones.tucasitatasaciones.repositories.entities.Room;
import com.tucasitatasaciones.tucasitatasaciones.services.OwnershipService;
import com.tucasitatasaciones.tucasitatasaciones.services.dtos.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@ExtendWith(MockitoExtension.class)
public class OwnershipServiceUTests {
    @Mock
    private IOwnerRepository ownerRepository;

    @Mock
    private IDistrictRepository districtRepository;

    @InjectMocks
    private OwnershipService ownershipService;

    @Test
    public void addOkTest() throws DistrictNotFoundException {
        OwnershipWithDataDTO expected = new OwnershipWithDataDTO();
        expected.setId(1);
        expected.setName("Add test dummy");
        expected.setDistrict(new DistrictDTO(1, "District dummy", 20.0));
        expected.setRooms(Arrays.asList(new RoomDTO("Room 1", 10D, 5D),
                new RoomDTO("Room 2", 5D, 2D)));

        District district = new District(1, "District dummy", 20.0);

        Mockito.when(districtRepository.findAny(expected.getDistrict().getId())).thenReturn(district);

        var received = ownershipService.add(expected);

        Mockito.verify(districtRepository, Mockito.atLeastOnce()).findAny(expected.getDistrict().getId());
        Assertions.assertEquals(expected, received);
    }

    @Test
    public void addDistrictNotFoundErrorTest() throws DistrictNotFoundException {
        OwnershipWithDataDTO expected = new OwnershipWithDataDTO();
        expected.setId(1);
        expected.setName("Add test dummy");
        expected.setDistrict(new DistrictDTO(1, "District dummy", 20.0));
        expected.setRooms(new ArrayList<>());

        Mockito.when(districtRepository.findAny(expected.getDistrict().getId())).thenReturn(null);

        Assertions.assertThrows(DistrictNotFoundException.class, () -> ownershipService.add(expected));
        Mockito.verify(districtRepository, Mockito.atLeastOnce()).findAny(expected.getDistrict().getId());
    }

    @Test
    public void calculateSquareMeterByOwnershipCorrectResultOkTest() throws OwnershipNotFoundException {
        List<Room> rooms = Arrays.asList(new Room(2, "Kitchen", 5.0, 3.0),
                new Room(3, "Linving", 15.0, 7.0),
                new Room(1, "Bedroom", 30.0, 10.0));

        Ownership expectedOwnership = new Ownership(1, "Ownership Test", rooms, 1);

        Mockito.when(ownerRepository.findFirst(expectedOwnership.getId())).thenReturn(expectedOwnership);

        OwnershipWithSquareMeterDTO received = ownershipService.calculateSquareMeterByOwnership(expectedOwnership.getId());

        double expected = rooms.stream()
                .map(x -> x.getWidth() * x.getHigh())
                .reduce(0D, Double::sum);

        Mockito.verify(ownerRepository, Mockito.atLeastOnce()).findFirst(expectedOwnership.getId());
        Assertions.assertEquals(expected, received.getSquareMeter());
    }

    @Test
    public void calculateSquareMeterByOwnershipSameObjectOkTest() throws OwnershipNotFoundException {
        OwnershipWithSquareMeterDTO expected = new OwnershipWithSquareMeterDTO();
        expected.setId(1);
        expected.setName("Ownership Test");
        expected.setSquareMeter(420D);

        List<Room> rooms = Arrays.asList(new Room(2, "Kitchen", 5.0, 3.0),
                new Room(3, "Linving", 15.0, 7.0),
                new Room(1, "Bedroom", 30.0, 10.0));

        Ownership expectedOwnership = new Ownership(1, "Ownership Test", rooms, 1);

        Mockito.when(ownerRepository.findFirst(expectedOwnership.getId())).thenReturn(expectedOwnership);

        OwnershipWithSquareMeterDTO received = ownershipService.calculateSquareMeterByOwnership(expectedOwnership.getId());

        Mockito.verify(ownerRepository, Mockito.atLeastOnce()).findFirst(expectedOwnership.getId());
        Assertions.assertEquals(expected, received);
    }

    @Test
    public void calculateSquareMeterByOwnershipInitZeroRoomsOkTest() throws OwnershipNotFoundException {
        Ownership expectedOwnership = new Ownership(1, "Ownership Test", new ArrayList<>(), 1);

        Mockito.when(ownerRepository.findFirst(expectedOwnership.getId())).thenReturn(expectedOwnership);

        OwnershipWithSquareMeterDTO received = ownershipService.calculateSquareMeterByOwnership(expectedOwnership.getId());

        Mockito.verify(ownerRepository, Mockito.atLeastOnce()).findFirst(expectedOwnership.getId());
        Assertions.assertEquals(0D, received.getSquareMeter());
    }

    @Test
    public void calculateSquareMeterByOwnershipNotFoundOwnershipErrorTest() throws OwnershipNotFoundException {
        int expectedId = 1;

        Mockito.when(ownerRepository.findFirst(expectedId)).thenReturn(null);

        Assertions.assertThrows(OwnershipNotFoundException.class, () ->
                ownershipService.calculateSquareMeterByOwnership(expectedId));
        Mockito.verify(ownerRepository, Mockito.atLeastOnce()).findFirst(expectedId);
    }

    //@Test
    // TODO: 17/06/2021 Same error next todo
    public void calculateSquareMeterByOwnershipNullRoomsErrorTest() throws OwnershipNotFoundException {
        Ownership expectedOwnership = new Ownership(1, "Ownership Test", null, 1);

        Mockito.when(ownerRepository.findFirst(expectedOwnership.getId())).thenReturn(expectedOwnership);

        OwnershipWithSquareMeterDTO received =ownershipService.calculateSquareMeterByOwnership(expectedOwnership.getId());

        Mockito.verify(ownerRepository, Mockito.atLeastOnce()).findFirst(expectedOwnership.getId());
        Assertions.assertEquals(0D, received.getSquareMeter());
    }

    @Test
    public void calculatePriceByOwnershipCorrectResultOkTest() throws DistrictNotFoundException, OwnershipNotFoundException {
        List<Room> rooms = Arrays.asList(new Room(2, "Kitchen", 5.0, 3.0),
                new Room(3, "Linving", 15.0, 7.0),
                new Room(1, "Bedroom", 30.0, 10.0));

        Ownership expectedOwnership = new Ownership(1, "Ownership Test", rooms, 1);

        District district = new District(1, "District Test 1", 20D);

        Mockito.when(ownerRepository.findFirst(expectedOwnership.getId())).thenReturn(expectedOwnership);
        Mockito.when(districtRepository.findAny(district.getId())).thenReturn(district);

        var received = ownershipService.calculatePriceByOwnership(expectedOwnership.getId());

        Double expected = rooms.stream()
                .map(x -> x.getHigh() * x.getWidth())
                .reduce(0D, Double::sum) * district.getPrice();

        Mockito.verify(ownerRepository, Mockito.atLeastOnce()).findFirst(expectedOwnership.getId());
        Mockito.verify(districtRepository, Mockito.atLeastOnce()).findAny(district.getId());
        Assertions.assertEquals(expected, received.getPrice());
    }

    @Test
    public void calculatePriceByOwnershipSameObjectOkTest() throws DistrictNotFoundException, OwnershipNotFoundException {
        OwnershipWithPriceDTO expected = new OwnershipWithPriceDTO();
        expected.setId(1);
        expected.setName("Ownership Test");
        expected.setPrice(8400D);

        List<Room> rooms = Arrays.asList(new Room(2, "Kitchen", 5.0, 3.0),
                new Room(3, "Linving", 15.0, 7.0),
                new Room(1, "Bedroom", 30.0, 10.0));

        Ownership expectedOwnership = new Ownership(1, "Ownership Test", rooms, 1);

        District district = new District(1, "District Test 1", 20D);

        Mockito.when(ownerRepository.findFirst(expectedOwnership.getId())).thenReturn(expectedOwnership);
        Mockito.when(districtRepository.findAny(district.getId())).thenReturn(district);

        var received = ownershipService.calculatePriceByOwnership(expectedOwnership.getId());

        Mockito.verify(ownerRepository, Mockito.atLeastOnce()).findFirst(expectedOwnership.getId());
        Mockito.verify(districtRepository, Mockito.atLeastOnce()).findAny(district.getId());
        Assertions.assertEquals(expected, received);
    }

    @Test
    public void calculatePriceByOwnershipNotFoundOwnershipErrorTest() throws DistrictNotFoundException, OwnershipNotFoundException {
        int expectedId = 1;

        Mockito.when(ownerRepository.findFirst(expectedId)).thenReturn(null);

        Assertions.assertThrows(OwnershipNotFoundException.class, () ->
                ownershipService.calculatePriceByOwnership(expectedId));

        Mockito.verify(ownerRepository, Mockito.atLeastOnce()).findFirst(expectedId);
    }

    @Test
    public void calculatePriceByOwnershipNotFoundDistrictErrorTest() throws DistrictNotFoundException, OwnershipNotFoundException {
        Ownership expectedOwnership = new Ownership(1, "Ownership Test", null, 1);

        Mockito.when(ownerRepository.findFirst(expectedOwnership.getId())).thenReturn(expectedOwnership);
        Mockito.when(districtRepository.findAny(expectedOwnership.getDistrictId())).thenReturn(null);

        Assertions.assertThrows(DistrictNotFoundException.class, () ->
                ownershipService.calculatePriceByOwnership(expectedOwnership.getId()));

        Mockito.verify(ownerRepository, Mockito.atLeastOnce()).findFirst(expectedOwnership.getId());
        Mockito.verify(districtRepository, Mockito.atLeastOnce()).findAny(expectedOwnership.getDistrictId());
    }

    @Test
    public void calculatePriceByOwnershipInitZeroRoomsOkTest() throws DistrictNotFoundException, OwnershipNotFoundException {
        Ownership expectedOwnership = new Ownership(1, "Ownership Test", new ArrayList<>(), 1);
        District district = new District(1, "District Test 1", 20D);

        Mockito.when(ownerRepository.findFirst(expectedOwnership.getId())).thenReturn(expectedOwnership);
        Mockito.when(districtRepository.findAny(expectedOwnership.getDistrictId())).thenReturn(district);

        var received = ownershipService.calculatePriceByOwnership(expectedOwnership.getId());

        Mockito.verify(ownerRepository, Mockito.atLeastOnce()).findFirst(expectedOwnership.getId());
        Mockito.verify(districtRepository, Mockito.atLeastOnce()).findAny(expectedOwnership.getDistrictId());
        Assertions.assertEquals(0, received.getPrice());
    }

    //@Test
    // TODO: 17/06/2021 Error to send null rooms
    public void calculatePriceByOwnershipNullRoomsErrorTest() throws DistrictNotFoundException, OwnershipNotFoundException {
        Ownership expectedOwnership = new Ownership(1, "Ownership Test", null, 1);
        District district = new District(1, "District Test 1", 20D);

        Mockito.when(ownerRepository.findFirst(expectedOwnership.getId())).thenReturn(expectedOwnership);
        Mockito.when(districtRepository.findAny(expectedOwnership.getDistrictId())).thenReturn(district);

        var received = ownershipService.calculatePriceByOwnership(expectedOwnership.getId());

        Mockito.verify(ownerRepository, Mockito.atLeastOnce()).findFirst(expectedOwnership.getId());
        Mockito.verify(districtRepository, Mockito.atLeastOnce()).findAny(expectedOwnership.getDistrictId());
        Assertions.assertEquals(0D, received.getPrice());
    }
}
