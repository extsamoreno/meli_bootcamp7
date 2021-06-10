package com.example.demo.repositories;

import com.example.demo.entities.User;
import com.example.demo.DTO.UserDTO;

import java.util.List;

public interface IUserRepository {

    public List<User> loadUsers();
    public void saveUsers();
    public User getById(int userId);
    public List<User> getSellersFollowedByUser(User user);
    public void unFollowSeller(User user, User seller);
    public List<UserDTO> sortByCriteria(List<UserDTO> list, String order);
}
