package com.api.socialmeli.service;

import com.api.socialmeli.dto.FollowerDTO;
import com.api.socialmeli.dto.FollowersCountDTO;
import com.api.socialmeli.dto.FollowersDetailDTO;
import com.api.socialmeli.exception.EqualsIdException;
import com.api.socialmeli.exception.NotFoundIdException;
import com.api.socialmeli.repository.SocialMeliRepositoryImple;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;


@Service
@AllArgsConstructor @NoArgsConstructor
public class SocialMeliServiceImple implements SocialMeliService {

@Autowired
SocialMeliRepositoryImple socialMeliRepositoryImple;

    @Override
    public String US001(Integer userId, Integer userIdToFollow) throws Exception {

        if (userId.equals(userIdToFollow)) throw new EqualsIdException();

        if (socialMeliRepositoryImple.getUsers().get(userId)==null) throw new NotFoundIdException(userId);
        String userName = socialMeliRepositoryImple.getUsers().get(userId).getUserName();

        if (socialMeliRepositoryImple.getUsers().get(userIdToFollow)==null) throw new NotFoundIdException(userId);
        socialMeliRepositoryImple.getUsers().get(userIdToFollow).getFollowers().put(userId,userName);

        return "todo OK";
    }

    @Override
    public FollowersCountDTO US002(Integer userId) throws Exception {

        if (socialMeliRepositoryImple.getUsers().get(userId)==null) throw new NotFoundIdException(userId);

        String userName = socialMeliRepositoryImple.getUsers().get(userId).getUserName();
        Integer followersCount=socialMeliRepositoryImple.getUsers().get(userId).getFollowers().size();
        return new FollowersCountDTO(userId, userName, followersCount);
    }

    @Override
    public FollowersDetailDTO US003(int userId) throws Exception {

        if (socialMeliRepositoryImple.getUsers().get(userId)==null) throw new NotFoundIdException(userId);

        FollowersDetailDTO followersDetailDTO = new FollowersDetailDTO();
        followersDetailDTO.setUserId(userId);
        followersDetailDTO.setUserName(socialMeliRepositoryImple.getUsers().get(userId).getUserName());
        ArrayList<FollowerDTO> followersList = new ArrayList<>();

        socialMeliRepositoryImple.getUsers().get(userId).getFollowers().entrySet().forEach(
                entry->{
                    FollowerDTO follower = new FollowerDTO(entry.getKey(), entry.getValue());
                    followersList.add(follower);
                    followersDetailDTO.setFollowers(followersList);
                }
        );

        return followersDetailDTO;
    }

}
