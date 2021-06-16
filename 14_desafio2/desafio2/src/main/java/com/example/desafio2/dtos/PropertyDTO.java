package com.example.desafio2.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropertyDTO {
    private String name;
    private DistrictDTO district;
    private List<RoomDTO> roomList;
}
