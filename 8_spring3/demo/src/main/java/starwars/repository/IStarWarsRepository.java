package starwars.repository;



import starwars.entity.MovieCharacter;

import java.util.List;

public interface IStarWarsRepository {
    public List<MovieCharacter> getCharacterByName(String name);
}

