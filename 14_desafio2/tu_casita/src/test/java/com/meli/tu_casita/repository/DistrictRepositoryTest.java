package com.meli.tu_casita.repository;

import com.meli.tu_casita.model.District;
import com.meli.tu_casita.util.TestUtilGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class DistrictRepositoryTest {

    IDistrictRepository districtRepository;

    @BeforeEach
    @AfterEach
    public void setUp() {
        String fileName = "suburbsCopia";
        TestUtilGenerator.emptyFile(fileName);
        this.districtRepository = new DistrictRepositoryImpl(fileName);
    }

    @Test
    public void saveTest() {
        //Arrange
        District district = TestUtilGenerator.getDistrict();
        //Act
        districtRepository.save(district);
        //Assert
        Assertions.assertEquals(districtRepository.findById(district.getId()).get().getId(), district.getId());
    }

    @Test
    public void findByIdTest() {
        //Arrange
        District district = TestUtilGenerator.getDistrict();
        districtRepository.save(district);
        //Act
        District districtFound = districtRepository.findById(district.getId()).get();
        //Assert
        Assertions.assertEquals(district, districtFound);

    }

    @Test
    public void findByNameTest() {
        //Arrange
        District district = TestUtilGenerator.getDistrict();
        districtRepository.save(district);
        //Act
        District districtFound = districtRepository.findByName(district.getName()).get();
        //Assert
        Assertions.assertEquals(district, districtFound);

    }

    @Test
    public void getDistrictList() {
        //Arrange
        List<District> districtList = TestUtilGenerator.getDistrictListTest();
        districtList.forEach(district -> districtRepository.save(district));

        //Act
        List<District> foundList = districtRepository.getDistrictList();

        //Assert

        Assertions.assertEquals(districtList.size(), foundList.size());

    }

}
