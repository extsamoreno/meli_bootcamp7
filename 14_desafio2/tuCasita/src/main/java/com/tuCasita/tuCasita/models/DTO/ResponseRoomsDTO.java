package com.tuCasita.tuCasita.models.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseRoomsDTO {

    private String houseName;
    private ArrayList<RoomDTO> resultList;
}
