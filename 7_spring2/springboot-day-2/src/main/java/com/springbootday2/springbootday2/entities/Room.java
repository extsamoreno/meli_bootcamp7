package com.springbootday2.springbootday2.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Room {
    private String name;
    private float high, width;
}
