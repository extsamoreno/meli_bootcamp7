package com.example.Challenge2.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor @NoArgsConstructor
public class Room {

    private String name;
    private double width;
    private double length;

}
