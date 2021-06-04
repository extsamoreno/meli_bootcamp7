package com.spring8tarde.demo.Repository;

import com.spring8tarde.demo.Model.CharacterStar;

import java.io.IOException;
import java.util.ArrayList;

public interface ICharacterRepository {

    ArrayList<CharacterStar> getCharacterByName(String name) throws IOException;
}
