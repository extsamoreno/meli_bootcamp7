package com.example.desafiospring.socialmeli.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class User {
    int userId;     //filtrar los parametros, como identificamos a cada usuario
    String userName;
    List<Integer> followers;
    List<Integer> follows;
}
