package com.desafrio2.Desafio1.Service;

import com.desafrio2.Desafio1.Model.DTO.PropDTOTMeters;
import com.desafrio2.Desafio1.Model.DTO.PropRequest;
import com.desafrio2.Desafio1.Model.District;
import com.desafrio2.Desafio1.Model.Environment;
import com.desafrio2.Desafio1.Model.Prop;
import com.desafrio2.Desafio1.Repository.IPropRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PropServiceTest {

    @Mock
    IPropRepository propRepository;

    @InjectMocks
    PropService propService;

    @Test
    void totalSquarMeters() {
        //arrange
        PropRequest propRequests = new PropRequest("Casa1", new District("Villa Prado", 300.0),
                List.of(new Environment("Cocina", 4, 3), new Environment("Habitacion", 6, 5)));
        PropDTOTMeters propDTOTMeters = new PropDTOTMeters("Casa1", 42);
        //act
        PropDTOTMeters response = propService.totalSquarMeters(propRequests);
        //assert
        assertEquals(propDTOTMeters, response);
    }

    @Test
    void priceProp() {
    }

    @Test
    void bigEnviroment() {
    }

    @Test
    void meterByEnviaroment() {
    }
}