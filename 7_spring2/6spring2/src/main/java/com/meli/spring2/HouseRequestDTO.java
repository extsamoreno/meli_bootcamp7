package com.meli.spring2;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class HouseRequestDTO {

    private String name;

    private String address;

    private List<RoomDTO> rooms;
}

