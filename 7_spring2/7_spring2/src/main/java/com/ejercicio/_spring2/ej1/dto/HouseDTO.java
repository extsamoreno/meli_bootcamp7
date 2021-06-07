package com.ejercicio._spring2.ej1.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HouseDTO {
    private String name;
    private String address;
    private List<RoomDTO> rooms;
}
