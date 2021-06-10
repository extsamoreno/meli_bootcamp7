package com.example.socialmeli.repository;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.example.socialmeli.exceptions.UserFollowthisUserException;
import com.example.socialmeli.exceptions.UserIdNotFountException;
import com.example.socialmeli.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        try {
            return users.stream().filter(x -> x.getUserId() == userId).findFirst().get();
        }
        catch (Exception e){

        }
        return null;
    }

    @Override
    public boolean userFollow(int userid, int useridFollow) {
        User userFollow = null, userFollowed = null;
        if (userid != useridFollow)
            for (User obj : users) {
                if (obj.getUserId() == userid)
                    userFollow = obj;
                if (obj.getUserId() == useridFollow)
                    userFollowed = obj;
                if (userFollow != null && userFollowed != null) {
                    var temp = userFollow.getFollowed();
                    temp.add(userFollowed);
                    userFollow.setFollowed(temp);
                    temp = userFollowed.getFollowers();
                    temp.add(userFollow);
                    userFollowed.setFollowers(temp);
                    break;
                }
            }
        return true;
    }

    @Override
    public boolean userUnFollow(int userid, int useridFollow) {
        User userFollow = null, userFollowed = null;
        if (userid != useridFollow)
            for (User obj : users) {
                if (obj.getUserId() == userid)
                    userFollow = obj;
                if (obj.getUserId() == useridFollow)
                    userFollowed = obj;
                if (userFollow != null && userFollowed != null) {
                    userFollow.setFollowed(userFollow.getFollowed().stream().filter(x -> x.getUserId() != useridFollow).collect(Collectors.toList()));
                    userFollowed.setFollowers(userFollowed.getFollowers().stream().filter(x -> x.getUserId() != userid).collect(Collectors.toList()));
                    break;
                }
            }
        return true;
    }
}
