package com.example._spring3.repository;

import com.example._spring3.entity.MovieCharacter;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IStarWarsRepository {
    public List<MovieCharacter> getCharacterByName(String name);
}
