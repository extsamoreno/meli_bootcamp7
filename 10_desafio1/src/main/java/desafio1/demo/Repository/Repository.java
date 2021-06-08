package desafio1.demo.Repository;

import desafio1.demo.Exception.UserNotFoundException;
import desafio1.demo.Model.Entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Stream;

@org.springframework.stereotype.Repository
public class Repository implements IRepository{
    HashMap<Integer, User> userDict = new HashMap<Integer,User>();

    public Repository() {
        this.userDict.put(0,new User(0,"user0", new ArrayList<User>()));
        this.userDict.put(1,new User(1,"user1", new ArrayList<User>()));
        this.userDict.put(2,new User(2,"user2", new ArrayList<User>()));
        this.userDict.put(3,new User(3,"user3", new ArrayList<User>()));
        this.userDict.put(4,new User(4,"user4", new ArrayList<User>()));
    }

    @Override
    public HashMap<Integer, User> getUserDict() {
        return userDict;
    }

    @Override
    public User getUserById(int userId) throws UserNotFoundException {
        var user = userDict.get(userId);
        if (user == null){
            throw new UserNotFoundException(userId);
        }
        return user;
    }

    @Override
    public Stream<User> getUserFollowersById(int userId) throws UserNotFoundException {
        var user = this.getUserById(userId);
        return this.userDict.values().stream()
                .filter(u -> u.getFollowedUsersList().contains(user));
    }


}
