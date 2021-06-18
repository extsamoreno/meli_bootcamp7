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
import org.junit.jupiter.api.BeforeEach;
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

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OwnershipServiceUTests {
    @Mock
    private IOwnerRepository ownerRepository;

    @Mock
    private IDistrictRepository districtRepository;

    @InjectMocks
    private OwnershipService ownershipService;

    private OwnershipWithDataDTO expectedOwnershipWithDataDTO;
    private District expectedDistrict;
    private List<Room> expectedRooms;
    private Ownership expectedOwnership;

    @BeforeEach
    public void InitData() {
        expectedOwnershipWithDataDTO = new OwnershipWithDataDTO();
        expectedOwnershipWithDataDTO.setId(1);
        expectedOwnershipWithDataDTO.setName("Add test dummy");
        expectedOwnershipWithDataDTO.setDistrict(new DistrictDTO(1, "District dummy", 20.0));

        expectedDistrict = new District(1, "District dummy", 20.0);

        expectedRooms = Arrays.asList(new Room(2, "Kitchen", 5.0, 3.0),
                new Room(3, "Linving", 15.0, 7.0),
                new Room(1, "Bedroom", 30.0, 10.0));

        expectedOwnership = new Ownership(1, "Ownership Test", expectedRooms, 1);
    }

    @Test
    public void addOkTest() throws DistrictNotFoundException {
        expectedOwnershipWithDataDTO.setRooms(Arrays.asList(
                new RoomDTO("Room 1", 10D, 5D),
                new RoomDTO("Room 2", 5D, 2D))
        );

        when(districtRepository.findAny(expectedOwnershipWithDataDTO.getDistrict().getId())).thenReturn(expectedDistrict);

        var received = ownershipService.add(expectedOwnershipWithDataDTO);

        verify(districtRepository, atLeastOnce()).findAny(expectedOwnershipWithDataDTO.getDistrict().getId());
        Assertions.assertEquals(expectedOwnershipWithDataDTO, received);
    }

    @Test
    public void addDistrictNotFoundErrorTest() throws DistrictNotFoundException {
        expectedOwnershipWithDataDTO.setRooms(new ArrayList<>());

        when(districtRepository.findAny(expectedOwnershipWithDataDTO.getDistrict().getId())).thenReturn(null);

        Assertions.assertThrows(DistrictNotFoundException.class, () -> ownershipService.add(expectedOwnershipWithDataDTO));
        verify(districtRepository, atLeastOnce()).findAny(expectedOwnershipWithDataDTO.getDistrict().getId());
    }

    @Test
    public void calculateSquareMeterByOwnershipCorrectResultOkTest() throws OwnershipNotFoundException {
        when(ownerRepository.findFirst(expectedOwnership.getId())).thenReturn(expectedOwnership);

        OwnershipWithSquareMeterDTO received = ownershipService.calculateSquareMeterByOwnership(expectedOwnership.getId());

        double expected = expectedRooms.stream()
                .map(x -> x.getWidth() * x.getHigh())
                .reduce(0D, Double::sum);

        verify(ownerRepository, atLeastOnce()).findFirst(expectedOwnership.getId());
        Assertions.assertEquals(expected, received.getSquareMeter());
    }

    @Test
    public void calculateSquareMeterByOwnershipSameObjectOkTest() throws OwnershipNotFoundException {
        OwnershipWithSquareMeterDTO expected = new OwnershipWithSquareMeterDTO();
        expected.setId(1);
        expected.setName("Ownership Test");
        expected.setSquareMeter(420D);

        when(ownerRepository.findFirst(expectedOwnership.getId())).thenReturn(expectedOwnership);

        OwnershipWithSquareMeterDTO received = ownershipService.calculateSquareMeterByOwnership(expectedOwnership.getId());

        verify(ownerRepository, atLeastOnce()).findFirst(expectedOwnership.getId());
        Assertions.assertEquals(expected, received);
    }

    @Test
    public void calculateSquareMeterByOwnershipInitZeroRoomsOkTest() throws OwnershipNotFoundException {
        expectedOwnership.setRooms(new ArrayList<>());

        when(ownerRepository.findFirst(expectedOwnership.getId())).thenReturn(expectedOwnership);

        OwnershipWithSquareMeterDTO received = ownershipService.calculateSquareMeterByOwnership(expectedOwnership.getId());

        verify(ownerRepository, atLeastOnce()).findFirst(expectedOwnership.getId());
        Assertions.assertEquals(0D, received.getSquareMeter());
    }

    @Test
    public void calculateSquareMeterByOwnershipNotFoundOwnershipErrorTest() throws OwnershipNotFoundException {
        int expectedId = 1;

        when(ownerRepository.findFirst(expectedId)).thenReturn(null);

        Assertions.assertThrows(OwnershipNotFoundException.class, () ->
                ownershipService.calculateSquareMeterByOwnership(expectedId));
        verify(ownerRepository, atLeastOnce()).findFirst(expectedId);
    }

    //@Test
    // TODO: 17/06/2021 Same error next todo
    public void calculateSquareMeterByOwnershipNullRoomsErrorTest() throws OwnershipNotFoundException {
        Ownership expectedOwnership = new Ownership(1, "Ownership Test", null, 1);

        when(ownerRepository.findFirst(expectedOwnership.getId())).thenReturn(expectedOwnership);

        OwnershipWithSquareMeterDTO received =ownershipService.calculateSquareMeterByOwnership(expectedOwnership.getId());

        verify(ownerRepository, atLeastOnce()).findFirst(expectedOwnership.getId());
        Assertions.assertEquals(0D, received.getSquareMeter());
    }

    @Test
    public void calculatePriceByOwnershipCorrectResultOkTest() throws DistrictNotFoundException, OwnershipNotFoundException {
        District district = new District(1, "District Test 1", 20D);

        when(ownerRepository.findFirst(expectedOwnership.getId())).thenReturn(expectedOwnership);
        when(districtRepository.findAny(district.getId())).thenReturn(district);

        var received = ownershipService.calculatePriceByOwnership(expectedOwnership.getId());

        Double expected = expectedRooms.stream()
                .map(x -> x.getHigh() * x.getWidth())
                .reduce(0D, Double::sum) * district.getPrice();

        verify(ownerRepository, atLeastOnce()).findFirst(expectedOwnership.getId());
        verify(districtRepository, atLeastOnce()).findAny(district.getId());
        Assertions.assertEquals(expected, received.getPrice());
    }

    @Test
    public void calculatePriceByOwnershipSameObjectOkTest() throws DistrictNotFoundException, OwnershipNotFoundException {
        OwnershipWithPriceDTO expected = new OwnershipWithPriceDTO();
        expected.setId(1);
        expected.setName("Ownership Test");
        expected.setPrice(8400D);

        when(ownerRepository.findFirst(expectedOwnership.getId())).thenReturn(expectedOwnership);
        when(districtRepository.findAny(expectedDistrict.getId())).thenReturn(expectedDistrict);

        var received = ownershipService.calculatePriceByOwnership(expectedOwnership.getId());

        verify(ownerRepository, atLeastOnce()).findFirst(expectedOwnership.getId());
        verify(districtRepository, atLeastOnce()).findAny(expectedDistrict.getId());
        Assertions.assertEquals(expected, received);
    }

    @Test
    public void calculatePriceByOwnershipNotFoundOwnershipErrorTest() throws DistrictNotFoundException, OwnershipNotFoundException {
        int expectedId = 1;

        when(ownerRepository.findFirst(expectedId)).thenReturn(null);

        Assertions.assertThrows(OwnershipNotFoundException.class, () ->
                ownershipService.calculatePriceByOwnership(expectedId));

        verify(ownerRepository, atLeastOnce()).findFirst(expectedId);
    }

    @Test
    public void calculatePriceByOwnershipNotFoundDistrictErrorTest() throws DistrictNotFoundException, OwnershipNotFoundException {
        expectedOwnership.setRooms(null);

        when(ownerRepository.findFirst(expectedOwnership.getId())).thenReturn(expectedOwnership);
        when(districtRepository.findAny(expectedOwnership.getDistrictId())).thenReturn(null);

        Assertions.assertThrows(DistrictNotFoundException.class, () ->
                ownershipService.calculatePriceByOwnership(expectedOwnership.getId()));

        verify(ownerRepository, atLeastOnce()).findFirst(expectedOwnership.getId());
        verify(districtRepository, atLeastOnce()).findAny(expectedOwnership.getDistrictId());
    }

    @Test
    public void calculatePriceByOwnershipInitZeroRoomsOkTest() throws DistrictNotFoundException, OwnershipNotFoundException {
        expectedOwnership.setRooms(new ArrayList<>());

        when(ownerRepository.findFirst(expectedOwnership.getId())).thenReturn(expectedOwnership);
        when(districtRepository.findAny(expectedOwnership.getDistrictId())).thenReturn(expectedDistrict);

        var received = ownershipService.calculatePriceByOwnership(expectedOwnership.getId());

        verify(ownerRepository, atLeastOnce()).findFirst(expectedOwnership.getId());
        verify(districtRepository, atLeastOnce()).findAny(expectedOwnership.getDistrictId());
        Assertions.assertEquals(0, received.getPrice());
    }

    //@Test
    // TODO: 17/06/2021 Error to send null rooms
    public void calculatePriceByOwnershipNullRoomsErrorTest() throws DistrictNotFoundException, OwnershipNotFoundException {
        Ownership expectedOwnership = new Ownership(1, "Ownership Test", null, 1);
        District district = new District(1, "District Test 1", 20D);

        when(ownerRepository.findFirst(expectedOwnership.getId())).thenReturn(expectedOwnership);
        when(districtRepository.findAny(expectedOwnership.getDistrictId())).thenReturn(district);

        var received = ownershipService.calculatePriceByOwnership(expectedOwnership.getId());

        verify(ownerRepository, atLeastOnce()).findFirst(expectedOwnership.getId());
        verify(districtRepository, atLeastOnce()).findAny(expectedOwnership.getDistrictId());
        Assertions.assertEquals(0D, received.getPrice());
    }
}
