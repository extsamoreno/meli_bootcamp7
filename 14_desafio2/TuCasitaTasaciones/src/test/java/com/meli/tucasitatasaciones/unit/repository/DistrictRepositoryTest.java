package com.meli.tucasitatasaciones.unit.repository;

import com.meli.tucasitatasaciones.model.District;
import com.meli.tucasitatasaciones.repository.district.DistrictRepository;
import com.meli.tucasitatasaciones.repository.district.IDistrictRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DistrictRepositoryTest {
    IDistrictRepository iDistrictRepository;

    @BeforeEach @AfterEach
    private void setUp() {
        this.iDistrictRepository = new DistrictRepository();
    }

    @Test
    public void findExistentDistrictByName() {
        //Arrange
        String districtName = "Alto Alberdi";

        //Act
        District found = iDistrictRepository.findDistrictByName(districtName);

        //Assert
        Assertions.assertEquals(found.getName(),districtName);
    }

    @Test
    public void findNonExistentDistrictByName() {
        //Arrange
        String districtName = "Distrito 1";

        //Act
        District found = iDistrictRepository.findDistrictByName(districtName);

        //Assert
        Assertions.assertNull(found);
    }
}