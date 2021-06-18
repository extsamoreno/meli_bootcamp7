package com.example.demo.repositories;


import com.example.demo.entities.District;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class DistrictRepositoryTest {

    DistrictRepository districtRepository = new DistrictRepository();

    @Test
    public void findByNameTest() {
        districtRepository.loadDistrict();
        District district = districtRepository.findDistrictByName("Barrio 1");
        Assertions.assertNotNull(district);
    }

    @Test
    public void saveDistrictTest() throws Exception {

        District district = new District();
        int beforeSize = districtRepository.loadDistrict().size();

        districtRepository.addDistrict(district);
        districtRepository.saveDistrict();
        assertEquals(beforeSize + 1, districtRepository.loadDistrict().size());
    }
}
