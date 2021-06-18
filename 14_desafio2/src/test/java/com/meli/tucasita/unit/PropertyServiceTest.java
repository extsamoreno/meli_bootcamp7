package com.meli.tucasita.unit;

import com.meli.tucasita.dto.PropertyPriceRequestDTO;
import com.meli.tucasita.dto.RoomAreaDTO;
import com.meli.tucasita.dto.RoomDTO;
import com.meli.tucasita.exception.InvalidDistrictException;
import com.meli.tucasita.exception.PropertyAlreadyExistsException;
import com.meli.tucasita.models.Property;
import com.meli.tucasita.repository.DistrictRepositoryImpl;
import com.meli.tucasita.repository.PropertyRepositoryImpl;
import com.meli.tucasita.service.PropertyService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static com.meli.tucasita.util.TestUtils.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PropertyServiceTest {

    @InjectMocks
    PropertyService propertyService;

    @Mock
    PropertyRepositoryImpl propertyRepository;

    @Mock
    DistrictRepositoryImpl districtRepository;

    @Test
    void calculatePropertyAreaOk() {

        // Arrange
        List<RoomDTO> rooms = createRoomDTOList();
        String expected = "El total de metros cuadrados de la propiedad es de 41.5 m2";

        // Act
        String actual = propertyService.getPropertyArea(rooms);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void getPropertyPriceOk() throws InvalidDistrictException {

        // Arrange
        PropertyPriceRequestDTO propertyPriceRequestDTO = createPropertyPriceRequestDTO();
        when(districtRepository.getDistrictByName(propertyPriceRequestDTO.getDistrict())).thenReturn(createDistrict());
        String expected = "El valor total de la propiedad es de USD$ 70550.0";

        // Act
        String actual = propertyService.getPropertyPrice(propertyPriceRequestDTO);

        // Assert
        verify(districtRepository, atLeastOnce()).getDistrictByName(propertyPriceRequestDTO.getDistrict());
        assertEquals(expected, actual);
    }

    @Test
    void getPropertyPriceThrowsInvalidDistrictException() {

        // Arrange
        PropertyPriceRequestDTO propertyPriceRequestDTO = createPropertyPriceRequestDTO();
        when(districtRepository.districtNameNotExists(propertyPriceRequestDTO.getDistrict())).thenReturn(true);

        // Act & Assert
        assertThrows(InvalidDistrictException.class, () -> propertyService.getPropertyPrice(createPropertyPriceRequestDTO()));
    }

    @Test
    void getPropertyBiggestRoomOk() {

        // Arrange
        List<RoomDTO> rooms = createRoomDTOList();
        String expected = "El ambiente más grande de la propiedad es Comedor, que tiene un área de 16.0 m2";

        // Act
        String actual = propertyService.getPropertyBiggestRoom(rooms);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void getropertyRoomsAreasOk() {

        // Arrange
        List<RoomDTO> rooms = createRoomDTOList();
        List<RoomAreaDTO> expected = createRoomAreaDTOList();

        // Act
        List<RoomAreaDTO> actual = propertyService.getRoomsAreas(rooms);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void insertNewPropertyOk() throws PropertyAlreadyExistsException, InvalidDistrictException {

        // Arrange
        Property property = createProperty();
        String expected = "La propiedad se ha registrado correctamente";

        // Act
        String actual = propertyService.insertNewProperty(createPropertyDTO());

        // Assert
        verify(propertyRepository, atLeastOnce()).insertNewProperty(property);
        assertEquals(expected, actual);
    }

    @Test
    void insertNewPropertyThrowsPropertyAlreadyExistsException() {

        // Arrange
        Property property = createProperty();
        when(propertyRepository.propertyAlreadyExists(property.getName())).thenReturn(true);

        // Act & Assert
        assertThrows(PropertyAlreadyExistsException.class, () -> propertyService.insertNewProperty(createPropertyDTO()));
    }

    @Test
    void insertNewPropertyThrowsInvalidDistrictException() {

        // Arrange
        Property property = createProperty();
        when(districtRepository.districtNameNotExists(property.getDistrict())).thenReturn(true);

        // Act & Assert
        assertThrows(InvalidDistrictException.class, () -> propertyService.insertNewProperty(createPropertyDTO()));
    }

}
