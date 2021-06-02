package com.calculadoras.calculadoras.mapper;
import com.calculadoras.calculadoras.entity.House;
import com.calculadoras.calculadoras.entity.Room;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseDTO {
int totalSquareMeters;
int houseValue;
House house;
Room biggerRoom;
List<RoomDTO> roomsDTO;

    public ResponseDTO(int totalSquareMeters) {
        this.totalSquareMeters = totalSquareMeters;
    }

    public ResponseDTO(House house,Room biggerRoom) {
        this.house = house;
        this.biggerRoom = biggerRoom;
    }

    public ResponseDTO(List<RoomDTO> roomsDTO) {
        this.roomsDTO = roomsDTO;
    }



}
