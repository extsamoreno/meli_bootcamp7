package com.socialmeli.socialmeli.repositories;
import com.socialmeli.socialmeli.exceptions.UserNotFoundException;
import com.socialmeli.socialmeli.models.User;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.HashMap;

@Repository
public class UserRepositoryImpl implements UserRepository{

    HashMap<Integer, User> users = new HashMap<>();

    public UserRepositoryImpl(){
        users.put(1235,new User(1235,"Jose",new ArrayList<>(),new ArrayList<>()));
        users.put(1569,new User(1569,"Joaquin",new ArrayList<>(),new ArrayList<>()));
    }

    @Override
    public void addFollowerToUser(int userId,int userIdToFollow){
        users.get(userId).getFollows().add(userIdToFollow);
        users.get(userIdToFollow).getFollowers().add(userId);
    }

    @Override
    public User getUserById(int userId) throws UserNotFoundException {
        if(users.get(userId) == null){
            throw new UserNotFoundException("El usuario no existe");
        }
        return users.get(userId);
    }

    @Override
    public int getFollowersCount(int userId) {
        return users.get(userId).getFollowers().size();
    }


}
