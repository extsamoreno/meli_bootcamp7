package com.desafiospring.socialMeli.repository;

import com.desafiospring.socialMeli.exceptions.PostIdAlreadyExistException;
import com.desafiospring.socialMeli.exceptions.UserNotFoundException;
import com.desafiospring.socialMeli.model.Post;
import com.desafiospring.socialMeli.model.User;

import java.util.List;

public interface IPostRepository {
    void addNewPost(Post post) throws UserNotFoundException, PostIdAlreadyExistException;

    List<Post> getFollowedPosts(List<User> usersFollowed, String order);
}
