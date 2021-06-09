package com.example.demo;

import com.example.demo.dtos.HouseRequestDTO;
import com.example.demo.dtos.HouseResponseDTO;
import com.example.demo.dtos.RoomDTO;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ApiService {

    public HouseResponseDTO getHouse(HouseRequestDTO houseRequestDTO) {

        HouseResponseDTO houseResponseDTO = new HouseResponseDTO();

        double totalArea = houseRequestDTO.getRooms().stream().mapToDouble((this::calculateArea)).sum();
        //double totalArea = houseRequestDTO.getRooms().stream().mapToDouble((r -> calculateArea(r))).sum();
        houseResponseDTO.setTotalArea(totalArea);

        double price = totalArea * 800;
        houseResponseDTO.setPrice(price);

        RoomDTO mainRoom = getMainRoom(houseRequestDTO.getRooms());
        houseResponseDTO.setMainRoom(mainRoom);

        Map<String, Double> roomsAreas = getRoomsAreas(houseRequestDTO.getRooms());
        houseResponseDTO.setRoomsAreas(roomsAreas);

        return houseResponseDTO;
    }

    private double calculateArea(RoomDTO roomDTO) {
        return roomDTO.getWidth() * roomDTO.getLength();
    }

    private RoomDTO getMainRoom(List<RoomDTO> roomDTOList) {

        RoomDTO mainRoom = new RoomDTO();
        double max = 0;
        for (RoomDTO r : roomDTOList) {

            double rArea = calculateArea(r);

            if (rArea > max) {
                mainRoom = r;
                max = rArea;
            }
        }
        return mainRoom;
    }

    private Map<String, Double> getRoomsAreas(List<RoomDTO> roomDTOList) {

        Map<String, Double> roomsArea = new HashMap<>();

        for (RoomDTO r : roomDTOList) {
            roomsArea.put(r.getName(), calculateArea(r));
        }
        return roomsArea;
    }
}
