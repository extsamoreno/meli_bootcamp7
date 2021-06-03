package com.starWars;

import java.util.List;

public interface iStarWarsService {

    List<CharacterDTO> getCharactersByName(String word);

}
