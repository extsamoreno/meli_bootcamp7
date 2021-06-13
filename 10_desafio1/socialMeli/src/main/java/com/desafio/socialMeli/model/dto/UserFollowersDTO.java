package com.desafio.socialMeli.model.dto;

import com.desafio.socialMeli.model.dao.models.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
public class UserFollowersDTO {
    private Integer userId;
    private String userName;
    private List<User> followers;


    public UserFollowersDTO() {
        this.userId = 0;
        this.userName = "";
        this.followers = new ArrayList<User>();
    }

    public void setFollowers(List<User> followers) {
        this.followers = followers;
    }
}