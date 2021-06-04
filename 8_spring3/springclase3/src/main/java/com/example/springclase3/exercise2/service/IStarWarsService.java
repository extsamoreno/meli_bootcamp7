package com.example.springclase3.exercise2.service;

import com.example.springclase3.exercise2.repository.CharacterSW;

import java.util.ArrayList;

public interface IStarWarsService {

    ArrayList<String> getCharacterDTO(String word);
    ArrayList<CharacterSW> test();
}
