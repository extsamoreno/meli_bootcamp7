package com.desafrio2.Desafio1.Service;

import com.desafrio2.Desafio1.Exception.DistrictNotExist;
import com.desafrio2.Desafio1.Model.DTO.PropDTOTMeters;
import com.desafrio2.Desafio1.Model.DTO.PropDTOTPrice;
import com.desafrio2.Desafio1.Model.DTO.PropRequest;
import com.desafrio2.Desafio1.Model.District;
import com.desafrio2.Desafio1.Model.Environment;
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
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PropServiceTest {

    @Mock
    IPropRepository propRepository;

    @Mock
    IPropMapper propMapper;

    @InjectMocks
    PropService propService;

    @Test
    void totalSquarMeters() {
        //arrange
        PropRequest propRequests = Util.getPropRequest();
        PropDTOTMeters propDTOTMeters = new PropDTOTMeters("Casa1", 42);
        when(propMapper.toDTOMeters(propRequests, 42.0)).thenReturn(propDTOTMeters);
        //act
        PropDTOTMeters response = propService.totalSquartMeters(propRequests);
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
    }

    @Test
    void bigEnviroment() {
    }

    @Test
    void meterByEnviaroment() {
    }
}