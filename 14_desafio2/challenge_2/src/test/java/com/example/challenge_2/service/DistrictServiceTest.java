package com.example.challenge_2.service;

import com.example.challenge_2.Util.TestUtilsGenerator;
import com.example.challenge_2.exception.DistrictNotFoundException;
import com.example.challenge_2.models.District;
import com.example.challenge_2.repository.IDistrictRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DistrictServiceTest {
    @Mock
    IDistrictRepository districtRepository;

    @InjectMocks
    DistrictService districtService;

    @Test
    public void getDistrictByNameTest() throws DistrictNotFoundException {
        //Arrange
        District districtTest = TestUtilsGenerator.getDistrictTest();
        when(districtRepository.getByName("Centro")).thenReturn(districtTest);
        //Act

        District result = districtService.getDistrictByName("Centro");
        //Assert

        assertEquals(districtTest, result);
    }

    @Test
    public void getDistrictByNameTestDistrictNotFound() throws DistrictNotFoundException {
        //Arrange
        when(districtRepository.getByName("Centro")).thenThrow(DistrictNotFoundException.class);
        //Act

        //Assert
        assertThrows(DistrictNotFoundException.class, () -> districtService.getDistrictByName("Centro"));
    }
}
