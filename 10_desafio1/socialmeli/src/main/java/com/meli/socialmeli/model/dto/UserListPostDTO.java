package com.meli.socialmeli.model.dto;

import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserListPostDTO {
    private int userId;
    private ArrayList<PostDTO> posts = new ArrayList<>();
}
