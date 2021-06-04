package com.example.springclase3.exercise2.service.mapper;

import com.example.springclase3.exercise2.repository.CharacterSW;

import java.util.ArrayList;
import java.util.List;

public class StarWarsMapper {

    public static ArrayList<String> toStrArr(List<CharacterSW> characters){
        ArrayList<String> r = new ArrayList<>();
        for (CharacterSW c:
        characters){
            r.add(c.getName());
        }
        return r;
    }

}
