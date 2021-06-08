package starwars.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class CharacterDTO {
    private String name,hair_color, skin_color, eye_color, birth_year, gender, homeworld,species, height, mass;
}
