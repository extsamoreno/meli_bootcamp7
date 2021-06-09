package com.challenge.repository;

import com.challenge.entity.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.guava.GuavaModule;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class UserRepositoryImpl implements UserRepository {


    private List<User> userList;
/*    follows y followedBy emulan la función de una tabla de relaciones en una relación many-to-many
    follows and followedBy emulate the functionality of relationship tables of many-to-many relationships
    follows = all the IDs of users that a certain user follows
    Multimap is a data structure that works like a regular Map but allows to having multiple values per key*/
    private Multimap<Integer, Integer> follows;
    //followedBy = all the IDs of users that follow a certain user
    private Multimap<Integer, Integer> followedBy;

    @PostConstruct
    private void init() {
        this.follows = loadFollowsMap();
        this.followedBy = loadFollowedByMap();
        this.userList = loadUserList();
    }

    public User getUserById(Integer id) {

        Optional<User> user =  userList.stream().filter(u -> u.getUserId().equals(id)).findFirst();
        return user.orElse(null);
    }

    //Each time a follow or unfollow is requested, the change is persisted in the corresponding file
    public void follow(Integer userId, Integer userIdToFollow) throws IOException {
        if (!follows.get(userId).contains(userIdToFollow)) {
            follows.put(userId, userIdToFollow);
            followedBy.put(userIdToFollow, userId);
            ObjectMapper objectMapper = new ObjectMapper().registerModule(new GuavaModule());
            //The file's url points to the project folder so data isn't lost upon executing mvn clean command
            objectMapper.writeValue(ResourceUtils.getFile(System.getProperty("user.dir") + "/src/main/resources/users_follows.json"), follows);
            objectMapper.writeValue(ResourceUtils.getFile(System.getProperty("user.dir") + "/src/main/resources/followed_by.json"), followedBy);
        }
    }

    public boolean checkIfExists(Integer userId) {
        return userList.stream().anyMatch(u -> u.getUserId().equals(userId));
    }

    @Override
    public void unfollow(Integer userId, Integer userToUnfollow) throws IOException {
        follows.get(userId).remove(userToUnfollow);
        followedBy.get(userToUnfollow).remove(userId);
        ObjectMapper objectMapper = new ObjectMapper().registerModule(new GuavaModule());
        //The file's url points to the project folder so data isn't lost upon executing mvn clean command
        objectMapper.writeValue(ResourceUtils.getFile(System.getProperty("user.dir") + "/src/main/resources/user_follows.json"), follows);
        objectMapper.writeValue(ResourceUtils.getFile(System.getProperty("user.dir") + "/src/main/resources/followed_by.json"), followedBy);
    }

    public List<User> getFollowers(Integer userId) {
        List<Integer> followersIds = (List<Integer>) followedBy.get(userId);
        return userList.stream().filter(u -> followersIds.contains(u.getUserId())).collect(Collectors.toList());
    }

    public List<User> getFollows(Integer userId) {
        List<Integer> followsIds = (List<Integer>) follows.get(userId);
        return userList.stream().filter(u -> followsIds.contains(u.getUserId())).collect(Collectors.toList());
    }

    public List<Integer> getFollowedIds(Integer userId) {
        return (List<Integer>) follows.get(userId);
    }

    public Integer getFollowersCount(Integer userId) {
        return followedBy.get(userId).size();
    }




    private Multimap<Integer, Integer> loadFollowedByMap() {
        File file = null;
        try {
            //The file's url points to the project folder so data isn't lost upon executing mvn clean command
            file = ResourceUtils.getFile(System.getProperty("user.dir") + "/src/main/resources/followed_by.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper().registerModule(new GuavaModule());
        TypeReference<ArrayListMultimap<Integer, Integer>> typeRef = new TypeReference<>() {};
        Multimap<Integer, Integer> followers = ArrayListMultimap.create();

        try {
            followers = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return followers;
    }

    private Multimap<Integer, Integer> loadFollowsMap() {
        File file = null;
        try {
            //The file's url points to the project folder so data isn't lost upon executing mvn clean command
            file = ResourceUtils.getFile(System.getProperty("user.dir") + "/src/main/resources/users_follows.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper().registerModule(new GuavaModule());
        TypeReference<ArrayListMultimap<Integer, Integer>> typeRef = new TypeReference<>() {};
        Multimap<Integer, Integer> follows = ArrayListMultimap.create();

        try {
            follows = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return follows;
    }

    private List<User> loadUserList() {
        File file = null;
        try {
            //The file's url points to the project folder so data isn't lost upon executing mvn clean command
            file = ResourceUtils.getFile(System.getProperty("user.dir") + "/src/main/resources/users.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<User>> typeRef = new TypeReference<>() {};
        List<User> users = null;

        try {
            users = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }


}
