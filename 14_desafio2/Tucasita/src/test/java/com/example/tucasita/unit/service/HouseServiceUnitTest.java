package com.example.tucasita.unit.service;

import com.example.tucasita.domain.District;
import com.example.tucasita.dto.DistrictDTO;
import com.example.tucasita.dto.HouseDTO;
import com.example.tucasita.dto.response.*;
import com.example.tucasita.exception.NotFoundException;
import com.example.tucasita.exception.PriceNotMatchException;
import com.example.tucasita.repository.IDistrictRepository;
import com.example.tucasita.service.HouseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Optional;

import static com.example.tucasita.TestUtil.getSampleHouseDTO;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.lenient;

@ExtendWith(MockitoExtension.class)

public class HouseServiceUnitTest {
    @Mock
    IDistrictRepository districtRepository;

    @InjectMocks
    HouseService houseService;

    HouseDTO houseDTO;
    HouseDTO houseDTONonExistingDistrict;
    HouseDTO houseDTONotSamePriceDistrict;

    @BeforeEach
    private void init() {
        houseDTO = getSampleHouseDTO();

        houseDTONonExistingDistrict = getSampleHouseDTO();
        houseDTONonExistingDistrict.setDistrict(new DistrictDTO("Non Exists", 100D));

        houseDTONotSamePriceDistrict = getSampleHouseDTO();
        houseDTONotSamePriceDistrict.setDistrict(new DistrictDTO("Barrio", 3000D));

        Optional<District> optionalDistrict = Optional.of(new District("Barrio", 100D));
        Optional<District> optionalNull = Optional.ofNullable(null);

        lenient().when(districtRepository.findByName("Barrio")).thenReturn(optionalDistrict);
        lenient().when(districtRepository.findByName("Non Exists")).thenReturn(optionalNull);

    }

    /**
     * Happy paths
     */

    @Test
    public void calculateTotalMetersHappyPath() {
        HouseWithTotalMetersDTO expected = new HouseWithTotalMetersDTO("Casa", 80);
        HouseWithTotalMetersDTO received = houseService.calculateTotalMeters(houseDTO);
        assertEquals(expected, received);
    }

    @Test
    public void calculateTotalValueHappyPath() {
        HouseWithTotalValueDTO expected = new HouseWithTotalValueDTO("Casa", 8000);
        HouseWithTotalValueDTO received = houseService.calculateTotalValue(houseDTO);
        assertEquals(expected, received);
    }

    @Test
    public void calculateLargestRoomHappyPath() {
        RoomWithMetersDTO largest=new RoomWithMetersDTO("Room2",60);
        HouseWithLargestRoomDTO expected = new HouseWithLargestRoomDTO("Casa", largest);
        HouseWithLargestRoomDTO received = houseService.calculateLargestRoom(houseDTO);
        assertEquals(expected, received);
    }

    @Test
    public void calculateRoomsSquareMetersHappyPath() {
        RoomWithMetersDTO room1=new RoomWithMetersDTO("Room1",20);
        RoomWithMetersDTO room2=new RoomWithMetersDTO("Room2",60);
        HouseWithRoomsMetersDTO expected = new HouseWithRoomsMetersDTO("Casa", Arrays.asList(room1,room2));
        HouseWithRoomsMetersDTO received = houseService.calculateRoomsSquareMeters(houseDTO);
        assertEquals(expected, received);
    }

    /**
     * Non existing district
     */
    @Test
    public void calculateTotalMetersNonExistingDistrict() {
        assertThrows(NotFoundException.class, () -> houseService.calculateTotalMeters(houseDTONonExistingDistrict));
    }

    @Test
    public void calculateTotalValueNonExistingDistrict() {
        assertThrows(NotFoundException.class, () -> houseService.calculateTotalValue(houseDTONonExistingDistrict));
    }

    @Test
    public void calculateLargestRoomNonExistingDistrict() {
        assertThrows(NotFoundException.class, () -> houseService.calculateLargestRoom(houseDTONonExistingDistrict));
    }

    @Test
    public void calculateRoomsSquareMetersNonExistingDistrict() {
        assertThrows(NotFoundException.class, () -> houseService.calculateRoomsSquareMeters(houseDTONonExistingDistrict));
    }

    /**
     * Not the same district price
     */
    @Test
    public void calculateTotalMetersNotSamePriceDistrict() {
        assertThrows(PriceNotMatchException.class, () -> houseService.calculateTotalMeters(houseDTONotSamePriceDistrict));
    }

    @Test
    public void calculateTotalValueNotSamePriceDistrict() {
        assertThrows(PriceNotMatchException.class, () -> houseService.calculateTotalValue(houseDTONotSamePriceDistrict));
    }

    @Test
    public void calculateLargestRoomNotSamePriceDistrict() {
        assertThrows(PriceNotMatchException.class, () -> houseService.calculateLargestRoom(houseDTONotSamePriceDistrict));
    }

    @Test
    public void calculateRoomsSquareMetersNotSamePriceDistrict() {
        assertThrows(PriceNotMatchException.class, () -> houseService.calculateRoomsSquareMeters(houseDTONotSamePriceDistrict));
    }


}
