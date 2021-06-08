package starwars.Repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;
import starwars.Service.CharacterDTO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Repository
public class StarWarsRepository implements IStarWarsRepository {

    @Override
    public List<String> findCharactersByName(String Name) {
        List<CharacterDTO> characterRes = null;
        characterRes = LoadDataBase();
        List<String> result = new ArrayList<>();
        if (characterRes != null) {

            result = characterRes.stream()
                    .filter(character -> character.getName().toLowerCase().contains(Name.toLowerCase()))
                    .map(pj -> pj.getName())
                    .collect(toList());

        }
        return result;
    }

    private List<CharacterDTO> LoadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile( "src/main/resources/static/starwars.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<CharacterDTO>> typeRef = new TypeReference<>() {};
        List<CharacterDTO> characterDTOs = null;
        try {
            characterDTOs = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return characterDTOs;
    }
}
