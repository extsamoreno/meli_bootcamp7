package com.meli.socialmeli.repository.post;

import com.meli.socialmeli.exception.InvalidDateException;
import com.meli.socialmeli.exception.PostAlreadyInsertedException;
import com.meli.socialmeli.exception.ProductAlreadyPostedException;
import com.meli.socialmeli.model.Post;
import com.meli.socialmeli.model.User;

import java.util.List;

public interface IPostRepository {
    void insertPost(Post post) throws PostAlreadyInsertedException, ProductAlreadyPostedException, InvalidDateException;
    List<Post> getFollowedPosts(List<User> followed, String order);
    List<Post> getPromoPosts(Integer userId);
}
