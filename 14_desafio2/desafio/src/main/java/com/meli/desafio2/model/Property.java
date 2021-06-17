package com.meli.desafio2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Property {

    Long id;
    String name;
    District district;
    List<Room> rooms;
}
