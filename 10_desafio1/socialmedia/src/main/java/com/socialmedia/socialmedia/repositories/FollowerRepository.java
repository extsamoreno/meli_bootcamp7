package com.socialmedia.socialmedia.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.socialmedia.socialmedia.exceptions.ObjectNotFoundException;
import com.socialmedia.socialmedia.repositories.entities.Follower;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class FollowerRepository implements IFollowerRepository {

    @Override
    public int add(Follower object) {
        List<Follower> followers = loadDatabaseFollowers();
        int newId = followers.size() + 1;

        object.setId(newId);
        object.setFollow(true);

        followers.add(object);

        updateDatabaseFollowers(followers);

        return newId;
    }

    @Override
    public Follower update(Follower object) throws ObjectNotFoundException {
        List<Follower> followers = loadDatabaseFollowers();

        Follower followerTemp = getById(object.getId());

        Optional<Follower> optional = followers.stream().filter(x -> x.getId() == followerTemp.getId()).findFirst();

        if (!optional.isPresent()) throw new ObjectNotFoundException(object.getId());

        int index = followers.indexOf(optional.get());
        followers.set(index, object);

        updateDatabaseFollowers(followers);

        return object;
    }

    @Override
    public Follower getById(int id) throws ObjectNotFoundException {
        List<Follower> followers = loadDatabaseFollowers();

        Follower result = followers.stream()
                .filter(follower -> follower.getId() == id)
                .findFirst().get();

        if (Objects.isNull(result)) throw new ObjectNotFoundException(id);

        return result;
    }

    @Override
    public List<Follower> getFollowersByUserId(int userId) throws ObjectNotFoundException {
        List<Follower> followers = loadDatabaseFollowers();

        var result = followers.stream()
                .filter(follower -> follower.getUserId() == userId)
                .collect(Collectors.toList());

        if (Objects.isNull(result)) throw new ObjectNotFoundException(userId);

        return result;
    }

    @Override
    public List<Follower> getFollowersByFollowerId(int followerId) throws ObjectNotFoundException {
        List<Follower> followers = loadDatabaseFollowers();

        var results = followers.stream()
                .filter(follower -> follower.getFollowerId() == followerId)
                .collect(Collectors.toList());

        if (Objects.isNull(results)) throw new ObjectNotFoundException(followerId);

        return results;
    }

    @Override
    public Follower getFollowerByUserIdAndFollowerId(int userId, int followerId) {
        List<Follower> followers = loadDatabaseFollowers();

        Follower resultObject = null;

        Optional<Follower> result = followers.stream()
                .filter(follower -> follower.getFollowerId() == followerId
                                    && follower.getUserId() == userId)
                .findFirst();

        if (result.isPresent()) resultObject = result.get();

        return resultObject;
    }

    private List<Follower> loadDatabaseFollowers() {
        File file = null;

        try {
            file = ResourceUtils.getFile("classpath:followers.json");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            file = null;
        }
        ObjectMapper objectMapper = new ObjectMapper();

        TypeReference<List<Follower>> typeReference = new TypeReference<>() {
        };
        List<Follower> followers = null;
        try {
            followers = objectMapper.readValue(file, typeReference);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return followers;
    }

    private void updateDatabaseFollowers(List<Follower> followers) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String jsonString = objectMapper.writeValueAsString(followers);

            FileWriter myWriter = new FileWriter("src/main/resources/followers.json", false);
            myWriter.write(jsonString);
            myWriter.close();

        } catch (Exception ex) {
            System.out.println("Error al convertir a json");
            ex.printStackTrace();
        }
    }
}

