package com.tucasitatasaciones.tucasitatasaciones.repositories.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ownership {
    private int id;
    private String name;
    private List<Room> rooms;
    private int districtId;
}
