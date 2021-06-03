package com.starWars;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CharacterDTO {

    private String name, hair_color, skin_color, eye_color, birth_year, gender, homeworld, species;
    private Integer height, mass;
}
