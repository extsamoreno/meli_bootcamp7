package com.meli.SocialMeli.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserFollowedpostDto {
    int userId;
    ArrayList<PostResDto> posts;
}
