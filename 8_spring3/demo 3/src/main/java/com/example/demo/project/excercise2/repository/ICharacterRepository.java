package com.example.demo.project.excercise2.repository;
import com.example.demo.project.excercise2.repository.entities.CharacterSW;

import java.util.ArrayList;
import java.util.List;

public interface ICharacterRepository {

    public ArrayList<CharacterSW> getCharacterList();
}
