package com.example.desafio1.repository;

import com.example.desafio1.exception.post.PostAlreadyExistException;
import com.example.desafio1.exception.post.PostNotFoundException;
import com.example.desafio1.exception.user.UserNotFoundException;
import com.example.desafio1.model.Post;
import com.example.desafio1.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Repository
public class PostRepository implements iPostRepository {

    @Autowired
    iUserRepository iUserRepository;

    // Map with Posts
    HashMap<Integer, Post> mapPosts = new HashMap();

    // Create a new post
    @Override
    public Post savePost(Post post) throws PostAlreadyExistException, UserNotFoundException {

        // Exception: user id doesn't exist
        if(iUserRepository.findUserById(post.getUserId()) == null){
            throw new UserNotFoundException(post.getUserId());
        }

        // Exception: post id already exists
        if (mapPosts.get(post.getIdPost()) != null) {
            throw new PostAlreadyExistException(post.getIdPost());
        }

        mapPosts.put(post.getIdPost(), post);
        return post;
    }

    /*// Search a post by postId
    @Override
    public Post findPostById(Integer id) throws PostNotFoundException {

        // Exception: ID doesn't exist
        if (mapPosts.get(id) == null) {
            throw new PostNotFoundException(id);
        }
        return mapPosts.get(id);
    }*/

    // Search all post created by userId
    @Override
    public ArrayList<Post> findPostsByUserId(Integer id) throws UserNotFoundException {

        User userOwner = iUserRepository.findUserById(id);
        ArrayList<Post> listPost = new ArrayList<>();

        for (Map.Entry<Integer, Post> entry : mapPosts.entrySet()) {

            if(entry.getValue().getUserId() == id){
                listPost.add(entry.getValue());
            }
        }
        return listPost;
    }
}
