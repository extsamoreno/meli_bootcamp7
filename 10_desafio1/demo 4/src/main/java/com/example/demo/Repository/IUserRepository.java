package com.example.demo.Repository;

import com.example.demo.Entities.User;

import java.util.HashMap;
import java.util.List;

public interface IUserRepository {

    public List<User> loadUsers();
    public void saveUsers();
    public User getById(int userId);
    public List<User> getSellersFollowedByUser(User user);
    public void unFollowSeller(User user, User seller);
}
