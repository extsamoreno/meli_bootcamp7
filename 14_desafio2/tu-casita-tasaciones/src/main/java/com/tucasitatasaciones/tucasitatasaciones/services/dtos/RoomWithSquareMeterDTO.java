package com.tucasitatasaciones.tucasitatasaciones.services.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomWithSquareMeterDTO extends RoomDTO {
    private double squareMeter;

    public RoomWithSquareMeterDTO(String s, double v, double v1, double v2) {
        super(s, v, v);
        this.squareMeter = v2;
    }
}
