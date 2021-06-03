package spring3.starwars.Repository.Implementations;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;
import spring3.demo.Models.Entities.Ingredient;
import spring3.starwars.Models.Entities.SWCharacter;
import spring3.starwars.Repository.Interfaces.ISWRepository;

import java.io.File;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Repository
public class SWRepository implements ISWRepository {
    List<SWCharacter> lSWCharacter = null;

    public SWRepository(List<SWCharacter> lSWCharacter) {
        this.lSWCharacter = loadSWJSON();
    }

    @Override
    public List<SWCharacter> getSWCharByName(String name) {
        return this.lSWCharacter.stream().filter(swCharacter -> swCharacter.getName().toLowerCase(Locale.ROOT)
                .contains(name.toLowerCase(Locale.ROOT))).collect(Collectors.toList());
    }

    private List<SWCharacter> loadSWJSON(){
        File file = null;

        try {
            file = ResourceUtils.getFile("classpath:static/starwars.json");
        }catch (Exception e){
            e.printStackTrace();
        }

        ObjectMapper omapper = new ObjectMapper();
        TypeReference<List<SWCharacter>> typeRef= new TypeReference<>(){};
        List<SWCharacter> lSWCharacter = null;

        try{
            lSWCharacter = omapper.readValue(file, typeRef);
        }catch (Exception e){
            e.printStackTrace();
        }

        return lSWCharacter;
    }
}
