package starwars.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import starwars.Repository.IStarWarsRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class StarWarsService implements IStarWarsService {

    @Autowired
    IStarWarsRepository starWarsRepository;

    @Override
    public List<String> findCharacters(String character) {
        List<String> characters = starWarsRepository.findCharactersByName(character);

        return characters;
    }
}
