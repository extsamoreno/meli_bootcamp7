package com.example.desafiospring.socialmeli.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class User {
    int userId;
    String userName;
    List<Integer> followers;
    List<Integer> follows;
}
