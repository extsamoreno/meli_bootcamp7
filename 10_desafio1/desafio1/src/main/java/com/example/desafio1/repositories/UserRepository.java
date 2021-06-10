package com.example.desafio1.repositories;

import com.example.desafio1.dtos.UserDTO;
import com.example.desafio1.exceptions.user.InvalidUserIdException;
import com.example.desafio1.models.Post;
import com.example.desafio1.models.Product;
import com.example.desafio1.models.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class UserRepository implements IUserRepository {
    protected HashMap<Integer, User> users = new HashMap<>();

    @Override
    public String createDB() {
        /*
        List<User> users = loadDateBase();
        for(User u : users) {
            this.users.put(u.getUserId(), u);
        }
        */
        users = loadDateBaseManually();
        return "Base de datos inicializada";
    }

    @Override
    public User getUserById(int userId) throws InvalidUserIdException {
        User user = users.get(userId);
        if(user == null) {
            throw new InvalidUserIdException(userId);
        }
        return user;
    }

    private List<User> loadDateBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:users.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<User>> typeRef = new TypeReference<>(){};
        List<User>  userList = null;
        try {
            userList = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userList;
    }

    private HashMap<Integer, User> loadDateBaseManually() {
        HashMap<Integer, User> users = new HashMap<>();

        List<Integer> followed = new ArrayList<>();
        List<Integer> followers = new ArrayList<>();
        followed.add(4);
        followed.add(5);
        followers.add(2);
        followers.add(3);
        List<Post> posts = new ArrayList<>();
        User u = new User(1, "Alvarez Jorge", followed, followers, posts);
        users.put(u.getUserId(), u);

        List<Integer> followed1 = new ArrayList<>();
        List<Integer> followers1 = new ArrayList<>();
        List<Post> posts1 = new ArrayList<>();
        followed1.add(1);
        followed1.add(3);
        followers1.add(3);
        u = new User(2, "Castro Miguel", followed1, followers1, posts1);
        users.put(u.getUserId(), u);

        List<Integer> followed2 = new ArrayList<>();
        List<Integer> followers2 = new ArrayList<>();
        List<Post> posts2 = new ArrayList<>();
        followed2.add(1);
        followed2.add(2);
        followers2.add(2);
        u = new User(3, "Rojas Macarena", followed2, followers2, posts2);
        users.put(u.getUserId(), u);

        List<Integer> followed3 = new ArrayList<>();
        List<Integer> followers3 = new ArrayList<>();
        List<Post> posts3 = new ArrayList<>();
        followers3.add(1);
        String dateString = "27-05-2021";
        String[] st = dateString.split("-");
        posts3.add(new Post(30, LocalDate.parse(st[2] + "-" + st[1] + "-" + st[0]), new Product(2,
                "Headset Gamer", "Gamer", "Racer", "Red & Black",
                "Special Edition"), 101, 3000.00));
        u = new User(4, "Rodriguez Nicolas", followed3, followers3, posts3);
        users.put(u.getUserId(), u);

        List<Integer> followed4 = new ArrayList<>();
        List<Integer> followers4 = new ArrayList<>();
        List<Post> posts4 = new ArrayList<>();
        followers4.add(1);
        dateString = "26-05-2021";
        st = dateString.split("-");
        posts4.add(new Post(20, LocalDate.parse(st[2] + "-" + st[1] + "-" + st[0]), new Product(100,
                "Keyboard Gamer", "Gamer", "Racer", "Red & Black",
                "Special Edition"), 101, 3000.00));
        dateString = "28-05-2021";
        st = dateString.split("-");
        posts4.add(new Post(40, LocalDate.parse(st[2] + "-" + st[1] + "-" + st[0]), new Product(3,
                "Mouse Gamer", "Gamer", "Racer", "Red & Black", "Special Edition"),
                101, 3000.00));
        u = new User(5, "Gomez Marcos", followed4, followers4, posts4);
        users.put(u.getUserId(), u);

        return users;
    }
}