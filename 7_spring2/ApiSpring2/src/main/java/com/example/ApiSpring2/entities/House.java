package com.example.ApiSpring2.entities;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class House {
    private Integer id;
    private String name, direction;
    private Room[] rooms;
}
