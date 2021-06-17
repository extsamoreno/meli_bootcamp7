package desafio2.testing.unit;

import desafio2.testing.domian.EnvironmentHouse;
import desafio2.testing.domian.House;
import desafio2.testing.exception.NotFoundException;
import desafio2.testing.repository.IHouseRepository;
import desafio2.testing.service.HouseService;
import desafio2.testing.service.dto.HouseDTO;
import desafio2.testing.service.dto.HouseLargestEnvironmentDTO;
import desafio2.testing.service.dto.HouseMeterPerEnvironmentDTO;
import desafio2.testing.service.dto.HouseMeterPropertyDTO;
import desafio2.testing.util.Generator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;


import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ServiceTest {
    //supongo que todas las validaciones
    // son correctas ytesteo que los metodos devuelvan lo que tienen que devolver

    @Mock
    IHouseRepository iHouseRepository;

    @InjectMocks
    HouseService houseService;

    @Test
    public void meterPropertyHappyPath() throws NotFoundException {
        //arrange
        int id = 1;

        House house = Generator.house();
        when(iHouseRepository.findHouseById(id)).thenReturn(house);

        HouseMeterPropertyDTO expected = Generator.getArea();

        //act
        HouseMeterPropertyDTO result = houseService.meterProperty(id);

        //assert
        verify(iHouseRepository, Mockito.atLeastOnce()).findHouseById(id);
        Assertions.assertEquals(expected,result);
    }


    @Test
    public void largestEnvironmentHappyPath() throws NotFoundException {
        //arrange
        int id = 1;
        House house = Generator.house();
        when(iHouseRepository.findHouseById(id)).thenReturn(house);

        double expected = 300.0;

        //act
        HouseLargestEnvironmentDTO result = houseService.largestEnvironment(id);

        //assert
        verify(iHouseRepository, Mockito.atLeastOnce()).findHouseById(id);
        Assertions.assertEquals(expected,result.getSquareMeter());
    }

    @Test //I check only one environment, because if one works well, the others also
    public void meterPerEnvironmentHappyPath() throws NotFoundException {
        //arrange
        Integer id = 1;
        House house = Generator.house();
        when(iHouseRepository.findHouseById(id)).thenReturn(house);

        double expected = 4.0;

        //act
        HouseMeterPerEnvironmentDTO result = houseService.meterPerEnvironment(id);
        double resultDouble = result.getMeterPerEnvironment().get("bath");

        //assert
        verify(iHouseRepository, Mockito.atLeastOnce()).findHouseById(id);
        Assertions.assertEquals(expected,resultDouble);
    }


}















