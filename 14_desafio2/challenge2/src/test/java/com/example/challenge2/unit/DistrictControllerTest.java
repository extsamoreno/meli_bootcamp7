package com.example.challenge2.unit;

import com.example.challenge2.controllers.DistrictController;
import com.example.challenge2.models.District;
import com.example.challenge2.serivces.IDistrictService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class DistrictControllerTest {
    @Mock
    IDistrictService districtService;
    @InjectMocks
    DistrictController districtController;

    @Test
    public void registerNewDistrict() {
        //Arrange
        District district =new District("Carrasco", 800.00);
        //Act
        ResponseEntity<?> received = districtController.registerDistrict(district);

        //Asset
        Mockito.verify(districtService,Mockito.atLeastOnce()).create(district);
        Assertions.assertEquals(HttpStatus.CREATED,received.getStatusCode());
    }



}
