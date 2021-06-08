package com.example.MeliSocialApi.project.service.dto;

import com.example.MeliSocialApi.project.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;

@Getter
@Setter
@AllArgsConstructor
public class FollowersUserDTOResponse extends UserDTOResponse {
    private LinkedHashSet<UserDTOResponse> followers = new LinkedHashSet<>();
    public FollowersUserDTOResponse(User user, LinkedHashSet<UserDTOResponse> followers){
        super(user.getId(),user.getName());
        this.followers = followers;
    }
}
