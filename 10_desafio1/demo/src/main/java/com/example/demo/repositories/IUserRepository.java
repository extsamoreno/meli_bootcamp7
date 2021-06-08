package com.example.demo.repositories;

import com.example.demo.model.DTO.UserDTO;
import com.example.demo.model.User;

import java.util.HashMap;
import java.util.List;

public interface IUserRepository {

    public void loadDataBase();
    public HashMap<Integer, List<UserDTO>> getFollowersList();
    public HashMap<Integer, List<UserDTO>> getFollowedList();
    public User getUserById(int id);
}
