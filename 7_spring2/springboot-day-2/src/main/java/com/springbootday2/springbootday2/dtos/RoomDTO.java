package com.springbootday2.springbootday2.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RoomDTO {
    private String name;
    private float high, width;
    private float meters;

    public RoomDTO(String name, float meters) {
        this.name = name;
        this.meters = meters;
    }
}
