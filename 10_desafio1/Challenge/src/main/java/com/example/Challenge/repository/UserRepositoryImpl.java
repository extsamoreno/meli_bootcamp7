package com.example.Challenge.repository;

import com.example.Challenge.model.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;


@Repository
public class UserRepositoryImpl implements IUserRepository {
    public final HashMap<Integer, User> dataBaseUsers = new HashMap<>();
    User u1=new User(1,"user1");
    User u2=new User(2,"user2");
    User u3=new User(3,"user3");
    User u4=new User(4,"user4");


    public UserRepositoryImpl() {
        this.dataBaseUsers.put(1,u1);
        this.dataBaseUsers.put(2,u2);
        this.dataBaseUsers.put(3,u3);
        this.dataBaseUsers.put(4,u4);
    }

    @Override
    public User getUserById(Integer id) {
        User userResult= dataBaseUsers.get(id);
        return  userResult;
    }

    @Override
    public void saveChanges(User user) {
        dataBaseUsers.put(user.getIdUser(), user);
    }

}

