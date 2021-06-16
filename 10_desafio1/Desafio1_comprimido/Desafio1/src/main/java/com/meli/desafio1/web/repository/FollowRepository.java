package com.meli.desafio1.web.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.desafio1.web.dto.FollowDTO;
import com.meli.desafio1.web.model.Follow;
import com.meli.desafio1.web.model.Npost;
import com.meli.desafio1.web.service.FollowMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository


public class FollowRepository implements IFollowRepository{
    private List<Follow> followList = loadDataFollow();
    @Override
    public List<Follow> getFollowList(){
        return this.followList;
    }
    @Override
    public void setFollowList(List <Follow> followList){
        this.followList = followList;
    }

    @Override
    public Follow getFollowById(int userId) {

        for(Follow follow:this.followList){
            if(follow.getUserId()==userId){
                return follow;
            }
        }
        return null;
    }


    private List<Follow> loadDataFollow() {
        File file = null;
        try{
            file = ResourceUtils.getFile("classpath:follow.json");
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Follow>> typeRef = new TypeReference<>() {};
        List<Follow> follows = null;

        try {
            follows = objectMapper.readValue(file,typeRef);
        } catch (IOException e){
            e.printStackTrace();
        }
        return follows;

    }





}
