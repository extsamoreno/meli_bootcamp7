package com.meli.spring2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApiService {

    public HouseResponseDTO getHouse(HouseRequestDTO houseRequestDTO) {

        HouseResponseDTO houseResponseDTO = new HouseResponseDTO();

        double totalArea = houseRequestDTO.getRooms().stream().mapToDouble((RoomDTO::calculateArea)).sum();
        houseResponseDTO.setTotalArea(totalArea);

        double price = totalArea * 800;
        houseResponseDTO.setPrice(price);

        RoomDTO mainRoom = getMainRoom(houseRequestDTO.getRooms());
        houseResponseDTO.setMainRoom(mainRoom);

        Map<String, Double> roomsAreas = getRoomsAreas(houseRequestDTO.getRooms());
        houseResponseDTO.setRoomsAreas(roomsAreas);

        return houseResponseDTO;
    }

    private RoomDTO getMainRoom(List<RoomDTO> roomDTOList) {

        RoomDTO mainRoom = new RoomDTO();
        double max = 0;
        for (RoomDTO r : roomDTOList) {

            double rArea = r.calculateArea();

            if (rArea > max) {
                mainRoom = r;
                max = rArea;
            }
        }
        return mainRoom;
    }

    private Map<String,Double> getRoomsAreas(List<RoomDTO> roomDTOList){

        Map<String,Double> roomsArea = new HashMap<>();

        for (RoomDTO r : roomDTOList) {
            roomsArea.put(r.getName(), r.calculateArea());
        }
        return roomsArea;
    }
}
