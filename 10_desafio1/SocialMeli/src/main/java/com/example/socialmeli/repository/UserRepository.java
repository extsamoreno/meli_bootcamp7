package com.example.socialmeli.repository;

import com.example.socialmeli.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository implements IUserRepository {
    List<User> users = new ArrayList<>();
    int cont = 1;

    @Override
    public User userAdd(User user) {
        user.setUserId(cont++);
        user.setFollowed(new ArrayList<>());
        user.setFollowers(new ArrayList<>());
        users.add(user);
        return user;
    }

    @Override
    public User getUserById(int userId) {
        return users.stream().filter(x -> x.getUserId() == userId).findFirst().get();
    }

    @Override
    public boolean userFollow(int userid, int useridFollow) {
        try {
            User userFollow = null, userFollowed = null;
            if (userid != useridFollow)
                for (User obj : users) {
                    if (obj.getUserId() == userid)
                        userFollow = obj;
                    if (obj.getUserId() == useridFollow)
                        userFollowed = obj;
                    if (userFollow != null && userFollowed != null) {
                        userFollow.addFollowed(userFollowed);
                        userFollowed.addFollowers(userFollow);
                    }
                }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean userUnFollow(int userid, int useridFollow) {
        try {
            User userFollow = null, userFollowed = null;
            if (userid != useridFollow)
                for (User obj : users) {
                    if (obj.getUserId() == userid)
                        userFollow = obj;
                    if (obj.getUserId() == useridFollow)
                        userFollowed = obj;
                    if (userFollow != null && userFollowed != null) {
                        userFollow.removeFollowed(userFollowed);
                        userFollowed.removeFollowers(userFollow);
                    }
                }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
