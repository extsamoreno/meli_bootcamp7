package com.example.testingchallengev2.unit;

import com.example.testingchallengev2.exception.DistrictNotFoundException;
import com.example.testingchallengev2.exception.HouseNotFoundException;
import com.example.testingchallengev2.model.House;
import com.example.testingchallengev2.model.response.*;
import com.example.testingchallengev2.repository.district.IDistrictDAO;
import com.example.testingchallengev2.repository.house.IHouseDAO;
import com.example.testingchallengev2.service.HouseInfoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.HashMap;

import static com.example.testingchallengev2.unit.TestUtils.getHouseWithName;

@ExtendWith(MockitoExtension.class)
public class HouseInfoServiceTest {

    @Mock
    IHouseDAO iHouseDAO;

    @Mock
    IDistrictDAO iDistrictDAO;

    @Mock
    ModelMapper modelMapper;

    @InjectMocks
    HouseInfoService houseInfoService;

    @Test
    public void getDistrictListDTOFromDao()
    {
        HashMap<String, Double> dist = new HashMap<>();
        dist.put("Centro", 150.0);
        dist.put("Nueva Córdoba", 160.0);
        DistrictListResponseDTO expected = new DistrictListResponseDTO(dist);
        Mockito.when(modelMapper.map(iDistrictDAO.getDistricts(), DistrictListResponseDTO.class)).thenReturn(expected);

        DistrictListResponseDTO received = houseInfoService.getDistrictListDTO();

        Mockito.verify(iDistrictDAO, Mockito.atLeastOnce()).getDistricts();
        Assertions.assertEquals(expected, received);
    }

    @Test
    public void getHouseListFromDao()
    {
        House casa1 = getHouseWithName("casa1");
        House casa2 = getHouseWithName("casa2");
        HashMap<String, House> houses = new HashMap<>();
        houses.put(casa1.getName(), casa1);
        houses.put(casa2.getName(), casa2);
        HouseListResponseDTO expected = new HouseListResponseDTO(houses);
        Mockito.when(modelMapper.map(iHouseDAO.getHouses(), HouseListResponseDTO.class))
                .thenReturn(expected);

        HouseListResponseDTO received = houseInfoService.getHouseListDTO();

        Mockito.verify(iHouseDAO, Mockito.atLeastOnce()).getHouses();
        Assertions.assertEquals(expected, received);
    }

    @Test
    public void getTotalHouseAreaResponseDTOTest() throws Exception {
        String name = "casa";
        House house = getHouseWithName(name);
        TotalHouseAreaResponseDTO expected = new TotalHouseAreaResponseDTO(name, 4.0);
        Mockito.when(iHouseDAO.getHouseByName(name)).thenReturn(house);

        TotalHouseAreaResponseDTO received = houseInfoService.getTotalHouseAreaResponseDTO(name);

        Mockito.verify(iHouseDAO, Mockito.atLeastOnce()).getHouseByName(name);
        Assertions.assertEquals(expected, received);
    }

    @Test
    public void getHouseValueResponseDTOTest() throws Exception {
        String name = "casa";
        House house = getHouseWithName(name);
        Mockito.when(iHouseDAO.getHouseByName(name)).thenReturn(house);
        Mockito.when(iDistrictDAO.getPriceByName(house.getDistrictName())).thenReturn(100.0);
        HouseValueResponseDTO expected = new HouseValueResponseDTO(name, 400.0);

        HouseValueResponseDTO received = houseInfoService.getHouseValueResponseDTO(name);

        Mockito.verify(iHouseDAO, Mockito.atLeastOnce()).getHouseByName(name);
        Mockito.verify(iDistrictDAO, Mockito.atLeastOnce()).getPriceByName(house.getDistrictName());
        Assertions.assertEquals(expected, received);
    }

    @Test
    public void getHouseBiggestRoomResponseDTOTest() throws Exception {
        String name = "casa";
        House house = getHouseWithName(name);
        Mockito.when(iHouseDAO.getHouseByName(name)).thenReturn(house);
        HouseBiggestRoomResponseDTO expected = new HouseBiggestRoomResponseDTO(name, "baño", 4.0);

        HouseBiggestRoomResponseDTO received = houseInfoService.getHouseBiggestRoomResponseDTO(name);

        Mockito.verify(iHouseDAO, Mockito.atLeastOnce()).getHouseByName(name);
        Assertions.assertEquals(expected, received);
    }

    @Test
    public void getRoomsSizeResponseDTOTest() throws Exception {
        String name = "casa";
        House house = getHouseWithName(name);
        HashMap<String, Double> roomsSize = new HashMap<>();
        roomsSize.put(house.getRooms().get(0).getName(), 4.0);
        Mockito.when(iHouseDAO.getHouseByName(name)).thenReturn(house);
        RoomsSizeResponseDTO expected = new RoomsSizeResponseDTO(roomsSize);

        RoomsSizeResponseDTO received = houseInfoService.getRoomsSizeResponseDTO(name);

        Mockito.verify(iHouseDAO, Mockito.atLeastOnce()).getHouseByName(name);
        Assertions.assertEquals(expected, received);
    }
}
