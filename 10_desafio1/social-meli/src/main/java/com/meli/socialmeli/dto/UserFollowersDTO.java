package com.meli.socialmeli.dto;

import com.meli.socialmeli.model.User;
import lombok.*;

import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserFollowersDTO {
    private Integer userId;
    private String userName;
    private List<User> followers;
}
