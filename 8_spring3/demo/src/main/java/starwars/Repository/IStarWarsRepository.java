package starwars.Repository;


import java.util.List;

public interface IStarWarsRepository {

    List<String> findCharactersByName(String Name);
}
