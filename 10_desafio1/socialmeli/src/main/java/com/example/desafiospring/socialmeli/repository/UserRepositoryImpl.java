package com.example.desafiospring.socialmeli.repository;

import com.example.desafiospring.socialmeli.exception.DateIsNotValidException;
import com.example.desafiospring.socialmeli.exception.PostIdAlreadyExistException;
//import com.example.desafiospring.socialmeli.exception.UserException;
import com.example.desafiospring.socialmeli.exception.UserNotFoundException;
import com.example.desafiospring.socialmeli.model.Post;
import com.example.desafiospring.socialmeli.model.User;
import com.example.desafiospring.socialmeli.model.ValidDate;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.HashMap;

@Repository
public class UserRepositoryImpl implements IUserRepository{

    HashMap<Integer, User> users = new HashMap<>();

    public UserRepositoryImpl(){
        users.put(0000,new User(0000,"Pablo",new ArrayList<>(),new ArrayList<>(),new ArrayList<>()));
        users.put(1111,new User(1111,"Pepito",new ArrayList<>(),new ArrayList<>(),new ArrayList<>()));
    } //los user

    @Override
    public void addFollowerToUser(int userId,int userIdToFollow) throws UserNotFoundException {
        User user1 = getUserById(userId);
        User user2 = getUserById(userIdToFollow);
        users.get(userId).getFollowed().add(user2);
        users.get(userIdToFollow).getFollowers().add(user1);
    }//agrego el follow entre user 1 y 2

    @Override
    public User getUserById(int userId) throws UserNotFoundException {
        if(users.get(userId) == null){
            throw new UserNotFoundException("El user no existe"); //exception para cuando el user no existe
        }
        return users.get(userId);
    }

    @Override
    public void removeFollowerToUser(int userId, int userIdToUnFollow) throws UserNotFoundException {
        User user1 = getUserById(userId);
        User user2 = getUserById(userIdToUnFollow);
        users.get(userId).getFollowed().remove(user2);
    }

    @Override
    public int getFollowersCount(int userId) {
        return users.get(userId).getFollowers().size();
    }

    @Override
    public void insertPost(Post post) throws UserNotFoundException, PostIdAlreadyExistException, DateIsNotValidException {
        User user = getUserById(post.getUserId());

        Post checkPost = user.getPosts().stream().filter(
                p -> p.getId_post() == post.getId_post()
        ).findAny().orElse(null);

        if(checkPost != null){
            throw new PostIdAlreadyExistException("Este ID ya existe");
        }

        if(post.getDate() == null){
            throw new DateIsNotValidException("La fecha no es valida");
        }

        if(!ValidDate.validateDate(post.getDate().toString())){
            throw new DateIsNotValidException("La fecha no es valida");
        }

        users.get(user.getUserId()).getPosts().add(post);
    }
}