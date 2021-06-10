package com.desafiospring.socialMeli.repository;

import com.desafiospring.socialMeli.dto.UserDTO;
import com.desafiospring.socialMeli.exceptions.PostIdAlreadyExistException;
import com.desafiospring.socialMeli.exceptions.UserAlreadyFollowsException;
import com.desafiospring.socialMeli.exceptions.UserAlreadyUnfollowsException;
import com.desafiospring.socialMeli.exceptions.UserNotFoundException;
import com.desafiospring.socialMeli.model.Post;
import com.desafiospring.socialMeli.model.User;

import java.util.List;

public interface ISocialMeliRepository {

    User findUserById(int id) throws UserNotFoundException;

    void addFollowerToUser(int userId, int userIdToFollow) throws UserNotFoundException, UserAlreadyFollowsException;

    int getFollowersCount(int userId);

    List<User> getFollowersList(int userId) throws UserNotFoundException;

    List<User> getFollowedList(int userId) throws UserNotFoundException;

    void deleteFollower(int userId, int userIdToFollow) throws UserNotFoundException, UserAlreadyUnfollowsException;

    void addNewPost(Post post) throws UserNotFoundException, PostIdAlreadyExistException;

    List<Post> getFollowedPosts(List<User> usersFollowed, String order);

}
