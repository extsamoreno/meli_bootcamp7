package com.socialmeli.desafio.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;


@Getter
@Setter

public class PostOfFollowedSellerDTO {

    private int userId;
    private ArrayList<PostDTO> posts;

}
