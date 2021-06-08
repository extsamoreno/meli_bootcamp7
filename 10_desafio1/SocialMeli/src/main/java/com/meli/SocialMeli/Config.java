package com.meli.SocialMeli;

import com.meli.SocialMeli.model.Follow;
import com.meli.SocialMeli.model.User;
import com.meli.SocialMeli.repository.Tables;

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
        Tables.follow(new Follow(-1,1,3));
        Tables.follow(new Follow(-1,1,5));
    }
}
