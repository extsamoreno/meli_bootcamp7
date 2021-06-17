package com.meli.tucasita.dto;

import lombok.Data;

import java.util.List;

@Data
public class RoomsAreasDTO {

    private String address;
    private List<RoomAreaDTO> rooms;

}
