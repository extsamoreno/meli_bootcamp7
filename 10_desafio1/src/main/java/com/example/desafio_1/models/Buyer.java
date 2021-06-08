package com.example.desafio_1.models;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
public class Buyer extends User {
    private HashMap<Integer, Seller> following;

    public Buyer(String name, int id) {
        super(name, id);
    }

    public Buyer(String name) {
        super(name, 0);
        this.following = new HashMap<>();
    }
}
