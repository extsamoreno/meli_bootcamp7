package com.example.demo.Services;

import com.example.demo.Entities.User;
import com.example.demo.Exeptions.BadRequestExeption;
import com.example.demo.Exeptions.CustomExeption;
import com.example.demo.Services.DTO.ResponseCountFollowersDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SocialMeliService {
/*
    public void addFollow(int userId, int sellerId) throws CustomExeption {

        if(!users.containsKey(userId)){
            throw new BadRequestExeption("User not exist");
        }
        if(!users.containsKey(sellerId)){
            throw new BadRequestExeption("Seller not exist");
        }

        users.get(sellerId).getFollowers().add(users.get(userId));

    }

    public ResponseCountFollowersDTO countFollowers (int sellerId){
        return new ResponseCountFollowersDTO(
                sellerId,
                users.get(sellerId).getUserName(),
                users.get(sellerId).getFollowers().size()
        );
    }

    public List listFollowersbySeller(int sellerId){
        return users.get(sellerId).getFollowers();
    }
    /*
    public List listSellersbyuser(int userId){
        List<User> list = new ArrayList();

        for(Map.Entry user: users.entrySet()){
            if(user.getValu){

            }
        }
        return list;
    }*/

}
