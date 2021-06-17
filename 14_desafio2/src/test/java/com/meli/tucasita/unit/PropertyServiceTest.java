package com.meli.tucasita.unit;

import com.meli.tucasita.dto.PropertyPriceRequestDTO;
import com.meli.tucasita.dto.RoomAreaDTO;
import com.meli.tucasita.dto.RoomDTO;
import com.meli.tucasita.exception.PropertyAlreadyExistsException;
import com.meli.tucasita.models.Property;
import com.meli.tucasita.repository.DistrictRepository;
import com.meli.tucasita.repository.PropertyRepositoryImpl;
import com.meli.tucasita.service.PropertyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static com.meli.tucasita.TestUtils.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PropertyServiceTest {

    @InjectMocks
    PropertyService propertyService;

    @Mock
    PropertyRepositoryImpl propertyRepository;

    @Mock
    DistrictRepository districtRepository;

    @Test
    public void calculateUnknownPropertyAreaOk() {

        // arrange
        List<RoomDTO> rooms = createRoomDTOList();
        String expected = "El total de metros cuadrados de la propiedad es de 41.5 m2";

        // act
        String actual = propertyService.calculateUnknownPropertyArea(rooms);

        // assert
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getUnknownPropertyPriceOk() {

        // arrange
        PropertyPriceRequestDTO propertyPriceRequestDTO = createPropertyPriceRequestDTO();
        when(districtRepository.getDistrictByName(propertyPriceRequestDTO.getDistrict())).thenReturn(createDistrict());
        String expected = "El valor total de la propiedad es de USD$ 70550.0";


        // act
        String actual = propertyService.getUnknownPropertyPrice(propertyPriceRequestDTO);

        // assert
        verify(districtRepository, atLeastOnce()).getDistrictByName(propertyPriceRequestDTO.getDistrict());
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getUnknownPropertyBiggestRoomOk() {

        // arrange
        List<RoomDTO> rooms = createRoomDTOList();
        String expected = "El ambiente más grande de la propiedad es Comedor, que tiene un área de 16.0 m2";

        // act
        String actual = propertyService.getUnknownPropertyBiggestRoom(rooms);

        // assert
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getUnknownPropertyRoomsAreasOk() {

        // arrange
        List<RoomDTO> rooms = createRoomDTOList();
        List<RoomAreaDTO> expected = createRoomAreaDTOList();

        // act
        List<RoomAreaDTO> actual = propertyService.getUnknownPropertyRoomsAreas(rooms);

        // assert
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void insertNewPropertyOk() throws PropertyAlreadyExistsException {

        // arrange
        Property property = createProperty();
        String expected = "La propiedad se ha registrado correctamente";

        // act
        String actual = propertyService.insertNewProperty(createPropertyDTO());

        // assert
        verify(propertyRepository, atLeastOnce()).insertNewProperty(property);
        Assertions.assertEquals(expected, actual);
    }
}
