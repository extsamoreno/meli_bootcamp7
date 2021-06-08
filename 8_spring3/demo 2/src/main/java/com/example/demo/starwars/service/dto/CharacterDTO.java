package com.example.demo.starwars.service.dto;

import com.example.demo.starwars.repository.CharacterStarWars;
import lombok.*;

import java.util.ArrayList;
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class CharacterDTO {
    private ArrayList<CharacterStarWars> listCharacters;
}
