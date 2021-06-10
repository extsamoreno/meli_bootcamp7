package com.example.demo.repositories;

import com.example.demo.entities.User;
import com.example.demo.DTO.UserDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class UserRepository implements IUserRepository {

    String userPathFile = System.getProperty("user.dir") + "/src/main/resources/data/users.json";

    List<User> users = loadUsers();

    @Override
    public User getById(int userId) {

        User result = null;
        if (users != null) {
            User item = users.stream()
                    .filter(user -> user.getUserId() == userId)
                    .findAny().orElse(null);
            result = item;
        }

        return result;
    }

    @Override
    public List<User> loadUsers() {
        File file = null;
        try {
            file = ResourceUtils.getFile(userPathFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<User>> typeRef = new TypeReference<>() {
        };
        List<User> users = null;
        try {
            users = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void saveUsers() {
        File file = null;
        try {
            file = ResourceUtils.getFile(userPathFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            objectMapper.writeValue(file, users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getSellersFollowedByUser(User user) {
        List<User> items = new ArrayList<>();

        for (User seller : users) {
            if(seller.getFollowers() != null){
                User userSeller = seller.getFollowers().stream().filter(userAux -> userAux.getUserId() == user.getUserId()).findAny().orElse(null);
                if(userSeller!= null){items.add(seller);};
            }
        }
        return items;
    }

    @Override
    public void unFollowSeller(User user, User seller) {
        User userToDelete = seller.getFollowers().stream()
                .filter(userAux -> userAux.getUserId() == user.getUserId())
                .findAny().orElse(null);

        seller.getFollowers().remove(userToDelete);
    }

    @Override
    public List<UserDTO> sortByCriteria(List<UserDTO> list, String order) {

        if (order.equals("name_desc")) {
            list.sort((name1, name2) -> name2.getUserName().compareTo(name1.getUserName()));
        } else {
            list.sort(Comparator.comparing(UserDTO::getUserName));
        }
        return list;
    }

}
