package com.spring3.spring3.PracticoMañana.Controller;

import com.spring3.spring3.PracticoMañana.DTO.FoodDTO;
import com.spring3.spring3.PracticoMañana.DTO.FoodResponseDTO;
import com.spring3.spring3.PracticoMañana.Service.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodController {

    @Autowired
    IFoodService iFoodService;

    @PostMapping("/getFoodListData")
    public ResponseEntity<List<FoodResponseDTO>> getFoodListData(@RequestBody List<FoodDTO> Lfood) {
        List<FoodResponseDTO> foodResponseDTOList = new ArrayList<>();
        for (FoodDTO f : Lfood){
            foodResponseDTOList.add(iFoodService.responseFoodDTO(f));
        }
        return new ResponseEntity<>(foodResponseDTOList, HttpStatus.OK);
    }

    @PostMapping("/getFoodData")
    public ResponseEntity<FoodResponseDTO> getFoodData(@RequestBody FoodDTO food) {
        return new ResponseEntity<>(iFoodService.responseFoodDTO(food), HttpStatus.OK);
    }

}
