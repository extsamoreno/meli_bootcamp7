package com.meli.socialmeli.service.mapper;

import com.meli.socialmeli.model.Post;
import com.meli.socialmeli.service.dto.PostDTO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PostMapper {

    public static PostDTO modelToDTO(Post model) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return new PostDTO(
                model.getUserId(),
                model.getPostId(),
                model.getDateCreation().format(formatter),
                ProductMapper.modelToDTO(model.getProduct()),
                model.getCategoryId(),
                model.getPrice(),
                model.isHasPromo(),
                model.getDiscount());
    }

    public static Post DTOToModel(PostDTO dto) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localDate;
        if (dto.getDate() == null) {
            localDate = LocalDate.now();
        } else {
            localDate = LocalDate.parse(dto.getDate(), formatter);
        }
        return new Post(
                dto.getPostId(),
                dto.getUserId(),
                localDate,
                localDate,
                dto.getCategory(),
                ProductMapper.DTOToModel(dto.getDetail()),
                dto.getPrice(),
                dto.isHasPromo(),
                dto.getDiscount());
    }
}
