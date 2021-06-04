package com.spring3.demo.Service;

import com.spring3.demo.Objects.DTO.DishDTO;
import com.spring3.demo.Objects.Dish;
import com.spring3.demo.Objects.Ingredient;

import java.io.IOException;
import java.util.ArrayList;

public interface IfoodService {

    DishDTO getfood(Dish dish) throws IOException;

    ArrayList<DishDTO> getListFood(ArrayList<Dish> listDish) throws IOException;
}
