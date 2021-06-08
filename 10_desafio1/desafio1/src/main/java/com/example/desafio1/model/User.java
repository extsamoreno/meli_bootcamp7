package com.example.desafio1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    private String name;
    //followers and followed are users id lists
    private ArrayList<Integer> followers;
    private ArrayList<Integer> followed;
}
