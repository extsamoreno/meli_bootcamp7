package com.meli.SocialMeli.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserFollowerListDto {
    int userId;
    String userName;
    ArrayList<UserBasicDto> followers;
}
