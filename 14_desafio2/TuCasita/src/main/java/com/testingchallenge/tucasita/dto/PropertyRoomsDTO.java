package com.testingchallenge.tucasita.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

// US004 - get me every room's area in a property

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropertyRoomsDTO {
    private String name;
    private List<RoomDTO> roomList = new ArrayList<>();

    public void addRoom (RoomDTO room) {
        roomList.add(room);
    }
}
