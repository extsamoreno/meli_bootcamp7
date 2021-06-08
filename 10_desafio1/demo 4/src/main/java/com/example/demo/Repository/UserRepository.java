package com.example.demo.Repository;

import com.example.demo.Entities.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserRepository implements IUserRepository {

    List<User> users = loadUsers();

    @Override
    public User getById(int userId) {

        User result = null;
        if(users != null){
            User item = users.stream()
                    .filter(user -> user.getUserId() == userId)
                    .findAny().orElse(null);
            result = item;
        }

        return result;
    }

    @Override
    public List<User> loadUsers(){
        File file = null;
        try{
            file = ResourceUtils.getFile("/Users/ctaeger/Desktop/RepoBootcampTaeger-Camila/meli_bootcamp7/10_desafio1/demo 4/src/main/java/com/example/demo/Repository/Data/Users.json");
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<User>> typeRef = new TypeReference<>(){};
        List<User> users = null;
        try{
            users = objectMapper.readValue(file,typeRef);
        }catch(IOException e){
            e.printStackTrace();
        }
        return users;
    }

}
