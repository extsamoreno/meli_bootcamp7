package project.Repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;
import project.Service.dto.IngredientsResponse;

import java.io.*;
import java.util.List;
import java.util.Optional;

@Repository
public class IngredientsRepository implements IIngredientsRepository {

    @Override
    public IngredientsResponse findIngridientsCaloriesByName(String Name) {
        List<IngredientsResponse> ingredientsRes = null;
        ingredientsRes = LoadDataBase();
        IngredientsResponse result = null;
        if (ingredientsRes != null) {
            Optional<IngredientsResponse> item = ingredientsRes.stream()
            .filter(ingredientDTO -> ingredientDTO.getName().equals(Name))
                    .findFirst();
            if (item.isPresent())
                result = item.get();
        }
        return result;
    }

    private List<IngredientsResponse> LoadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile( "src/main/resources/static/food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<IngredientsResponse>> typeRef = new TypeReference<>() {};
        List<IngredientsResponse> ingredientsResponseDTOs = null;
        try {
            ingredientsResponseDTOs = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ingredientsResponseDTOs;
    }
}
