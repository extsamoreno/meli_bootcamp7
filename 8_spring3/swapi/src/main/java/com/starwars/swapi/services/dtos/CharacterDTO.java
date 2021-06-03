package com.starwars.swapi.services.dtos;

import lombok.*;

@Data
public class CharacterDTO {
    private String name;

    public CharacterDTO(String name) {
        this.name = name;
    }
}
