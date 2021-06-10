package com.example.challenge.Services.Mappers;

import com.example.challenge.Models.Post;
import com.example.challenge.Models.User;
import com.example.challenge.Services.DTOs.*;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {

    public FollowerCountDTO userToFollowerCount(User user) {
        FollowerCountDTO followerCountDTO = new FollowerCountDTO();
        followerCountDTO.setId(user.getId());
        followerCountDTO.setName(user.getName());
        followerCountDTO.setCount(user.getFollowers().size());
        return followerCountDTO;
    }

    public PromoCountDTO userToPromoCount(User user) {
        int count = 0;
        PromoCountDTO promoCountDTO = new PromoCountDTO();
        promoCountDTO.setId(user.getId());
        promoCountDTO.setName(user.getName());
        for (Post p : user.getPosts()) {
            if (p.getHasPromo())
                count++;
        }
        promoCountDTO.setCount(count);
        return promoCountDTO;
    }

    public ResponsePromotionListDTO userToResponsePromo(User user) {
        ResponsePromotionListDTO responsePromotionListDTODTO = new ResponsePromotionListDTO(user.getId(), user.getName(),new ArrayList<>() );
        List<PostPromotionDTO> posts = responsePromotionListDTODTO.getPosts();
        for (Post p : user.getPosts()) {
            if (p.getHasPromo())
                posts.add(PostMapper.postToPostPromotionDTO(p));
        }
       // responsePromotionListDTODTO.setPosts(posts);
        return responsePromotionListDTODTO;
    }

    public GetUserDTO userToGetUser(User user) {
        List<PostDTO> postDTOList = new ArrayList<>();
        for(Post p : user.getPosts()){
            postDTOList.add(PostMapper.postToPostDTO(p));
        }
        GetUserDTO getUserDTO = new GetUserDTO(user.getId(), user.getName(), new ArrayList<>(), new ArrayList<>(), postDTOList);
        for (User u : user.getFollowed()) {
            UserDTO us = new UserDTO(u.getId(), u.getName());
            getUserDTO.getFollowed().add(us);
        }
        for (User u : user.getFollowers()) {
            UserDTO us = new UserDTO(u.getId(), u.getName());
            getUserDTO.getFollowers().add(us);

        }
        return getUserDTO;
    }

    public FollowersDTO userToFollowers(User user) {
        FollowersDTO followersDTO = new FollowersDTO(user.getId(), user.getName(), new ArrayList<>());
        for (User u : user.getFollowers()) {
            followersDTO.getFollowers().add(new UserDTO(u.getId(), u.getName()));
        }
        return followersDTO;
    }

    public FollowersDTO userToFollowed(User user) {
        FollowersDTO followersDTO = new FollowersDTO(user.getId(), user.getName(), new ArrayList<>());
        for (User u : user.getFollowed()) {
            followersDTO.getFollowers().add(new UserDTO(u.getId(), u.getName()));
        }
        return followersDTO;
    }
}
