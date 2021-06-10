package com.example.demo.repositories;

import com.example.demo.DTO.PostDTO;
import com.example.demo.DTO.PostPromoDTO;
import com.example.demo.entities.Post;

import java.util.ArrayList;
import java.util.List;

public class Mappers {

    public static List<PostPromoDTO> mapperToPostPromoDTO(List<Post> list) {
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

    public static List<PostDTO> mapperToPostDTO(List<Post> list) {
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

}
