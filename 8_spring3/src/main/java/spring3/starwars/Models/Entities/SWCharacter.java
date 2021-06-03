package spring3.starwars.Models.Entities;

import lombok.Data;

@Data
public class SWCharacter {
    String name;
    Object height;
    Object mass;
    String hair_color;
    String skin_color;
    String eye_color;
    String birth_year;
    String gender;
    String homeworld;
    String species;
}
