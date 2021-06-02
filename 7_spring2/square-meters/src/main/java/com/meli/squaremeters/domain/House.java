package com.meli.squaremeters.domain;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class House {
    private String name;
    private String address;
    private List<Room> rooms;
}
