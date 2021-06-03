package spring3.starwars.Services.Interfaces;

import spring3.starwars.Models.Entities.SWCharacter;

import java.util.List;

public interface ISWCharacterService {
    public List<SWCharacter> findCharByName(String name);
}
