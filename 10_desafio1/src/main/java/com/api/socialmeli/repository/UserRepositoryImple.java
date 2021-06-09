package com.api.socialmeli.repository;

import com.api.socialmeli.model.UserModel;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepositoryImple implements UserRepository {

    private static Map<Integer, UserModel> users = new HashMap<>();
    static {
        ArrayList<UserModel> followers1 = new ArrayList<>();
        ArrayList<UserModel> followers2 = new ArrayList<>();
        ArrayList<UserModel> followers3 = new ArrayList<>();
        ArrayList<UserModel> followed1 = new ArrayList<>();
        ArrayList<UserModel> followed2 = new ArrayList<>();
        ArrayList<UserModel> followed3 = new ArrayList<>();

        users.put(1000, new UserModel(1000, "vendedor1", followers1, followed1));
        users.put(2000, new UserModel(2000, "vendedor2", followers2, followed2));
        users.put(3000, new UserModel(3000, "vendedor3", followers3, followed3));
    }

    public Map<Integer, UserModel> getUsers() {
        return users;
    }

    public void setUsers(Map<Integer, UserModel> users) {
        UserRepositoryImple.users = users;
    }
}
