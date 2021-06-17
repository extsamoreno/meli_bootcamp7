package com.desafio2.Repository;

import com.desafio2.Exception.DistrctNotFoundException;
import com.desafio2.Model.District;
import com.desafio2.Repository.DistrictRepository;
import com.desafio2.Repository.IDistrctRepository;
import com.desafio2.Utils.TestUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DistrictRepositoryTest {

    IDistrctRepository iDistrctRepository;

    @BeforeEach
    @AfterEach
    private void setUp() {
        TestUtils.emptyFile("districts.json");
        this.iDistrctRepository = new DistrictRepository();
    }

    @Test
    public void saveNoExistentDistrictTest() {
        //arrange
        District district = TestUtils.createWestDistrict100USD();

        //act
        iDistrctRepository.save(district);

        //arrange
        Assertions.assertTrue(iDistrctRepository.exists(district));
        Assertions.assertEquals("West", district.getDistrict_name());
        Assertions.assertEquals(iDistrctRepository.findByName(district.getDistrict_name()), district);
    }

    @Test
    public void modifyExistentDistrictTest() {
        //arrange
        District district = TestUtils.createWestDistrict100USD();
        iDistrctRepository.save(district);
        district.setDistrict_price(500D);

        //act
        iDistrctRepository.save(district);

        //assert
        Assertions.assertTrue(iDistrctRepository.exists(district));
        Assertions.assertEquals(500D, iDistrctRepository.findByName(district.getDistrict_name()).getDistrict_price());
        Assertions.assertEquals(iDistrctRepository.findByName(district.getDistrict_name()), district);
    }

    @Test
    public void findExistentDistrictTest() {
        //arrange
        District expected = TestUtils.createWestDistrict100USD();
        iDistrctRepository.save(expected);

        //act
        District received = iDistrctRepository.findByName(expected.getDistrict_name());

        //assert
        Assertions.assertEquals(expected, received);
    }

    @Test
    public void findNonExistentDistrictTest() {
        //arrange
        District received = TestUtils.createWestDistrict100USD();

        //assert
        Assertions.assertThrows(DistrctNotFoundException.class, () -> iDistrctRepository.findByName(received.getDistrict_name()));
    }

    @Test
    public void deleteExistentDistrictTest() {
        // arrange
        District district = TestUtils.createWestDistrict100USD();
        iDistrctRepository.save(district);

        // act
        iDistrctRepository.delete(district.getDistrict_name());

        // assert
        Assertions.assertFalse(iDistrctRepository.exists(district));
        Assertions.assertThrows(DistrctNotFoundException.class,() -> iDistrctRepository.findByName(district.getDistrict_name()));
    }

    @Test
    public void deleteNonExistentDistrict() {
        // arrange
        District district = TestUtils.createWestDistrict100USD();

        // act
        iDistrctRepository.delete(district.getDistrict_name());

        // assert
        Assertions.assertFalse(iDistrctRepository.exists(district));
        Assertions.assertThrows(DistrctNotFoundException.class,() -> iDistrctRepository.findByName(district.getDistrict_name()));
    }
}
