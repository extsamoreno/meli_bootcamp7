package com.example.demo.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@AllArgsConstructor
public class User {


    private int id;

    private String name;
    private String surname;
    private List<String> cloth;

    public User(String name, String surname){
        this.id = 1;
        this.name = name;
        this.surname = surname;
        this.cloth = fillList();
    }

    private List<String> fillList(){
        List<String> list = new ArrayList<String>();
        list.add("T-shirt");
        list.add("Pant");
        list.add("jacket");

        return list;

    }
}

