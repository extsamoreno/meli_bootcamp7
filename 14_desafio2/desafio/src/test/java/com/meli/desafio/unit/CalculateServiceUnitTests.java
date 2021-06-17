package com.meli.desafio.unit;

import com.meli.desafio.exceptions.models.DistrictNotFoundException;
import com.meli.desafio.exceptions.models.HouseAlreadyExistsException;
import com.meli.desafio.exceptions.models.HouseNotFoundException;
import com.meli.desafio.models.District;
import com.meli.desafio.models.House;
import com.meli.desafio.models.Room;
import com.meli.desafio.models.dto.HouseDTO;
import com.meli.desafio.repositories.ICalculateRepository;
import com.meli.desafio.services.CalculateService;
import com.meli.desafio.utils.Mappers;
import com.meli.desafio.utils.TestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CalculateServiceUnitTests {

    @Mock
    private ICalculateRepository calculateRepository;

    @InjectMocks
    private CalculateService calculateService;

    @Test
    public void saveHappyPath() throws HouseAlreadyExistsException {
        HouseDTO house = TestUtils.getTotalHouseDTO("House");
        Integer houseId = 1;
        when(calculateRepository.save(house)).thenReturn(houseId);

        Integer response = calculateService.save(house);

        Assertions.assertEquals(response, houseId);
    }

    @Test
    public void getHouseByIdHappyPath() throws HouseNotFoundException, DistrictNotFoundException {
        House house = TestUtils.getTotalHouse("House");
        Integer houseId = house.getId();
        District district = TestUtils.getDistrict("Avellaneda");
        when(calculateRepository.getById(houseId)).thenReturn(house);
        when(calculateRepository.getDistrict(house.getDistrictId())).thenReturn(district);
        HouseDTO expected = Mappers.houseToDTO(house, Mappers.districtToDTO(district));

        HouseDTO response = calculateService.getHouseById(houseId);

        Assertions.assertEquals(response, expected);
    }

    @Test
    public void getTotalMetersHappyPath() throws HouseNotFoundException, DistrictNotFoundException {
        House house = TestUtils.getTotalHouse("House");
        Integer houseId = house.getId();
        District district = TestUtils.getDistrict("Avellaneda");
        when(calculateRepository.getById(houseId)).thenReturn(house);
        when(calculateRepository.getDistrict(house.getDistrictId())).thenReturn(district);
        Double expected = 865.0;

        Double response = calculateService.getTotalMeters(houseId);

        Assertions.assertEquals(response, expected);
    }

    @Test
    public void calculateTotalMetersHappyPath() {
        HouseDTO house = TestUtils.getTotalHouseDTO("House");
        Double expected = 865.0;

        Double response = calculateService.calculateTotalMeters(house.getRooms());

        Assertions.assertEquals(response, expected);
    }

    @Test
    public void calculateMetersHappyPath() {
        HouseDTO house = TestUtils.getTotalHouseDTO("House");
        Double expected = 625.0;

        Double response = calculateService.calculateSquareMeters(house.getRooms().get(0));

        Assertions.assertEquals(response, expected);
    }

    @Test
    public void getTotalPriceHappyPath() throws HouseNotFoundException, DistrictNotFoundException {
        House house = TestUtils.getTotalHouse("House");
        Integer houseId = house.getId();
        District district = TestUtils.getDistrict("Avellaneda");
        when(calculateRepository.getById(houseId)).thenReturn(house);
        when(calculateRepository.getDistrict(house.getDistrictId())).thenReturn(district);
        Double expected = 86500.0;

        Double response = calculateService.getTotalPrice(houseId);

        Assertions.assertEquals(response, expected);
    }

    @Test
    public void calculateTotalPriceHappyPath() throws HouseNotFoundException, DistrictNotFoundException {
        House house = TestUtils.getTotalHouse("House");
        Double expected = 1730.0;

        Double response = calculateService.calculateTotalPrice(house.getRooms(), 2);

        Assertions.assertEquals(response, expected);
    }

    @Test
    public void getBiggerRoomHappyPath() throws HouseNotFoundException, DistrictNotFoundException {
        House house = TestUtils.getTotalHouse("House");
        Integer houseId = house.getId();
        when(calculateRepository.getById(houseId)).thenReturn(house);
        Room expected = house.getRooms().get(0);

        Room response = calculateService.getBiggerRoom(houseId);

        Assertions.assertEquals(response, expected);
    }
}
