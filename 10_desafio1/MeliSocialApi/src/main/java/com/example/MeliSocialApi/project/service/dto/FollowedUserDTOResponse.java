package com.example.MeliSocialApi.project.service.dto;

import com.example.MeliSocialApi.project.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.LinkedList;

@Getter
@Setter
@AllArgsConstructor
public class FollowedUserDTOResponse extends UserDTOResponse {
    private LinkedList<UserDTOResponse> followed = new LinkedList<>();
    public FollowedUserDTOResponse(User user, LinkedList<UserDTOResponse> followers){
        super(user.getId(),user.getName());
        this.followed = followers;
    }
}