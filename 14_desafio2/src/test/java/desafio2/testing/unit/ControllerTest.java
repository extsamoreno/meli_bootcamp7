package desafio2.testing.unit;

import desafio2.testing.controller.CalculateController;
import desafio2.testing.exception.NotFoundException;
import desafio2.testing.service.IHouseService;
import desafio2.testing.service.dto.HouseLargestEnvironmentDTO;
import desafio2.testing.service.dto.HouseMeterPerEnvironmentDTO;
import desafio2.testing.service.dto.HouseMeterPropertyDTO;
import desafio2.testing.service.dto.HousePriceDTO;
import desafio2.testing.util.Generator;
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

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ControllerTest {
    @Mock
    IHouseService iHouseService;

    @InjectMocks
    CalculateController calculateController;

    @Test
    public void meterPropertyHappyPath() throws NotFoundException {
        //arrange
        int id = 1;
        HouseMeterPropertyDTO expected = Generator.getArea();
        when(iHouseService.meterProperty(id)).thenReturn(expected);

        //act
        ResponseEntity<HouseMeterPropertyDTO> result = calculateController.meterProperty(id);

        //assert
        verify(iHouseService, Mockito.atLeastOnce()).meterProperty(id);
        Assertions.assertEquals(HttpStatus.OK , result.getStatusCode());
        Assertions.assertEquals(expected.getSquareMeter() , result.getBody().getSquareMeter());

    }

    @Test
    public void pricePropertyHappyPath() throws NotFoundException {
        //arrange
        int id=1;
        HousePriceDTO expected = Generator.housePriceDTO();
        when(iHouseService.priceProperty(id)).thenReturn(expected);

        //act
        ResponseEntity<HousePriceDTO> result = calculateController.priceProperty(id);

        //assert
        verify(iHouseService, Mockito.atLeastOnce()).priceProperty(id);
        Assertions.assertEquals(HttpStatus.OK , result.getStatusCode());
        Assertions.assertEquals(expected.getPrice() , result.getBody().getPrice());

    }

    @Test
    public void largestEnvironment() throws NotFoundException {
        //arrange
        int id =1 ;
        HouseLargestEnvironmentDTO expected = Generator.houseLargestEnvironmentDTO();
        when(iHouseService.largestEnvironment(id)).thenReturn(expected);

        //act
        ResponseEntity<HouseLargestEnvironmentDTO> result = calculateController.largestEnvironment(id);

        //assert
        verify(iHouseService, Mockito.atLeastOnce()).largestEnvironment(id);
        Assertions.assertEquals(HttpStatus.OK , result.getStatusCode());
        Assertions.assertEquals(expected.getSquareMeter(), result.getBody().getSquareMeter());
    }

    @Test
    public void meterPerEnvironment() throws NotFoundException {
        //arrange
        HouseMeterPerEnvironmentDTO expected = Generator.houseMeterPerEnvironmentDTO();
        int id=1;
        when(iHouseService.meterPerEnvironment(id)).thenReturn(expected);

        //act
        ResponseEntity<HouseMeterPerEnvironmentDTO> result = calculateController.meterPerEnvironment(id);

        //assert
        verify(iHouseService, Mockito.atLeastOnce()).meterPerEnvironment(id);
        Assertions.assertEquals(HttpStatus.OK , result.getStatusCode());
        Assertions.assertEquals(expected.getMeterPerEnvironment().get("Bath"), result.getBody().getMeterPerEnvironment().get("Bath"));
    }

}

