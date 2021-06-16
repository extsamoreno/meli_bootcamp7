package com.tucasitatasaciones.tucasitatasaciones.services.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomDTO {
    private String name;
    private double high;
    private double width;
}

