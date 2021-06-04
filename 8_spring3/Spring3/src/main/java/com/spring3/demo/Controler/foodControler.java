package com.spring3.demo.Controler;

import com.spring3.demo.Objects.DTO.DishDTO;
import com.spring3.demo.Service.IfoodService;
import com.spring3.demo.Objects.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@RestController
@RequestMapping("/food")
public class foodControler {

    @Autowired
    IfoodService ifoodService;

    @PostMapping("/getDish")
    public ResponseEntity<DishDTO> getDish(@RequestBody Dish dish) throws IOException {
        return new ResponseEntity<>(ifoodService.getfood(dish), HttpStatus.OK);
    }

    @GetMapping("/hello3")
    public String hello() {
        return "hello";
    }

    @PostMapping("/getListDish")
    public ResponseEntity<ArrayList<DishDTO>> getListDish(@RequestBody ArrayList<Dish> listDish) throws IOException {
        return new ResponseEntity<>(ifoodService.getListFood(listDish), HttpStatus.OK);
    }

}
