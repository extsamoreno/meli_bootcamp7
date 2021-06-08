package com.example.demo.repositories;

import com.example.demo.model.DTO.UserDTO;
import com.example.demo.model.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
@Data
public class UserRepository implements IUserRepository {
    public List<User> listUsers = new ArrayList<>();
    private HashMap<Integer, List<UserDTO>> followersList = new HashMap<>();
    private HashMap<Integer, List<UserDTO>> followedList = new HashMap<>();

    @Override
    public List<User> getUserList() {
        return listUsers;
    }

    @Override
    public HashMap<Integer, List<UserDTO>>getFollowersList(){
       return this.getFollowersList();
    }

    @Override
    public HashMap<Integer, List<UserDTO>>getFollowedList(){
        return this.getFollowedList();
    }

    @Override
    public User getUserById(int id) {

        for(User u : listUsers){
            if(u.getId() == id){
                return u;
            }
        }

        return null;
    }


}
