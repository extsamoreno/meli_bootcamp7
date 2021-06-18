package com.example.tucasita.unit.repository;

import com.example.tucasita.model.DistrictDTO;
import com.example.tucasita.repository.DistrictRepository;
import com.example.tucasita.repository.DistrictRepositoryImple;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class DistrictRepositoryTests {

    DistrictRepository districtRepository;

    @BeforeEach
    public void init() {
        districtRepository = new DistrictRepositoryImple();
    }

    @Test
    public void testFindAll() {
        //ARRANGE
        DistrictDTO expectedDistrict1 = new DistrictDTO( "Belgrano", 250.00);
        DistrictDTO expectedDistrict2 = new DistrictDTO( "Caballito", 100.00);
        DistrictDTO expectedDistrict3 = new DistrictDTO( "Almagro", 300.00);
        Set<DistrictDTO> expectedDistricts = new HashSet<>();
        expectedDistricts.add(expectedDistrict1);
        expectedDistricts.add(expectedDistrict2);
        expectedDistricts.add(expectedDistrict3);

        //ACT
        Set<DistrictDTO> receivedDistricts = districtRepository.findAll();

        //ASSERT
        Assertions.assertEquals(expectedDistricts, receivedDistricts);
    }
}
