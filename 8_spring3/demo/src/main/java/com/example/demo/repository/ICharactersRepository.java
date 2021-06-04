package com.example.demo.repository;

import com.example.demo.domains.Character;

import java.util.List;

public interface ICharactersRepository {

    public List<Character> getByName(String name);
}
