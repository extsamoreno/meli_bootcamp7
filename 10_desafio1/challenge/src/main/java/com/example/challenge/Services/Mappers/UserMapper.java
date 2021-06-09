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
        for(Post p : user.getPosts()){
            if(p.getHasPromo())
                count++;
        }
        promoCountDTO.setCount(count);
        return promoCountDTO;
    }

    public ResponsePromotionListDTO userToResponsePromo(User user) {
        ResponsePromotionListDTO responsePromotionListDTODTO = new ResponsePromotionListDTO();
        responsePromotionListDTODTO.setUserId(user.getId());
        responsePromotionListDTODTO.setUserName(user.getName());
        List<PostPromotionDTO> posts = new ArrayList<>();
        for(Post p : user.getPosts()){
            if(p.getHasPromo())
                posts.add(PostMapper.postToPostPromotionDTO(p));
        }
        responsePromotionListDTODTO.setPosts(posts);
        return responsePromotionListDTODTO;
    }

    public GetUserDTO userToGetUser(User user) {
        GetUserDTO getUserDTO = new GetUserDTO();
        getUserDTO.setId(user.getId());
        getUserDTO.setName(user.getName());
        getUserDTO.setFollowed( new ArrayList<>());
        getUserDTO.setFollowers(new ArrayList<>());
        for (User u : user.getFollowed()) {
            UserDTO us = new UserDTO(u.getId(), u.getName());
            getUserDTO.getFollowed().add(us);
        }
        for (User u : user.getFollowers()) {
            UserDTO us = new UserDTO(u.getId(), u.getName());
            getUserDTO.getFollowers().add(us);

        }
        getUserDTO.setPosts(user.getPosts());
        return getUserDTO;
    }

    public FollowersDTO userToFollowers(User user){
        FollowersDTO followersDTO = new FollowersDTO();
        followersDTO.setFollowers(new ArrayList<>());
        followersDTO.setUserName(user.getName());
        followersDTO.setId(user.getId());
        for(User u : user.getFollowers()){
            followersDTO.getFollowers().add(new UserDTO(u.getId(), u.getName()));
        }
        return followersDTO;
    }

    public FollowersDTO userToFollowed(User user){
        FollowersDTO followersDTO = new FollowersDTO();
        followersDTO.setFollowers(new ArrayList<>());
        followersDTO.setUserName(user.getName());
        followersDTO.setId(user.getId());
        for(User u : user.getFollowed()){
            followersDTO.getFollowers().add(new UserDTO(u.getId(), u.getName()));
        }
        return followersDTO;
    }
}
