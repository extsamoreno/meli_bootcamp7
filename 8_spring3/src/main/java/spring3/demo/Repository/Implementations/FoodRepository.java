package spring3.demo.Repository.Implementations;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;
import spring3.demo.Models.Entities.Ingredient;
import spring3.demo.Repository.Interfaces.IFoodRepository;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Repository
public class FoodRepository implements IFoodRepository {
    @Override
    public Ingredient getIngredientByName(String name) {
        var ingredients = loadIngredients();
        return ingredients.stream().filter(i -> i.getName().equals(name)).findAny().get();
    }

    private List<Ingredient> loadIngredients(){
        File file = null;

        try {
            file = ResourceUtils.getFile("classpath:static/food.json");
        }catch (Exception e){
            e.printStackTrace();
        }

        ObjectMapper omapper = new ObjectMapper();
        TypeReference<List<Ingredient>> typeRef= new TypeReference<>(){};
        List<Ingredient> lingredient = null;

        try{
            lingredient = omapper.readValue(file, typeRef);
        }catch (Exception e){
            e.printStackTrace();
        }

        return lingredient;
    }
}
