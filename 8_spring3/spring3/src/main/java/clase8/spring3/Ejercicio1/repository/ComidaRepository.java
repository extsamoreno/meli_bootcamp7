package clase8.spring3.Ejercicio1.repository;


import clase8.spring3.Ejercicio1.service.dto.IngredienteDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Repository
public class ComidaRepository implements IComidaRepository {

    @Override
    public IngredienteDTO findIngredienteByName(String nombre){
        List<IngredienteDTO> ingredienteDTOS = null;
        ingredienteDTOS = loadDataBase();
        IngredienteDTO ingrediente = null;

        if(ingredienteDTOS != null){
            Optional<IngredienteDTO> item = ingredienteDTOS.stream().filter(i -> i.getName().equals(nombre)).findFirst();
            if(item.isPresent()) ingrediente = item.get();
        }
        return ingrediente;
    }

    private List<IngredienteDTO> loadDataBase() {
        File file = null;

        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<IngredienteDTO>> typeRef = new TypeReference<>() {};
        List<IngredienteDTO> ingredienteDTOS = null;

        try{
            ingredienteDTOS = objectMapper.readValue(file , typeRef);
        }catch (IOException e){
            e.printStackTrace();
        }
        return ingredienteDTOS;
    }
}
