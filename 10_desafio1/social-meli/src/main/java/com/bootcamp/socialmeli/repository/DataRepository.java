package com.bootcamp.socialmeli.repository;

import com.bootcamp.socialmeli.exception.UserIdNotFoundException;
import com.bootcamp.socialmeli.model.Post;
import com.bootcamp.socialmeli.model.Product;
import com.bootcamp.socialmeli.model.User;
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
public class DataRepository implements IDataRepository {

    private static List<User> users = loadDatabase();
    private static List<Post> posts = new ArrayList<>();
    private static List<Product> products = new ArrayList<>();

    @Override
    public User findUserById(Integer id) throws UserIdNotFoundException {

        User user = users.stream()
                .filter(userE -> userE.getUserId() == id)
                .findFirst()
                .orElse(null);

        if (user == null) {
            throw new UserIdNotFoundException(id);
        }

        return user;
    }

    public User findUserByIdWithoutException(Integer id) {
        return users.stream()
                .filter(userE -> userE.getUserId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }

    @Override
    public List<User> getUserFollowers(Integer id) throws UserIdNotFoundException {
        User user = findUserById(id);

        return user.getFollowers()
                .stream()
                .map(followerId -> findUserByIdWithoutException(followerId))
                .collect(Collectors.toList());
    }


    @Override
    public List<User> getUserFollowed(Integer id) throws UserIdNotFoundException {
        User user = findUserById(id);

        return user.getFollowed()
                .stream()
                .map(followedId -> findUserByIdWithoutException(followedId))
                .collect(Collectors.toList());
    }


    @Override
    public List<Post> getAllPost() {
        return posts;
    }

    @Override
    public Post findPostById(Integer id) {

        Post post = posts.stream()
                .filter(postAux -> postAux.getPostId() == id)
                .findFirst()
                .orElse(null);

        return post;
    }

    private static List<User> loadDatabase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:users.json");
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
}
