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
public class UsuarioModel {

    private int userId;
    private String userName;
    private ArrayList<VendedorModel> follows;



    public void agregarFollow (VendedorModel follow){//Agrego un vendedor seguido a la lista de "seguidos"
        this.follows.add(follow);

    }

    public void quitarFollow(VendedorModel follow){
        this.follows.remove(follow);

    }

}
