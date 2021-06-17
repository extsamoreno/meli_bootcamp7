package com.example.Challenge2.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor @NoArgsConstructor
public class Property {

    private String name;
    private Long id;
    private List<Room> rooms;
    private Long districtId;

}
