package spring3.starwars.Repository.Interfaces;

import spring3.starwars.Models.Entities.SWCharacter;

import java.util.List;

public interface ISWRepository {
    List<SWCharacter> getSWCharByName(String name);
}
