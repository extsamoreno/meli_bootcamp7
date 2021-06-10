package com.example.desafiospring.socialmeli.model;

import com.example.desafiospring.socialmeli.service.DTO.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Seller extends User implements Comparable<Seller> {
    /**
     *SELLER
     */
    private ArrayList<UserDTO> followers;
    private ArrayList<Post> posts;

    public Seller(int userId, String username, List<User> followers, List<User> followed, List<Post> posts) {
        super(userId, username, followers, followed, posts);
    }

    //si son iguales devuelve 0
    @Override
    public int compareTo(Seller o) {
        return (getUsername().compareTo(o.getUsername()));
    }
}