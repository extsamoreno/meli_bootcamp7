package com.bootcamp.desafio1.repository.post;

import com.bootcamp.desafio1.exception.PostAlreadyExistsException;
import com.bootcamp.desafio1.exception.PostNotFoundException;
import com.bootcamp.desafio1.exception.UserNotFoundException;
import com.bootcamp.desafio1.model.Post;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@Repository
public class PostRepositoryImpl implements IPostRepository{

    // Posts Data Base
    private HashMap<Integer, Post> postsDB = loadDateBase();


    public HashMap<Integer, Post> loadDateBase(){
        HashMap<Integer, Post> postsDB = new HashMap<>();
        ArrayList<Post> postsList = readDateBase();
        for(Post x :  postsList){
            postsDB.put(x.getPostId(), x);
        }
        return postsDB;
    }


    // Method to Read the data from JSON to List of Posts called postsList
    public ArrayList<Post> readDateBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:posts.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper om = new ObjectMapper();
        TypeReference<ArrayList<Post>> typeDef = new TypeReference<>() {
        };
        ArrayList<Post> postsList = null;
        try {
            postsList = om.readValue(file, typeDef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return postsList;
    }


    @Override
    public boolean postIdExists(int postId) {
        // Validate that the productId is in the Data Base
        if(postsDB.containsKey(postId))
            return true;
        else
            return false;
    }


    @Override
    public Post getPostById(int postId) throws PostNotFoundException {
        // Validate that the postId is in the Data Base
        if(postIdExists(postId))
            return  postsDB.get(postId);
        else
            throw new PostNotFoundException(postId);
    }


    @Override
    public void addPostInDB(Post post) throws PostAlreadyExistsException {
        int postId = post.getPostId();

        // Validate that the postId is not in the postsDB
        if( postsDB.containsKey(postId) )
            throw new PostAlreadyExistsException(postId);
        else
            postsDB.put(postId, post);
    }


}
