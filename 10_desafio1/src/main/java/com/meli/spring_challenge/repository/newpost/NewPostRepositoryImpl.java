package com.meli.spring_challenge.repository.newpost;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.spring_challenge.model.Post;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class NewPostRepositoryImpl implements NewPostRepository{
    private List<Post> newPostList;

    NewPostRepositoryImpl(){
        this.newPostList = loadDataBase();
    }

    @Override
    public void create(Post post) {
        newPostList.add(post);
    }

    @Override
    public List<Post> getAll() {
        return newPostList;
    }

    @Override
    public List<Post> getPostsByUserID(int userID) {
        return this.newPostList.stream()
                .filter(post -> post.getUserID() == userID)
                .collect(Collectors.toList());
    }

    @Override
    public Post getPostById(int postID){
        return this.newPostList.stream()
                .filter(post -> post.getPostID() == postID)
                .findFirst()
                .orElse(null);
    }

    private List<Post> loadDataBase() {
        File file = null;
        try{
            file = ResourceUtils.getFile("classpath:newposts.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper om = new ObjectMapper();
        TypeReference<List<Post>> typeDef = new TypeReference<>(){};
        List<Post> postList = null;
        try{
            postList = om.readValue(file,typeDef);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return postList;
    }

}
