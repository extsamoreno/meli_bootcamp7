package com.example.DesafioTasaciones.unit.repository;

import com.example.DesafioTasaciones.exceptions.HouseNotFoundException;
import com.example.DesafioTasaciones.models.House;
import com.example.DesafioTasaciones.repository.HouseRepository;
import com.example.DesafioTasaciones.repository.IHouseRepository;
import com.example.DesafioTasaciones.util.TestUtilGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class HouseRepositoryTest {
    IHouseRepository iHouseRepository;

    @BeforeEach
    @AfterEach
    private void setUp() { this.iHouseRepository = new HouseRepository(); }

    @Test
    public void saveNewProperty() {
        //Arrange
        House house = TestUtilGenerator.getProperty();

        //Act
        iHouseRepository.saveProperty(house);

        //Assert
        Assertions.assertEquals(1,house.getId());
        Assertions.assertEquals(iHouseRepository.findPropertyById(house.getId()),house);
    }

    @Test
    public void findExistentPropertyById() {
        //Arrange
        House house = TestUtilGenerator.getProperty();
        iHouseRepository.saveProperty(house);

        //Act
        House found = iHouseRepository.findPropertyById(house.getId());

        //Assert
        Assertions.assertEquals(found,house);
    }

    @Test
    public void findNonExistentPropertyById() {
        //Arrange
        Integer propertyId = 1;

        //Act & Assert
        Assertions.assertThrows(HouseNotFoundException.class, () -> iHouseRepository.findPropertyById(propertyId));
    }

    @Test
    public void getAllProperties() {
        //Arrange
        List<House> houses = TestUtilGenerator.getProperties();
        houses.forEach((prop) -> iHouseRepository.saveProperty(prop));

        //Act
        List<House> foundList = iHouseRepository.getAllProperties();

        //Assert
        Assertions.assertEquals(houses,foundList);
    }
}
