package com.meli.desafio.unit;

import com.meli.desafio.exceptions.models.HouseAlreadyExistsException;
import com.meli.desafio.models.dto.HouseDTO;
import com.meli.desafio.repositories.ICalculateRepository;
import com.meli.desafio.services.CalculateService;
import com.meli.desafio.utils.TestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CalculateServiceUnitTests {

    @Mock
    private ICalculateRepository calculateRepository;

    @InjectMocks
    private CalculateService calculateService;

    @Test
    public void saveHappyPath() throws HouseAlreadyExistsException {
        HouseDTO house = TestUtils.getTotalHouse("House");
        Integer houseId = 1;
        when(calculateRepository.save(house)).thenReturn(houseId);

        Assertions.assertEquals(calculateRepository.save(house), houseId);
    }
}
