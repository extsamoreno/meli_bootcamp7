package com.example.demo.repository;

import com.example.demo.DTO.FollowersListDTO;
import com.example.demo.DTO.UserDTO;
import com.example.demo.exception.FollowersNotFoundException;
import com.example.demo.exception.UserNotFoundException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository implements IUserRepository {

    private HashMap<Integer, List<UserDTO>> followerDB;
    private HashMap<Integer, List<UserDTO>> followedDB;

    public UserRepository(){
        this.followedDB = new HashMap<>();
        this.followerDB = new HashMap<>();
    }

    @Override
    public void follow(UserDTO userId, UserDTO userIdToFollow){
        addFollower(userId, userIdToFollow);
        addFollowed(userId, userIdToFollow);
    }

    @Override
    public UserDTO findById(Integer userId) throws UserNotFoundException {
        List<UserDTO> user = null;
        user = LoadDataBase();
        UserDTO result = null;
        if (user != null) {
            Optional<UserDTO> item = user.stream()
                    .filter(id -> id.getUserId().intValue() == userId.intValue())
                    .findFirst();
            if (item.isPresent())
                result = item.get();
        }
        if (result == null)
            throw new UserNotFoundException(userId);
        return result;
    }

    @Override
    public Integer countFollowers(UserDTO user) {
        List<UserDTO> followerList  = this.followerDB.get(user.getUserId());
        return (followerList == null ? 0:followerList.size());
    }

    @Override
    public List<UserDTO> followersList(Integer userId) {
        List<UserDTO> followersList = this.followerDB.get(userId);
        return (followersList == null?new ArrayList<>():followersList);
    }

    private void addFollowed(UserDTO userId, UserDTO userIdToFollow) {
        if(this.followedDB.containsKey(userId.getUserId())){
            this.followedDB.get(userId.getUserId()).add(userIdToFollow);
        }else{
            List<UserDTO> listFollower = new ArrayList<>();
            listFollower.add(userIdToFollow);
            this.followedDB.put(userId.getUserId(),listFollower);
        }
    }

    private void addFollower(UserDTO userId, UserDTO userIdToFollow) {
        if(this.followerDB.containsKey(userIdToFollow.getUserId())){
            this.followerDB.get(userIdToFollow.getUserId()).add(userId);
        }else{
            List<UserDTO> listFollowed = new ArrayList<>();
            listFollowed.add(userId);
            this.followerDB.put(userIdToFollow.getUserId(),listFollowed);
        }
    }

    private List<UserDTO> LoadDataBase() {
        File file = null;
        String fuenteArchivo = "src/main/java/com/example/demo/repository/user.json";
        try {
            file = ResourceUtils.getFile(fuenteArchivo);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<UserDTO>> typeRef = new TypeReference<>() {};
        List<UserDTO> user = null;
        try {
            user = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return user;
    }
}
