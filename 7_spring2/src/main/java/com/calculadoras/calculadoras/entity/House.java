package com.calculadoras.calculadoras.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class House {
    String name,adress;
    List<Room> rooms;
}

