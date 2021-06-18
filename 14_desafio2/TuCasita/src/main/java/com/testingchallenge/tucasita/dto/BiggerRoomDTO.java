package com.testingchallenge.tucasita.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BiggerRoomDTO {
    private String name;
    private RoomDTO room;
}
