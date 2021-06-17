package com.meli.desafio.unit;

import com.meli.desafio.controllers.CalculateController;
import com.meli.desafio.exceptions.models.HouseAlreadyExistsException;
import com.meli.desafio.exceptions.models.HouseNotFoundException;
import com.meli.desafio.models.dto.HouseDTO;
import com.meli.desafio.services.ICalculateService;
import com.meli.desafio.utils.TestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CalculateControllerUnitTests {

    @Mock
    private ICalculateService calculateService;

    @InjectMocks
    private CalculateController calculateController;

    @Test
    public void getHouseHappyPath() throws HouseNotFoundException {
        HouseDTO house = TestUtils.getTotalHouse("House1");
        Integer houseId = 1;
        when(calculateService.getHouseById(houseId)).thenReturn(house);

        ResponseEntity<HouseDTO> response = calculateController.getHouse(houseId);

        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
        Assertions.assertEquals(response.getBody(), house);
        verify(calculateService, atLeastOnce()).getHouseById(houseId);
    }

    @Test
    public void getHouseTotalMetersHappyPath() throws HouseNotFoundException {
        Integer houseId = 1;
        when(calculateService.getTotalMeters(houseId)).thenReturn(50.00);

        ResponseEntity<String> response = calculateController.getTotalMeters(houseId);

        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
        Assertions.assertEquals(response.getBody(), "50.0m2");
        verify(calculateService, atLeast(1)).getTotalMeters(houseId);
    }
}
