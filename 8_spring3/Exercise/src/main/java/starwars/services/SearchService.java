package starwars.services;
import starwars.repositories.Personaje;
import java.util.List;

public interface SearchService {
    public List<Personaje> buscar(String nombre);
}