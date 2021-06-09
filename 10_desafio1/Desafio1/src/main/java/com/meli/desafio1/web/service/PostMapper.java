package com.meli.desafio1.web.service;


import com.meli.desafio1.web.dto.PostDTO;
import com.meli.desafio1.web.model.Npost;

public class PostMapper {
    public static PostDTO toDTO(Npost npost){
        return new PostDTO(npost.getUserId(),npost.getId_post(),npost.getDate(),npost.getDetail(),npost.getCategory(),npost.getPrice());
    }
    public static Npost toModel(PostDTO postDTO){
        return new Npost(postDTO.getUserId(),postDTO.getId_post(),postDTO.getDate(),postDTO.getDetail(),postDTO.getCategory(),postDTO.getPrice());
    }


}
