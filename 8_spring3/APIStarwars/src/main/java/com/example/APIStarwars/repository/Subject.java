package com.example.APIStarwars.repository;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Subject {
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
