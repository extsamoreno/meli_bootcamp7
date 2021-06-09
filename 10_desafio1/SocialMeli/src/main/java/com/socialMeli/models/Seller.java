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

    //0 si son iguales, <0 si username va antes de o.username, >0 al reves
    @Override
    public int compareTo(Seller o) {
        return (getUsername().compareTo(o.getUsername()));
    }
}
