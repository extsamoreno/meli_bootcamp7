package com.bootcamp.desafio2.unit.Service;

import com.bootcamp.desafio2.UtilsGenerator;
import com.bootcamp.desafio2.controller.HouseController;
import com.bootcamp.desafio2.dto.request.HouseDTO;
import com.bootcamp.desafio2.dto.response.EnvironmentShortDTO;
import com.bootcamp.desafio2.dto.response.HouseFeaturesDTO;
import com.bootcamp.desafio2.entity.House;
import com.bootcamp.desafio2.exception.district.DistrictNotFoundException;
import com.bootcamp.desafio2.exception.house.HouseAlreadyExistsException;
import com.bootcamp.desafio2.exception.house.HouseNotFoundException;
import com.bootcamp.desafio2.repository.district.IDistrictRepository;
import com.bootcamp.desafio2.repository.house.IHouseRepository;
import com.bootcamp.desafio2.service.HouseServiceImpl;
import com.bootcamp.desafio2.service.IHouseService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

@ExtendWith(MockitoExtension.class)
public class UTHouseServiceImpl {

    @Mock
    IHouseRepository houseRepository;

    @Mock
    IDistrictRepository districtRepository;

    @InjectMocks
    HouseServiceImpl houseService;

    @Test
    public void calculateFeaturesSuccessfullyComplete() throws HouseNotFoundException, DistrictNotFoundException {
        // Arrange
        String prop_name = "Casa101";
        House expected = UtilsGenerator. ;
        Mockito.when(houseRepository.findHouseByPropName(prop_name)).thenReturn(expected);

        // Act
        HouseFeaturesDTO response = houseService.calculateFeatures(prop_name);

        // Assert
        Mockito.verify(houseRepository, Mockito.atLeastOnce()).findHouseByPropName(prop_name);
        Assertions.assertEquals(expected, response);
    }


    HouseFeaturesDTO calculateFeatures(String prop_name) throws HouseNotFoundException, DistrictNotFoundException;

    ArrayList<EnvironmentShortDTO> generateEnvironmentList(String prop_name) throws HouseNotFoundException;

    void addNewProperty(HouseDTO houseDTO) throws DistrictNotFoundException, HouseAlreadyExistsException;

}
