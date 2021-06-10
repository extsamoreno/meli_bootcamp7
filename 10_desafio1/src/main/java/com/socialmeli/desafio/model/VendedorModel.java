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

    public void addFollower(UsuarioModel follower){  //Agrego un usuario que sigue a este vendedor
        this.followers.add(follower);

    }

    public void addPost(PublicacionModel publicacion){
        this.posts.add(publicacion);
    }


    public void removeFollower(UsuarioModel follower){
        this.followers.remove(follower);

    }


}
