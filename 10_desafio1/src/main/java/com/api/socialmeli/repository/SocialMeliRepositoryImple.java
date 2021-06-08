package com.api.socialmeli.repository;

import com.api.socialmeli.model.UserModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Repository
public class SocialMeliRepositoryImple implements SocialMeliRepository{

    private static Map<Integer, UserModel> users = new HashMap<>();
    static {
        HashMap <Integer, String> followers1 = new HashMap<>();
        followers1.put(5678,"usuario1");
        followers1.put(1234,"usuario2");
        followers1.put(3456,"usuario3");

        HashMap <Integer, String> followers2 = new HashMap<>();
        followers2.put(5678,"usuario1");
        followers2.put(1234,"usuario2");

        HashMap <Integer, String> followers3 = new HashMap<>();
        followers3.put(5678,"usuario1");
        followers3.put(6677,"usuario4");

        users.put(1000, new UserModel("vendedor1", followers1));
        users.put(2000, new UserModel("vendedor2", followers2));
        users.put(3000, new UserModel("vendedor3", followers3));
    }

    public Map<Integer, UserModel> getUsers() {
        return users;
    }

    public void setUsers(Map<Integer, UserModel> users) {
        SocialMeliRepositoryImple.users = users;
    }
}
