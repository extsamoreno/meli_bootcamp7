package com.meli.tucasita.unit;

import com.meli.tucasita.controller.PropertyController;
import com.meli.tucasita.dto.RoomAreaDTO;
import com.meli.tucasita.exception.InvalidDistrictException;
import com.meli.tucasita.exception.PropertyAlreadyExistsException;
import com.meli.tucasita.service.IPropertyService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static com.meli.tucasita.util.TestUtils.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PropertyControllerTest {

    @Mock
    IPropertyService propertyService;

    @InjectMocks
    PropertyController propertyController;

    @Test
    void calculateSquareMetersOk(){

        // Arrange
        String expected = "El total de metros cuadrados de la propiedad es de 41.5 m2";
        when(propertyService.getPropertyArea(createRoomDTOList())).thenReturn(expected);

        // Act
        ResponseEntity<String> actual = propertyController.calculateSquareMeters(createRoomsDTO());

        // Assert
        verify(propertyService, atLeast(1)).getPropertyArea(createRoomDTOList());
        assertEquals(expected, actual.getBody());

    }

    @Test
    void calculatePropertyPriceOk() throws InvalidDistrictException {

        // Arrange
        String expected = "El valor total de la propiedad es de USD$ 70550.0";
        when(propertyService.getPropertyPrice(createPropertyPriceRequestDTO())).thenReturn(expected);

        // Act
        ResponseEntity<String> actual = propertyController.calculatePropertyPrice(createPropertyPriceRequestDTO());

        // Assert
        verify(propertyService, atLeast(1)).getPropertyPrice(createPropertyPriceRequestDTO());
        assertEquals(expected, actual.getBody());
    }

    @Test
    void getBiggestRoomOk(){

        // Arrange
        String expected = "El ambiente más grande de la propiedad es Comedor, que tiene un área de 16.0 m2";
        when(propertyService.getPropertyBiggestRoom(createRoomDTOList())).thenReturn(expected);

        // Act
        ResponseEntity<String> actual = propertyController.getBiggestRoom(createRoomsDTO());

        // Assert
        verify(propertyService, atLeast(1)).getPropertyBiggestRoom(createRoomDTOList());
        assertEquals(expected, actual.getBody());
    }

    @Test
    void getRoomsAreasOk(){

        // Arrange
        List<RoomAreaDTO> expected = createRoomAreaDTOList();
        when(propertyService.getRoomsAreas(createRoomDTOList())).thenReturn(expected);

        // Act
        ResponseEntity<List<RoomAreaDTO>> actual = propertyController.getRoomsAreas(createRoomsDTO());

        // Assert
        verify(propertyService, atLeast(1)).getRoomsAreas(createRoomDTOList());
        assertEquals(expected, actual.getBody());
    }

    @Test
    void registerNewPropertyOk() throws PropertyAlreadyExistsException, InvalidDistrictException {

        // Arrange
        String expected = "La propiedad se ha registrado correctamente";
        when(propertyService.insertNewProperty(createPropertyDTO())).thenReturn(expected);

        // Act
        ResponseEntity<String> actual = propertyController.addProperty(createPropertyDTO());

        // Assert
        verify(propertyService, atLeast(1)).insertNewProperty(createPropertyDTO());
        assertEquals(expected, actual.getBody());
    }
}
