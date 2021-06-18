package com.desafio2.testing.Unit;

import com.desafio2.testing.Controller.PropertyController;
import com.desafio2.testing.Dto.*;
import com.desafio2.testing.Exception.DistrictNonExistentException;
import com.desafio2.testing.Exception.PropertyNonExistentException;
import com.desafio2.testing.Exception.ExistenPropertyException;
import com.desafio2.testing.Service.IPropertyService;
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
    IPropertyService iPropertyService;

    @InjectMocks
    PropertyController propertyController;



    @Test  //CrearCasa
    public void createHouseHappyPath() throws DistrictNonExistentException, ExistenPropertyException {
        //arrange
        PropiedadRequestDTO propiedadDto= UtilTest.crearPropiedadRequestDTO();
        Mockito.when((iPropertyService.createNewProperty(propiedadDto))).thenReturn(true);

        //act
        ResponseEntity<?> received = propertyController.createProperty(propiedadDto);

        //assert
        Mockito.verify(iPropertyService,Mockito.atLeastOnce()).createNewProperty(propiedadDto);
        assertThat(received.getStatusCode().is2xxSuccessful());

    }

    @Test  //CU0001
    public void calcularM2HappyPath() throws PropertyNonExistentException {
        //arrange
        String nombre= "Moldes 100";
        PropertyM2DTO propiedadDto= UtilTest.createPropiedadM2DTO();
        Mockito.when(iPropertyService.calcM2PropDTO(nombre)).thenReturn(propiedadDto);
        //act
        ResponseEntity<PropertyM2DTO> received = propertyController.m2Property(nombre);

        //assert
        Mockito.verify(iPropertyService,Mockito.atLeastOnce()).calcM2PropDTO(nombre);
        assertThat(received.getStatusCode().is2xxSuccessful());
        Assertions.assertEquals(propiedadDto.getM2(),received.getBody().getM2());

    }


    @Test //CU0002
    public void PropiedadValorDTOHappyPath() throws PropertyNonExistentException {
        //arrange
        String nombre= "Moldes 100";
        PropertyValueDTO propiedadDto= UtilTest.crearPropiedadValorDto();
        Mockito.when(iPropertyService.calcPropValueDTO(nombre)).thenReturn(propiedadDto);
        //act
        ResponseEntity<PropertyValueDTO> received = propertyController.valueProp(nombre);

        //assert
        Mockito.verify(iPropertyService,Mockito.atLeastOnce()).calcPropValueDTO(nombre);
        assertThat(received.getStatusCode().is2xxSuccessful());
        Assertions.assertEquals(propiedadDto.getPropertyName(),received.getBody().getPropertyName());
        Assertions.assertEquals(propiedadDto.getValue(),received.getBody().getValue());
    }

    @Test //CU0003
    public void ambienteMasGrandeHappyPath() throws PropertyNonExistentException {
        //arrange
        String nombre= "Moldes 100";
         RoomDTO ambiente= UtilTest.createAmbienteMayorDTO();
        Mockito.when(iPropertyService.calcBiggestRoom(nombre)).thenReturn(ambiente);
        //act
        ResponseEntity<RoomDTO> received = propertyController.biggestRoom(nombre);

        //assert
        Mockito.verify(iPropertyService,Mockito.atLeastOnce()).calcBiggestRoom(nombre);
        assertThat(received.getStatusCode().is2xxSuccessful());
        Assertions.assertEquals(ambiente.getName(),received.getBody().getName());
        Assertions.assertEquals(ambiente.getM2(),received.getBody().getM2());

    }


    @Test //CU0004
    public void PropiedadListaAmbientesM2DTOhappyPath() throws PropertyNonExistentException {
        //arrange
        String nombre= "Moldes 100";
        PropertyRoomListM2DTO propLista= UtilTest.createPropiedadListaAmbientesM2DTO();
        Mockito.when(iPropertyService.calcRoomListM2(nombre)).thenReturn(propLista);

        //act
        ResponseEntity<PropertyRoomListM2DTO> received = propertyController.calcRoomListM2(nombre);

        //assert
        Mockito.verify(iPropertyService,Mockito.atLeastOnce()).calcRoomListM2(nombre);
        assertThat(received.getStatusCode().is2xxSuccessful());
        assertThat(propLista.equals(received.getBody()));
    }





}
