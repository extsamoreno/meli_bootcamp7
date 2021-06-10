package com.example.desafio_1.service.mapper;

import com.example.desafio_1.models.Post;
import com.example.desafio_1.service.dto.PostDTO;
import com.example.desafio_1.service.dto.PostPromoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Component
public class PostMapper implements IGenericMapper<Post, PostDTO, Object> {

    @Autowired
    ProductMapper productMapper;

    @Override
    public PostDTO toDto(Post model) {
        return new PostDTO(model.getId(), model.getUserId(), new SimpleDateFormat("dd-MM-yyyy").format(model.getCreatedDate()), model.getCategoryId(), model.getPrice(), productMapper.toDto(model.getDetail()));
    }

    @Override
    public Post toModel(PostDTO dto) {
        try {
            return new Post(dto.getId_post(), dto.getUserId(), new SimpleDateFormat("dd-MM-yyyy").parse(dto.getDate()), dto.getCategory(), dto.getPrice(), productMapper.toModel(dto.getDetail()), false, 0);
        }
        catch(Exception e) {
            return null; //Bad...
        }
    }

    @Override
    public Object toDtoResponse(Post model) {
        return null;
    }

    public PostPromoDTO toPostPromoDTO(Post model) {
       return new PostPromoDTO(model.getId(), model.getUserId(), new SimpleDateFormat("dd-MM-yyyy").format(model.getCreatedDate()), model.getCategoryId(), model.getPrice(), productMapper.toDto(model.getDetail()), model.isHasPromo(), model.getDiscount());
    }

    public Post toModel(PostPromoDTO dto) {

        Post post = toModel((PostDTO) dto);

        post.setHasPromo(dto.isHasPromo());
        post.setDiscount(dto.getDiscount());

        return post;
    }
}
