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
public class UserFollowedDTO {
    private Integer userId;
    private String userName;
    private List<User> followedList;


    public UserFollowedDTO() {
        this.userId = 0;
        this.userName = "";
        this.followedList = new ArrayList<User>();
    }

    public void setFollowedList(List<User> followedList) {
        this.followedList = followedList;
    }
    public List<User> getFollowedList() { return this.followedList; }
}