package com.desafio2.testing.Dto;

import lombok.*;

import java.util.ArrayList;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyRoomListM2DTO {

    String name;
    ArrayList<RoomDTO> roomList;


}
