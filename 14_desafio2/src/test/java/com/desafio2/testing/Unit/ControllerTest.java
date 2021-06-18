package com.desafio2.testing.Unit;

import com.desafio2.testing.Controller.MiCasitaController;
import com.desafio2.testing.Dto.*;
import com.desafio2.testing.Exception.BarrioNoExistException;
import com.desafio2.testing.Exception.PropiedadInexistenteException;
import com.desafio2.testing.Exception.PropiedadYaRegistradaException;
import com.desafio2.testing.Service.IPropiedadService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(MockitoExtension.class)
public class ControllerTest {

    @Mock
    IPropiedadService iPropiedadService;

    @InjectMocks
    MiCasitaController miCasitaController;



    @Test  //CrearCasa
    public void createHouseHappyPath() throws BarrioNoExistException, PropiedadYaRegistradaException {
        //arrange
        PropiedadRequestDTO propiedadDto= UtilTest.crearPropiedadRequestDTO();
        Mockito.when((iPropiedadService.crearPropiedad(propiedadDto))).thenReturn(true);

        //act
        ResponseEntity<?> received = miCasitaController.crearPropiedad(propiedadDto);

        //assert
        Mockito.verify(iPropiedadService,Mockito.atLeastOnce()).crearPropiedad(propiedadDto);
        assertThat(received.getStatusCode().is2xxSuccessful());

    }

    @Test  //CU0001
    public void calcularM2HappyPath() throws PropiedadInexistenteException {
        //arrange
        String nombre= "Moldes 100";
        PropiedadM2DTO propiedadDto= UtilTest.createPropiedadM2DTO();
        Mockito.when(iPropiedadService.calcularM2PropiedadDTO(nombre)).thenReturn(propiedadDto);
        //act
        ResponseEntity<PropiedadM2DTO> received = miCasitaController.m2Propiedad(nombre);

        //assert
        Mockito.verify(iPropiedadService,Mockito.atLeastOnce()).calcularM2PropiedadDTO(nombre);
        assertThat(received.getStatusCode().is2xxSuccessful());
        Assertions.assertEquals(propiedadDto.getM2(),received.getBody().getM2());

    }


    @Test //CU0002
    public void PropiedadValorDTOHappyPath() throws PropiedadInexistenteException {
        //arrange
        String nombre= "Moldes 100";
        PropiedadValorDTO propiedadDto= UtilTest.crearPropiedadValorDto();
        Mockito.when(iPropiedadService.calcularValorPropiedadDTO(nombre)).thenReturn(propiedadDto);
        //act
        ResponseEntity<PropiedadValorDTO> received = miCasitaController.valorProp(nombre);

        //assert
        Mockito.verify(iPropiedadService,Mockito.atLeastOnce()).calcularValorPropiedadDTO(nombre);
        assertThat(received.getStatusCode().is2xxSuccessful());
        Assertions.assertEquals(propiedadDto.getNombrePropiedad(),received.getBody().getNombrePropiedad());
        Assertions.assertEquals(propiedadDto.getValor(),received.getBody().getValor());
    }

    @Test //CU0003
    public void ambienteMasGrandeHappyPath() throws PropiedadInexistenteException {
        //arrange
        String nombre= "Moldes 100";
         AmbienteDTO ambiente= UtilTest.createAmbienteMayorDTO();
        Mockito.when(iPropiedadService.calcularAmbienteMasGrande(nombre)).thenReturn(ambiente);
        //act
        ResponseEntity<AmbienteDTO> received = miCasitaController.ambienteMasGrande(nombre);

        //assert
        Mockito.verify(iPropiedadService,Mockito.atLeastOnce()).calcularAmbienteMasGrande(nombre);
        assertThat(received.getStatusCode().is2xxSuccessful());
        Assertions.assertEquals(ambiente.getNombre(),received.getBody().getNombre());
        Assertions.assertEquals(ambiente.getM2(),received.getBody().getM2());

    }


    @Test //CU0004
    public void PropiedadListaAmbientesM2DTOhappyPath() throws PropiedadInexistenteException {
        //arrange
        String nombre= "Moldes 100";
        PropiedadListaAmbientesM2DTO propLista= UtilTest.createPropiedadListaAmbientesM2DTO();
        Mockito.when(iPropiedadService.calcularListaAmbientesM2(nombre)).thenReturn(propLista);

        //act
        ResponseEntity<PropiedadListaAmbientesM2DTO> received = miCasitaController.calcularListaAmbientesM2(nombre);

        //assert
        Mockito.verify(iPropiedadService,Mockito.atLeastOnce()).calcularListaAmbientesM2(nombre);
        assertThat(received.getStatusCode().is2xxSuccessful());
        assertThat(propLista.equals(received.getBody()));
    }





}
