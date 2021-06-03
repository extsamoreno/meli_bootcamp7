package com.example.spring3.classes;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ingredient {
    private String name;
    private Integer calories;
}
