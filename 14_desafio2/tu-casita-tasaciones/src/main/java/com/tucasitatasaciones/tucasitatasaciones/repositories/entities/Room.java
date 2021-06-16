package com.tucasitatasaciones.tucasitatasaciones.repositories.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    private int id;
    private String name;
    private double width;
    private double high;
}
