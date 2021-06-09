package com.meli.SocialMeli;

import com.meli.SocialMeli.model.Follow;
import com.meli.SocialMeli.model.Post;
import com.meli.SocialMeli.model.Product;
import com.meli.SocialMeli.model.User;
import com.meli.SocialMeli.repository.Tables;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Config {

    //Este metodo agrega usuarios hardcodeados, se llama desde el main
    public static void configUsers(){
        Tables.newUser(new User(-1,"Edefer"));
        Tables.newUser(new User(-1,"Ninon"));
        Tables.newUser(new User(-1,"Edefergio"));
        Tables.newUser(new User(-1,"Laenis"));
        Tables.newUser(new User(-1,"Reine"));
    }

    //Este metodo agrega follows hardcodeados, se llama desde el main
    public static void configFollows(){
        Tables.follow(new Follow(-1,1,2));
        Tables.follow(new Follow(-1,3,2));
        Tables.follow(new Follow(-1,5,2));
        Tables.follow(new Follow(-1,1,4));
        Tables.follow(new Follow(-1,1,5));
    }

    public static void configPosts(){

        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        try{
            int id;
            id=Tables.newProduct(new Product(-1,10,"a2420","monitor","asus","black","144hz"));
            Tables.newPost(new Post(-1,2,57,df.parse("05-03-2021"),id,100,2200.35));
            id=Tables.newProduct(new Product(-1,80,"g880","headphones","logitech","black",""));
            Tables.newPost(new Post(-1,2,80,df.parse("08-06-2021"),id,130,5200));
            id=Tables.newProduct(new Product(-1,33,"dav2","mouse","razer","black",""));
            Tables.newPost(new Post(-1,4,21,df.parse("01-06-2021"),id,200,1300.2));
        }catch(Exception e){}

    }
}
