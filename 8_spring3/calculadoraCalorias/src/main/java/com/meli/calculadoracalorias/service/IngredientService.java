package com.meli.calculadoracalorias.service;

import com.meli.calculadoracalorias.domain.Ingredient;
import com.meli.calculadoracalorias.service.dto.IngredientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class IngredientService implements IIngredientService {

    @Autowired
    IngredientMapper ingredientMapper;

    @Override
    public List<Ingredient> getAll() {
        return new GenericLoader<Ingredient>().loadData();
    }

    @Override
    public List<IngredientDTO> getAllInDto() {
        return getAll().stream().map(x -> ingredientMapper.toDto(x)).collect(Collectors.toList());
        /* List<IngredientDTO> listDto = new ArrayList<IngredientDTO>();
        List<Ingredient> listIngredient = getAll();

        try {
            //return getAll().stream().map(x -> ingredientMapper.toDto(x)).collect(Collectors.toList());
            for (Ingredient ingredient:
                 listIngredient) {
                IngredientDTO ingredientDTO = ingredientMapper.toDto(ingredient);
                listDto.add(ingredientDTO);
            }
            //listIngredient.forEach(x -> listDto.add(ingredientMapper.toDto((Ingredient) x)));

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listDto; */
    }
}
