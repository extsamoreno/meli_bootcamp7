package com.example.DesafioTasaciones.unit.repository;

import com.example.DesafioTasaciones.models.District;
import com.example.DesafioTasaciones.repository.HouseRepository;
import com.example.DesafioTasaciones.repository.IHouseRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DistrictRepositoryTest {
    IHouseRepository iHouseRepository;

    @BeforeEach
    @AfterEach
    private void setUp() {
        this.iHouseRepository = new HouseRepository();
    }

    @Test
    public void findExistentDistrictByName() {
        //Arrange
        String districtName = "Capital";

        //Act
        District found = iHouseRepository.findDistrictByName(districtName);

        //Assert
        Assertions.assertEquals(found.getName(),districtName);
    }

    @Test
    public void findNonExistentDistrictByName() {
        //Arrange
        String districtName = "Jardin";

        //Act
        District found = iHouseRepository.findDistrictByName(districtName);

        //Assert
        Assertions.assertNull(found);
    }
}
