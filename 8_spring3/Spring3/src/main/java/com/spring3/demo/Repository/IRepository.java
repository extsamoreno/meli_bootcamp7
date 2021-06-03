package com.spring3.demo.Repository;

import com.spring3.demo.Objects.Ingredient;

import java.io.IOException;
import java.util.ArrayList;


public interface IRepository {

    Ingredient getIngredientByName(String name) throws IOException;

}
