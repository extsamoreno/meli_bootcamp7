package com.desafio.TuCasitaTasacionesApp.Unit;

import com.desafio.TuCasitaTasacionesApp.controllers.CalculateRestController;
import com.desafio.TuCasitaTasacionesApp.model.dto.PropietyDTOResponseCost;
import com.desafio.TuCasitaTasacionesApp.model.dto.PropietyDTOResponseTotalMeters;
import com.desafio.TuCasitaTasacionesApp.model.dto.RoomDTO;
import com.desafio.TuCasitaTasacionesApp.model.dto.RoomMetersListResponseDTO;
import com.desafio.TuCasitaTasacionesApp.model.exceptions.NeighborhoodNotFoundException;
import com.desafio.TuCasitaTasacionesApp.model.exceptions.PropietyNotFoundException;
import com.desafio.TuCasitaTasacionesApp.model.service.ICalculateService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CalculateRestControllerTest{

    @Mock
    ICalculateService iCalculateService;

    @InjectMocks
    CalculateRestController calculateRestController;

    @Test
    void getSquareMeterForPropietyHappyPath() throws Exception {
        //arrange
        HttpStatus expected = HttpStatus.OK;
        PropietyDTOResponseTotalMeters propietyDTO = new PropietyDTOResponseTotalMeters();
        //act
        when(iCalculateService.getSquareMeterForPropiety("name")).thenReturn(propietyDTO);
        ResponseEntity<PropietyDTOResponseTotalMeters> propiety = calculateRestController.getSquareMeterForPropiety("name");

        //assert
        verify(iCalculateService, Mockito.atLeast(1)).getSquareMeterForPropiety("name");
        assertEquals(expected ,propiety.getStatusCode());
        assertEquals(propietyDTO, propiety.getBody());
    }

    @Test
    void getSquareMeterForPropiety_nameNotFound_PropietyNotFoundException() throws PropietyNotFoundException {
        //arrange
        String name = "name";
        HttpStatus expected = HttpStatus.BAD_REQUEST;
        when(iCalculateService.getSquareMeterForPropiety(name)).thenThrow(new PropietyNotFoundException(name));
        assertThrows(PropietyNotFoundException.class,() ->calculateRestController.getSquareMeterForPropiety(name));
        verify(iCalculateService, Mockito.atLeast(1)).getSquareMeterForPropiety(name);

    }


    //-----------------------------//


    @Test
    void getValueForPropietyHappyPath() throws PropietyNotFoundException, NeighborhoodNotFoundException {
        //arrange
        HttpStatus expected = HttpStatus.OK;

        //act
        when(iCalculateService.getValueForPropiety("name")).thenReturn(new PropietyDTOResponseCost());
        ResponseEntity<PropietyDTOResponseCost> propiety = calculateRestController.getValueForPropiety("name");

        //assert
        verify(iCalculateService, Mockito.atLeast(1)).getValueForPropiety("name");
        assertEquals(expected ,propiety.getStatusCode());
    }

    @Test
    void getValueForPropiety_nameNotFound_PropietyNotFoundException() throws PropietyNotFoundException, NeighborhoodNotFoundException {
        //arrange
        String name = "name";
        HttpStatus expected = HttpStatus.BAD_REQUEST;
        when(iCalculateService.getValueForPropiety(name)).thenThrow(new PropietyNotFoundException(name));
        assertThrows(PropietyNotFoundException.class,() ->calculateRestController.getValueForPropiety(name));
        verify(iCalculateService, Mockito.atLeast(1)).getValueForPropiety(name);
    }


    //-----------------------------//

    @Test
    void getBiggestRoomHappyPath() throws PropietyNotFoundException {
        //arrange
        HttpStatus expected = HttpStatus.OK;

        //act
        when(iCalculateService.getBiggestRoom("name")).thenReturn(new RoomDTO());
        ResponseEntity<RoomDTO> propiety = calculateRestController.getBiggestRoom("name");

        //assert
        verify(iCalculateService, Mockito.atLeast(1)).getBiggestRoom("name");
        assertEquals(expected ,propiety.getStatusCode());
    }

    @Test
    void getSquareMeterForRoomHappyPath() throws PropietyNotFoundException {
        //arrange
        HttpStatus expected = HttpStatus.OK;

        //act
        when(iCalculateService.getSquareMeterForRoom("name")).thenReturn(new RoomMetersListResponseDTO());
        ResponseEntity<RoomMetersListResponseDTO> propiety = calculateRestController.getSquareMeterForRoom("name");

        //assert
        verify(iCalculateService, Mockito.atLeast(1)).getSquareMeterForRoom("name");
        assertEquals(expected ,propiety.getStatusCode());
    }
}
