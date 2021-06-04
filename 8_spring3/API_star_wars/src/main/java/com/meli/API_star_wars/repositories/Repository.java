package com.meli.API_star_wars.repositories;

import com.meli.API_star_wars.service.dto.CharacterResDTO;

import java.util.ArrayList;

public interface Repository {
    ArrayList<CharacterResDTO> returnCharacters(String name);
}
