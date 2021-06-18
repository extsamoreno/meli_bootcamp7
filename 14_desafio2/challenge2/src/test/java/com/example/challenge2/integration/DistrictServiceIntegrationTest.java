package com.example.challenge2.integration;

import com.example.challenge2.exceptions.DistrictAlreadyExistException;
import com.example.challenge2.models.District;
import com.example.challenge2.serivces.IDistrictService;
import com.example.challenge2.util.TestUtilGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureMockMvc
public class DistrictServiceIntegrationTest {

    @Autowired
    IDistrictService districtService;

    @BeforeEach
    @AfterEach
    private void setUp() {
        TestUtilGenerator.emptyFiles();
    }

    @Test
    public void createDistrict() throws DistrictAlreadyExistException {
        // arrange
        District district = new District("Carrasco Nuevo", 400.0);

        // act
        District received = districtService.create(district);

        // assert
        Assertions.assertEquals(district, received);
    }


}
