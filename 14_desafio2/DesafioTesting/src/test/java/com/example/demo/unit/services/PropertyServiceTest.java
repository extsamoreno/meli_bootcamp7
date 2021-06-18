package com.example.demo.unit.services;

import com.example.demo.Utils;
import com.example.demo.dtos.*;
import com.example.demo.exceptions.DistrictDontFoundException;
import com.example.demo.exceptions.PropertyDontFoundException;
import com.example.demo.model.Property;
import com.example.demo.repositories.DistrictRepository;
import com.example.demo.repositories.PropertyRepository;
import com.example.demo.services.PropertyServiceImple;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PropertyServiceTest {

    @Mock
    PropertyRepository propertyRepository;
    @Mock
    DistrictRepository districtRepository;
    @InjectMocks
    PropertyServiceImple propertyServiceImple;


    @Test
    public void getSquareMetersHappyPath() throws PropertyDontFoundException {

        //arr
        PropertyM2ResponseDTO expected = Utils.getPropertyM2ResponseDTO();
        int id =1;
        Mockito.when(propertyRepository.getSquareMeter(id)).thenReturn(expected);

        //act
        PropertyM2ResponseDTO received = propertyServiceImple.getMeterSquare(id);

        //assert
        Mockito.verify(propertyRepository, Mockito.atLeastOnce()).getSquareMeter(id);
        Assertions.assertEquals(expected,received);

    }

    @Test
    public void getPriceHappyPath() throws PropertyDontFoundException {

        //arrange
        PropertyPriceResponseDTO expected = Utils.getPropertyPriceResponseDTO();
        int id = 1;
        Mockito.when(propertyRepository.getPrice(id)).thenReturn(expected);

        //act
        PropertyPriceResponseDTO received = propertyServiceImple.getPrice(id);

        //assert
        Mockito.verify(propertyRepository, Mockito.atLeastOnce()).getPrice(id);
        Assertions.assertEquals(expected,received);

    }

    @Test
    public void getBiggestEnvPropHappyPath() throws PropertyDontFoundException {

        //arrange
        BiggestPropResponseDTO expected = Utils.getBiggestEnvPropDTO();
        int id = 1;
        Mockito.when(propertyRepository.getBiggestEnvProp(id)).thenReturn(expected);

        //act
        BiggestPropResponseDTO received = propertyServiceImple.getBiggestEnvProp(id);

        //assert
        Mockito.verify(propertyRepository, Mockito.atLeastOnce()).getBiggestEnvProp(id);
        Assertions.assertEquals(expected,received);
    }

    @Test
    public void getSquareMetersEnvHappyPath() throws PropertyDontFoundException {

        //arrange
        PropertyM2EnvsResponseDTO expected = Utils.getSquareMetersEnvDTO();
        int id = 1;
        Mockito.when(propertyRepository.getMeterSquareEnvs(id)).thenReturn(expected);

        //act
        PropertyM2EnvsResponseDTO received = propertyServiceImple.getMeterSquareEnvs(id);

        //assert
        Mockito.verify(propertyRepository, Mockito.atLeastOnce()).getMeterSquareEnvs(id);
        Assertions.assertEquals(expected,received);

    }

    @Test
    public void findPropertyByIdHappyPath() throws PropertyDontFoundException {
        //arrange
        Property expected = Utils.getProperty();
        int id = 1;
        Mockito.when(propertyRepository.findPropertyById(id)).thenReturn(expected);

        //act
        Property received = propertyServiceImple.findPropertyById(id);

        //assert
        Mockito.verify(propertyRepository, Mockito.atLeastOnce()).findPropertyById(id);
        Assertions.assertEquals(expected,received);

    }

    @Test
    public void addPropertyHappyPath() throws DistrictDontFoundException {
        //arrange
        PropertyRequestDTO expected = Utils.getPropertyRequestDTO();
        Mockito.when(propertyRepository.addProperty(expected)).thenReturn(expected);

        //act
        PropertyRequestDTO received = propertyServiceImple.addProperty(expected);

        //assert
        Mockito.verify(propertyRepository, Mockito.atLeastOnce()).addProperty(expected);
        Assertions.assertEquals(expected,received);
    }

}
