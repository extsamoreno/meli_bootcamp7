package com.reto1.demo.Repository;

import com.reto1.demo.Exception.UserAlreadyFollowException;
import com.reto1.demo.Exception.UserIdNotFoundException;
import com.reto1.demo.Model.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class FollowRepository<user> implements IFollowRepository {

    static HashMap<Integer, User> dataUsers = new HashMap<>();

    static {
        User u1 = new User(1235, "Construcciones SAS" );
        User u3 = new User(1236, "Mega SAS" );
        User u2 = new User(1569, "Edilberto Suarez");
        User u4 = new User(1570, "Jenny Angarita");

        dataUsers.put(u1.getId(), u1);
        dataUsers.put(u2.getId(), u2);
        dataUsers.put(u3.getId(), u3);
        dataUsers.put(u4.getId(), u4);
    }


    @Override
    public String follow(int userId, int userIdToFollow) throws UserIdNotFoundException, UserAlreadyFollowException {
        User user = getUserById(userId);
        User follower = getUserById(userIdToFollow);
        //Revisa si ya existe el usuario ya sigue al vendedor
        if(!follower.getFollowers().contains(user)){
            follower.follow(user);
            user.followed(follower);
        }else{
            throw new UserAlreadyFollowException(user.getName());
        }
        return follower.getName();
    }

    @Override
    public User getUserById(int userId) throws UserIdNotFoundException {
        User user = dataUsers.get(userId);
        if (user == null)
            throw new UserIdNotFoundException(userId);
        return user;
    }



}
