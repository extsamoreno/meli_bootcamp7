package starwars.service;


import starwars.entity.MovieCharacter;

import java.util.List;

import java.util.List;

public interface IStarWarsService {
    public List<MovieCharacter> getCharacterByName(String name);
}
