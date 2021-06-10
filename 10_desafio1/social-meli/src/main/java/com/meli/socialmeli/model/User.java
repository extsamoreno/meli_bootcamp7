package com.meli.socialmeli.model;

import lombok.*;

import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer userId;
    private String userName;
    private List<User> followed;
    private List<User> followers;
    private List<Post> post;
}
