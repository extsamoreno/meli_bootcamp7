package com.meli.squaremeters.domain;

import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class HouseDTO {
    private double totalMeters;
    private double houseValue;
    private Room largestRoom;
    private List<RoomDTO> rooms;
}
