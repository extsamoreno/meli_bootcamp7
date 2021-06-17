package com.example.DesafioTasaciones.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter@Setter@AllArgsConstructor@NoArgsConstructor
public class House {
    private Integer id;
    private String name;
    private District district;
    private List<Room> rooms;
}
