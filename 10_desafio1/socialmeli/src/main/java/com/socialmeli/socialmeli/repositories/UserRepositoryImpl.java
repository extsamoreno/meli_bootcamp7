package com.socialmeli.socialmeli.repositories;
import com.socialmeli.socialmeli.exceptions.UserNotFoundException;
import com.socialmeli.socialmeli.models.Post;
import com.socialmeli.socialmeli.models.User;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.HashMap;

@Repository
public class UserRepositoryImpl implements UserRepository{

    HashMap<Integer, User> users = new HashMap<>();

    public UserRepositoryImpl(){
        users.put(1235,new User(1235,"Jose",new ArrayList<>(),new ArrayList<>(),new ArrayList<>()));
        users.put(1569,new User(1569,"Joaquin",new ArrayList<>(),new ArrayList<>(),new ArrayList<>()));
    }

    @Override
    public void addFollowerToUser(int userId,int userIdToFollow) throws UserNotFoundException {
        User user1 = getUserById(userId);
        User user2 = getUserById(userIdToFollow);
        users.get(userId).getFollowed().add(user2);
        users.get(userIdToFollow).getFollowers().add(user1);
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

    @Override
    public void insertPost(Post post) throws UserNotFoundException {
        User user = getUserById(post.getUserId());
        users.get(user.getUserId()).getPosts().add(post);
    }


}
