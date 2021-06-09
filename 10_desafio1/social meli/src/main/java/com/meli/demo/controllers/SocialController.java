package com.meli.demo.controllers;


import com.meli.demo.dtos.*;
import com.meli.demo.exceptions.FollowException;
import com.meli.demo.exceptions.PostDiscountException;
import com.meli.demo.exceptions.PostException;
import com.meli.demo.services.SocialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("social")
public class SocialController {

    @Autowired
    SocialService FollowService;
    //POST http://localhost:8080/social/users/111/follow/1001
    @PostMapping("/users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<String> Follow(@PathVariable int userId, @PathVariable int userIdToFollow) throws FollowException {
        return new ResponseEntity<>(FollowService.Follow(userId,userIdToFollow), HttpStatus.OK);
    }
    //GET http://localhost:8080/social/users/1001/followers/count/
    @GetMapping("/users/{userId}/followers/count/")
    public ResponseEntity<CountUsersDTO> countUser(@PathVariable int userId) throws FollowException {
        return new ResponseEntity<>(FollowService.countUsers(userId), HttpStatus.OK);
    }

    //GET http://localhost:8080/social/users/1001/followers/list
    @GetMapping("/users/{UserID}/followers/list")
    public ResponseEntity<LisUsersResponseDTO> ListUsers(@PathVariable int UserID) throws FollowException {

        return new ResponseEntity<>(FollowService.listUsers(UserID), HttpStatus.OK);
    }
    //GET http://localhost:8080/social/users/101/followed/list
    @GetMapping("/users/{User}/followed/list")
    public ResponseEntity<ListSellersResponseDTO> ListaVendedores(@PathVariable int User) throws FollowException {

        return new ResponseEntity<>(FollowService.listVendedores(User), HttpStatus.OK);
    }


    /* POST
  {
    "userId":1001,
    "id_post":18,
    "date":"03-003-2021",
    "detail":
    {
        "product_id":1,
        "productName":"Silla gamner",
        "type":"gamer",
        "brand":"Racer",
        "color":"red $ black",
        "notes":"special edition"
    },
    "category":100,
    "price":1500.50
}
     */

    @PostMapping("/products/newpost")
    public ResponseEntity<String> newPost(@RequestBody PostDTO pubtDTO) throws PostException {
        return new ResponseEntity<>(FollowService.newPost(pubtDTO), HttpStatus.OK);
    }

    //GET http://localhost:8080/social/products/followed/101/list

    @GetMapping("/products/followed/{userId}/list")
    public ResponseEntity<ListSellersPostDTO> listPostVendedors(@PathVariable int userId){
        return new ResponseEntity<>(FollowService.listPostVendedors(userId), HttpStatus.OK);
    }

    //POST http://localhost:8080/social/users/101/unfollow/1001

    @PostMapping("/users/{userId}/unfollow/{userIdToUnfollow}")
    public  ResponseEntity  unFollow(@PathVariable int userId, @PathVariable int userIdToUnfollow) throws FollowException {
        FollowService.unFollow(userId,userIdToUnfollow);
        return new ResponseEntity(HttpStatus.OK);
    }

    //http://localhost:8080/social/users/105/followers/list/name_desc
    //http://localhost:8080/social/users/105/followers/list/name_asc

    @GetMapping("/users/{UserID}/followers/list/{order}")
    public  ResponseEntity<ListSellersPostDTO>   orderNameDesc(@PathVariable int UserID, @PathVariable String order) {
        return new ResponseEntity<>(FollowService.orderNameAscDesc(UserID,order), HttpStatus.OK);
    }


    //http://localhost:8080/social/products/followed/105/list/date_asc
    //http://localhost:8080/social/products/followed/105/list/date_desc

    @GetMapping("/products/followed/{userId}/list/{order}")
    public  ResponseEntity<ListSellersPostDTO>   orderDateDesc(@PathVariable int userId, @PathVariable String order) {
        return new ResponseEntity<>(FollowService.orderDateAscDesc(userId,order), HttpStatus.OK);
    }
/*
    {
        "userId":1002,
            "id_post":18,
            "date":"29-04-2021",
            "detail":
        {
            "product_id":1,
                "productName":"Silla gamner",
                "type":"gamer",
                "brand":"Racer",
                "color":"red $ black",
                "notes":"special edition"
        },
        "category":100,
            "price":1500.50,
        "hasPromo":true,
        "discount":0.25
    }*/

    @PostMapping("/products/newpromopost")
    public ResponseEntity<String> newPost(@RequestBody PostDiscountDTO postDiscountDTO) throws  PostDiscountException {
        return new ResponseEntity<>(FollowService.newPostDiscount(postDiscountDTO), HttpStatus.OK);
    }

    //GET http://localhost:8080/social/products/1002/countPromo/

    @GetMapping("/products/{userId}/countPromo/")
    public ResponseEntity<CountDiscountSelleDTO> countDiscount(@PathVariable int userId ){

        return new ResponseEntity<>(FollowService.countDiscount(userId),HttpStatus.OK);
    }

    //http://localhost:8080/social//products/1002/list/

    @GetMapping("/products/{userId}/list/")
    public ResponseEntity<ListDiscountDTO> listDiscount(@PathVariable int userId){
        return new ResponseEntity<>(FollowService.listDiscount(userId),HttpStatus.OK);
    }

    //http://localhost:8080/social/products/1002/list/name_desc
    //http://localhost:8080/social/products/1002/list/name_asc


    @GetMapping("/products/{userId}/list/{order}")
    public  ResponseEntity<ListDiscountDTO>   orderDtoNameDesc(@PathVariable int userId,@PathVariable String order) {
        return new ResponseEntity<>(FollowService.orderDtoNameDesc(userId,order), HttpStatus.OK);
    }






}
