package com.example.demo.Repository;

import com.example.demo.Entities.User;

import java.util.HashMap;
import java.util.List;

public interface IUserRepository {

    public List<User> loadUsers();
    public User getById(int userId);
}
