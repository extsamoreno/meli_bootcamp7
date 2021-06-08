package starwars.repositories;

import java.util.List;

public interface PersonajeRepository {
    List<Personaje> getMatches(String name);
}
