package com.tucasitatasaciones.tucasitatasaciones.services.mappers;

import com.tucasitatasaciones.tucasitatasaciones.repositories.entities.District;
import com.tucasitatasaciones.tucasitatasaciones.repositories.entities.Ownership;
import com.tucasitatasaciones.tucasitatasaciones.repositories.entities.Room;
import com.tucasitatasaciones.tucasitatasaciones.services.dtos.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OwnershipMapper {
    public static OwnershipWithDataDTO entityToOwnershipWithDataDTO(Ownership ownership) {
        var result = new OwnershipWithDataDTO();

        result.setId(ownership.getId());
        result.setName(ownership.getName());
        result.setRooms(roomToRoomDto(ownership.getRooms()));

        return result;
    }

    public static OwnershipWithPriceDTO entityToOwnershipWithPriceDTO(Ownership ownership) {
        var result = new OwnershipWithPriceDTO();

        result.setId(ownership.getId());
        result.setName(ownership.getName());

        return result;
    }

    public static OwnershipWithSquareMeterDTO entityToOwnershipWithSquareMeterDTO(Ownership ownership) {
        var result = new OwnershipWithSquareMeterDTO();

        result.setId(ownership.getId());
        result.setName(ownership.getName());

        return result;
    }

    public static Ownership dtoToEntity(OwnershipWithDataDTO ownership) {
        var result = new Ownership();

        result.setId(ownership.getId());
        result.setName(ownership.getName());
        result.setDistrictId(ownership.getDistrict().getId());
        result.setRooms(roomDtoToRoom(ownership.getRooms()));

        return result;
    }


    // TODO: 16/06/2021 Modify because must in other class or with other library
    public static DistrictDTO districtDtoTODistrict(District district) {
        var result = new DistrictDTO();

        result.setId(district.getId());
        result.setName(district.getName());
        result.setPrice(district.getPrice());

        return result;
    }

    public static RoomWithSquareMeterDTO roomToRoomWithSquareMeterDTO(Room room) {
        RoomWithSquareMeterDTO result = new RoomWithSquareMeterDTO();

        result.setName(room.getName());
        result.setWidth(room.getWidth());
        result.setHigh(room.getHigh());

        return result;
    }

    private static List<RoomDTO> roomToRoomDto(List<Room> rooms) {
        var result = new ArrayList<RoomDTO>();

        for (Room room : rooms) {
            result.add(roomToRoomDto(room));
        }

        return result;
    }

    private static RoomDTO roomToRoomDto(Room room) {
        var result = new RoomDTO();

        result.setName(room.getName());
        result.setHigh(room.getHigh());
        result.setWidth(room.getWidth());

        return result;
    }

    private static List<Room> roomDtoToRoom(List<RoomDTO> rooms) {
        var result = new ArrayList<Room>();

        for (RoomDTO room : rooms) {
            result.add(roomDtoToRoom(room));
        }

        return result;
    }

    private static Room roomDtoToRoom(RoomDTO room) {
        var result = new Room();

        result.setName(room.getName());
        result.setWidth(room.getWidth());
        result.setHigh(room.getHigh());

        return result;
    }
}
