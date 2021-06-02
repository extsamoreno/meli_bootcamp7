package com.meli.squaremeters.domain;

import lombok.*;

@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
public class Room {
    private String name;
    private double width;
    private double length;
}
