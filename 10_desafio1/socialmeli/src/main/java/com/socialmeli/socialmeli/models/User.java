package com.socialmeli.socialmeli.models;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class User {
    int userId;
    String userName;
    List<User> followers;
    List<User> follows;
}
