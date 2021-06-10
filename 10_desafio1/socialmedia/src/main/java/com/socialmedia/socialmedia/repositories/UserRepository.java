package com.socialmedia.socialmedia.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.socialmedia.socialmedia.exceptions.ObjectNotFoundException;
import com.socialmedia.socialmedia.exceptions.UserNotFoundException;
import com.socialmedia.socialmedia.repositories.entities.Follower;
import com.socialmedia.socialmedia.repositories.entities.User;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class UserRepository implements IUserRepository, IRepository<User> {

    @Override
    public int add(User object) {
        List<User> users = loadDatabaseUsers();
        int newId = users.size() + 1;

        object.setId(newId);

        users.add(object);

        return newId;
    }

    @Override
    public User update(User object) throws ObjectNotFoundException {
        List<User> users = loadDatabaseUsers();

        User userTemp = getById(object.getId());

        Optional<User> optional = users.stream().filter(x -> x.getId() == userTemp.getId()).findFirst();

        if (!optional.isPresent()) throw new ObjectNotFoundException(object.getId());

        int index = users.indexOf(optional.get());

        users.set(index, object);

        updateDatabaseUsers(users);

        return object;
    }

    @Override
    public User getById(int id) throws ObjectNotFoundException {
        List<User> users = loadDatabaseUsers();

        Optional<User> result = users.stream()
                .filter(user -> user.getId() == id)
                .findFirst();

        if (!result.isPresent()) throw new ObjectNotFoundException(id);

        var resultObject = result.get();

        return resultObject;
    }

    private List<User> loadDatabaseUsers() {
        File file = null;

        try {
            file = ResourceUtils.getFile("src/main/resources/users.json");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            file = null;
        }
        ObjectMapper objectMapper = new ObjectMapper();

        TypeReference<List<User>> typeReference = new TypeReference<>() {
        };
        List<User> users = null;
        try {
            users = objectMapper.readValue(file, typeReference);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return users;
    }

    private void updateDatabaseUsers(List<User> followers) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String jsonString = objectMapper.writeValueAsString(followers);

            FileWriter myWriter = new FileWriter("src/main/resources/users.json", false);
            myWriter.write(jsonString);
            myWriter.close();

        } catch (Exception ex) {
            System.out.println("Error al convertir a json");
            ex.printStackTrace();
        }
    }
}
