package com.meli.desafio1.web.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.desafio1.web.model.Npost;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class PostRepository implements IPostRepository{

    private List<Npost> listaPosts = loadDataPosts();
    @Override
    public List <Npost> getListaPosts(){
        return listaPosts;
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
