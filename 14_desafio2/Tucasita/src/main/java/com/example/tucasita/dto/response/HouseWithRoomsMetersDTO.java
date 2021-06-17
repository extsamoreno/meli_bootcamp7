package com.example.tucasita.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class HouseWithRoomsMetersDTO {
    private String name;
    private List<RoomWithMetersDTO> rooms;
}
