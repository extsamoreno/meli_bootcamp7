package com.example.APIHouse.service.dto;

import com.example.APIHouse.repository.Room;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HouseResponseDTO {
    private String name;
    private double areaTotal, price;
    private Room biggerRoom;
    private List<RoomDTO> listRoomsArea;

}
