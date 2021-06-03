package com.meli.spring.Controllers;

import com.meli.spring.Classes.Plato;
import com.meli.spring.Dto.PlatoDto;
import com.meli.spring.Services.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FoodController {

    @Autowired
    FoodService foodService;

    @PostMapping("/transform/plate")
    public PlatoDto transformPlate(@RequestBody Plato plato){
        return foodService.transformPlate(plato);
    }

    @PostMapping("/transform/AllPlates")
    public List<PlatoDto> transformAllPlates(@RequestBody List<Plato> platoList){
        return foodService.transformAllPlate(platoList);
    }

}
