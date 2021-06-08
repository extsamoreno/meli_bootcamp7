package com.reto1.demo.Model;

import lombok.Data;


public interface IUser {

    void follow(IUser iuser);
    default void sell(IProduct iProduct){
    }
}
