package com.socialmeli.socialmeli.repositories;
import com.socialmeli.socialmeli.exceptions.UserNotFoundException;
import com.socialmeli.socialmeli.models.Post;
import com.socialmeli.socialmeli.models.User;

public interface UserRepository {
    public void addFollowerToUser(int userId,int userIdToFollow) throws UserNotFoundException;
    public User getUserById(int userId) throws UserNotFoundException;
    public int getFollowersCount(int userId);
    public void insertPost(Post post) throws UserNotFoundException;
}
