package com.meli.spring.PracticaTarde.Repository;

import com.meli.spring.PracticaTarde.Classes.CharacterSW;

import java.util.List;

public interface CharacterRepository {
    List<CharacterSW> findAll();
}
