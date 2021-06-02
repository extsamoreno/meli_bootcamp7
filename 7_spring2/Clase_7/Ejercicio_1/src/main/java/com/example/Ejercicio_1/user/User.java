package com.example.Ejercicio_1.user;


import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor

public class User {
    private Integer id;
    private String name;
    private String surname;
    private List<String> hobbies;

    public User(String name, String surname) {
        this.id = 1;
        this.name = name;
        this.surname = surname;
        this.hobbies =createLis();
    }

    public List<String> createLis(){
        List<String> test = new ArrayList<>();
        test.add("tESTE");
        test.add("tESTE1");
        test.add("tESTE2");
        return test;


    }
}
