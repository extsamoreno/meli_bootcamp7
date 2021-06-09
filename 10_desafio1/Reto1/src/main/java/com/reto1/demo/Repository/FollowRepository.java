package com.reto1.demo.Repository;

import com.reto1.demo.Exception.GeneralException;
import com.reto1.demo.Exception.UserAlreadyFollowException;
import com.reto1.demo.Exception.UserIdNotFoundException;
import com.reto1.demo.Exception.UserNotFollowException;
import com.reto1.demo.Model.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class FollowRepository<user> implements IFollowRepository {

    static HashMap<Integer, User> dataUsers = new HashMap<>();

    static {
        User u1 = new User(1569, "Construcciones SAS" );
        User u3 = new User(1570, "Mega SAS" );
        User u2 = new User(1235, "Edilberto Suarez");
        User u4 = new User(1236, "Jenny Angarita");

        dataUsers.put(u1.getId(), u1);
        dataUsers.put(u2.getId(), u2);
        dataUsers.put(u3.getId(), u3);
        dataUsers.put(u4.getId(), u4);
    }


    @Override
    public String follow(int userId, int userIdToFollow) throws UserIdNotFoundException, UserAlreadyFollowException {
        User user = getUserById(userId);
        User followed = getUserById(userIdToFollow);
        //Revisa si ya el seguidor esta en la lista getFollower del usuario
        if(!followed.getFollowers().contains(user)){
            user.followPages(followed);
            followed.addFollower(user);
        }else{
            throw new UserAlreadyFollowException(followed.getName());
        }
        return followed.getName();
    }

    @Override
    public User getUserById(int userId) throws UserIdNotFoundException {
        User user = dataUsers.get(userId);
        if (user == null)
            throw new UserIdNotFoundException(userId);
        return user;
    }

    @Override
    public String unfollow(int userId, int userIdToUnFollow) throws UserNotFollowException, UserIdNotFoundException {
        User user = getUserById(userId);
        User followed = getUserById(userIdToUnFollow);
        //Revisa si el seguidor sigue al usuario
        if(!user.getFollowed().contains(followed)){
            throw new UserNotFollowException(followed.getName());
        }
        user.unFollowPages(followed);
        followed.removeFollower(user);
        return followed.getName();
    }
}
