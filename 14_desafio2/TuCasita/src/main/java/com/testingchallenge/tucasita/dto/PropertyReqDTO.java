package com.testingchallenge.tucasita.dto;

import com.testingchallenge.tucasita.model.Room;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyReqDTO {
    private String name;
    private String neighborhood;
    private List<Room> roomList;
}
