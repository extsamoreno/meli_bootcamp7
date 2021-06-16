package com.meli.desafio1.web.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.desafio1.web.model.Npost;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepository implements IPostRepository{

    private List<Npost> postList = loadDataPosts();
    @Override
    public List <Npost> getPostList(){
        return postList;
    }
    public void setPostList(Npost npost){
        this.postList.add(npost);
    }

    @Override
    public Npost getPostById(int postId) {
        for(Npost npost: postList){
            if(npost.getId_post()==postId){
                return npost;
            }
        }
        return null;
    }

    @Override
    public List<Npost> getPromoPostByUserId(int userId) {
        List<Npost> nposts = new ArrayList<>();
        for(Npost npost: postList){
            if(npost.getUserId()==userId && npost.isHasPromo()){
                nposts.add(npost);
            }
        }
        return nposts;
    }

    private List<Npost> loadDataPosts() {
        File file = null;
        try{
            file = ResourceUtils.getFile("classpath:posts.json");
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Npost>> typeRef = new TypeReference<>() {};
        List<Npost> npost = null;

        try {
            npost = objectMapper.readValue(file,typeRef);
        } catch (IOException e){
            e.printStackTrace();
        }
        return npost;

    }
}
