package com.example.challenge.Controllers;

import com.example.challenge.Exceptions.InvalidOrderException;
import com.example.challenge.Exceptions.NotPromoPostException;
import com.example.challenge.Exceptions.UserNotFoundException;
import com.example.challenge.Services.DTOs.*;
import com.example.challenge.Services.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {


    IProductService iProductService;

    public ProductController(IProductService iProductService) {
        this.iProductService = iProductService;
    }

    /*
    Create a new Post
     @param postDTO model with the necessary information to add a new post to a user
     @return 200 ok -> String return a messege "Post added successfully"
             400 BadRequest if the json is not valid, if the postId already exist for the userId

             body example:
                         {
                          "userId" : 1,
                          "id_post" : 23,
                          "date" : "07-06-2021",
                          "detail" :{
                                "product_id" : 23,
                          "productName" : " Monitor",
                          "type" : "Curvo",
                          "brand" : "AOC",
                          "color" : "Negro",
                          "notes": " Dale dale"
                         },
                         "category" : 100,
                         "price" : 256
                         }

     @throws UserNotFoundException if the userID is not found in the repository

*/
    @PostMapping("/newpost")
    public ResponseEntity<String> addNewPost(@RequestBody PostDTO postDTO) throws UserNotFoundException {

        return new ResponseEntity<>(iProductService.addNewPost(postDTO), HttpStatus.OK);
    }

    /*
     Create a new Promotion Post
      @param PostPromotionDTO model with the necessary information to add a new post to a user
      @return 200 ok -> String return a messege "Post added successfully"
              400 BadRequest if the json is not valid,
                             if the postId already exist for the userId,
                             if the value of hasPromo is false


              body example:
                          {
                           "userId" : 1,
                           "id_post" : 23,
                           "date" : "07-06-2021",
                           "detail" :{
                                 "product_id" : 23,
                           "productName" : " Monitor",
                           "type" : "Curvo",
                           "brand" : "AOC",
                           "color" : "Negro",
                           "notes": " Dale dale"
                          },
                          "category" : 100,
                          "price" : 256,
                          "hasPromo": true,
     	                  "discount": 0.25
                          }

      @throws UserNotFoundException if the userID is not found in the repository

 */
    @PostMapping("/newpromopost")
    public ResponseEntity<String> addNewPromoPost(@RequestBody PostPromotionDTO postPromoDTO) throws UserNotFoundException, InvalidOrderException, NotPromoPostException {

        return new ResponseEntity<>(iProductService.addNewPromoPost(postPromoDTO), HttpStatus.OK);
    }

    /*
        Followed Posts list
        Return the list containing the last two weeks of post form the user that UserId followed
        @param userId indicate the the id of user that want to know the post of the followed users
        @param order must be date_asc or date_desc if it is not use are order like date_desc
        @return ResponseFollowedPostDTO
                                         "userId": 3,
                                         "posts": [
                                        {
                                            "userId": 1,
                                            "id_post": 2,
                                            "date": "08-06-2021",
                                            "detail": {
                                                "type": "type2",
                                                "brand": "brand2",
                                                "color": "Color2",
                                                "notes": "bla",
                                                "product_id": 2,
                                                "productName": "prod2"
                                            },
                                            "category": 123,
                                            "price": 232.0,
                                            "hasPromo": false,
                                            "discount": 0.0
                                        },
                                        {
                                            "userId": 1,
                                            "id_post": 3,
                                            "date": "05-06-2021",
                                            "detail": {
                                                "type": "type3",
                                                "brand": "brand3",
                                                "color": "Color3",
                                                "notes": "bla",
                                                "product_id": 3,
                                                "productName": "prod3"
                                            },
                                            "category": 123,
                                            "price": 232.0,
                                            "hasPromo": false,
                                            "discount": 0.0
                                        },
                                    ]
                                }

                @throws UserNotFoundException if the userID is not found in the repository
                @throws InvalidOrderException if the order is not date_desc or date_asc


     */

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<ResponseFollowedPostDTO> getMyFollowedPostList(@PathVariable int userId, @RequestParam(required = false,
            defaultValue = "") String order)
            throws UserNotFoundException, InvalidOrderException {
        return new ResponseEntity<>(iProductService.getMyFollowedPostList(userId, order), HttpStatus.OK);
    }


    /*
     Count Promo post
     @param userId indicate the the id of user that want to know the Promotion Posts
      @return PromoCountDTO
                          {
                            "id": 6,
                            "name": "Amelia",
                            "count": 1
                           }

     @throws UserNotFoundException if the userID is not found in the repository

*/
    @GetMapping("/{userId}/countPromo")
    public ResponseEntity<PromoCountDTO> getCountPromo(@PathVariable int userId)
            throws UserNotFoundException {
        return new ResponseEntity<>(iProductService.getCountPromo(userId), HttpStatus.OK);
    }


 /*
        Promo post list
        Return the list containing the post with promotions.
        @param userId indicate the the id of user that want to know the Promotion Posts
        @return ResponsePromotionListDTO
                                      {
                                        "userId": 6,
                                        "userName": "Amelia",
                                        "posts": [
                                            {
                                                "userId": 6,
                                                "id_post": 18,
                                                "date": "29-04-2021",
                                                "detail": {
                                                    "type": "Gamer",
                                                    "brand": "Racer",
                                                    "color": "Red & Black",
                                                    "notes": "Special Edition",
                                                    "product_id": 1,
                                                    "productName": "Silla Gamer"
                                                },
                                                "category": 100,
                                                "price": 1500.5,
                                                "hasPromo": true,
                                                "discount": 0.25
                                            }
                                        ]
                                    }

                @throws UserNotFoundException if the userID is not found in the repository

     */

    @GetMapping("/{userId}/list")
    public ResponseEntity<ResponsePromotionListDTO> getPromotionsPost(@PathVariable int userId)
            throws UserNotFoundException {
        return new ResponseEntity<>(iProductService.getPromotionsPost(userId), HttpStatus.OK);
    }


}
