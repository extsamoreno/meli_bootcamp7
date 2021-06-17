package com.meli.calculatorHouseSquareMeters.model.mapper;

import com.meli.calculatorHouseSquareMeters.model.dao.model.District;
import com.meli.calculatorHouseSquareMeters.model.dao.model.House;
import com.meli.calculatorHouseSquareMeters.model.dao.model.Room;
import com.meli.calculatorHouseSquareMeters.model.dto.*;

import java.util.ArrayList;

public class HouseMapper {

    public static House toHouseModel(HouseRequestDTO houseRequestDTO, District district) {
        House house = new House();
        double totalSquareMeters = 0;

        house.setHouseName(houseRequestDTO.getHouseName());
        house.setDistrict(district);
        house.setNumberRooms(houseRequestDTO.getRooms().size());

        for (Room room: houseRequestDTO.getRooms()) {
            double width = room.getWidth();
            double length = room.getLength();
            totalSquareMeters = totalSquareMeters + (width * length);
        }

        house.setTotalSquareMeters(totalSquareMeters);
        house.setTotalPrice(totalSquareMeters * district.getSquareMeterPrice());
        house.setRooms(houseRequestDTO.getRooms());

        return house;
    }

    public static HouseTotalQuantityResponseDTO toHouseTotalQuantityResponseDTO(House house) {
        HouseTotalQuantityResponseDTO houseTotalQuantityResponseDTO;
        return new HouseTotalQuantityResponseDTO(house.getHouseName(), house.getTotalPrice(),
                house.getTotalSquareMeters());
    }

    public static HouseBiggestRoomResponseDTO toHouseBiggestRoomResponseDTO(House house) {
        ArrayList<Room> rooms = house.getRooms();
        double maxSize = 0;
        String nameRoom = null;

        for (Room room: rooms) {
            double size = (room.getWidth() * room.getLength());
            if (size > maxSize) {
                maxSize = size;
                nameRoom = room.getName();
            }
        }

        return new HouseBiggestRoomResponseDTO(house.getHouseName(), nameRoom, maxSize);
    }

    public static HouseRoomListResponseDTO toHouseRoomListResponseDTO(House house) {
        HouseRoomListResponseDTO houseRoomListResponseDTO = new HouseRoomListResponseDTO();
        houseRoomListResponseDTO.setHouseName(house.getHouseName());
        ArrayList<RoomResponseDTO> roomResponseDTOS= new ArrayList<>();
        for (Room room: house.getRooms()) {
            roomResponseDTOS.add(RoomMapper.toRoomResponseDTO(room));
        }
        houseRoomListResponseDTO.setRooms(roomResponseDTOS);
        return houseRoomListResponseDTO;
    }
}
