package com.socialmeli.desafio.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VendedorModel {

    private int userId;
    private String userName;
    private ArrayList<PublicacionModel> posts;
    private ArrayList<UsuarioModel> followers;

    public void agregarFollower (UsuarioModel follower){  //Agrego un usuario que sigue a este vendedor
        this.followers.add(follower);

    }


}
