package com.example.desafiospring.socialmeli.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class User {
    int userId;     //filtrar los parametros, como identificamos a cada user
    String userName;  //los param de user que devolveria
    List<User> followers;
    List<User> followed;
    List<Post> posts;
}
