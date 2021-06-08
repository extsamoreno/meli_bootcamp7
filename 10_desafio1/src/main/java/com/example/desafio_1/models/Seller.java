package com.example.desafio_1.models;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
public class Seller extends User{
    private HashMap<Integer, Buyer> followers;

    public Seller(String name, int id) {
        super(name, id);
    }

    public Seller(String name) {
        super(name, 0);
        this.followers = new HashMap<>();
    }
}

