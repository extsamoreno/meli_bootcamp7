package com.starwars.api.dto;

import lombok.*;

@AllArgsConstructor @NoArgsConstructor
@Setter @Getter
public class CaracterResponseDTO {
    private String name;
    private String height;
    private String mass;
    private String hair_color;
    private String skin_color;
    private String eye_color;
    private String birth_year;
    private String gender;
    private String homeworld;
    private String species;
}
