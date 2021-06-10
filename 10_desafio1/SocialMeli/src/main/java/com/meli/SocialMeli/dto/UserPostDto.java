package com.meli.SocialMeli.dto;

import com.meli.SocialMeli.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserPostDto {
    int userId;
    String userName;
    ArrayList<PostResDto> posts;
}
