package com.spring3.spring3.PracticoTarde.Repository;

import com.spring3.spring3.PracticoTarde.Classes.SWCharacter;

import java.util.List;

public interface IStarWarsRepository {

    public List<SWCharacter> findAll();
}
