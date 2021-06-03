package spring3.starwars.Services.Implementations;

import org.springframework.stereotype.Service;
import spring3.starwars.Models.Entities.SWCharacter;
import spring3.starwars.Repository.Interfaces.ISWRepository;
import spring3.starwars.Services.Interfaces.ISWCharacterService;

import java.util.List;

@Service
public class SWCharacterService implements ISWCharacterService {
    ISWRepository iSWRepository;

    public SWCharacterService(ISWRepository iSWRepository) {
        this.iSWRepository = iSWRepository;
    }

    @Override
    public List<SWCharacter> findCharByName(String name) {
        return this.iSWRepository.getSWCharByName(name);
    }
}
