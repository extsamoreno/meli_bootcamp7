package com.spring3.spring3.PracticoMañana.Classes;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Food {
    private String name;
    private List<Ingredient> ingredients;
}
