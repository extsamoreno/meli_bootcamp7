package com.meli.demo.services.mappers;

import com.meli.demo.dtos.CountUsersDTO;
import com.meli.demo.dtos.PostDTO;
import com.meli.demo.models.CountUser;
import com.meli.demo.models.Post;

public class CountUserMapper {
    public static CountUsersDTO toDTO(CountUser count){
        return new CountUsersDTO(count.getUserid(),
                count.getUserName(),
                count.getFollowers_count());
    }

    public static CountUser toCount(CountUsersDTO count){
        return new CountUser(count.getUserid(),
                count.getUserName(),
                count.getFollowers_count());
    }
}
