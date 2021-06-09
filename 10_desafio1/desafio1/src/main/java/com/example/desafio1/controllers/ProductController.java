package com.example.desafio1.controllers;

import com.example.desafio1.dtos.PostDTO;
import com.example.desafio1.dtos.ResponseFollowedPostDTO;
import com.example.desafio1.exceptions.InvalidUserIdException;
import com.example.desafio1.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    IProductService iProductService;

    // Add a post of a product to a user
    // Parameters
    // @productDTO,  entity that has all the necessary information to add a product to a user (see example)
    // Response 200 / 400 -> if the user does not exists
    // Example: /products/newpost
    // Body example:
    /*
        {
            "userId": 1235,
            "id_post": 18,
            "date": "29-04-2021",
            "detail" :
                        {
                        "product_id": 1,
                        "productName": "Silla Gamer",
                        "type": "Gamer",
                        "brand": "Racer",
                        "color": "Red & Black",
                        "notes": "Special Edition"
                        },
            "category": 100,
            "price": 1500.50
        }
     */
    @PostMapping("/newpost")
    public ResponseEntity<String> addNewPost(@RequestBody PostDTO postDTO) throws InvalidUserIdException {
        return new ResponseEntity(iProductService.addNewPost(postDTO), HttpStatus.OK);
    }

    // Obtain all post of the last 2 week from the sellers the user follow
    // Parameters
    // @userId,  number that identifies the actual user
    // Response 200 / 400 -> if the user does not exists
    // Example: /products/followed/1/list
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<ResponseFollowedPostDTO> getAllPostOfMyFollowed(@PathVariable int userId)
            throws InvalidUserIdException {
        return new ResponseEntity(iProductService.getAllPostOfMyFollowed(userId), HttpStatus.OK);
    }
}
