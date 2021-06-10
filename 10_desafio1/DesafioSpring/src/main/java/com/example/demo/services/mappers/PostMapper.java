package com.example.demo.services.mappers;

import com.example.demo.JavaUtils;
import com.example.demo.dtos.*;
import com.example.demo.exceptions.InvalidDateFormatException;
import com.example.demo.model.Category;
import com.example.demo.model.Post;
import com.example.demo.model.User;

import java.text.ParseException;
import java.util.ArrayList;
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
    public static NewPostWithPromResponseDTO toNewPostResponseDTO(NewPostWithPromRequestDTO newPostWithPromRequestDTO, Category category) {
        return new NewPostWithPromResponseDTO(newPostWithPromRequestDTO.getUserId()
                ,newPostWithPromRequestDTO.getId_post()
                ,newPostWithPromRequestDTO.getDate()
                ,newPostWithPromRequestDTO.getDetail()
                ,category.getCategory_id()
                ,newPostWithPromRequestDTO.getPrice()
                ,newPostWithPromRequestDTO.isHasPromo()
                ,newPostWithPromRequestDTO.getDiscount()
        );
    }

    public static PostDTO toPostDTO(Post post) throws InvalidDateFormatException {
        return new PostDTO(
                 post.getId_post()
                ,JavaUtils.dateToString(post.getDate())
                ,ProductMapper.toDetailDTO(post.getProduct())
                ,post.getCategory().getCategory_id()
                ,post.getPrice()
        );
    }
    public static PostWithPromDTO toPostWithPromDTO(Post post) throws InvalidDateFormatException {
        return new PostWithPromDTO(
                post.getId_post()
                ,JavaUtils.dateToString(post.getDate())
                ,ProductMapper.toDetailDTO(post.getProduct())
                ,post.getCategory().getCategory_id()
                ,post.getPrice()
                ,post.isHasPromo()
                ,post.getDiscount()
        );
    }
    public static Post toPost(NewPostRequestDTO newPostRequestDTO, Category category) throws ParseException, InvalidDateFormatException {
        return new Post(newPostRequestDTO.getId_post()
                ,JavaUtils.stringToDate(newPostRequestDTO.getDate())
                ,ProductMapper.toProduct(newPostRequestDTO.getDetail())
                ,category
                ,newPostRequestDTO.getPrice()
                ,false
                ,0
        );
    }
    public static Post toPost(NewPostWithPromRequestDTO newPostWithPromRequestDTO, Category category) throws ParseException, InvalidDateFormatException {
        return new Post(newPostWithPromRequestDTO.getId_post()
                ,JavaUtils.stringToDate(newPostWithPromRequestDTO.getDate())
                ,ProductMapper.toProduct(newPostWithPromRequestDTO.getDetail())
                ,category
                ,newPostWithPromRequestDTO.getPrice()
                ,newPostWithPromRequestDTO.isHasPromo()
                ,newPostWithPromRequestDTO.getDiscount()
        );
    }

    public static FollowedPostListResponseDTO toFollowedPostListResponseDTO(User user, List<Post> postList) throws InvalidDateFormatException {
        List<PostDTO> postDTOList = new ArrayList<>();
        for(Post post:postList){
            postDTOList.add(PostMapper.toPostDTO(post));
        }
        FollowedPostListResponseDTO followedPostListResponseDTO = new FollowedPostListResponseDTO(user.getUserId(), postDTOList);
        return followedPostListResponseDTO;
    }
}
