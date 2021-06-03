package clase8.spring3.ejercicio2.service;
import clase8.spring3.ejercicio2.domain.Character;
import clase8.spring3.ejercicio2.repository.ICharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StarwarsService implements IStarwarsService {

    @Autowired
    ICharacterRepository iCharacterRepository;

    @Override
    public List<Character> findCharactersByName(String name) {
        return iCharacterRepository.getCharacterByName(name);
    }
}
