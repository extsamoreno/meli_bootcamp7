package starwars.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import starwars.entity.MovieCharacter;
import starwars.repository.IStarWarsRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class StarWarsService implements IStarWarsService{
    @Autowired
    IStarWarsRepository iStarWarsRepository;

    @Override
    public List<MovieCharacter> getCharacterByName(String name) {
        return iStarWarsRepository.getCharacterByName(name);
    }
}
