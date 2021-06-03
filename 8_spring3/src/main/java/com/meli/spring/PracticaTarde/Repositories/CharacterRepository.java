package com.meli.spring.PracticaTarde.Repositories;

import com.meli.spring.PracticaTarde.Classes.CharacterSW;

import java.util.List;

public interface CharacterRepository {
    List<CharacterSW> findAll();
}
