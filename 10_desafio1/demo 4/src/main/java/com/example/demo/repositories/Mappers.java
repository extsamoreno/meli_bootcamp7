package com.example.demo.repositories;

import com.example.demo.DTO.PostDTO;
import com.example.demo.DTO.PostPromoDTO;
import com.example.demo.DTO.UserDTO;
import com.example.demo.entities.Post;
import com.example.demo.entities.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Mappers {

    public static List<PostPromoDTO> toPostPromoDTO(List<Post> list) {
        List<PostPromoDTO> result = new ArrayList<>();

        for (Post post : list) {
            PostPromoDTO postPromoDTO = new PostPromoDTO();
            postPromoDTO.setId_post(post.getId_post());
            postPromoDTO.setDate(post.getDate());
            postPromoDTO.setDetail(post.getDetail());
            postPromoDTO.setCategory(post.getCategory());
            postPromoDTO.setPrice(post.getPrice());
            postPromoDTO.setHasPromo(true);
            postPromoDTO.setDiscount(post.getDiscount());

            result.add(postPromoDTO);
        }
        return result;
    }

    public static List<PostDTO> toPostDTO(List<Post> list) {
        List<PostDTO> result = new ArrayList<>();

        for (Post post : list) {
            PostDTO postDTO = new PostDTO();
            postDTO.setId_post(post.getId_post());
            postDTO.setDate(post.getDate());
            postDTO.setDetail(post.getDetail());
            postDTO.setCategory(post.getCategory());
            postDTO.setPrice(post.getPrice());

            result.add(postDTO);
        }

        return result;
    }

    public static UserDTO toUserDTO(User user) {
        UserDTO userDto = new UserDTO();
        userDto.setUserId(user.getUserId());
        userDto.setUserName(user.getUserName());
        return userDto;
    }

    public static List<UserDTO> toUserDTOlist(List<User> users) {

        List<UserDTO> result = new ArrayList<>();
        for (User user : users) {
            if (user != null) {
                UserDTO userDto = new UserDTO();
                userDto.setUserId(user.getUserId());
                userDto.setUserName(user.getUserName());
                result.add(userDto);
            }
        }
        return result;
    }
}
