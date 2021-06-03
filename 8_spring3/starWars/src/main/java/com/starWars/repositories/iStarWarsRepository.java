package com.starWars.repositories;


import com.starWars.CharacterDTO;

import java.util.List;

public interface iStarWarsRepository {

    List<CharacterDTO> loadDataBase();
}
