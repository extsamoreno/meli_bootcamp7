package com.desafio2.demo.Service;

import com.desafio2.demo.Exception.DistrictNotExist;
import com.desafio2.demo.Model.DTO.*;
import com.desafio2.demo.Model.District;
import com.desafio2.demo.Model.Mapper.IPropMapper;
import com.desafio2.demo.Repository.IPropRepository;
import com.desafio2.demo.Util.Util;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PropServiceTest {

    @Mock
    IPropRepository propRepository;

    @Mock
    IPropMapper propMapper;

    @InjectMocks
    PropService propService;

    @Test
    void totalSquareMeters() {
        //arrange
        PropRequest propRequests = Util.getPropRequest();
        PropDTOTMeters propDTOTMeters = new PropDTOTMeters("Casa1", 42);
        when(propMapper.toDTOMeters(propRequests, 42.0)).thenReturn(propDTOTMeters);
        //act
        PropDTOTMeters response = propService.totalSquareMeters(propRequests);
        //assert
        assertEquals(propDTOTMeters, response);
    }

    @Test
    void priceProp() throws DistrictNotExist {
        //arrange
        PropRequest propRequests = Util.getPropRequest();
        District district = new District("Villa Prado", 300.0);
        when(propRepository.getDistrictByName(any())).thenReturn(district);
        //Expected prop with price
        PropDTOTPrice propExpected = new PropDTOTPrice("Casa1", 12600);
        when(propMapper.toDTOPrice(propRequests, 12600)).thenReturn(propExpected);
        //act
        PropDTOTPrice response = propService.priceProp(propRequests);
        //assert
        assertEquals(propExpected, response);
        verify(propRepository, atLeastOnce()).getDistrictByName(any());
    }

    @Test
    void bigEnvironment() {
        //arrange
        PropRequest propRequests = Util.getPropRequest();
        EnvironmentDTO env = new EnvironmentDTO("Habitation", 30.0);
        List<EnvironmentDTO> expected = List.of(env);
        when(propMapper.toEnvDTO(any())).thenReturn(env);
        //act
        List<EnvironmentDTO> response = propService.bigEnvironment(propRequests);
        //assert
        assertEquals(expected, response);
    }
    /*
    * If there are one or more with the max area
    * */
    @Test
    void bigEnvironmentDuplicateDimensions() {
        //arrange
        PropRequest propRequests = Util.getPropRequestDuplicateDimensions();
        //DTO response mapeo
        EnvironmentDTO env = new EnvironmentDTO("Habitation", 30.0);
        EnvironmentDTO env2 = new EnvironmentDTO("Habitation2", 30.0);
        List<EnvironmentDTO> expected = List.of(env, env2);
        when(propMapper.toEnvDTO(propRequests.getEnvironments().get(0))).thenReturn(env);
        when(propMapper.toEnvDTO(propRequests.getEnvironments().get(1))).thenReturn(env2);
        //act
        List<EnvironmentDTO> response = propService.bigEnvironment(propRequests);
        //assert
        assertEquals(expected, response);
    }

    @Test
    void meterByEnvironment() {
        //arrange
        PropRequest propRequests = Util.getPropRequest();
        PropDTOTMeterByEnvironment expected = new PropDTOTMeterByEnvironment(propRequests.getName(),
                List.of(new EnvironmentDTO("Kitchen", 12.0), new EnvironmentDTO("Habitation", 30.0)));
        when(propMapper.toPropByMeter(any())).thenReturn(expected);
        //act
        PropDTOTMeterByEnvironment prop = propService.meterByEnvironment(propRequests);
        //assert
        assertEquals(expected, prop);
    }
}