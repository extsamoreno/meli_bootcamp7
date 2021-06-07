package com.example.demo.classes;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Character {

    private String name;
    private Object height;
    private Object mass;
    private String hair_color;
    private String skin_color;
    private String eye_color;
    private String birth_year;
    private String gender;
    private String homeworld;
    private String species;

}
