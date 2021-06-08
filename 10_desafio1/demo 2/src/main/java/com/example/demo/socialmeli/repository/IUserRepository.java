package com.example.demo.socialmeli.repository;

import com.example.demo.socialmeli.service.dto.UserDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
@Repository
public interface IUserRepository {
    public User getUserId (int id);
    public void refreshUser(User user);
    public int getCountFollowers (int id);
    public ArrayList<UserDTO> getFollowersList (int id);
}
