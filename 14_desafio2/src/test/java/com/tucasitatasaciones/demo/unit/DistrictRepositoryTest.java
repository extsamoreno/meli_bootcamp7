package com.tucasitatasaciones.demo.unit;

import com.tucasitatasaciones.demo.models.District;
import com.tucasitatasaciones.demo.repository.DistrictRepository;
import com.tucasitatasaciones.demo.repository.IDistrictRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class DistrictRepositoryTest {

    IDistrictRepository districtRepository;

    @BeforeEach @AfterEach
    private void setUp(){
        this.districtRepository = new DistrictRepository();
    }

    @Test
    public void testFindDistrictByIdWithExistDistrict(){
        //Arrange
        int districtId = 1;
        District district = new District(1, "Guemes", 100);

        //Act
        District districtReceived = districtRepository.findDistrictById(districtId);

        //Assert
        assertEquals(district, districtReceived);

    }

    @Test
    public void testFindDistrictByIdWithNotExistDistrict(){
        //Arrange
        int districtId = 2;

        //Act
        District districtReceived = districtRepository.findDistrictById(districtId);

        //Assert
        assertNull(districtReceived);

    }

}
