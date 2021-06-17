package com.desafrio2.Desafio1.Service;

import com.desafrio2.Desafio1.Exception.DistrictNotExist;
import com.desafrio2.Desafio1.Model.DTO.*;
import com.desafrio2.Desafio1.Model.District;
import com.desafrio2.Desafio1.Model.Mapper.IPropMapper;
import com.desafrio2.Desafio1.Repository.IPropRepository;
import com.desafrio2.Desafio1.Util.Util;
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
        EnvironmentDTO expected = new EnvironmentDTO("Habitation", 30.0);
        when(propMapper.toEnvDTO(any())).thenReturn(expected);
        //act
        EnvironmentDTO response = propService.bigEnvironment(propRequests);
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