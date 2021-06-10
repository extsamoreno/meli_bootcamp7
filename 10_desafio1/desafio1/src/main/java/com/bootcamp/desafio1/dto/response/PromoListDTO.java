package com.bootcamp.desafio1.dto.response;

import com.bootcamp.desafio1.dto.UserDTO;
import com.bootcamp.desafio1.dto.request.NewPostDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class PromoListDTO extends UserDTO {

    private ArrayList<PostDTO> posts;

    public PromoListDTO(int userId, String userName, ArrayList<PostDTO> posts) {
        super(userId, userName);
        this.posts = posts;
    }
}
