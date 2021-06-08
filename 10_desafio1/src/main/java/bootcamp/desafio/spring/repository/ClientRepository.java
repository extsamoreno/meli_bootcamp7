package bootcamp.desafio.spring.repository;

import bootcamp.desafio.spring.model.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository implements IClientRepository{


    ArrayList<User> dbUser;

    public ClientRepository() {
        this.dbUser= this.LoadDataBase();;
    }

    @Override
    public List<User> findAll(){
        return dbUser;
    }

    @Override
    public Optional<User> findById(Long id) {
        Optional<User> userFilter = dbUser
                .stream()
                .filter(localUser -> localUser.getUserId().equals(id))
                .findFirst();
        return userFilter;
    }

    @Override
    public User save(User user){
        Optional<User> userFilter = dbUser
                .stream()
                .filter(localUser -> localUser.getUserId().equals(user.getUserId()))
                .findFirst();
        if(userFilter.isPresent()){
            dbUser.remove(userFilter);
        }
        dbUser.add(user);
        return user;
    }



    private ArrayList<User> LoadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile( "src/main/resources/static/users.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<ArrayList<User>> typeRef = new TypeReference<>() {};
        ArrayList<User> users = null;
        try {
            users = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

}
