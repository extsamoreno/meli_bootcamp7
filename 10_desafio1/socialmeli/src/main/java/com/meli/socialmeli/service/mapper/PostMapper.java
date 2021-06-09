package com.meli.socialmeli.service.mapper;

import com.meli.socialmeli.model.Post;
import com.meli.socialmeli.service.dto.PostDTO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PostMapper {

    public static PostDTO modelToDTO(Post model) {
        return new PostDTO(
                model.getUserId(),
                model.getPostId(),
                model.getDateCreation(),
                ProductMapper.modelToDTO(model.getProduct()),
                model.getCategoryId(),
                model.getPrice());
    }

    public static Post DTOToModel(PostDTO dto) {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return new Post(
                dto.getPostId(),
                dto.getUserId(),
                localDate.format(formatter),
                localDate.format(formatter),
                dto.getCategory(),
                ProductMapper.DTOToModel(dto.getDetail()),
                dto.getPrice(),
                false,
                0);
    }
}
