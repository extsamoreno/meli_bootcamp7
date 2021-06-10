package com.socialMeli.models;

import com.socialMeli.models.DTOs.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Seller extends User implements Comparable<Seller>{

    private ArrayList<UserDTO> followers;
    private ArrayList<Post> posts;
    private ArrayList<PromoPost> promoPosts;

    //0 if equals, < 0 if username goes beforeo.username, > 0 other case
    @Override
    public int compareTo(Seller o) {
        return (getUsername().compareTo(o.getUsername()));
    }
}
