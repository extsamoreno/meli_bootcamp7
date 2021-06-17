package com.desafio2.testing.Unit;

import com.desafio2.testing.Dto.PropiedadM2DTO;
import com.desafio2.testing.Exception.PropiedadInexistenteException;
import com.desafio2.testing.Model.PropiedadModel;
import com.desafio2.testing.Repository.IMiCasitaRespositoryInit;
import com.desafio2.testing.Repository.IPropiedadRepository;
import com.desafio2.testing.Service.IPropiedadService;
import com.desafio2.testing.Service.Mapper.IPropiedadMapper;
import com.desafio2.testing.Service.Mapper.PropiedadMapper;
import com.desafio2.testing.Service.PropiedadService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
public class ServiceTests {

    @Mock
    IPropiedadRepository iPropiedadRepository;

    @Mock
    IPropiedadMapper iPropiedadMapper;

    @InjectMocks
    PropiedadService propiedadService;


    @Test
    public void calcularM2PropiedadDTOok() throws PropiedadInexistenteException {
        // arrange
        PropiedadModel propiedad = UtilTest.createPropiedadModel();// Se llama a Util que crea la propiedad
        PropiedadM2DTO expected = UtilTest.createPropiedadM2DTO(); //trae el dto de la propiedad "propiedad"
        Mockito.when(iPropiedadRepository.getPropiedadByName(propiedad.getProp_name())).thenReturn(propiedad);

        // act
        PropiedadM2DTO received= propiedadService.calcularM2PropiedadDTO("Libertador 5");

        // assert
        verify(iPropiedadRepository,Mockito.atLeastOnce()).getPropiedadByName(propiedad.getProp_name());
        assertEquals(expected, received);
    }







}
