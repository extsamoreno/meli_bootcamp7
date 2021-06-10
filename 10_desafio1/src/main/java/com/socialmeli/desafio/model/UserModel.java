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
public class UserModel {

    private int userId;
    private String userName;
    private ArrayList<SellerModel> follows;



    public void addFollow(SellerModel follow){//Agrego un vendedor seguido a la lista de "seguidos"
        this.follows.add(follow);

    }

    public void removeFollow(SellerModel follow){
        this.follows.remove(follow);

    }

}
