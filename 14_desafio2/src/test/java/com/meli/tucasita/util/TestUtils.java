package com.meli.tucasita.util;

import com.meli.tucasita.dto.*;
import com.meli.tucasita.models.District;
import com.meli.tucasita.models.Property;

import java.util.ArrayList;
import java.util.List;

import static com.meli.tucasita.mapper.PropertyMapper.mapPropertyFromDTO;

public class TestUtils {

    public static Property createProperty() {

        return mapPropertyFromDTO(createPropertyDTO());
    }

    public static PropertyDTO createPropertyDTO(){

        PropertyDTO propertyDTO = new PropertyDTO();
        propertyDTO.setName("Medrano 78");
        propertyDTO.setDistrict("Caballito");
        propertyDTO.setRooms(createRoomDTOList());

        return propertyDTO;
    }

    public static List<RoomAreaDTO> createRoomAreaDTOList() {

        return new ArrayList<>() {
            {
                add(new RoomAreaDTO("Comedor", 16));
                add(new RoomAreaDTO("Dormitorio 1", 9));
                add(new RoomAreaDTO("Dormitorio 2", 10.5));
                add(new RoomAreaDTO("Cocina", 6));
            }
        };
    }

    public static District createDistrict() {

        return new District("Caballito", 1700);
    }

   public static PropertyPriceRequestDTO createPropertyPriceRequestDTO() {

        PropertyPriceRequestDTO propertyPriceRequestDTO = new PropertyPriceRequestDTO();
        propertyPriceRequestDTO.setDistrict("Caballito");
        propertyPriceRequestDTO.setRooms(createRoomDTOList());

        return propertyPriceRequestDTO;
    }

    public static RoomsDTO createRoomsDTO(){
        return new RoomsDTO(createRoomDTOList());
    }

    public static List<RoomDTO> createRoomDTOList() {
        return new ArrayList<>() {
            {
                add(new RoomDTO("Comedor", 4, 4));
                add(new RoomDTO("Dormitorio 1", 3, 3));
                add(new RoomDTO("Dormitorio 2", 3.5, 3));
                add(new RoomDTO("Cocina", 2, 3));
            }
        };
    }

}
