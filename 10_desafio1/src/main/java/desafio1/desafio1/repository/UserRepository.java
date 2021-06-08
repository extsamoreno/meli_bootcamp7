package desafio1.desafio1.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import desafio1.desafio1.domain.User;
import desafio1.desafio1.exception.UserNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class UserRepository implements IUserRepository{
    @Override
    public User findUserById(int userId) throws UserNotFoundException {

        List<User> listUser = null;
        listUser = loadDataBase();
        User userResult = null;

        if(listUser != null){
            userResult = (User)listUser.stream().filter(u -> u.getUserId() == userId);
        }

        if(userResult == null) {
            throw new UserNotFoundException(userId);
        }

        return userResult;
    }


    private List<User> loadDataBase() {
        File file = null;

        try {
            file = ResourceUtils.getFile("classpath:user.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<User>> typeRef = new TypeReference<>() {};
        List<User> listUsers = null;

        try{
            listUsers = objectMapper.readValue(file , typeRef);
        }catch (IOException e){
            e.printStackTrace();
        }
        return listUsers;
    }
}
