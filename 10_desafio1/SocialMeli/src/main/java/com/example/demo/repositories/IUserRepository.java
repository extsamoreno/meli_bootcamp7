package com.example.demo.repositories;

import com.example.demo.entities.User;
import com.example.demo.DTO.UserDTO;
import com.example.demo.exceptions.NotFoundException;

import java.util.List;

public interface IUserRepository {

    public List<User> loadUsers();
    public void saveUsers();
    public User getById(int userId);
    public List<User> getSellersFollowedByUser(User user) throws NotFoundException;
    public void unFollowSeller(User user, User seller) throws NotFoundException;
}
