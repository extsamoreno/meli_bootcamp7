package project.starwarsapi.project.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StarwarsRepository implements IStarwarsRepository {

    @Override
    public ArrayList<StarwarsCharacter> getCharactersByName (String name){
        ArrayList<StarwarsCharacter> StarwarsCharacterList = null;
        StarwarsCharacterList = loadDataBase();

        List<StarwarsCharacter> result = null;
        if(StarwarsCharacterList != null){
         result = StarwarsCharacterList.stream()
                    .filter(x -> x.getName().contains(name)).collect(Collectors.toList());
        }

        ArrayList<StarwarsCharacter> finalResult = new ArrayList<>();
        finalResult.addAll(result);
        return finalResult;
    }

    private ArrayList<StarwarsCharacter> loadDataBase() {
        File file = null;
        try{
            file = ResourceUtils.getFile("classpath:starwars.json");
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<ArrayList<StarwarsCharacter>> typeRef = new TypeReference<>() {};
        ArrayList<StarwarsCharacter> starwarsCharacterList = null;

        try{
            starwarsCharacterList = objectMapper.readValue(file, typeRef);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        return starwarsCharacterList;
    }
}
