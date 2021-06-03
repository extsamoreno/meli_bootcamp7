package com.example.spring3.repositories.interfaces;

import java.util.List;
import com.example.spring3.classes.Character;
public interface ICharacterRepository {

    List<Character> findCharacterByPortionName(String name);
}
