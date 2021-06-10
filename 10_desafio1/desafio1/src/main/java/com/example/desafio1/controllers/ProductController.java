package com.example.desafio1.controllers;

import com.example.desafio1.dtos.*;
import com.example.desafio1.exceptions.product.ProductException;
import com.example.desafio1.exceptions.product.SameIdPostException;
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

    /**
     * Add a post of a product to a user
     * @param postDTO  entity that has all the necessary information to add a product to a user (see example)
     * @return String which idProduct was added to the userId
     * Response
     * 200 -> OK
     * 400
     * if the user does not exists
     * if the user already has a post with the same idPost
     * if date of the post > today
     * Example: /products/newpost
     * Body example:

        {
            "userId": 1,
            "idPost": 18,
            "date": "01-06-2021",
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

     *   @author Sapaya Nicolás Martín
    */
    @PostMapping("/newpost")
    public ResponseEntity<String> addNewPost(@RequestBody PostDTO postDTO) throws InvalidUserIdException,
            ProductException {
        return new ResponseEntity<>(iProductService.addNewPost(postDTO), HttpStatus.OK);
    }

    /**
     * Add a PROMO post of a product to a user
     * @param postPromoDTO  entity that has all the necessary information to add a product to a user (see example)
     * @return String which idProduct with promo was added to the userId
     * Response
     * 200 -> OK
     * 400
     * if the user does not exists
     * if the user already has a post with the same idPost
     * if date of the post > today
     * if discount is < 0.00 or >  1.00
     * Example: /products/newpromopost
     * Body example:

        {
            "userId": 5,
            "idPost": 18,
            "date": "01-06-2021",
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

      *   @author Sapaya Nicolás Martín
     */
    @PostMapping("/newpromopost")
    public ResponseEntity<String> addNewPromoPost(@RequestBody PostPromoDTO postPromoDTO)
            throws InvalidUserIdException, ProductException {
        return new ResponseEntity<>(iProductService.addNewPromoPost(postPromoDTO), HttpStatus.OK);
    }

    /**
     * Obtain all post of the last 2 week from the sellers the user follow
     * @param userId  number that identifies the actual user
     * @param order default value = date_des, not required through request param must be date_asc or date_des
     * @return ResponseFollowedPostDTO that contains userId and a list of post
     * Response
     * 200 -> OK
     * 400
     * if the user does not exists
     * if passed through request param, order is not date_asc or date_des
     * Example:
     * /products/followed/1/list
     * /products/followed/1/list?order=date_asc // sort date in ascending order
     * /products/followed/1/list?order=date_des // sort date in descending order
     * @author Sapaya Nicolás Martín
     */
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<ResponseFollowedPostDTO> getAllPostOfMyFollowed(@PathVariable int userId,
                                                                          @RequestParam(required = false,
                                                                                  defaultValue = "date_des")
                                                                                  String order)
            throws UserException {
        return new ResponseEntity<>(iProductService.getAllPostOfMyFollowed(userId, order), HttpStatus.OK);
    }

    /**
     * Get the number of PROMO products that user has
     * @param userId  number that identifies the actual user
     * @return ResponsePromoCountDTO that contains userId, username and quantity of post with promo
     * Response
     * 200 -> OK
     * 400 -> if the user does not exists
     * Example: /products/5/countPromo
     * @author Sapaya Nicolás Martín
     */
    @GetMapping("/{userId}/countPromo")
    public ResponseEntity<ResponsePromoCountDTO> getPromoProductsCount(@PathVariable int userId)
            throws InvalidUserIdException {
        return new ResponseEntity<>(iProductService.getPromoProductsCount(userId), HttpStatus.OK);
    }

    /**
     * Get the number of PROMO products that user has
     * @param userId  number that identifies the actual user
     * @return ResponsePromoListDTO that contains userId, username and a list of post with promo
     * Response
     * 200 -> OK
     * 400 -> if the user does not exists
     * Example: /products/5/list
     * @author Sapaya Nicolás Martín
    */
    @GetMapping("/{userId}/list")
    public ResponseEntity<ResponsePromoListDTO> getListOfPromoProducts(@PathVariable int userId)
            throws InvalidUserIdException {
        return new ResponseEntity<>(iProductService.getListOfPromoProducts(userId), HttpStatus.OK);
    }
}
