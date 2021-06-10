package com.meli.spring_challenge.repository.follow;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.spring_challenge.model.Follow;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


@Repository
public class FollowRepositoryImpl implements FollowRepository{
    private final String jsonPath = "classpath:follow.json";
    List<Follow> followList;

    FollowRepositoryImpl(){
        this.followList = loadDataBase();
    }

    @Override
    public List<Follow> getFollowedByUserID(int userID){
        return this.followList.stream()
                .filter(follow -> follow.getUserID() == userID)
                .collect(Collectors.toList());
    }

    @Override
    public List<Follow> getAll() {
        return this.followList;
    }

    @Override
    public void save(Follow follow) {
        this.followList.add(follow);
        writeDataBase(follow);
    }

    @Override
    public int getMaxID() {
        if(followList.size() == 0)
            return 0;

        return (followList.stream()
                .mapToInt(Follow::getId)
                .max()
                .getAsInt());
    }

    @Override
    public Follow getFollow(int userID) {
        return this.followList.stream()
                .filter(follow -> follow.getUserID() == userID)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Follow getFollow(int userID, int userToFollowID) {
        return this.followList.stream()
                .filter(follow -> follow.getUserID() == userID && follow.getFollowedUserID() == userToFollowID)
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean remove(Follow follow) {
        return this.followList.remove(follow);
    }

    private List<Follow> loadDataBase() {
        File file = null;
        try{
            file = ResourceUtils.getFile(jsonPath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper om = new ObjectMapper();
        TypeReference<List<Follow>> typeDef = new TypeReference<>(){};
        List<Follow> followList = null;
        try{
            followList = om.readValue(file,typeDef);
        } catch (IOException e) {
            throw new RuntimeException("Impossible to open JSON file", e);
        }

        return followList;
    }

    private void writeDataBase(Follow follow) {
        JSONArray followsArray = new JSONArray(this.followList);
        JSONObject followJson = new JSONObject(follow);
        followsArray.put(followJson);

        try(FileWriter writer = new FileWriter(jsonPath)) {
            writer.write(followsArray.toString());
            writer.flush();
        } catch(IOException e) {
            throw new RuntimeException("Impossible to write on JSON file", e);
        }

    }


}
