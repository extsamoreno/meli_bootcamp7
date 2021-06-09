package com.example.desafio1.controllers;

import com.example.desafio1.dtos.*;
import com.example.desafio1.exceptions.product.InvalidDiscountException;
import com.example.desafio1.exceptions.user.InvalidUserIdException;
import com.example.desafio1.exceptions.user.UserException;
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
            "idPost": 18,
            "date": "29-04-2021",
            "detail" :
                        {
                        "productId": 1,
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

    // Add a PROMO post of a product to a user
    // Parameters
    // @productDTO,  entity that has all the necessary information to add a product to a user (see example)
    // Response 200 / 400 -> if the user does not exists
    // Example: /products/newpromopost
    // Body example:
    /*
        {
            "userId": 1235,
            "idPost": 18,
            "date": "29-04-2021",
            "detail" :
                        {
                        "productId": 1,
                        "productName": "Silla Gamer",
                        "type": "Gamer",
                        "brand": "Racer",
                        "color": "Red & Black",
                        "notes": "Special Edition"
                        },
            "category": 100,
            "price": 1500.50,
            "hasPromo": true,
            "discount": 0.25
        }
     */
    @PostMapping("/newpromopost")
    public ResponseEntity<String> addNewPromoPost(@RequestBody PostPromoDTO postPromoDTO)
            throws InvalidUserIdException, InvalidDiscountException {
        return new ResponseEntity(iProductService.addNewPromoPost(postPromoDTO), HttpStatus.OK);
    }

    // Obtain all post of the last 2 week from the sellers the user follow
    // Parameters
    // @userId,  number that identifies the actual user
    // Response 200 / 400 -> if the user does not exists
    // Example:
    // /products/followed/1/list
    // /products/followed/1/list?order=date_asc // sort date in ascending order
    // /products/followed/1/list?order=date_des // sort date in descending order
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<ResponseFollowedPostDTO> getAllPostOfMyFollowed(@PathVariable int userId,
                                                                          @RequestParam(required = false,
                                                                                  defaultValue = "date_des")
                                                                                  String order)
            throws UserException {
        return new ResponseEntity(iProductService.getAllPostOfMyFollowed(userId, order), HttpStatus.OK);
    }


    // Get the number of PROMO products that user has
    // Parameters
    // @userId,  number that identifies the actual user
    // Response 200 / 400 -> if the user does not exists
    // Example: /products/5/countPromo
    @GetMapping("/{userId}/countPromo")
    public ResponseEntity<ResponsePromoCountDTO> getPromoProductsCount(@PathVariable int userId)
            throws InvalidUserIdException {
        return new ResponseEntity(iProductService.getPromoProductsCount(userId), HttpStatus.OK);
    }

    // Get the number of PROMO products that user has
    // Parameters
    // @userId,  number that identifies the actual user
    // Response 200 / 400 -> if the user does not exists
    // Example: /products/5/list
    @GetMapping("/{userId}/list")
    public ResponseEntity<ResponsePromoListDTO> getListOfPromoProducts(@PathVariable int userId)
            throws InvalidUserIdException {
        return new ResponseEntity(iProductService.getListOfPromoProducts(userId), HttpStatus.OK);
    }
}
