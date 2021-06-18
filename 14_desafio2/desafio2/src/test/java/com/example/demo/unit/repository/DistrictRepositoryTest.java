package com.example.demo.unit.repository;

import com.example.demo.exception.DistrictNotFoundException;
import com.example.demo.models.District;
import com.example.demo.repository.DistrictRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class DistrictRepositoryTest {
    @InjectMocks
    DistrictRepository districtRepository;
    @Test
    public void findDistrictByNameHappyPath() throws DistrictNotFoundException {
        //arrange
        District expected = new District("Compartir",300);
        //act
        District response = districtRepository.findDistrictByName(expected.getDistric_name());
        //asser
        Assertions.assertEquals(expected,response);
    }
    @Test
    public void addDistrictHappyPath() throws DistrictNotFoundException {
        //arrange
        District district = new District("Compartir",300);
        //act
        districtRepository.addDistrict(district);
        District received = districtRepository.findDistrictByName(district.getDistric_name());
        //asser
        Assertions.assertEquals(district,received);
    }
    @Test
    public void findDistrictByNameNullHappyPath() throws DistrictNotFoundException {
        //asser
        Assertions.assertThrows(DistrictNotFoundException.class, ()-> districtRepository.findDistrictByName("xx"));
    }
}
