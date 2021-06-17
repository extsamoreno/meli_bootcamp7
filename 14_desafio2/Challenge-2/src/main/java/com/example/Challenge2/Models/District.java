package com.example.Challenge2.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class District {

    private Long id;
    private String name;
    private double pricePerM2;
}
