package com.meli.desafio1.web.service;


import com.meli.desafio1.web.dto.PostDTO;
import com.meli.desafio1.web.model.Npost;

public class PostMapper {
    public static PostDTO toDTO(Npost npost){
        return new PostDTO(npost.getId_post(),npost.getPrice());
    }
}
