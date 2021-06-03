package com.meli.spring.PracticaMañana.Services;

import com.meli.spring.PracticaMañana.Classes.Ingrediente;
import com.meli.spring.PracticaMañana.Classes.Plato;
import com.meli.spring.PracticaMañana.Dto.IngredienteDto;
import com.meli.spring.PracticaMañana.Dto.PlatoDto;
import com.meli.spring.PracticaMañana.Repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    FoodRepository foodRepository;

    @Override
    public PlatoDto transformPlate(Plato plato) {
        float totalCalorias = 0;
        IngredienteDto ingredienteMasCalorias = null;
        List<IngredienteDto> ingredienteDtoList = new ArrayList<>();

        for(Ingrediente item : plato.getIngredienteList()){
              IngredienteDto aux = foodRepository.findCalorias(item);
            ingredienteDtoList.add(aux);
            if(ingredienteMasCalorias == null){
                ingredienteMasCalorias = aux;
                totalCalorias += (item.getPesoGrs() / 100) * aux.getCalories();
            }else{
                if(ingredienteMasCalorias.getCalories() < aux.getCalories()){
                    ingredienteMasCalorias = aux;
                }
                totalCalorias += (item.getPesoGrs() / 100) * aux.getCalories();
            }
        }

    return new PlatoDto(plato.getNombre(),totalCalorias,ingredienteDtoList,ingredienteMasCalorias);
    }

    @Override
    public List<PlatoDto> transformAllPlate(List<Plato> platoList) {
        List<PlatoDto> result = new ArrayList<>();
        for(Plato item : platoList){
            result.add(transformPlate(item));
        }
        return result;
    }


}
