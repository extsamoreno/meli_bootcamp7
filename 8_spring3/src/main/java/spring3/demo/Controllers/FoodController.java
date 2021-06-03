package spring3.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring3.demo.Models.DTOs.FoodDTO;
import spring3.demo.Models.DTOs.FoodResponseDTO;
import spring3.demo.Services.Interfaces.IFoodService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodController {

    @Autowired
    IFoodService iFoodService;

    @PostMapping("/postFood")
    public ResponseEntity<FoodResponseDTO> getFood(@RequestBody FoodDTO foodDTO){
        return new ResponseEntity<>(iFoodService.getFoodCalories(foodDTO), HttpStatus.OK);
    }

    @PostMapping( "/postFoodArr")
    public ResponseEntity<List<FoodResponseDTO>> getFoodList(@RequestBody FoodDTO[] foodDTOArr){
        var listFoodResponseDTO = new ArrayList<FoodResponseDTO>();
        for (FoodDTO food: foodDTOArr
             ) {
            listFoodResponseDTO.add(iFoodService.getFoodCalories(food));
        }
        return new ResponseEntity<>(listFoodResponseDTO, HttpStatus.OK);
    }
}
