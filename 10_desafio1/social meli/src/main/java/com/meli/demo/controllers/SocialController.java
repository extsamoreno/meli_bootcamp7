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
    //POST http://localhost:8080/social/users/101/follow/1002
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

    //POST http://localhost:8080/social/products/newpost

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
    public  ResponseEntity<String>   unFollow(@PathVariable int userId, @PathVariable int userIdToUnfollow) throws FollowException {
        ;
        return new ResponseEntity(FollowService.unFollow(userId,userIdToUnfollow),HttpStatus.OK);
    }


/*
    {
        "userId":1002,
            "id_post":18,
            "date":"29-04-2021",
            "detail":
        {
            "product_id":1,
                "productName":"TES2 gam",
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
    //POST http://localhost:8080/social/products/newpromopost

    @PostMapping("/products/newpromopost")
    public ResponseEntity<String> newPost(@RequestBody PostDiscountDTO postDiscountDTO) throws  PostDiscountException {
        return new ResponseEntity<>(FollowService.newPostDiscount(postDiscountDTO), HttpStatus.OK);
    }

    //GET http://localhost:8080/social/products/1002/countPromo/

    @GetMapping("/products/{userId}/countPromo/")
    public ResponseEntity<CountDiscountSelleDTO> countDiscount(@PathVariable int userId ){

        return new ResponseEntity<>(FollowService.countDiscount(userId),HttpStatus.OK);
    }

    //GET http://localhost:8080/social//products/1002/list/

    @GetMapping("/products/{userId}/list/")
    public ResponseEntity<ListDiscountDTO> listDiscount(@PathVariable int userId){
        return new ResponseEntity<>(FollowService.listDiscount(userId),HttpStatus.OK);
    }

    //http://localhost:8080/social/products/1002/list/name_desc
    //http://localhost:8080/social/products/1002/list/name_asc


}
