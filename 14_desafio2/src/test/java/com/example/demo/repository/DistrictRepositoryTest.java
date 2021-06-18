package com.example.demo.repository;


import com.example.demo.Utils.UtilTest;
import com.example.demo.entities.District;
import com.example.demo.entities.Property;
import com.example.demo.repositories.DistrictRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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
