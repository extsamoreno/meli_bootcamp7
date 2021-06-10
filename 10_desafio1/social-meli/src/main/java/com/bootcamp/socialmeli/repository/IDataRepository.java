package com.bootcamp.socialmeli.repository;

import com.bootcamp.socialmeli.exception.UserIdNotFoundException;
import com.bootcamp.socialmeli.model.Post;
import com.bootcamp.socialmeli.model.User;

import java.util.List;

public interface IDataRepository {

    User findUserById(Integer id);

    List<User> getUserFollowers(Integer id);

    List<User> getUserFollowed(Integer id);

    List<Post> getAllPosts();

    Post findPostById(Integer id);

    List<Post> getPostsByUserId(Integer id);

    List<Post> getPostWithPromoByUserId(Integer id);

}
