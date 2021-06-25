package project.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import project.Service.IDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import project.Service.dto.DishRequestDTO;
import project.Service.dto.IngredientsRequestDTO;
import project.Service.dto.IngredientsResponse;

import java.util.List;

@RestController
public class ControllerDishes {

    @Autowired
    IDishService dishService;

    @PostMapping("/totalCalories")
    public ResponseEntity<Float> totalCalories(@RequestBody DishRequestDTO dishDTO){
        return new ResponseEntity<>(dishService.calculateCalories(dishDTO), HttpStatus.OK);
    }

    @PostMapping("/ingredientsCalories")
    public ResponseEntity<List<IngredientsRequestDTO>> ingredientsCalories(@RequestBody DishRequestDTO dishDTO){
        return new ResponseEntity<List<IngredientsRequestDTO>>(dishService.calculateCaloriesPerIngredients(dishDTO), HttpStatus.OK);
    }

    @PostMapping("/ingredientMaxCalories")
    public ResponseEntity<IngredientsRequestDTO> ingredientsMostCalories(@RequestBody DishRequestDTO dishDTO){
        return new ResponseEntity<IngredientsRequestDTO>(dishService.ingredientsMostCalories(dishDTO), HttpStatus.OK);
    }

    public ControllerDishes() {
        this.dishService = dishService;
    }
}
