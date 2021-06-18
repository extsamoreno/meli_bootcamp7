package com.example.DesafioTasaciones.unit.service;

import com.example.DesafioTasaciones.dtos.HouseDTO;
import com.example.DesafioTasaciones.dtos.ResponseDTO;
import com.example.DesafioTasaciones.dtos.RoomDTO;
import com.example.DesafioTasaciones.exceptions.DistrictNotFound;
import com.example.DesafioTasaciones.models.District;
import com.example.DesafioTasaciones.models.House;
import com.example.DesafioTasaciones.repository.IHouseRepository;
import com.example.DesafioTasaciones.services.HouseService;
import com.example.DesafioTasaciones.util.TestUtilGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.math.RoundingMode;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class HouseServiceTest {
    ModelMapper mapper = new ModelMapper();

    @Mock
    IHouseRepository iHouseRepository;

    @Mock
    ModelMapper modelMapper;

    @InjectMocks
    HouseService houseService;


    @Test
    public void createPropertyWithExistingDistrict() {
        //Arrange
        String districtName = "Capital";
        HouseDTO houseDTO = TestUtilGenerator.getPropertyDTO(districtName);
        House house = mapper.map(houseDTO,House.class);
        Mockito.when(iHouseRepository.findDistrictByName(districtName)).thenReturn(new District("Capital",150.0));
        Mockito.when(modelMapper.map(houseDTO,House.class)).thenReturn(house);

        //Act
        houseService.createProperty(houseDTO);

        //Assert
        Mockito.verify(iHouseRepository, Mockito.atLeastOnce()).saveProperty(house);
        Mockito.verify(iHouseRepository, Mockito.atLeastOnce()).findDistrictByName(districtName);
        Assertions.assertEquals(house.getDistrict().getName(),districtName);
    }

    @Test
    public void createPropertyWithNonExistingDistrict() {
        //Arrange
        HouseDTO houseDTO = TestUtilGenerator.getPropertyDTO("Barrio 1");

        //Act & Assert
        Assertions.assertThrows(DistrictNotFound.class, () -> houseService.createProperty(houseDTO));
    }

    @Test
    public void getAllProperties() {
        //Arrange
        List<House> houses = TestUtilGenerator.getProperties();

        Mockito.when(iHouseRepository.getAllProperties()).thenReturn(houses);

        //Act
        List<HouseDTO> foundProperties = houseService.getAllProperties();

        //Assert
        Mockito.verify(iHouseRepository,Mockito.atLeastOnce()).getAllProperties();
    }

    @Test
    public void propertyTotalSquareMeters() {
        //Arrange
        House house = TestUtilGenerator.getProperty();
        Mockito.when(iHouseRepository.findPropertyById(house.getId())).thenReturn(house);

        //Act
        ResponseDTO response = houseService.totalSquareMeters(house.getId());

        //Assert
        Mockito.verify(iHouseRepository,Mockito.atLeastOnce()).findPropertyById(house.getId());
        Assertions.assertEquals(40.0,response.getTotalSquareMeters());
    }

    @Test
    public void propertyValue() {
        //Arrange
        House house = TestUtilGenerator.getProperty();
        Mockito.when(iHouseRepository.findPropertyById(house.getId())).thenReturn(house);

        //Act
        ResponseDTO response = houseService.propertyValue(house.getId());

        //Assert
        Mockito.verify(iHouseRepository,Mockito.atLeastOnce()).findPropertyById(house.getId());
        Assertions.assertEquals(10000.0,response.getPropertyValue());
    }

    @Test
    public void getBiggestEnvironment() {
        //Arrange
        House house = TestUtilGenerator.getProperty();
        RoomDTO room = mapper.map(house.getRooms().get(0), RoomDTO.class);
        Mockito.when(iHouseRepository.findPropertyById(house.getId())).thenReturn(house);
        Mockito.when(modelMapper.map(house.getRooms().get(0),RoomDTO.class)).thenReturn(room);

        //Act
        ResponseDTO response = houseService.largestEnvironment(house.getId());

        //Assert
        Mockito.verify(iHouseRepository,Mockito.atLeastOnce()).findPropertyById(house.getId());
        Assertions.assertEquals(room,response.getLargestEnvironment());
    }

    @Test
    public void roomsSquareMeters() {
        //Arrange
        House house = TestUtilGenerator.getProperty();
        Mockito.when(iHouseRepository.findPropertyById(house.getId())).thenReturn(house);

        //Act
        ResponseDTO response = houseService.roomsSquareMeters(house.getId());

        //Assert
        Mockito.verify(iHouseRepository,Mockito.atLeastOnce()).findPropertyById(house.getId());
        Assertions.assertEquals(30.0,response.getRoomsSquareMeters().get(0).getSquareMeters());
    }
}
