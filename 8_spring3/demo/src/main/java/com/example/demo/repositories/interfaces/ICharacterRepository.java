package com.example.demo.repositories.interfaces;

import java.util.List;
import com.example.demo.classes.Character;
public interface ICharacterRepository {

    List<Character> findCharacterByPortionName(String name);
}