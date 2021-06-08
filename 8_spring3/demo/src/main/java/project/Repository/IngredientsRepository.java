package project.Repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;
import project.Service.dto.DishResponseDTO;
import project.Service.dto.IngredientsResponseDTO;

import java.io.*;
import java.io.FileReader;
import java.util.List;
import java.util.Optional;

@Repository
public class IngredientsRepository implements IIngredientsRepository {

    @Override
    public IngredientsResponseDTO findIngridientsCaloriesByName(String Name) {
        List<IngredientsResponseDTO> ingredientsRes = null;
        ingredientsRes = LoadDataBase();
        IngredientsResponseDTO result = null;
        if (ingredientsRes != null) {
            Optional<IngredientsResponseDTO> item = ingredientsRes.stream()
            .filter(ingredientDTO -> ingredientDTO.getName().equals(Name))
                    .findFirst();
            if (item.isPresent())
                result = item.get();
        }
        return result;
    }

    private List<IngredientsResponseDTO> LoadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile( "src/main/resources/static/food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<IngredientsResponseDTO>> typeRef = new TypeReference<>() {};
        List<IngredientsResponseDTO> ingredientsResponseDTOs = null;
        try {
            ingredientsResponseDTOs = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ingredientsResponseDTOs;
    }
}
