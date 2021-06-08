package desafio1.desafio1.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import desafio1.desafio1.domain.User;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserRepository implements IUserRepository{
    /*@Override
    public List<User> findUserById(String userId) {

        List<User> ListUser = null;
        ListUser = loadDataBase();
        List<Character> listCharacterResult = null;

        if(listCharacters != null){
            listCharacterResult = listCharacters.stream().filter(i -> i.getName().toLowerCase().contains(name.toLowerCase())).collect(Collectors.toList());
        }
        return listCharacterResult;
    }


    private List<User> loadDataBase() {
        File file = null;

        try {
            file = ResourceUtils.getFile("classpath:user.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Character>> typeRef = new TypeReference<>() {};
        List<Character> listCharacters = null;

        try{
            listCharacters = objectMapper.readValue(file , typeRef);
        }catch (IOException e){
            e.printStackTrace();
        }
        return listCharacters;
    }*/
}
