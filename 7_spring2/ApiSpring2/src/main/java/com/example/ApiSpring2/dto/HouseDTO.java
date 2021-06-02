package com.example.ApiSpring2.dto;

import com.example.ApiSpring2.entities.Room;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class HouseDTO {
    private String name, direction;
    private Room[] rooms;
}
