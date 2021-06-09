package com.example.demo.services.mappers;

import com.example.demo.dtos.FollowedPostListResponseDTO;
import com.example.demo.dtos.NewPostRequestDTO;
import com.example.demo.dtos.NewPostResponseDTO;
import com.example.demo.model.Category;
import com.example.demo.model.Post;
import com.example.demo.model.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class PostMapper {
    public static NewPostResponseDTO toNewPostResponseDTO(NewPostRequestDTO newPostRequestDTO, Category category) {
        return new NewPostResponseDTO(newPostRequestDTO.getUserId(),
                newPostRequestDTO.getId_post()
                ,newPostRequestDTO.getDate()
                ,newPostRequestDTO.getDetail()
                ,category.getCategory_id()
                ,newPostRequestDTO.getPrice()
                );
    }

    public static Post toPost(NewPostRequestDTO newPostRequestDTO, Category category) throws ParseException {
        return new Post(newPostRequestDTO.getId_post()
                , new SimpleDateFormat("dd-MM-yyyy").parse(newPostRequestDTO.getDate())
                ,ProductMapper.toProduct(newPostRequestDTO.getDetail())
                ,category
                ,newPostRequestDTO.getPrice());
    }

    public static FollowedPostListResponseDTO toFollowedPostListResponseDTO(User user, List<Post> postList){
        FollowedPostListResponseDTO followedPostListResponseDTO = new FollowedPostListResponseDTO(user.getUserId(), postList);
        return followedPostListResponseDTO;
    }
}
