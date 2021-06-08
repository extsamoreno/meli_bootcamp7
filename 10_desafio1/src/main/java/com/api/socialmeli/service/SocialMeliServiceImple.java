package com.api.socialmeli.service;

import com.api.socialmeli.dto.FollowersCountDTO;
import com.api.socialmeli.repository.SocialMeliRepositoryImple;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor @NoArgsConstructor
public class SocialMeliServiceImple implements SocialMeliService {

@Autowired
SocialMeliRepositoryImple socialMeliRepositoryImple;

    @Override
    public String US001(Integer userId, Integer userIdToFollow) {

        if (userId.equals(userIdToFollow)) return "Exception Id Equals";

        if (socialMeliRepositoryImple.getUsers().get(userId)==null) return "Not found Id";
        String userName = socialMeliRepositoryImple.getUsers().get(userId).getUserName();

        if (socialMeliRepositoryImple.getUsers().get(userIdToFollow)==null) return "Not found User ID to Follow";
        socialMeliRepositoryImple.getUsers().get(userIdToFollow).getFollowers().put(userId,userName);

        return "todo OK";
    }

    @Override
    public FollowersCountDTO US002(Integer userId){

        if (socialMeliRepositoryImple.getUsers().get(userId)==null) return null; //aca va exception

        String userName = socialMeliRepositoryImple.getUsers().get(userId).getUserName();
        Integer followersCount=socialMeliRepositoryImple.getUsers().get(userId).getFollowers().size();
        return new FollowersCountDTO(userId, userName, followersCount);
    }

}
