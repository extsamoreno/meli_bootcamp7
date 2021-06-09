package com.api.socialmeli.service.mapper;

import com.api.socialmeli.dto.PostDTO;
import com.api.socialmeli.dto.PostNoUserIdDTO;
import com.api.socialmeli.model.PostModel;

public class PostMapper {

    public static PostModel dtoToModel (PostDTO post){
        PostModel model = new PostModel();
        model.setUserId(post.getUserId());
        model.setId_post(post.getId_post());
        model.setDate(post.getDate());
        model.setDetail(post.getDetail());
        model.setCategory(post.getCategory());
        model.setPrice(post.getPrice());
        model.setHasPromo(post.isHasPromo());
        model.setDiscount(post.getDiscount());

        return model;
    }

    public static PostDTO modelToDto (PostModel model){
        PostDTO dto = new PostDTO();
        dto.setUserId(model.getUserId());
        dto.setId_post(model.getId_post());
        dto.setDate(model.getDate());
        dto.setDetail(model.getDetail());
        dto.setCategory(model.getCategory());
        dto.setPrice(model.getPrice());
        dto.setHasPromo(model.isHasPromo());
        dto.setDiscount(model.getDiscount());

        return dto;
    }

    public static PostNoUserIdDTO toNoIdDto (PostModel model) {
        PostNoUserIdDTO dto = new PostNoUserIdDTO();
        dto.setId_post(model.getId_post());
        dto.setCategory(model.getCategory());
        dto.setDetail(model.getDetail());
        dto.setHasPromo(model.isHasPromo());
        dto.setPrice(model.getPrice());
        dto.setDiscount(model.getDiscount());

        return dto;
    }

}
