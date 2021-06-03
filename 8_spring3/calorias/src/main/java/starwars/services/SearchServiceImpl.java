package starwars.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import starwars.repositories.Personaje;
import starwars.repositories.PersonajeRepository;

import java.util.List;


@Service
public class SearchServiceImpl implements SearchService{

    @Autowired
    PersonajeRepository personajeRepository;

    @Override
    public List<Personaje> buscar(String nombre) {
        return personajeRepository.getMatches(nombre);
    }

}
